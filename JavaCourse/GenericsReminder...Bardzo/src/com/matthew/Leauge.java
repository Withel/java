package com.matthew;

import java.util.ArrayList;
import java.util.Collections;

public class Leauge<T extends Team> {
    public String name;
    private ArrayList<T> leauge = new ArrayList<T>();

    public Leauge(String name) {
        this.name = name;
    }

    public boolean add(T team){
        if (leauge.contains(team)) {
            return false;
        }
        leauge.add(team);
        return true;
    }

    public void showLeaugeTable(){
        Collections.sort(leauge);
        for(T t: leauge){
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
