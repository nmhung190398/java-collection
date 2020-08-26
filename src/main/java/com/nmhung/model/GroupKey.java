package com.nmhung.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

public class GroupKey {

    private Field[] _fields;


    protected Field[] getFields() {
        if (_fields == null) {
            _fields = this.getClass().getDeclaredFields();
            for (Field field : _fields) {
                field.setAccessible(true);
            }
        }
        return _fields;
    }

    @Override
    public int hashCode() {
        Field[] fields = getFields();
        Object[] values = new Object[fields.length * 2 + 1];

        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                values[i * 2] = fields[i].getName();
                values[i * 2 + 1] = fields[i].get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        values[fields.length * 2] = GroupKey.class.getSimpleName();

        String out = Arrays.stream(values).reduce("", (s, o) -> {
            return s.toString() + o.toString() + ",";
        }).toString();
        int hashValue = Objects.hash(values);
//        System.out.println(out + " : " + hashValue);

        return hashValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GroupKey)) {
            return false;
        }

        Field[] fields = getFields();
        for (Field field : fields) {
            String name = field.getName();
            Field tmp = getDeclaredField(obj.getClass(), name);
            if (tmp == null) {
                return false;
            }

            Object value = getValueField(field,this);
            Object value1 = getValueField(tmp,obj);
            if(value == null && value1 == null){
                continue;
            }
            if(value == null || value1 == null){
                return false;
            }

            if(!value.equals(value1)){
                return false;
            }
        }
        return true;
    }

    private static Field getDeclaredField(Class zClass, String name) {
        try {
            return zClass.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    private static Object getValueField(Field field, Object source) {
        try {
            field.setAccessible(true);
            return field.get(source);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
