package com.matthewklim;



import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high leve, oop, platform blah blah");
        languages.put("Python", "just Python, because I dont care about it");
        languages.put("Algol", "some language starting with A I dont know");
        languages.put("BASIC", "begginers all Purposes Symbolic instructon Code");
        languages.put("Lisp", "therein lies madness");

//        System.out.println(languages.get("Java"));
        if(languages.containsKey("Java")){
            System.out.println("Java is already on list");
        } else {
            System.out.println("Javy nie ma");
        }
        System.out.println(languages.put("Java", "gowno"));
        System.out.println(languages.get("Java"));

        System.out.println("================================================");

        //method remove returns true or false
//        languages.remove("Lisp");
        if(languages.remove("Algol", "some language starting with A I dont know")){
            System.out.println("algol removed");
        } else {
            System.out.println("algol not removed");
        }

        if(languages.replace("Lisp", "therein lies madness", ".replace working for \"lisp\"")){
            System.out.println("Lisp replaced");
        } else {
            System.out.println("lisp was not replaced");
        }
        System.out.println(languages.replace("Scala", "this will not be added"));

        for(String key: languages.keySet()){
            System.out.println(key +" : " + languages.get(key));
        }
    }
}
