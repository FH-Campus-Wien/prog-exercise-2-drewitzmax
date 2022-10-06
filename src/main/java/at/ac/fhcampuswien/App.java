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
        int lines = this.getPositiveNumber('n');
        if(lines <= 0){
            System.out.println("Invalid number!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        int number = 1;
        for(int i = 1; i<=lines; i++){
            for(int j=0; j<i; j++){
                sb.append(number + " ");
                number++;
            }
            if(i != lines)
                sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    //todo Task 3
    public void printPyramid(){
        final int LINES = 6;
        for(int i=0; i<LINES; i++){
            for(int j=0; j < LINES - i - 1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<(1+(2*i)); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("h: ");
            int height = scanner.nextInt();
            System.out.print("c: ");
            char c = scanner.next().charAt(0);

            if(height % 2 == 0){
                System.out.println("Invalid number!");
                return;
            }

            actuallyPrintRhombus(height, c);
        }
    }

    //todo Task 5
    public void marks(){
        try (Scanner scanner = new Scanner(System.in)){
            int markSum = 0;
            int markCount = 0;
            int negativeMarks = 0;
            while(true){
                markCount++;
                System.out.printf("Mark %d: ", markCount);
                int mark = scanner.nextInt();
                if(mark < 0 || mark > 5){
                    System.out.println("Invalid mark!");
                    markCount--;
                    continue;
                }
                if(mark == 0){
                    double average = markCount == 0 || markSum == 0 ? 0:(double)markSum/(markCount - 1);

                    System.out.printf("Average: %.2f" + System.lineSeparator(),average);
                    System.out.println("Negative marks: " + negativeMarks);
                    return;
                }
                markSum += mark;
                if(mark == 5){
                    negativeMarks++;
                }
            }

        }
    }

    //todo Task 6
    public void happyNumbers(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("n: ");
            int number = scanner.nextInt();
            this.recursedHappyNumber(number);
        }
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

    private int getPositiveNumber(char name){
        System.out.print(String.format("%c: ", name));
        try(Scanner scanner = new Scanner(System.in)){
            return scanner.nextInt();
        }
    }

    private void actuallyPrintRhombus(int height, char character){
     for(int i=0; i<height; i++){
         if(i<=height/2){
             int j = 0;
             for(; j <= ((height/2)-i-1); j++){
                 System.out.print(" ");
             }
             for(;j <= ((height/2)+i); j++){
                 System.out.print((char)(character - Math.abs(j- (height/2))));
             }
         }else{
             int j=0;
             for(; j <= (i - (height/2)-1); j++){
                 System.out.print(" ");
             }
             for(;j <= height - i+1; j++){
                 System.out.print((char)(character - Math.abs(j- (height/2))));
             }
         }
         System.out.println();
     }
    }

    private void recursedHappyNumber(int number){
        if(number == 4){
            System.out.println("Sad number!");
            return;
        }
        if(number == 1){
            System.out.println("Happy number!");
            return;
        }
        int res = 0;
        String numString = Integer.toString(number);
        for (char c: numString.toCharArray()){
            int charNumber = Integer.parseInt(String.valueOf(c));
            res += charNumber * charNumber;
        }
        recursedHappyNumber(res);
    }
}