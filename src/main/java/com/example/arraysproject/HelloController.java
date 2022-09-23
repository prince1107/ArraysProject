package com.example.arraysproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15;

    @FXML
    private TextField input1, input2;

    @FXML
    private Label resultLabel;

    @FXML
    public void onHelloButtonClick() {
        findNumInArray();
        arrayMaxMinAvg();
        rollXDiceYTimes();
        translateAlphabet();
    }

    @FXML
    public void findNumInArray(){
        int num = 5;
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int[] array2 = {1,4,2,3,5,5,3,80,1,2,3,5,3,4,5,6,7,4,3,6,20,78,45};
        String positions = "Positions: ";
        int count = 0;

        for (int i = 0; i < array2.length; i++){
            if (array2[i] == num){
                positions += i + ", ";
                count++;
            }
        }
        positions += "How Many: " + count;

        System.out.println(positions);
    }

    @FXML
    public void arrayMaxMinAvg(){
        int[] array = new int[(int) (Math.random()*100)];
        String result = "";

        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random()*1000);
        }

//        for testing vvvv
//        result += "Array: " + Arrays.toString(array) + "; ";
        result += "Max: " + findMax(array) + "; ";
        result += "Min: " + findMin(array) + "; ";
        result += "Average: " + findAverage(array);

        System.out.println(result);
    }

    protected int findMax(int[] tempArray){
        int max = 0;

        for (int element:tempArray) {
            if (element > max){
                max = element;
            }
        }
        return max;
    }

    protected int findMin(int[] tempArray) {
        int min = 500000;

        for (int element : tempArray) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    protected double findAverage(int[] tempArray){
        double sum = 0;

        for (int element:
             tempArray) {
            sum += element;
        }

//        double sum = Arrays.stream(tempArray).sum();

        double length = tempArray.length;
        double average = sum/length;

        return average;
    }

    @FXML
    public void mutateArray(){

    }

    @FXML
    protected void rollXDiceYTimes(){
        int x = 2;
        int y = 20000000;

        int numFrequencies = x*6 - (x-1);
        int[] frequencies = new int[numFrequencies];
        int temp;

        String result = "";

        for (int i = 0; i < y; i++){
            temp = 0;
            for (int j = 0; j < x; j++){
                temp += (int) Math.round(Math.random()*5) + 1;
            }
            frequencies[temp - x]++;
        }

        result += "Array: " + Arrays.toString(frequencies) + ";";

        System.out.println(result);
    }

    @FXML
    protected void shuffleArray(){

    }

    @FXML
    protected void translateAlphabet(){
        ArrayList<Character> alphabet = new ArrayList<Character>();
        int translation = -5;

        String result = "";

        for (int i = 0; i < 26; i++){
            alphabet.add((char) (65 + i));
        }

        result += "Array: " + alphabet + ";";

        System.out.println(result);

        result = "";

        if (translation > 0) {
            for (int i = 0; i < translation; i++) {
                alphabet.add(0,alphabet.remove(alphabet.size()-1));;
            }
        } else if (translation < 0) {
            for (int i = 0; i < translation * -1; i++) {
                alphabet.add(alphabet.remove(0));;
            }
        } else{
            System.out.println("Don't input 0");
        }

        result += "Array: " + alphabet + ";";

        System.out.println(result);
    }

    @FXML
    protected void pascalsTriangle(){

    }

    @FXML
    protected void searchArray(){

    }

    @FXML
    protected void lockerSimulation(){

    }
}