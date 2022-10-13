package lab4.zxsipromise.lab3;

public class Lab3ExtendWeightGrade {

    private double finalGrade;          ////Instance variables
    public Lab3ExtendWeightGrade (int[] totalPoint, double[] earnedPoint,double[] percentage){   //Constructor method
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

}
