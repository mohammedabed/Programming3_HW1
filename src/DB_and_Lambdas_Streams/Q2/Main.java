package DB_and_Lambdas_Streams.Q2;

import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("file.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();
        while (br.ready()) {
            sb.append(br.readLine()).append("\n");
        }
        System.out.println(sb);

        myOperation count = (text) -> {

            HashMap<String, Integer> hm = new HashMap();

            for (int i = 0; i < text.length(); i++) {
                Character chr = text.charAt(i);
                Integer i1 = hm.get(chr.toString());
                if (i1 == null) {
                    hm.put(chr.toString(), 1);
                } else {
                    hm.put(chr.toString(), i1 + 1);
                }
            }
            return hm;
        };

        System.out.println(count.operation(sb.toString()));

    }

    interface myOperation {

        Object operation(String text);
    }
}


