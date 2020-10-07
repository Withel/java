package com.thewithel.model.datamodel;

import com.thewithel.model.MostUselessException;

import java.util.HashMap;
import java.util.Set;

/**
 * Class that holds every data that is needed to convert message
 * from morse code to text and from text to morse code. It is using
 * HashMaps to map these into each other.
 *
 * It is used as a singleton pattern because program always needs only one
 * instance of this class.
 *
 * @author Mateusz Klimas
 * @since 20.10.2019
 */

public class ConverterData {

    private static ConverterData instance = new ConverterData();

    private final HashMap<String, String> morseData;
    private HashMap<String, String> textData;

    public static ConverterData getInstance() {
        return instance;
    }

    /**
     * As in singleton pattern constructor is private to ensure
     * that we can't create more than one instance of this class.
     *
     * In constructor is exception that is totally unnecessary but I had to
     * implement it so there it is.
     *
     * Later in code all data that is needed to translate from morse to text
     * is hardcoded. Then there is extraction of keys and same actions is happening,
     * but for mapping data needed to convert from text to morse. Also it is written
     * in small loop.
     */
    private ConverterData() {

        try {
            throw new MostUselessException("I'm useless exception, called constructor for\n" +
                    "ConverterData singleton class");
        } catch (MostUselessException e) {
            System.out.println(e.getMessage());
        }

        morseData = new HashMap<>();
        textData = new HashMap<>();
        //letters
        morseData.put(".-", "a");
        morseData.put("-...", "b");
        morseData.put("-.-.", "c");
        morseData.put("-..", "d");
        morseData.put(".", "e");
        morseData.put("..-.", "f");
        morseData.put("--.", "g");
        morseData.put("....", "h");
        morseData.put("..", "i");
        morseData.put(".---", "j");
        morseData.put("-.-", "k");
        morseData.put(".-..", "l");
        morseData.put("--", "m");
        morseData.put("-.", "n");
        morseData.put("---", "o");
        morseData.put(".--.", "p");
        morseData.put("--.-", "q");
        morseData.put(".-.", "r");
        morseData.put("...", "s");
        morseData.put("-", "t");
        morseData.put("..-", "u");
        morseData.put("...-", "v");
        morseData.put(".--", "w");
        morseData.put("-..-", "x");
        morseData.put("-.--", "y");
        morseData.put("--..", "z");
        //numbers
        morseData.put(".----", "1");
        morseData.put("..---", "2");
        morseData.put("...--", "3");
        morseData.put("....-", "4");
        morseData.put(".....", "5");
        morseData.put("-....", "6");
        morseData.put("--...", "7");
        morseData.put("---..", "8");
        morseData.put("----.", "9");
        morseData.put("-----", "0");

        //from text to morse
        for (String key : morseData.keySet()) {
            textData.put(morseData.get(key), key);
        }
        textData.put(" ", "  ");
        textData.put("\n", "\n");
        textData.put("\t", "\t");
    }

    /**
     * @param key only accepted parameter used to map to correct translation
     * @return returns translated value
     */
    public String getChar(String key) {
        return morseData.get(key);
    }

    public String getSign(String key){
        return textData.get(key);
    }

    /**
     * All functions listed below were made for testing purposes.
     * In some situations they were really helpfull so I decided
     * to keep them in case I will need them in future.
     * They will be removed in final version of project.
     * @return HashMap
     */


    public HashMap<String, String> getMorseData() {
        return morseData;
    }

    public HashMap<String, String> getTextData() {
        return textData;
    }

    public void checkData(HashMap<String, String> data) {
        Set keys = data.keySet();

        for (Object e : keys) {
            System.out.println(e + " = " + data.get(e));
        }
    }

}
