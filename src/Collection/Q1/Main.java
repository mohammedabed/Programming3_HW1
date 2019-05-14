package Collection.Q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        HashMap<String, Integer> hm = new HashMap();

        File file = new File("C:\\Users\\jit\\test.txt");
        Scanner in = new Scanner(file);

        while (in.hasNext()) {
            //Word
            String word = in.next();
            System.out.println(word);

            Integer i = hm.get(word);
            if (i == null) {
                hm.put(word, 1);
            } else {
                hm.put(word, i + 1);
            }
            //Craracter
            for (int j = 0; j < word.length(); j++) {

                Character chr = word.charAt(j);
                System.out.println(chr);

                Integer i2 = hm.get(chr.toString());
                if (i2 == null) {
                    hm.put(chr.toString(), 1);
                } else {
                    hm.put(chr.toString(), i2 + 1);
                }
            }

            System.out.println(hm);

        }
    }
}


