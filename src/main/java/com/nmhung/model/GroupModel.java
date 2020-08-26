package com.nmhung.model;

import java.util.ArrayList;
import java.util.Map;

public class GroupModel<K extends GroupKey, E> extends ArrayList<E> {

    public GroupModel(K key){
        super();
        this.key = key;
    }
    private K key;

    public K getKey() {
        return key;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GroupModel)) {
            return false;
        }
        if (!(key instanceof Map)) {
            return key.equals(((GroupModel) o).key);
        }

        Map mapKey = (Map) key;
        Map mapKeyObject = (Map) ((GroupModel) o).key;
        for (Object key : mapKey.keySet()) {
            if (!mapKeyObject.containsKey(key)) {
                return false;
            }
            if (!mapKey.get(key).equals(mapKeyObject.get(key))) {
                return false;
            }
        }


        return true;
    }
}
