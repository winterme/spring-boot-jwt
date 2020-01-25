package com.zzq.util;

public class ArrayUtils {

    public static boolean isNotEmpty(byte[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        return true;
    }

}
