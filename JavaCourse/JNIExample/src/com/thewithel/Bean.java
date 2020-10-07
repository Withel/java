package com.thewithel;

public class Bean {
    //public members
    public String dataString;
    public byte[] dataByteArray;

    public Bean() {
    }

    //getters and setters
    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public byte[] getDataByteArray() {
        return dataByteArray;
    }

    public void setDataByteArray(byte[] dataByteArray) {
        this.dataByteArray = dataByteArray;
    }

    @Override
    public String toString() {
        String ret = "string = " + dataString;

        ret += " / byteArray =";
        if (dataByteArray != null) {
            for (byte b : dataByteArray) {
                ret += " " + b;
            }
        }

        return ret;
    }
}