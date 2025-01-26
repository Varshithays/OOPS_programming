package PRA;

import java.util.Scanner;

public class Divisible3 {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();int sum=0;
        for(int i=0;i<n;i++){
            int el= in.nextInt();
            sum+=el;
        }
        if(sum%3==0){
            System.out.println(sum+" TRUE");
        }else{
            System.out.println(sum+" FALSE");
        }
    }
}