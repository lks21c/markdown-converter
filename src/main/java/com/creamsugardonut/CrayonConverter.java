package com.creamsugardonut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CrayonConverter {

    private static final CharSequence TAB = "    ";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("week1.md")));
        String line;

        StringBuilder sb = new StringBuilder();
        boolean startCode = false;
        while ((line = reader.readLine()) != null) {
            if (line.contains(TAB)) {
                if (!startCode) {
                    startCode = true;
                }
                sb.append(line.replace(TAB, "") + "\n");
            } else {
                if(startCode) {
                    startCode = false;
                    System.out.println();
                    System.out.println("<pre class=\"lang:java\">" + sb.toString() + "</pre>");
                    System.out.println();
                    sb = new StringBuilder();
                }
            }
        }
        reader.close();
    }
}
