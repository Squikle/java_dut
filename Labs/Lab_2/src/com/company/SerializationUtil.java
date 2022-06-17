package com.company;

import java.io.*;

public class SerializationUtil {
    public static <T extends Serializable> void serializeToFile(T data, String path)
            throws Exception
    {
        try
        {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(data);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public static <T extends Serializable> T deserializeFromFile(String path)
            throws Exception
    {
        try
        {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            return (T)objectInputStream.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
