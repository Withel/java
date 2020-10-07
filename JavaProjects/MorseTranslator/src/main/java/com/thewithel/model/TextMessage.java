package com.thewithel.model;

import com.thewithel.model.datamodel.ConverterData;

/**
 * Class TextMessage stores message represented by string in any form.
 * In this case, as class suggest, it is text message. For now there is no
 * validation if it is really text message that's why 'nulls' might appear
 * in program, but it will still work.
 *
 * @author Mateusz Klimas
 * @since 20.10.2019
 */

public class TextMessage implements Convertible {

    /**
     * Only one field is used for this class that holds message in string format.
     */
    private String message;

    /**
     * Only one constructor that accepts message as a parameter.
     * It not possible to create class without it.
     * @param message message that is put into class
     */
    public TextMessage(String message) {
        this.message = message;
    }

    /**
     * Function that takes text message and then it translates
     * it to message represented by morse code. It is one simple loop.
     * In every iteration it translates next characters to signs in morse code.
     * In the end function returns message made in StringBuilder which is converted
     * to String.
     * @return textMessage
     */
    @Override
    public String convert() {
        if(this.message.equals("")){
            return "";
        }

        StringBuilder morseMessage = new StringBuilder();

        char[] chars = message.toCharArray();

        for(int i=0;i<chars.length;i++){
            Character tempChar = chars[i];
            morseMessage.append(ConverterData.getInstance().getSign(tempChar.toString()) + " ");
        }

        return morseMessage.toString();
    }
}
