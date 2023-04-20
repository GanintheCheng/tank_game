package 线程;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int youxiu=0;
        int jige=0;
        for(int i=0;i<n;i++){
            int temp=scan.nextInt();
            if(temp>=60)jige++;
            if(temp>=85)youxiu++;
        }
        System.out.printf("%.0f",100.0*jige/n);
        System.out.print("%");
        System.out.println();
        System.out.printf("%.0f",100.0*youxiu/n);
        System.out.print("%");
        scan.close();
    }
}