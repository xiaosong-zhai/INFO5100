package lab4;
import java.util.ArrayList;

public class Lab4ExtendWeightedGrades {
    
    /*
    The points of an assignment must be above 0;
    method Used to determine whether the value entered by the user is greater than 0
    If the total point of a assignment is not greater than 0, then printout wrong
    if true,the go to the next step
     */
    public static boolean determin(ArrayList<Integer> assignList) {
        for (int i = 0; i < assignList.size(); i++) {
            if (assignList.get(i) < 0) {
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
    public static void determinper (ArrayList<Integer> assignList,ArrayList<Double> precentageList){
        if (assignList.size() == precentageList.size()) {
            double sumper = 0;
            for (int i = 0; i < precentageList.size(); i++) {
                sumper += precentageList.get(i);
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
    public static boolean compare(ArrayList<Integer> assignList, ArrayList<Double> earnedList) {
        if (assignList.size() == earnedList.size()) {
//            System.out.println("The numbers of these elements do not match the first row");
            for (int i = 0; i < assignList.size(); i++) {
                if (earnedList.get(i) > assignList.get(i)) {
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }

    /*
    method used to calculate the final grade with user's input values.
    then based on the final grade to determinate which scope of it and printout A-F
     */
    public static double calculate(ArrayList<Integer> assignList, ArrayList<Double> earnedList,ArrayList<Double> precentageList) {
        double finalGrade = 0;
        for (int i = 0; i < assignList.size(); i++) {
            finalGrade += earnedList.get(i) / assignList.get(i) * precentageList.get(i) * 100;
        }
        System.out.println("Your finalGrade is: " + finalGrade);
        if (finalGrade >= 0.0 && finalGrade < 60.0) {
            System.out.println("Your grade belongs to : " + 'F');
        } else if (finalGrade >= 60.0 && finalGrade <70.0) {
            System.out.println("Your grade belongs to : " + 'D');
        } else if (finalGrade >= 70.0 && finalGrade <80.0) {
            System.out.println("Your grade belongs to : " + 'C');
        } else if (finalGrade >= 80.0 && finalGrade <89.9999) {
            System.out.println("Your grade belongs to : " + 'B');
        }else if (finalGrade >= 90.0 && finalGrade <=100.0){
            System.out.println("Your grade belongs to : " + 'A');
        }else{
            System.out.println("Your grade is not correct");
        }
        return finalGrade;
    }
}

