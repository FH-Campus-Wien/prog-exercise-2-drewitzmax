package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber(){
        List<Double> numbers = this.getNumbersUntilNonPositive();
        try{
            double max = this.findMaximum(numbers);
            System.out.println(String.format("The largest number is %.2f", max));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    //todo Task 2
    public void stairs(){
        // input your solution here
    }

    //todo Task 3
    public void printPyramid(){
        // input your solution here
    }

    //todo Task 4
    public void printRhombus(){
        // input your solution here
    }

    //todo Task 5
    public void marks(){
        // input your solution here
    }

    //todo Task 6
    public void happyNumbers(){
        // input your solution here
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }

    private List<Double>getNumbersUntilNonPositive(){
        int num = 1;
        List<Double> numbers = new ArrayList<>();
        boolean wasPositive = false;
        try(Scanner scanner = new Scanner(System.in)){
            do{
                System.out.print(String.format("Number %d: ", num));
                num++;
                double input = scanner.nextDouble();
                wasPositive = input > 0;
                if(wasPositive){
                    numbers.add(input);
                }
            } while (wasPositive);
        }
        return numbers;
    }

    private double findMaximum(List<Double> numbers){
        if(numbers.isEmpty()){
            throw new IllegalArgumentException("No number entered.");
        }
        double max = numbers.get(0);
        for(double num: numbers){
            if(num > max){
                max = num;
            }
        }
        return max;
    }
}