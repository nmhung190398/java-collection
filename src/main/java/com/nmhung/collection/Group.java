package com.nmhung.collection;

import com.nmhung.model.GroupKey;
import com.nmhung.model.GroupModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Group {

    public <K extends GroupKey, T> List<GroupModel<K, T>> by(List<T> data, Class<K> keyClass) {

        Map<K, GroupModel<K, T>> map = new HashMap<>();

//
        for (T item : data) {
            K key = getKeyInData(item, keyClass);
            if (map.containsKey(key)) {
                map.get(key).add(item);
            } else {
                GroupModel<K, T> list = new GroupModel<K, T>(key);
                map.put(key, list);
            }
        }
        return new ArrayList<GroupModel<K, T>>();
    }

    private <T, K extends GroupKey> K getKeyInData(T item, Class<K> keyClass) {
        return null;
    }

    public <T> List<List<T>> by(List<T> data, String... keys) {
        if (data.size() == 0) {
            return new ArrayList<>();
        }

        //validate keys

        HashMap<String, List<T>> map = new HashMap<>();

        for (T item : data) {
            String key = getKeyInData(item, keys);
            if (map.containsKey(key)) {
                map.get(key).add(item);
            } else {
                List<T> list = new ArrayList<>();
                list.add(item);
                map.put(key, list);
            }
        }

        List<List<T>> lists = new ArrayList<>();

        return lists;
    }

    private <T> String getKeyInData(T item, String[] keys) {

        return null;
    }


    public <T> List<List<T>> by(List<T> data, BiFunction<T, T, Boolean> funcEqualKey) {


        return null;
    }


}
