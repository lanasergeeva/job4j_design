package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> map = new HashMap<>();
        Info info = new Info();
        for (User user : previous) {
            map.put(user.getId(), user.getName());
        }
        for (User user : current) {
            if (!user.getName().equals(map.get(user.getId()))) {
                info.changed++;
            }
        }
        if (map.keySet().size() < current.size()) {
            info.added = current.size() - map.keySet().size();
            info.changed = info.changed - info.added;
        } else if (map.keySet().size() > current.size()) {
            info.deleted = map.keySet().size() - current.size();
        }
        return info;
    }


    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {

        private int added;
        private int changed;
        private int deleted;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}

