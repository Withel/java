package com.thewithel;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
//    private final String name;
    private final Key key;              //instead of having name and bodyType as a "key" we have Key class
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satelites;
//    private final BodyTypes bodyType;


//    public static final int STAR = 1;
//    public static final int PLANET = 2;
//    public static final int DWARF_PLANET = 3;
//    public static final int MOON = 4;
//    public static final int COMET = 5;
//    public static final int ASTEROID = 6;

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
//        this.name = name;
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satelites = new HashSet<HeavenlyBody>();
//        this.bodyType = bodyType;
    }

//    public String getName() {
//        return name;
//    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

//    public BodyTypes getBodyType() {
//        return bodyType;
//    }


    public Key getKey() {
        return key;
    }

    public boolean addSatelite(HeavenlyBody moon){
            return this.satelites.add(moon);
    }

    //this way we ensure that noone has acces to original variable, but only to copy
    public Set<HeavenlyBody> getSatelites() {
        return new HashSet<HeavenlyBody>(this.satelites);
    }

    //difference between overriding and overloading
    @Override
    public final boolean equals(Object obj){
        if(this == obj){
            return true;
        }
//        System.out.println("object.getClass is " +obj.getClass());
//        System.out.println("this.getClass() is " + this.getClass());
//        if(obj == null || obj.getClass() != this.getClass()) {
//            return false;
//        }

        if(obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
//            if(this.name.equals(theObject.getName())){
//                return this.bodyType == theObject.getBodyType();
//            }
            return this.key.equals(theObject.getKey());
        }
//        String objName = ((HeavenlyBody) obj).getName();
//        return this.name.equals(objName);
        return false;
    }

    @Override
    public final int hashCode() {
//        System.out.println("hashCode() called.");
//        return this.name.hashCode() + 57 + this.bodyType.hashCode();
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " +this.orbitalPeriod;
    }

    public static final class Key{
        private String name;
        private BodyTypes bodyType;

        //THE CONSTRUCTOR IS FINAL SO OBJECT OF THIS CLASS CANT BE MADE OUTSIDE THE CLASS
        //BUT IT CAN BE MADE WITHIN THE CLASS
        private Key(String name, BodyTypes bodyType){
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())){
                return(this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ", " + this.bodyType;
        }
    }
}
