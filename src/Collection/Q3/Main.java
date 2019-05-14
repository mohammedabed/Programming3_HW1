package Collection.Q3;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        Random r = new Random();
        int random;
        int sum = 0;

        // inserts 25 random integers from 0 to 100
        for (int i = 0; i < 25; i++) {
            random = r.nextInt(100);
            list.add(random);
        }
        //printout list content
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("*****************************");

        //sort
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 > o1) {
                    return 1;
                } else if (o2 < o1) {
                    return -1;
                }
                return 0;
            }
        });
        //printout list content
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            sum += list.get(i);
        }

        System.out.println("******************************");
        System.out.println("The sum of the elements is : " + sum);
        System.out.println("The floating-point average of the elements is : " + (sum / 25));
    }
}


