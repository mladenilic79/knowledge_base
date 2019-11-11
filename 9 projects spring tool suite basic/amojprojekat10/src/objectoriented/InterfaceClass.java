package objectoriented;

/*
functional interface is when it has only one abstract method (can have more if
there are overridden methods)
prevents editing of the body of class
*/
@FunctionalInterface

/*
Interface is a class with only abstract methods
Interface provide all of the methods you must use, but none of the code
class can have many interfaces implemented in the same time
here lambda can be implemented because there is only one abstract method
*/
public interface InterfaceClass {

    // fields in interface are public, static and final by default
    int randomVariable = 0;

    /*
    All methods in interface must be implemented by class that uses the
    interface (public & abstract by default, cannot be final)
     */
    public abstract void interfaceMethod();
    
    /*
    from java 1.8 on interfaces can have default & static methods also
    */
    static void print1(){
        System.out.println("interface static method");
    }
    default void print2(){
        System.out.println("interface default method");
    }
}
