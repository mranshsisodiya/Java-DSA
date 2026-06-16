package Arrays;

import java.util.*;
public class LargestElement{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        //brute force sol
        //sort the array and print the last element; time complexity will be O(nlogn) due to the sort function
        //we will copy the original array to a new rry to compare the solution of brute force, optimized sol.
        //soo don't think this is taking an extra of O(n) its just for comparison based for understanding
        int arrbrute[]=new int[size];
        for(int i=0;i<arr.length;i++){
            arrbrute[i]=arr[i];
        }
        //now that the brute array is created we will apply brute force solution
        Arrays.sort(arrbrute);
        System.out.println(arrbrute[arrbrute.length-1]);

        //let us now see the optimal solution
        //we will take the first element as the largest of the array and then iterate the whole array and compare
        //if we find any element greater than the assumed greatest number replace it and do the same till last element
        //return the largest element

        int largest=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        System.out.println(largest);
        // here the time complexity is O(n) as the for loop runs just once to iterate the array
        //hence the optimal solution is of time complexity O(n).
    }
}