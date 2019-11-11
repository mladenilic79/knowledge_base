
package functional;

public class B_variables_casting {
    
    public static void main(String[] args) {
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< variables basics >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        Variable names are case sensitive
        Variables must begin with a letter and contain numbers, _, or $
        You must declare all variables with a data type
        declared variable with same name creates a copy of a existing variable
        */
        
        // declaration statement;
        int var1;
        
        // instantiation statement;
        var1 = 3;
        
        // definition statement
        int var2 = 22;
        
        // expression statement
        int var3 = var1 + var2;
        
        // reference type variables can have no value (refer to nothing)
        String var4 = null;
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< variables casting >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // You use casting to convert from one type to another
        double x = 3.1456789;
        int y = (int) x;
        
        // Without the casting the value wouldn't consider fractions
        double z = (double) y / 2;
        
        // normally used on primitives but can be used on reference types also
    }
}
