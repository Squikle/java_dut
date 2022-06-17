package com.company;

public class Main {

    public static void main(String[] args)
            throws Exception
    {
        CollectionTest(new LinkedList<>());
        CollectionTest(new ArrayList<>(2));

        SerializationUtilTask();
    }

    public static void CollectionTest(Collection<Object> collection)
    {
        collection.add(1);
        System.out.println("Added 1");
        collection.add(2);
        System.out.println("Added 2");
        collection.add(10);
        System.out.println("Added 10");
        System.out.println("Size: " + collection.size());

        System.out.println("Collection contains 10: " + collection.contains(10));
        collection.remove(10);
        System.out.println("Removed 10");
        System.out.println("Collection contains 10: " + collection.contains(10));

        System.out.println("Collection size: " + collection.size());

        System.out.print("Collection data: ");
        for(Object o : collection){
            System.out.print(o + " ");
        }

        System.out.println();
    }

    public static void SerializationUtilTask()
            throws Exception
    {
        Car car = new Car("BMW", "M3", 250, 1500);

        String fileName = "myCar.data";
        SerializationUtil.serializeToFile(car, fileName);
        System.out.println(car.getBrand() + " " + car.getModel() + " was recorded to the file " + fileName);

        Car myCar = SerializationUtil.deserializeFromFile(fileName);
        if (myCar != null) {
            System.out.println(car.getBrand() + " " + car.getModel() + " was restored from the file " + fileName);
        }
    }
}
