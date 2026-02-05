
/**
 * Write a description of class GradeCalculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class GradeCalculator
{
    public static void main(String[]args){
        Scanner input= new Scanner(System.in);
        int score;
        System.out.println("===Grade Calculator===\n");
        
        System.out.println("Enter your exam Score (0-100)");
        score=input.nextInt();
        
    if(score<0|| score>100){
         System.out.println("Error: Score must be between 0 and 100");
    }else{
        if(score>=90){
             System.out.println("Grade: A (Excellent)");
        }else if(score>=80){
             System.out.println("Grade: B (Very Good)");
        }else if(score>=70){
            System.out.println("Grade: C (Good)");
        }else if (score>=60){
            System.out.println("Grade: D (Satisfactory)");
        }else if(score>=50){
            System.out.println("Grade: E (Pass)");
        }else{
            System.out.println("Grade: F (Fail)");
        }
        }
    if(score>=50){
            System.out.println("Status: PASSED! Congratulations!");
        }else{
            System.out.println("Status: FAILED. Please try again");
        }
        input.close();
    }
}
    

        
        
    