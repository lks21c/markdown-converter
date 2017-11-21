package com.creamsugardonut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CrayonConverter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("week1.md")));
        String line;
        while ((line = reader.readLine()) != null) {
            if(line.equals("    ")){
                System.out.println("yes");
            }
        }
        reader.close();
    }
}
