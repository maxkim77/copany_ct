package 현대오토에버;

import java.util.*;
import java.io.*;
public class HDjava01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long N =0;
        int K= 0;
        String input;
        long answer;
        input = sc.next();
        String[] array = input.split(" ");
        N = Long.parseLong(array[0]);
        K = Integer.parseInt(array[1]);
        answer=(N/(2*K+1))+K;
        System.out.print(answer);
        sc.close();
    }
}