package datasort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataSort {
    
public static int[] doSelectionSort(int[] arr){
         
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index]) 
                    index = j;
      
            int smallerNumber = arr[index];  
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }
public static int[] doInsertionSort(int[] input){
         
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }

public static void main(String a[]) throws FileNotFoundException {
              
        Scanner scanner = new Scanner(new File("ints10000.dat"));
                 MyQuickSort sorter = new MyQuickSort(); 
                        int[] data = new int[10000];
                        int[] arr1 = new int[10000];
                        int[] arr2 = new int[10000];
                        int[] arr3 = new int[10000];

            int z = 0;
            while (scanner.hasNextInt()) {
                data[z] = scanner.useDelimiter(" ").nextInt();
                
                 arr1[z] = data[z];
                 System.out.println(z + ": "+arr1[z]);
                 z++;
                         }
              long timeStarted = System.currentTimeMillis();
              System.out.println(timeStarted);  
                arr2 = doInsertionSort(arr1);
                System.out.println("Insertion SORT");
                
                for(int i=0; i< arr2.length; i++){
                   System.out.println("Insertion SORTED: " + arr2[i]);
        }
                  System.out.println("Sorting last for:" + (System.currentTimeMillis() - timeStarted)+ "ms");
                   long timeStarted1 = System.currentTimeMillis();
                   System.out.println(timeStarted1);
                arr3 = doSelectionSort(arr1);
                System.out.println("SELECTION SORT");
              
                for(int i =0;i<arr3.length;i++){
                    System.out.println("Selected SORTED: " + arr2[i]);
            } 
                      System.out.println("Sorting last for:" + (System.currentTimeMillis() - timeStarted1)+ "ms");
             long timeStarted2 = System.currentTimeMillis();
             System.out.println(timeStarted2);
                sorter.sort(arr1);                
                System.out.println("Quick SORT");
                for(int i:arr1){
                    System.out.println("Quick SORTED: " +i);   
        }
                    System.out.println("Sorting last for:" + (System.currentTimeMillis() - timeStarted2) + "ms");
}
}