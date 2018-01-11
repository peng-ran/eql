package org.n3r.eql;

import com.google.common.collect.Maps;

import java.util.Map;

public class EqlContext {
    private static ThreadLocal<Map<String, Object>> threadLocalMap = new ThreadLocal<Map<String, Object>>() {
        @Override protected Map<String, Object> initialValue() {
            return Maps.newHashMap();
        }
    };

    public static void put(String name, Object value) {
        getMap().put(name, value);
    }

    public static Object get(String name) {
        return getMap().get(name);
    }

    public static Map<String, Object> getMap() {
        return threadLocalMap.get();
    }

    public static void clear() {
        getMap().clear();
    }
}
