package com.thewithel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<HeavenlyBody.Key, HeavenlyBody>();
    private static Set<HeavenlyBody> planets = new HashSet<HeavenlyBody>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        //getName() its key
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatelite(tempMoon);

        tempMoon = new Moon("Fake Moon", 9271);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatelite(tempMoon);

        temp = new Planet("Mars", 666);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Phobos", 11111);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatelite(tempMoon);

        tempMoon = new Moon("Deimos", 22222);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatelite(tempMoon);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for(HeavenlyBody planet: planets){
            System.out.println("\t" + planet.getKey());
        }

        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of " + body.getKey());
        for(HeavenlyBody earthMoon: body.getSatelites()){
            System.out.println("\t" + earthMoon.getKey());
        }

        Set<HeavenlyBody> moons = new HashSet<HeavenlyBody>();

        for(HeavenlyBody planet: planets){
            moons.addAll(planet.getSatelites());
        }

        System.out.println("All moons");
        for(HeavenlyBody moon: moons){
            System.out.println("\t" + moon.getKey());
        }

        System.out.println(moons.contains(solarSystem.get("Deimos")));
        System.out.println(moons.add(solarSystem.get("Deimos")));

        HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
        planets.add(pluto);

        for(HeavenlyBody planet: planets){
            System.out.println(planet);
//            System.out.println(planet.getKey() + ": " +planet.getOrbitalPeriod());
        }

        HeavenlyBody eart1 = new Planet("Earth", 365);
        HeavenlyBody earth2 = new Planet("Earth", 365);

        System.out.println(eart1.equals(earth2));
        System.out.println(earth2.equals(eart1));

        solarSystem.put(pluto.getKey(), pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));

        System.out.println();
        System.out.println("The Solar system contais:");
        for(HeavenlyBody heavenlyBody : solarSystem.values()){
            System.out.println(heavenlyBody);
        }

    }
}
