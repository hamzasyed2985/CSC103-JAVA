import java.util.Scanner;



public class Main{

    public static void main(String[] args)  {
        Scanner ham=new Scanner(System.in);
        System.out.println("Enter range to check if its prime or not: ");

        System.out.println("Enter First number of range ");
        int start=ham.nextInt();
        System.out.println("Enter Second number of range ");
        int end=ham.nextInt();

        int i;
        for(int j=start;j<=end;j++){
            int count=0;
            for (i=2; i < j; i++){
            if (j%i==0){
                count++;
                break;}}

           if (count==0){
               System.out.println("it is prime number "+j);}
           else{
               System.out.println("composite "+j);}
    }}}