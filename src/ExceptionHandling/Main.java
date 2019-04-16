package ExceptionHandling;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        System.out.println("1.1 :");
        try {
            throw new ExceptionB("ExceptionB");
        } catch (ExceptionA ex) {
            System.out.println(ex.getMessage());
        }

        try {
            throw new ExceptionC("ExceptionC");
        } catch (ExceptionA ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("--------\n1.2 :");
        try {
            throw new ExceptionA("ExceptionA");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            throw new ExceptionB("ExceptionB");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            throw new NullPointerException("NullPointerException");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            throw new InputMismatchException("InputMismatchException");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("--------\n2 :");
        try {
            Method();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void Method() throws Exception {
        Method2();
    }

    public static void Method2() throws Exception {
        throw new Exception("Error");
    }
}


