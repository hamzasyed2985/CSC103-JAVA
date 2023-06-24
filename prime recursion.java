
    import java.util.Scanner;
import java.util.Date;

    public class outputtest {

        public static void main(String[] args) {
            // Create a Scanner
            Scanner input = new Scanner(System.in);
            System.out.println("Enter total numbers:");
            int total= input.nextInt();
            int[] array=new int[total];
            for(int i=1;i<total;i++){
                 int check=m(i,2);
                if(check==1){
                    array[i]=i;
                }else
                    array[i]=0;}
            for(int i=1;i< array.length;i++){
                System.out.println(array[i]+" "+i);
            }

            System.out.println(sumofprime(array,0));


        }
        private static int  m(int n ,int i) {
            if(i<n) {
                if (n % i != 0) {
                    return m(n, ++i);
                } else {
                    return 0;
                }
            }
             return 1;

        }
        private static int  sumofprime(int[] n,int index ) {
            if(index==n.length-1){
                return n[index];}
        else return n[index] + sumofprime(n,index+1);
        }

    }


