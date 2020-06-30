package cn.edu.nenu.config;

import java.util.Collection;
import java.util.Map;


public class CollectionsUtil {

    /**
     * 判断是否为空.
     */
    public static boolean isEmpty(Collection collection) {
        return (collection == null) || collection.isEmpty();
    }

    /**
     * 判断是否为空.
     */
    public static boolean isEmpty(Map map) {
        return (map == null) || map.isEmpty();
    }

    /**
     * 判断是否为空.
     */
    public static boolean isNotEmpty(Collection collection) {
        return (collection != null) && !(collection.isEmpty());
    }
}
