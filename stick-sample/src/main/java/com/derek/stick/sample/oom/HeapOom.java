package com.derek.stick.sample.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆溢出
 * 
 * @author derek.wu
 * @date 2019-11-07
 * @since v1.0.0
 */
public class HeapOom {

    public static void main(String[] args) {
        List<OomObject> list = new ArrayList<>();
        while (true) {
            list.add(new OomObject());
        }
    }

    private static class OomObject {
    }
}
