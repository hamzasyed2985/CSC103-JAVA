import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of given options: ");
        System.out.println("1. For largest element in array: ");
        System.out.println("2. For index of largest element in array: ");
        System.out.println("3. For summing elements in array: ");
        System.out.println("4. For random array in array: ");
        System.out.println("5. For shuffling element in array: ");
        System.out.println("6. For shifting elements in array: ");
        System.out.println("7. For searching elements in array: ");
        System.out.println("8. For binary searching elements in array: ");
        int option = in.nextInt();
        if (option == 1) {
            System.out.println("enter 1. for single dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter size of array ");
            int size = in.nextInt();
            int[] array = new int[size];
            for (int i = 0; i <= array.length - 1; i++) {
                System.out.println("enter element " + i);
                int input = in.nextInt();
                array[i] = input;
            }
            largestelement(array);
        }
        if (option == 2) {
            System.out.println("enter 1. for single dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter size of array ");
            int size = in.nextInt();
            int[] array = new int[size];
            for (int i = 0; i <= array.length - 1; i++) {
                System.out.println("enter element " + i);
                int input = in.nextInt();
                array[i] = input;
            }

            indexoflargest(array);
        }
        if (option == 3) {
            System.out.println("enter 1. for single dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter size of array ");
            int size = in.nextInt();
            int[] array = new int[size];
            for (int i = 0; i <= array.length - 1; i++) {
                System.out.println("enter element " + i);
                int input = in.nextInt();
                array[i] = input;
            }
            summing(array);
        }
        if (option == 4) {
            System.out.println("enter 1. for single dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter size of array ");
            int size = in.nextInt();
            Random rd = new Random();
            int[] array = new int[size];
            for (int i = 0; i <= array.length - 1; i++) {
                array[i] = rd.nextInt(1, 100);
            }
            randomarray(array);
        }
        if (option == 5) {
            System.out.println("enter 1. for single dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter size of array ");
            int size = in.nextInt();
            int[] array = new int[size];
            for (int i = 0; i <= array.length - 1; i++) {
                System.out.println("enter elemets of array: " + i);
                array[i] = in.nextInt();
            }
            shuffling(array);
        }
        if (option == 6) {
            System.out.println("enter 1. for single dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter size of array ");
            int size = in.nextInt();
            int[] array = new int[size];
            for (int i = 0; i <= array.length - 1; i++) {
                System.out.println("enter elemets of array: " + i);
                array[i] = in.nextInt();
            }
            shifting(array);
        }
        if (option == 7) {
            System.out.println("enter 1. for single dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter size of array ");
            int size = in.nextInt();
            Random rd = new Random();
            int[] array = new int[size];
            for (int i = 0; i <= array.length - 1; i++) {
                array[i] = rd.nextInt(1, 100);
            }
            searching(array);}
        if (option == 8) {
            System.out.println("enter 1. for single dimession array: ");
            int dimension = in.nextInt();
            System.out.println("enter size of array ");
            int size = in.nextInt();
            int[] array = new int[size];
            for (int i = 0; i <= array.length - 1; i++) {
                System.out.println("enter elemets of array: " + i);
                array[i] = in.nextInt();}
            System.out.println("enter the element you want to binary search");
            int inp=in.nextInt();
                binary(array,inp);}
    }

    public static void largestelement(int[] arr){
        int temp=0;
        for (int i=0;i<= arr.length-1;i++){
            if(arr[i]>temp){
                temp=arr[i];}}
        System.out.println("largest "+temp);}
    public static void indexoflargest(int[] arr){
        int temp=0;
        for (int i=0;i<= arr.length-1;i++){
            if(arr[i]>temp){
                temp=i;}}
        System.out.println("Index of largest "+temp);}
    public static void summing(int[] arr){
        int total=0;
        for (int i=0;i<= arr.length-1;i++){
            total+=arr[i];
        }System.out.println("SUM "+total);}
    public static void randomarray(int[] arr){
        for(int x:arr)
            System.out.println(x);

}
    public static void shuffling(int[] arr){
        Random rd=new Random();
        for (int i=1;i< arr.length;i++){
            int randomindex= rd.nextInt(arr.length);
            int temp=arr[randomindex];
            arr[randomindex]=arr[i];
            arr[i]=temp;}
        for(int x:arr){
            System.out.println(x);}
    }
    public static void shifting(int[] arr){
        Scanner in =new Scanner(System.in);
        System.out.println("emter index number to shift:");
        int index1=in.nextInt();
        System.out.println("enter another index number to get shifted: ");
        int index2=in.nextInt();
        int temp=0;
        temp=arr[index2];
        arr[index2]=arr[index1];
        arr[index1]=temp;
        for(int x:arr){
            System.out.println(x);
        }
    }
    public static void searching(int[] arr){
        Scanner in =new Scanner(System.in);
        System.out.println("enter the element you want to search: ");
        int input =in.nextInt();
        int count=0;
        for(int i=0;i< arr.length;i++){
            if (input==arr[i]){
                count++;
                }
            }
        if(count>0){System.out.println("This element exists in array");}
        else{System.out.println("this does not exist");}
    }
    public static void binary(int[] arr,int key){
        int low=0;
        int high=arr.length-1;
        Arrays.sort(arr);
        System.out.println(arr.length/2);
        if(key==arr[arr.length/2]){
            System.out.println("Math found at index:" +arr.length/2+" \nVlaue is: "+arr[arr.length/2]);
        }
        for (int i=0;i<arr.length/2;i++){
            if(key==arr[i]){
            System.out.println("MAtch found at index:" +i+"\nValue is : "+arr[i]);}
        }
        for (int i=(arr.length/2)+1;i<=arr.length-1;i++){
            if(key==arr[i]){
            System.out.println("MAtch found at index:" +i+"\nValue is : "+arr[i]);}
        }



    }




    }
