import java.util.Scanner;
public class Main{
    public static void main(String[] agrs) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the number");

        int num1 =in.nextInt();
                int num2 =in.nextInt();
                int num3 =in.nextInt();
                if ((num1 > num2 && num1 > num3)) {
                    if(num2 > num3) {
                        System.out.print(num1 + " " + num2 + " " + num3);}
                    else
                        System.out.print(num1 + " " + num3 + " " + num2);}

                else if ((num2 > num1 && num2 > num3)) {
                    if(num1 > num3) {
                        System.out.print(num2 + " " + num1 + " " + num3);}
                    else {
                        System.out.print(num1 + " " + num3 + " " + num1);
                    }}

                else if ((num3 > num1 && num3 > num2)) {
                    if(num1 > num2) {
                        System.out.print(num3 + " " + num1 + " " + num2);}
                    else
                        System.out.print(num3 + " " + num2 + " " + num1);}
                else {
                    System.out.println("ERROR!");}

            }}