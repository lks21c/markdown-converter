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
        Scanner sc = new Scanner(System.in);

        boolean allSameLanguage = false;
        StringBuilder output = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        boolean startCode = false;

        System.out.println("Plase enter global language name, otherwise press no.");
        String language = sc.next();

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

                    if (language.equals("no")) {
                        System.out.println(sb.toString() + ", which language will you use?");
                        output.append("\n" + "<pre class=\"lang:" + sc.next() + "\">" + sb.toString() + "</pre>" + "\n");
                    } else {
                        output.append("\n" + "<pre class=\"lang:" + language + "\">" + sb.toString() + "</pre>" + "\n");
                    }
                    sb = new StringBuilder();
                }
            }
        }

        System.out.println("output :" + output.toString());
        System.out.println("<a href=\"http://www.kwangsiklee.com/\" target=\"_blank\"><img src=\"http://www.kwangsiklee.com/wp-content/uploads/2017/01/kwangsiklee4.png\" /></a>");
        reader.close();
    }
}
