package com.example.arraysproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;

    @FXML
    private TextField input1, input2;

    @FXML
    private Label resultLabel;

    @FXML
    private ListView resultView;

//    @FXML
//    public void onHelloButtonClick() throws IOException {
//        findNumInArray();
//        arrayMaxMinAvg();
//        mutateArray();
//        rollXDiceYTimes();
//        shuffleArray();
//        translateAlphabet();
//        pascalsTriangle();
//        searchArray();
//        lockerSimulation();
//        rainAccumumulation();
//    }

    @FXML
    public void findNumInArray(){
        int num = 5;
        int[] array = new int[(int) (Math.random() * 11 + 10)];

        for (int element:
             array) {
            element = (int) (Math.random()*50);
        }
        System.out.println(Arrays.toString(array));

        String positions = "Positions: ";
        int count = 0;

        for (int i = 0; i < array.length; i++){
            if (array[i] == num){
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
        int function = 1;
        int index = 5;
        int num = 5;

        int[] array = {0,1,2,3,4,7,6,7,8,9,10};
        int[] finalArray = new int[array.length + 1];

        if (function == 0) {
            System.arraycopy(array, 0, finalArray, 0, array.length);
            finalArray[finalArray.length-1] = num;
            System.out.println(Arrays.toString(finalArray));
        } else if (function == 1) {
            System.out.println(Arrays.toString(array));
            array[index] = num;
            System.out.println(Arrays.toString(array));
        }
    }

    @FXML
    protected void rollXDiceYTimes(){
        int x = 1;
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

        String[] resultArray = new String[frequencies.length];

        for (int i = 0; i < resultArray.length; i++){
            resultArray[i] = "Frequency of " + (i + x) + ": " + frequencies[i];
        }

        result = "";

        result += "resultArray: " + Arrays.toString(resultArray) + ";";

        System.out.println(result);
    }

    @FXML
    protected void shuffleArray(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> array2 = new ArrayList<Integer>();

        for (int i = 0; i <= 20; i++){
            array.add(i);
        }
        System.out.println(array);

        for (int i = 0; i <= array.size(); i++){
            array.add((int) (Math.random()*array.size()), array.remove((int) (Math.random()*array.size())));
        }
        System.out.println("Shuffle 1: " + array);

        int iterations = array.size();

        for (int i = 0; i < iterations; i++){
            array2.add(array.remove((int) (Math.random()*array.size())));
        }
        System.out.println("Shuffle 2: " + array2);
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
                alphabet.add(0,alphabet.remove(alphabet.size()-1));
            }
        } else if (translation < 0) {
            for (int i = 0; i < translation * -1; i++) {
                alphabet.add(alphabet.remove(0));
            }
        } else{
            System.out.println("Don't input 0");
        }

        result += "Array: " + alphabet + ";";

        System.out.println(result);
    }

    @FXML
    protected void pascalsTriangle(){
        int numRows = 10;

        String[] results = new String[numRows];
        String temp;

        ArrayList<Integer> tempArray = new ArrayList<Integer>();
        ArrayList<Integer> tempArray2 = new ArrayList<Integer>();

        if (numRows >= 1){
            results[0] = String.valueOf(1);
            if (numRows >= 2){
                results[1] = 1 + " " + 1;
                if (numRows >= 3){
                    tempArray.add(1);
                    tempArray.add(1);
                    for (int i = 0; i < numRows - 2; i++){
                        tempArray2.clear();
                        tempArray2.add(1);
                        for (int j = 0; j <= tempArray.size() - 2; j++){
                            tempArray2.add(tempArray.get(j)+tempArray.get(j+1));
                        }
                        tempArray2.add(1);
                        System.out.println(tempArray2);
                        tempArray.clear();
                        for (int value : tempArray2) {
                            tempArray.add(value);
                        }
                        System.out.println(tempArray);

                        temp = "";

                        for (int element: tempArray2){
                            temp += element + " ";
                        }

                        results[i+2] = temp;
                    }
                }
            }
        }
        System.out.println("Results: " + Arrays.toString(results));
    }

    @FXML
    protected void searchArray() throws IOException {

        ArrayList<String> lines = new ArrayList<>();

        try{
            FileReader reader = new FileReader("src/main/resources/words_alpha.txt");
            Scanner in = new Scanner(reader);

            while(in.hasNext()){
                lines.add(in.next());
            }

        } catch (FileNotFoundException ex){
            System.out.println("Something is very wrong");
        }


        String input = "a";

        ArrayList <String> results = new ArrayList<>();

        for (String element: lines) {
            if (element.contains(input)){
                results.add(element);
            }
        }

        System.out.println(results);
    }

    @FXML
    protected void lockerSimulation(){
        boolean[] lockers = new boolean[100];
        int numtimes = 100;

        for (int e = 0; e < lockers.length; e++) {
            lockers[e] = true;
        }

        System.out.println(Arrays.toString(lockers));

        for (int i = 1; i <= numtimes; i++){
            for (int j = 0; j < 100; j++){
                if(((j+1) % i) == 0) {
                    if (lockers[j] == true){
                        lockers[j] = false;
                    } else {
                        lockers[j] = true;
                    }
                } else {

                }
            }
        }

        String result = "";

        for (int m = 0; m < 100; m++){
            if (!lockers[m]){
                result += (m + 1) + ", ";
            }
        }

        System.out.println(Arrays.toString(lockers));
        System.out.println(result);
    }

    @FXML
    protected void rainAccumumulation(){
        int[] array = {5, 3, 0, 3, 1};

        int water = 0;

        for (int i = 1; i < array.length - 1; i++){
            int maxL = array[i];
            int maxR = array[i];
            for (int l = 0; l < i; l++){
                if (array[l] > maxL){
                    maxL = array[l];
                }
            }
            for (int r = array.length-1; r > i; r--){
                if (array[r] > maxR){
                    maxR = array[r];
                }
            }

            water += Math.min(maxL, maxR) - array[i];
        }
        System.out.println(water);
    }


}