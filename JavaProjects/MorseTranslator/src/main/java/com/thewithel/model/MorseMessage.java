package com.thewithel.model;

import com.thewithel.model.datamodel.ConverterData;

/**
 * Class MorseMessage stores message represented by string in any form.
 * In this case, as class suggest, it is Morse message. For now there is no
 * validation if it is really morse message that's why 'nulls' might appear
 * in program, but it will still work.
 *
 * @author Mateusz Klimas
 * @since 20.10.2019
 */
public class MorseMessage implements Convertible{

    /**
     * Only one field is used for this class that holds message in string format.
     */
    private String message;

    /**
     * Only one constructor that accepts message as a parameter.
     * It not possible to create class without it.
     * @param message message that is put into class
     */
    public MorseMessage(String message) {
        this.message = message;
    }

    /**
     * Function that takes message written in morse code and then
     * it translates it to message represented by text. It uses three
     * StringBuilders: character, word and textMessage which are appended
     * in every iteration. In the end textMessage is converted to string
     * and returned from funcion.
     * @return textMessage
     */
    @Override
    public String convert() {

        if(this.message.equals("")){
            return "";
        }
        message = message.replaceAll("  +", "  ");
        String[] words = message.split("  ");

        StringBuilder character = new StringBuilder();
        StringBuilder word = new StringBuilder();
        StringBuilder textMessage = new StringBuilder();

        for (String temp : words) {
            char[] chars = temp.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '\n') {
                    word.append('\n');
                    continue;
                } else if (chars[i] == '\t') {
                    word.append('\t');
                    continue;
                } else {
                    if (chars[i] == ' ') {
                        word.append(ConverterData.getInstance().getChar(character.toString()));
                        character = new StringBuilder();
                    } else {
                        character.append(chars[i]);
                    }
                }
            }
            word.append(ConverterData.getInstance().getChar(character.toString()));
            character = new StringBuilder();

            textMessage.append(word.toString() + " ");

            word = new StringBuilder();
        }

        return textMessage.toString();
    }
}


