package lab4.zxsipromise.lab3;

public class Lab3ExtendWeightGrade {

    private double finalGrade;          ////Instance variables

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public Lab3ExtendWeightGrade (int[] totalPoint, double[] earnedPoint, double[] percentage){   //Constructor method
        double fG = getFinalGrade(totalPoint,earnedPoint,percentage);
        this.finalGrade = fG;
    }
    /*
    create method used to calculate finalgrade
    sumpercentage used to determin if the whole percentage is euqal 100%
    if true, next to calculate
    if not, next printout wrong
     */
    public static double getFinalGrade (int[] totalPoint, double[] earnedPoint,double[] percentage){
        double finalGrade = 0;
        double sumPercentage = 0;
        for (int i = 0; i < totalPoint.length; i++) {
            sumPercentage += percentage[i];
            finalGrade += earnedPoint[i] / totalPoint[i] * percentage[i] * 100;
        }
        if (sumPercentage == 1.0) {

        }else{
            System.out.println("The total percentage is not equal 100%");
        }
        return finalGrade;
    }

    public static void calculate(double finalGrade) {
        System.out.println("Your finalGrade is: " + finalGrade);
        if (finalGrade >= 0.0 && finalGrade < 60.0) {
            System.out.println("Your grade belongs to : " + 'F');
        } else if (finalGrade >= 60.0 && finalGrade < 70.0) {
            System.out.println("Your grade belongs to : " + 'D');
        } else if (finalGrade >= 70.0 && finalGrade < 80.0) {
            System.out.println("Your grade belongs to : " + 'C');
        } else if (finalGrade >= 80.0 && finalGrade < 89.9999) {
            System.out.println("Your grade belongs to : " + 'B');
        } else if (finalGrade >= 90.0 && finalGrade <= 100.0) {
            System.out.println("Your grade belongs to : " + 'A');
        } else {
            System.out.println("Your grade is not correct");
        }
    }

}
