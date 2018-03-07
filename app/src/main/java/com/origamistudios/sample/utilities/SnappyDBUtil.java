package com.origamistudios.sample.utilities;


import com.origamistudios.sample.AppController;
import com.snappydb.DB;
import com.snappydb.SnappydbException;

import java.util.ArrayList;

public class SnappyDBUtil {
    public static <T> boolean saveObject(String key, T item) {
        DB snappy = AppController.getSnappyInstance();
        try {
            if (item != null) {
                snappy.put(key, item);
            } else {
                snappy.del(key);
            }
            return true;
        } catch (SnappydbException e) {
            return false;
        }

    }

    public static <T> T getObject(String key, Class T) {
        T item = null;
        DB snappy = AppController.getSnappyInstance();
        try {
            boolean isKeyExist = snappy.exists(key);
            if (isKeyExist) {
                item = (T) snappy.getObject(key, T);
            }
        } catch (SnappydbException e) {
            return item;
        }
        return item;
    }


    public static <T> boolean saveList(String key, ArrayList<T> list) {
        DB snappy = AppController.getSnappyInstance();
        try {
            if (snappy != null) {
                snappy.put(key, list);
            } else {
                snappy.del(key);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static <T> ArrayList<T> getList(String key, Class T) {
        DB snappy = AppController.getSnappyInstance();
        ArrayList<T> list = null;
        try {
            if (snappy != null) {
                list = snappy.getObject(key, ArrayList.class);
            }
        } catch (Exception e) {
            return list;
        }
        return list;
    }

    public static boolean deleteObjectOrList(String key) {
        DB snappy = AppController.getSnappyInstance();
        try {
            if (key != null) {
                snappy.del(key);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
