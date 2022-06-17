package com.company;

public class Main {

    public static void main(String[] args) {
        CollectionTest(new MyLinkedList<>());
        CollectionTest(new MyArrayList<>(2));

        SerializationUtilTest();
    }

    public static void SerializationUtilTest(){
        Hero hero = new Hero("Anti-Mage", "Jungler", 100, 0, 0);

        if(SerializationUtil.serialize(hero, "support.dat")){
            System.out.println(hero.getName() + "recorded in a file.");
        }

        Hero creep = SerializationUtil.deserialize("support.dat");
        if(creep != null){
            System.out.println(creep.getName() + " restored.");
        }
    }

    public static void CollectionTest(Collection<Object> collection){
        collection.add(10);
        System.out.println("Added 10");

        collection.add(13);
        System.out.println("Added 13");

        collection.add(54);
        System.out.println("Added 54");

        collection.add(20);
        System.out.println("Added 20");

        System.out.println("Size: " + collection.size()); // 4

        if(collection.remove(13)){
            System.out.println("Removed 13");
        }

        if(collection.removeLast()){
            System.out.println("Removed last");
        }

        System.out.println("Contains 54? Answer: " + collection.contains(54)); //true
        System.out.println("Contains 20? Answer: " + collection.contains(20)); //false
        System.out.println("Size: " + collection.size()); // 2

        System.out.print("Collection: ");
        for(Object o : collection){
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
