import java.util.Arrays;
import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        String[] lockers = new String[100];
        for(int i=1;i< lockers.length;i++){
            lockers[i]="Close";
        }

int start=0;
        for(int i=1;i< lockers.length;i++){
            for(int j=1;j< lockers.length;j+=i)  {
                if(lockers[i].equalsIgnoreCase("OPEN")){
                        lockers[j]="Close";
                }else {
                    lockers[j]="OPEN";
                }

            }start++;
        }
        for (int i = 1; i < lockers.length; i++) {
            if (lockers[i].equalsIgnoreCase("OPEN")) {
                System.out.print("L" + (i ) + " ");
            }
        }
        System.out.println();


    }}