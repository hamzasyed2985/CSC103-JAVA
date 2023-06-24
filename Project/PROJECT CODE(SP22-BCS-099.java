import java.util.InputMismatchException;
import java.util.Scanner;
public class Project {
    public static void main (String[] args){
        Scanner in =new Scanner(System.in);
        //Creating array of 100 plots whose columns show detail of each plot
        String[][] plots=new String[100][9];
        //Declaring every plot Available at the start
        for (int i=0;i<100;i++){
            for (int j=0;j<1;j++){
                plots[i][j]="Available";
            }}
        //for (int i=0;i<100;i++){
            //for (int j=0;j<8;j++){
                //System.out.println(plots[i][j]);}}

        while(true) {

            System.out.println("WELCOME! \n1.Press 1 for Admin\n2.Press 2 for User\n3.Press 0 to Exit ");
            String adminORuser = in.next();
            if (adminORuser.equalsIgnoreCase("1")) {
                adminpanel(plots);
            }
            else if (adminORuser.equalsIgnoreCase("2")) {
                Userpanel(plots);
            }
            else if(adminORuser.equalsIgnoreCase("0")){
                break;
            }
        }
    }
    public static void adminpanel(String[][] plots){
        Scanner in=new Scanner(System.in);
        try{
        if(Adminlogin()==1){
            System.out.println("Logged in successfully.");
            System.out.println("press 1. for Booking ");
            System.out.println("press 2. for Plots Status ");
            System.out.println("press 3. for Editing ");
            int admin= in.nextInt();
            if(admin==1){
                booking(plots);
            }
            else if(admin==2){
                plotstatus(plots);
            }
            else if (admin==3) {
                 Editing(plots);                   }
        }
        else
            System.out.println("Wrong Password");}
        catch (InputMismatchException e){
            System.out.println("Please enter correct digit ");
        }
    }
    public static void Userpanel(String[][] plots){

        plotstatus(plots);
    }
    public static int Adminlogin(){
        Scanner in =new Scanner(System.in);
        String password="admin";
        System.out.println("Enter your password: ");
        String admpass= in.next();
        if(admpass.equalsIgnoreCase(password)){
            return 1;
        }else
            return 0;

    }
    public static void booking(String[][] plots){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter plot number for booking");
        try{
            int plotnum=in.nextInt();
        if(plots[plotnum][0].equalsIgnoreCase("Available")) {
            for (int j = 0; j < 9; j++) {
                plots[plotnum][j]="null";}
            System.out.println("Enter the Owner's name: ");
            in.nextLine();
            String ownername = in.nextLine();
            plots[plotnum][1] = ownername;
            System.out.println("Enter Your Mobile Number: ");
            String mobno = in.nextLine();
            plots[plotnum][2] = mobno;
            System.out.println("Enter payment method \nPress 1 for full payment\nPress 2 for installments: ");
            int paymenttype = in.nextInt();
            if (paymenttype == 1) {
                plots[plotnum][3] = "Full Payment";
                fullpayment(plots, plotnum);
                plots[plotnum][0] = "Booked";
                System.out.println("Plot " + plotnum + " booked");
            }
            else if (paymenttype == 2) {
                plots[plotnum][3] = "Installments";
                Installmentplan(plots, plotnum);
                plots[plotnum][0] = "Booked";
                System.out.println("Plot " + plotnum + " booked");
            }else {
                System.out.println("Enter correct number");
                plots[plotnum][0] = "Available";
            }

        }else System.out.println("Plot is already Booked");}
        catch (InputMismatchException e){
            System.out.println("Mismatched error TRY AGAIN!");
        }
    }
    public static void fullpayment(String[][] plots,int plotnum){
        Scanner in=new Scanner(System.in);
        System.out.println("Press 1 if paid And 0 if not paid");
        String paid=in.next();
        if(paid.equals("1")){
            plots[plotnum][4]="Payment Status: Paid";}
        else if(paid.equals("0")){
            plots[plotnum][4]="Payment Status: Not Paid";}
        else {throw new InputMismatchException("Error");
        }

    }
    public static void Installmentplan(String[][] plots,int plotnum){
        Scanner in=new Scanner(System.in);
        System.out.println("Select the Installment Plant:\nPress \"1\" for 2 Installment Plan.\nPress \"2\" for 3 Installment Plan.");
        int plan=in.nextInt();
        if(plan==1){
            plots[plotnum][5]="2 Installment Plan";
            System.out.println("Press 1 if First installment paid or 0 otherwise ");
            int first=in.nextInt();
            if(first==0){
                plots[plotnum][6]="First Installment: NOT Paid";
                plots[plotnum][7]="Second Installment: NOT Paid";}
            else if(first==1){plots[plotnum][6]="First Installment: Paid";
                System.out.println("Press 1 if Second installment paid or 0 otherwise ");
                int second=in.nextInt();
                if(second==1){
                    plots[plotnum][7]="Second Installment: Paid";}
                else if(second==0){plots[plotnum][7]="Second Installment: NOT Paid";}}
        }
        else if(plan==2){
            plots[plotnum][5]="3 Installment Plan";
            System.out.println("Press 1 if First installment paid or 0 otherwise ");
            int first=in.nextInt();
            if(first==0){
                plots[plotnum][6]="First Installment: NOT Paid";
                plots[plotnum][7]="Second Installment: NOT Paid";
                plots[plotnum][8]="Third Installment: NOT Paid";}
            else if(first==1) {
                plots[plotnum][6] = "First Installment: Paid";
                System.out.println("Press 1 if Second installment paid or 0 otherwise ");
                int second = in.nextInt();
                if (second == 0) {
                    plots[plotnum][7] = "Second Installment: NOT Paid";
                    plots[plotnum][8] = "Third Installment: NOT Paid";
                } else if (second == 1) {
                    plots[plotnum][7] = "Second Installment: Paid";
                    System.out.println("Press 1 if Third installment paid or 0 otherwise ");
                    int third = in.nextInt();
                    if (third == 1) {
                        plots[plotnum][8] = "Third Installment: Paid";
                    } else if (third == 0) {
                        plots[plotnum][8] = "Third Installment: NOT Paid";
                    }}
            }
        }
    }
    public static void plotstatus(String[][] plots) {
        try{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter plot number for details (1-99): ");
        int plotnum = in.nextInt();
        if (plotnum < 100) {
            if (plots[plotnum][0].equals("Booked")) {

                System.out.println("Plot Number: " + plotnum);
                for (int j = 0; j < 9; j++) {
                    if (j == 0) {
                        System.out.println("Plot Status: " + plots[plotnum][j]);
                    } else if (j == 1) {
                        System.out.println("Owner's Name: " + plots[plotnum][j]);
                    } else if (j == 2) {
                        System.out.println("Mobile Number " + plots[plotnum][j]);
                    } else if (j == 3) {
                        System.out.println("Payment Type: " + plots[plotnum][j]);
                    } else if (j == 4) {
                        if (plots[plotnum][j].equalsIgnoreCase("null")) {
                            if (plots[plotnum][8].equalsIgnoreCase("Third Installment: NOT Paid")) {
                                plots[plotnum][4] = "Payment Status: Not Paid";
                                System.out.println(plots[plotnum][4]);
                            }else if (plots[plotnum][8].equalsIgnoreCase("Third Installment: Paid")) {
                                plots[plotnum][4] = "Payment Status: Paid";
                                System.out.println(plots[plotnum][4]);
                            }
                        } else if (!plots[plotnum][j].equalsIgnoreCase("null")) {
                            if (plots[plotnum][8].equalsIgnoreCase("Third Installment: NOT Paid")) {
                                plots[plotnum][4] = "Payment Status: Not Paid";
                                System.out.println(plots[plotnum][4]);
                            }else if (plots[plotnum][8].equalsIgnoreCase("Third Installment: Paid")) {
                                plots[plotnum][4] = "Payment Status: Paid";
                                System.out.println(plots[plotnum][4]);
                            }
                            else
                                System.out.println(plots[plotnum][j]);}
                    } else if (j == 5) {
                        if (plots[plotnum][j].equalsIgnoreCase("null")){
                            System.out.print(" ");}
                        else {
                            System.out.println(plots[plotnum][j]);}
                    } else if (j == 6) {
                        if (plots[plotnum][j].equalsIgnoreCase("null")){
                            System.out.print(" ");}
                        else {
                            System.out.println("Payment Status: " + plots[plotnum][j]);}
                    }else if (j == 7) {
                        if (plots[plotnum][j].equalsIgnoreCase("null")){
                            System.out.print(" ");}
                        else {
                            System.out.println("Payment Status: " + plots[plotnum][j]);}
                    }if(j==8){
                        if (plots[plotnum][j].equalsIgnoreCase("null")){
                            System.out.print(" ");}
                        else {
                            System.out.println("Payment Status: " + plots[plotnum][j]);}
                    }
                }
            }
            else {
                System.out.println("Plot is not booked!");
            }}
    }
    catch(InputMismatchException e){
        System.out.println("Enter Correct Number");
    }}
    public static void Editing(String[][] plots){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Plot Number For Changes: ");
        int plotnum=in.nextInt();
        if (plots[plotnum][0].equals("Booked")) {
            System.out.println("What do you want to change:\n1. For Name \n2. For Mobile Number\n3. For Payment Status\n4. For 1st Installment\n5. For 2nd Installment\n6. For 3rd Installment");
            String change = in.next();
            if (change.equalsIgnoreCase("1")) {
                System.out.println("Enter New Name: ");
                in.nextLine();
                String name = in.nextLine();
                plots[plotnum][1] = name;
            } else if (change.equalsIgnoreCase("2")) {
                System.out.println("Enter New Mobile Number: ");

                String name = in.nextLine();
                plots[plotnum][2] = name;
            } else if (change.equalsIgnoreCase("3")) {
                System.out.println("Type Payment Status: Paid or Not Paid");
                in.nextLine();
                String status = in.nextLine();
                if (status.equalsIgnoreCase("Paid")) {
                    plots[plotnum][4] = "Payment Status: Paid";
                }
                else if (status.equalsIgnoreCase("Not Paid")) {
                    plots[plotnum][4] = "Payment Status: Not Paid";
                } else {
                    System.out.println("Status not correct!");
                }
            } else if (change.equalsIgnoreCase("4")) {
                if (plots[plotnum][6].equalsIgnoreCase("null")) {
                    System.out.print(" ");}
                else {
                System.out.println("Type 1st Installment Status: Paid or Not Paid");

                String status = in.nextLine();
                if(status.equalsIgnoreCase("Paid")){
                    plots[plotnum][6] = "First Installment: Paid";}
                else if(status.equalsIgnoreCase("Not Paid")){
                    plots[plotnum][6] = "First Installment: Not Paid";
                }else{
                    System.out.println("Status not correct!");}}
            } else if (change.equalsIgnoreCase("5")) {
                if (plots[plotnum][7].equalsIgnoreCase("null")) {
                    System.out.print(" ");}
                else {
                System.out.println("Type 2nd Installment Status: Paid or Not Paid");
                String status = in.next();
                if(status.equalsIgnoreCase("Paid")){
                    plots[plotnum][7] = "Second Installment: Paid";}
                else if(status.equalsIgnoreCase("Not Paid")){
                    plots[plotnum][7] = "Second Installment: Not Paid";
                }else{
                    System.out.println("Status not correct!");}}
            } else if (change.equalsIgnoreCase("6")) {
                if (plots[plotnum][8].equalsIgnoreCase("null")) {
                    System.out.print(" ");}
                else {
                System.out.println("Type 3rd Installment Status: Paid or Not Paid");
                in.nextLine();
                String status = in.nextLine();
                if(status.equalsIgnoreCase("Paid")){
                    plots[plotnum][8] = "Third Installment: Paid";}
                else if(status.equalsIgnoreCase("Not Paid")){
                    plots[plotnum][8] = "Third Installment: Not Paid";
                }else{
                    System.out.println("Status not correct!");}
            }}
        }
        else{
            System.out.println("Plot is not Booked!");
        }
    }
}
