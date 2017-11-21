package com.creamsugardonut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CrayonConverter {

    private static final CharSequence TAB = "    ";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("week1.md")));
        String line;

        StringBuilder output = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        boolean startCode = false;
        while ((line = reader.readLine()) != null) {
            if (line.contains(TAB)) {
                if (!startCode) {
                    startCode = true;
                }
                sb.append(line.replace(TAB, "") + "\n");
            } else {
                if (startCode) {
                    startCode = false;
                    System.out.println();

                    Scanner sc = new Scanner(System.in);

                    System.out.println(sb.toString() + "에 쓸 언어");

                    output.append("\n" + "<pre class=\"lang:" + sc.next() + "\">" + sb.toString() + "</pre>" + "\n");
                    sb = new StringBuilder();
                }
            }
        }

        System.out.println("output :" + output.toString());
        reader.close();
    }
}
