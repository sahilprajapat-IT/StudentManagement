package org.s;
import java.util.*;

public class Newpage {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of page");
        int n = sc.nextInt();
        System.out.println("Enter what page you want to search ");
        int q = sc.nextInt();
////        if(n/2<q){
////            int sum = 0;
////            for(int i =n;i>=q;i--){
////                sum+=1;
////            }
////            System.out.println(sum/2);
////        }
////        else {
////            int sum = 0;
////            for(int i=0;i<=q;i++){
////                sum+=1;
////            }
//            System.out.println((sum/2-1));
//        }
        int sum = 0;
        for(int i = n; i >= n/2; i--){
            if(i != q){
                sum += 1;
            }

        }
        System.out.println(sum/2 );
    }


}
