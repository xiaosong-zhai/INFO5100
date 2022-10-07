package lab4.zxsipromise.lab3;

import java.util.Scanner;  //import scanner class

public class lab3extendweightgrade2 {
    public static void main(String[] args) { //main method(a entrance of a program)
        Scanner sc = new Scanner(System.in); //scanner method
        double sumper = 0;
        /* give a sum of percentage initial value in order to judge if the user input for percentage is correct*/
        double totalgrade = 0;//to caculate totalgrade
        for (int i = 0; i < 8; i++) {        // for loop 8 times to let user input point
            System.out.println("Please enter the totalpoint of an assignment ");
            int tp = sc.nextInt();           //the totalpoint of an assignment
            System.out.println("Please enter your earnpoint");
            double ea = sc.nextDouble();     //the point your earned
            System.out.println("Please enter the percentage of this assignment");
            double per = sc.nextDouble();    //the percentage of an assignment
            sumper += per;                   //everytime the user input a percentage, giveing a hit of the total percentage
            totalgrade += ea / tp * per * 100; //Evaluate expression
            System.out.println("Your totalgrade now is: " + totalgrade);
            if (sumper == 1.0) {
                //to judge if the sum of percentage that user input is equal 1 finally,if true,continue to judge grade level
                if (totalgrade >= 0.0 && totalgrade < 60.0) {
                    System.out.println("you grade belongs to : " + 'F');
                } else if (totalgrade >= 60.0 && totalgrade <70.0) {
                    System.out.println("you grade belongs to : " + 'D');
                } else if (totalgrade >= 70.0 && totalgrade <80.0) {
                    System.out.println("you grade belongs to : " + 'C');
                } else if (totalgrade >= 80.0 && totalgrade <80.9999) {
                    System.out.println("you grade belongs to : " + 'B');
                }else if (totalgrade >= 90.0 && totalgrade <=100.0){
                    System.out.println("you grade belongs to : " + 'A');
                }else{
                    System.out.println("You grade is not correct");
                }
            } else{
                System.out.println("The percentage is still left: " + sumper); // if not equal 1, output sum percentage
            }

            lab3extendweightgrade extendgrade = new lab3extendweightgrade();   //new extendgrade
            extendgrade.getgrade(tp,ea,per);
        }
    }
}
