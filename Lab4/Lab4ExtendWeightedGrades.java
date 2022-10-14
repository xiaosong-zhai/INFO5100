package lab4;
import java.util.ArrayList;

public class Lab4ExtendWeightedGrades {
    /*
    method used to calculate the final grade with user's input values.
    then based on the final grade to determinate which scope of it and printout A-F
     */
    public static double calculate(ArrayList<Integer> List1, ArrayList<Double> List2,ArrayList<Double> List3) {
        double finalGrade = 0;
        for (int i = 0; i < List1.size(); i++) {
            finalGrade += List2.get(i) / List1.get(i) * List3.get(i) * 100;
        }
        System.out.println("Your finalGrade is: " + finalGrade);
        if (finalGrade >= 0.0 && finalGrade < 60.0) {
            System.out.println("Your grade belongs to : " + 'F');
        } else if (finalGrade >= 60.0 && finalGrade <70.0) {
            System.out.println("Your grade belongs to : " + 'D');
        } else if (finalGrade >= 70.0 && finalGrade <80.0) {
            System.out.println("Your grade belongs to : " + 'C');
        } else if (finalGrade >= 80.0 && finalGrade <80.9999) {
            System.out.println("Your grade belongs to : " + 'B');
        }else if (finalGrade >= 90.0 && finalGrade <=100.0){
            System.out.println("Your grade belongs to : " + 'A');
        }else{
            System.out.println("Your grade is not correct");
        }
        return finalGrade;
    }

    /*
    The points of an assignment must be above 0;
    method Used to determine whether the value entered by the user is greater than 0
    If the total point of a assignment is not greater than 0, then printout wrong
    if true,the go to the next step
     */
    public static boolean determin(ArrayList<Integer> List1) {
        for (int i = 0; i < List1.size(); i++) {
            if (List1.get(i) < 0) {
                return false;
            }
        }
        return true;
    }
    /*
    all of assignment's percentage must be equal 100%
    If the final percentage sum is one, go to the next step
    if not, printout wrong
     */
    public static void determinper (ArrayList<Integer> List1,ArrayList<Double> List3){
        if (List1.size() == List3.size()) {
            double sumper = 0;
            for (int i = 0; i < List3.size(); i++) {
                sumper += List3.get(i);
            }
            if (sumper == 1.0){

            }else {
                System.out.println("The whole percentages of assignments must equal 100%");
            }
        }else {
            System.out.println("The numbers of these elements do not match the first row");
        }
    }
    /*
    The student's earnedpoint cannot be greater than the total points of an assignment
    if greater, then return false
    if true,then go to next step.
     */
    public static boolean compare(ArrayList<Integer> List1, ArrayList<Double> List2) {
        if (List1.size() == List2.size()) {
//            System.out.println("The numbers of these elements do not match the first row");
            for (int i = 0; i < List1.size(); i++) {
                if (List2.get(i) > List1.get(i)) {
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
