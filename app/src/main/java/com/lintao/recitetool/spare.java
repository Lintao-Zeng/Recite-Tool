package com.lintao.recitetool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class spare {

    public static int index = 0;
    public static int count = 1;
    public static int line = getLine();

    public static String[] getTemp() {

        String[] temp = new String[line];
        int i = 0;

        try {
            FileReader fr = new FileReader("/sdcard/content.txt");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                temp[i]=str;
                i++;
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return temp;
    }

    //    txt行数获取函数
    public static int getLine() {
        int count=0;
        File file = new File("/sdcard/content.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fis);
        while(scanner.hasNextLine()){
            scanner.nextLine();
            count++;
        }
        return count;
    }

}
