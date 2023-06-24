import java.util.Scanner;
public class Main{
    public static void main(String[] agrs) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the series");
        int num= in.nextInt();
        int first=0;
        int second=0;
        int third=0;

        while(num!=0){
             num =in.nextInt();
             if(num>first){
                 third=second;
                 second=first;
                 first=num;}
             if(num>second && num<first){
                 third= second;
                     second=num;
                 }
             if(num>third && num<second){
            third=num;
            }}
        System.out.println(" "+first+" "+second+" "+third);
            }}