package com.company;

import java.io.*;

public class SerializationUtil {
    public static <T extends Serializable> boolean serialize(T object, String path)
    {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path)))
        {
            objectOutputStream.writeObject(object);
            return true;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static <T extends Serializable> T deserialize(String path){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path)))
        {
            return (T)objectInputStream.readObject();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
            return null;
        }
    }
}
