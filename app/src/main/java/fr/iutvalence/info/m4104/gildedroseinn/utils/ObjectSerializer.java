package fr.iutvalence.info.m4104.gildedroseinn.utils;

import android.util.Base64;

import java.io.*;

public class ObjectSerializer {

    /**
     * Reads the object from Base64 string.
     *
     * @param s String to be converted
     * @return the Object
     * @throws IOException            In case the data couldn’t be read
     * @throws ClassNotFoundException In case a wrong class was passed
     */
    public static Object fromString(String s) throws IOException, ClassNotFoundException {
        byte[] data = Base64.decode(s, Base64.DEFAULT);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

    /**
     * Converts an object implementing Serializable to a Base64 string.
     *
     * @param o String to be converted
     * @return String based on o       Serialized object as string
     * @throws IOException In case the data couldnt be read
     */
    public static String toString(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
    }

}