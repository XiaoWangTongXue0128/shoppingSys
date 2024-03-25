package util;

import java.util.HashMap;

public class MySpring {
    private static HashMap<String, Object> objectHashMap=new HashMap<>();

    public static <T>T getBean(String classname) {
        T obj = (T)objectHashMap.get(classname);
        if (obj == null) {
            try {
                obj=(T) Class.forName(classname).newInstance();
                objectHashMap.put(classname, obj);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
