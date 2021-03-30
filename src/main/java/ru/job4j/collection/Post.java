package ru.job4j.collection;

import java.util.*;

public class Post {
    public Map<String, Set<String>> unique(Map<String, Set<String>> users) {
        Map<String, Set<String>> result = new HashMap<>();
        for (Map.Entry<String, Set<String>> first : users.entrySet()) {
            String mapKey = first.getKey();
            for (Map.Entry<String, Set<String>> second : result.entrySet()) {
                Set<String> check = new HashSet<>();
                check.addAll(first.getValue());
                check.addAll(second.getValue());
                if ((first.getValue().size() + second.getValue().size()) != check.size()) {
                    first.setValue(check);
                    mapKey = second.getKey();
                }
            }
            result.put(mapKey, first.getValue());
        }
        return result;
    }
}

