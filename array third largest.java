import java.util.Scanner;
public class Main{
    public static void main(String[] agrs) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the series");
        int[] newarray=new int[5];
        int temp=0;
        int second=0;
        int third=0;

        for (int i=0;i<= newarray.length-1;i++){
            int input=in.nextInt();
            newarray[i]=input;
            if(newarray[i]>temp){
                third=second;
                second=temp;
                temp=newarray[i];
            }
            else if (newarray[i]>second && second<temp){
                third =second;
                second=newarray[i];
            }
            else if(newarray[i]>third && third<second){
                third=newarray[i];
            }


        }
        System.out.println("largest"+temp);
        System.out.println("second largest"+second);
        System.out.println("third largest"+third);
        }








            }