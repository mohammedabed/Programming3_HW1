package DB_and_Lambdas_Streams.Q1;



public class Main {

    public static void main(String[] args) {
        //a
        myOperation accept = (value) -> System.out.printf("%d \n", value);
        accept.operation(5);

        //b
        myOperation2 operation2 = String::toUpperCase;
        System.out.println(operation2.operation("abc"));

        //c
        myOperation3 print = () -> {
            return "Welcome to lambdas!";
        };
        System.out.println(print.operation());

        //d
        myOperation4 operation4 = Math::sqrt;
        System.out.println(operation4.operation(9));

        //e
        myOperation5 cube = (num) -> num * num * num;
        System.out.println(cube.operation(2));
    }

    interface myOperation {

        void operation(int value);
    }

    interface myOperation2 {

        String operation(String text);
    }

    interface myOperation3 {

        String operation();
    }

    interface myOperation4 {

        double operation(double num);
    }

    interface myOperation5 {

        double operation(double num);
    }


}
