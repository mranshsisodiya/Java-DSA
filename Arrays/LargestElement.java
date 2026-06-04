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
        //sort the array and print the last element; time complexity will be O(n^2) due to the sort method
        //we will copy the original array to a new rry to compare the solution of brute force, optimized sol.
        //soo don't think this is taking an extra of O(n) its just for comparison based for understanding
        int arrbrute[]=new int[size];
        for(int i=0;i<arr.length;i++){
            arrbrute[i]=arr[i];
        }
        //now that the brute array is created we will apply brute force solution
        Arrays.sort(arrbrute);
        System.out.println(arrbrute[arrbrute.length-1]);

        
    }
}