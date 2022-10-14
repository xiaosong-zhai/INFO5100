package lab4;
import java.util.ArrayList;
import java.util.Scanner;
public class Lab4ExtendWeightedGrades2 {
    /*
    create 3 ArrayLists to store user's input values
    enter the values in a row, Press SPACE to separate and ENTER to go to next step
    use if to judge the values ,and use method that created in the first class.
    if true to next step
   
     */
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the total points of the assignments in a row, Press SPACE to separate and ENTER to end");
        String inputStr1 = sc1.nextLine();
        Scanner st1 = new Scanner(inputStr1);
        ArrayList assignList = new ArrayList();
        while (st1.hasNextInt()) {
            assignList.add(st1.nextInt());
        }
        System.out.println(assignList);
        if (lab4.Lab4ExtendWeightedGrades.determin(assignList) == true) {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Enter the earned points of the assignments in a row, Press SPACE to separate and ENTER to end");
            String inputStr2 = sc2.nextLine();
            Scanner st2 = new Scanner(inputStr2);
            ArrayList earnedlist = new ArrayList();
            while (st2.hasNextDouble()) {
                earnedlist.add(st2.nextDouble());
            }
            System.out.println(earnedlist);
            if (lab4.Lab4ExtendWeightedGrades.compare(assignList,earnedlist) == true) {
                Scanner sc3 = new Scanner(System.in);
                System.out.println("Enter the percentage of the assignments in a row, Press SPACE to separate and ENTER to end");
                String inputStr3 = sc3.nextLine();
                Scanner st3 = new Scanner(inputStr3);
                ArrayList percentageList = new ArrayList();
                while (st3.hasNextDouble()) {
                    percentageList.add(st3.nextDouble());
                }
                System.out.println(percentageList);

                lab4.Lab4ExtendWeightedGrades.determinper(assignList,percentageList);

                lab4.Lab4ExtendWeightedGrades.calculate(assignList,earnedlist,percentageList);
            }else {
                System.out.println("The points your entered is not correct." + "\n"
                        + "1.The numbers of these elements need match the first row" + "\n"
                        + "2.The elements of second row need to lower or equal the first row");
            }
        }else {
            System.out.println("The points of the asignment your entered is not correct(points >= 0),Please enter again");

        }
    }

}

