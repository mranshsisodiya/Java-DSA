package Arrays;

import java.util.*;
public class ArraysBasic{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in); //declare a sc to scan the numbers or characters given in question
        int arr[]=new int[5];  //declare array
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);  //iterate the array to check what values the system have assigned
        }
        //in this main method, the max size of array can be 10^6
        //but globally the max size of array will be 10^7
        
    }
}