package com.thewithel;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "B");
        map.put("C", "D");
        map.put("ASD", "QWERTY");

        Gson gson = new Gson();
        System.out.println(gson.toJson(map));
    }
}
