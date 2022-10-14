package lab4.zxsipromise.lab3;

import java.util.Scanner;

public class Lab3ExtendWeightGrade2 {

    public static void main(String[] args) {
        /*
        use 3 times for loop to recive values from user's input,
        then use arraies to store those values
        note: totalPoint must be int type values, the earned point maybe int or double.
         */
        Scanner sc = new Scanner(System.in);
        int[] totalPoint = new int[8];
        for (int i = 0; i < totalPoint.length; i++) {
            System.out.println("Please enter total points of assignments");
            int number1 = sc.nextInt();
            totalPoint[i] = number1;
        }

        double[] earnedPoint = new double[8];
        for (int i = 0; i < earnedPoint.length; i++) {
            System.out.println("Please enter earned points of assignments");
            double number2 = sc.nextDouble();
            earnedPoint[i] = number2;
        }

        double[] percentage = new double[8];
        for (int i = 0; i < percentage.length; i++) {
            System.out.println("Please enter the percentage of assignments");
            double number3 = sc.nextDouble();
            percentage[i] = number3;
        }


        /*
        call method to calculate final grade.
         */
        Lab3ExtendWeightGrade extendgrade = new Lab3ExtendWeightGrade (totalPoint,earnedPoint,percentage);
        double fG = Lab3ExtendWeightGrade.getFinalGrade(totalPoint,earnedPoint,percentage);
//        System.out.println("Your final grade is: " + fG);
        Lab3ExtendWeightGrade.calculate(fG);



    }
}
