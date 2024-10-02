package DesignPatterns.Creational;
//https://refactoring.guru/design-patterns/singleton/java/example#example-0
/*
1. Why to declare class as final ?
2. volatile ?
 */

//Naive Solution
final class Singleton{
    private static Singleton instance;
    public String value;

    private Singleton(String value){
        try{
            Thread.sleep(1000);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value){
        if(instance == null){
            instance = new Singleton(value);
        }
        return instance;
    }
}

//Thread safe with lazy loading
final class MySingleton{
    private static volatile MySingleton instance;
    public String value;
    private MySingleton(String value){
        this.value = value;
    }

    public static MySingleton getInstance(String value){
        //implementing double-checked locking
        MySingleton result = instance;
        if(result != null){
            return result;
        }
        synchronized (MySingleton.class){
            if(instance == null){
                instance = new MySingleton(value);
            }
            return instance;
        }
    }
}


public class singleton_pattern {

    static class ThreadFoo implements Runnable{
        @Override
        public void run() {
            MySingleton mySingleton = MySingleton.getInstance("Foo");
            System.out.println("value : "+ mySingleton.value);
        }
    }

    static class ThreadBar implements  Runnable{
        @Override
        public void run() {
            MySingleton mySingleton = MySingleton.getInstance("Bar");
            System.out.println("value : "+ mySingleton.value);
        }
    }


    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }
}
