
//package statement not needed outside of netbeans project
//package shellsortimp;
import java.util.Arrays;

/*
 * @author nickcarlson
 */
public class ShellSortImp {

    //Main: main driver of the program
    public static void main(String[] args) {
        
        smalltest(); //test both sorts with ten random integers
        mediumtest(); //test both sorts with one hundred random integers
        largetest(); //test both sorts with one thousand random integers
        
    }
    
    //shellsort: accepts an integer array and runs shell sort
    public static int shellsort(int[] args){
        //counter to keep track of swaps
        int count = 0;
        
        //set gap for initial swaps
        double length = args.length;
        double temp_gap = Math.floor(length/2.0);
        int gap = (int) temp_gap;
        
        //while sorting is still happening
        while(gap > 0){
            //iterate through the entire array
            for(int i=gap; i < length; i++){
                //save the value located 'gap' spots from where we start
                int temp = args[i];
                int j = i;
                //while swap is needed
                while(j >= gap && args[j-gap] > temp){
                    //perform swap
                    args[j] = args[j - gap];
                    j = j - gap;
                    //increment count to keep track of # of swaps
                    count++;
                }
                //place lower value where it belongs
                args[j] = temp;
            }
            //set new gap
            temp_gap = Math.floor(gap/2.0);
            gap = (int) temp_gap;
        }
        //return number of swaps
        return count;
    }
    
    //insertionsort: accepts an integer array and runs insertion sort
    public static int insertionsort(int[] args){
        //counter to keep track of swaps
        int count = 0;
        
        //iterate through the entire array
        for(int i = 0; i < args.length; i++){
            //while still in array bounds (starting from the second element) and swap is needed
            for(int j = i; j > 0 && args[j] < args[j-1]; j--){
                //perform swap
                int temp = args[j];
                args[j] = args[j-1];
                args[j-1] = temp;
                
                //increment count to keep track of # of swaps
                count++;
            }
        }
        //return number of swaps
        return count;
    }
    
    //smalltest: tests both sorts with ten integers
    public static void smalltest(){
        //arrays to hold test data
        int[] test1 = new int[10];
        int[] test2 = new int[10];
        
        //if test arrays are the same length
        if(test1.length == test2.length){
        //iterate through the entire array
        for(int i = 0; i < test1.length; i++){
            //set each array element to a random integer
            double temp = Math.random() * 10;
            test1[i] = (int) temp;
        }
        //set the second array to the same values as the first array
        for(int i = 0; i < test2.length; i++){
            test2[i] = test1[i];
        }
        
        //run shell sort on test1 with timer running, then convert time to milliseconds
        long startTime1 = System.nanoTime();
        int swapcount1 = shellsort(test1);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;
        double elapsedTime1 = (double) duration1 / 1000000.0;
        
        //run insertion sort on test2 with timer running, then convert time to milliseconds
        long startTime2 = System.nanoTime();
        int swapcount2 = insertionsort(test2);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        double elapsedTime2 = (double) duration2 / 1000000.0;
        
        //if the two sorted arrays are identical, output performance data
        if(Arrays.equals(test1,test2) == true){
        System.out.println("Time was: " + elapsedTime1 + " milliseconds for Shell sort and " + elapsedTime2 + " milliseconds for insertion sort while sorting ten integers.");
        System.out.println("Shell sort swapped " + swapcount1 + " times.");
        System.out.println("Insertion sort swapped " + swapcount2 + " times.");
        System.out.println("The ten sorted numbers are:");
        for(int i = 0; i < test1.length; i++){
            System.out.print(test1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < test2.length; i++){
            System.out.print(test2[i] + " ");
        }
        System.out.println();
        System.out.println();
        }
        }
    }
    
    //mediumtest: tests both sorts with one hundred integers
    public static void mediumtest(){
        //arrays to hold test data
        int[] test1 = new int[100];
        int[] test2 = new int[100];
        
        //if test arrays are the same length
        if(test1.length == test2.length){
        //iterate through the entire array
        for(int i = 0; i < test1.length; i++){
            //set each array element to a random integer
            double temp = Math.random() * 100;
            test1[i] = (int) temp;
        }
        //set the second array to the same values as the first array
        for(int i = 0; i < test2.length; i++){
            test2[i] = test1[i];
        }
        
        //run shell sort on test1 with timer running, then convert time to milliseconds
        long startTime1 = System.nanoTime();
        int swapcount1 = shellsort(test1);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;
        double elapsedTime1 = (double) duration1 / 1000000.0;
        
        //run insertion sort on test2 with timer running, then convert time to milliseconds
        long startTime2 = System.nanoTime();
        int swapcount2 = insertionsort(test2);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        double elapsedTime2 = (double) duration2 / 1000000.0;
        
        //if the two sorted arrays are identical, output performance data
        if(Arrays.equals(test1,test2) == true){
        System.out.println("Time was: " + elapsedTime1 + " milliseconds for Shell sort and " + elapsedTime2 + " milliseconds for insertion sort while sorting one hundred integers.");
        System.out.println("Shell sort swapped " + swapcount1 + " times.");
        System.out.println("Insertion sort swapped " + swapcount2 + " times.");
        System.out.println("The first 25 sorted number are:");
        for(int i = 0; i < test1.length/4; i++){
            System.out.print(test1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < test2.length/4; i++){
            System.out.print(test2[i] + " ");
        }
        System.out.println();
        System.out.println();
        }
        }
        
    }
    
    //largetest: tests both sorts with one thousand integers
    public static void largetest(){
        //arrays to hold test data
        int[] test1 = new int[1000];
        int[] test2 = new int[1000];
        
        //if test arrays are the same length
        if(test1.length == test2.length){
        
        //iterate through the entire array
        for(int i = 0; i < test1.length; i++){
            //set each array element to a random integer
            double temp = Math.random() * 1000;
            test1[i] = (int) temp;
        }
        //set the second array to the same values as the first array
        for(int i = 0; i < test2.length; i++){
            test2[i] = test1[i];
        }
        
        //run shell sort on test1 with timer running, then convert time to milliseconds
        long startTime1 = System.nanoTime();
        int swapcount1 = shellsort(test1);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;
        double elapsedTime1 = (double) duration1 / 1000000.0;
        
        //run insertion sort on test2 with timer running, then convert time to milliseconds
        long startTime2 = System.nanoTime();
        int swapcount2 = insertionsort(test2);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        double elapsedTime2 = (double) duration2 / 1000000.0;
        
        //if the two sorted arrays are identical, output performance data
        if(Arrays.equals(test1,test2) == true){
        System.out.println("Time was: " + elapsedTime1 + " milliseconds for Shell sort and " + elapsedTime2 + " milliseconds for insertion sort while sorting one thousand integers.");
        System.out.println("Shell sort swapped " + swapcount1 + " times.");
        System.out.println("Insertion sort swapped " + swapcount2 + " times.");
        System.out.println("The first 20 sorted values are:");
        for(int i = 0; i < test1.length/50; i++){
            System.out.print(test1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < test2.length/50; i++){
            System.out.print(test2[i] + " ");
        }
        }
        }
    }
    
}
