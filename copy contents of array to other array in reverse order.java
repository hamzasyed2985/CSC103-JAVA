import java.util.Scanner;
public class Main{
    public static void main(String[] agrs) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the series");
        int[] array ={1,2,3,4,5,6};
        int [] rev=new int[6];
        for (int i=array.length-1;i>=0;i--){
            System.out.println(array[i]);
            rev[i]=array[i];
        }
        for(int x:rev)
        System.out.println(x);
    }}