package Arrays;

import java.util.*;
public class SecondLargest{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        //brute force solution
        //sort the array and return the second last element but there is a catch
        //if the last 2 number are same for example the array is 1,3,3 then second largest is 1 but the output will be 3
        //soo to avoid that before returning check if it is same as the last element then go to third last and soo on

        //creating a temporary array for brute force solution
        int arrbrute[]=new int[size];
        for(int i=0;i<arr.length;i++){
            arrbrute[i]=arr[i];
        }
        Arrays.sort(arrbrute);
        int second=Integer.MIN_VALUE;//for empty array and if the hole array has just 1 number it also handles -ve numbers
        for(int i=arrbrute.length-2;i>=0;i--){
            if(arrbrute[i] !=arrbrute[arrbrute.length-1]){
                second=arrbrute[i];
                break;
            }
        }
        System.out.println(second);
        //time complexity will be O(nlogn) due to sorting


        //better solution
        //let us first find the largest element
        int arrbetter[]=new int[size];
        for(int i=0;i<arr.length;i++){
            arrbetter[i]=arr[i];
        }
        int largest=arrbetter[0];
        for(int i=1;i<arrbetter.length;i++){
            if(arrbetter[i]>largest){
                largest=arrbetter[i];
            }
        }
        //now take second largest element as int min and check if any number it greater then the assumed second largest
        //and also check if the number in the array is not same as largest soo this will avoid the same number issue
        int second_better=Integer.MIN_VALUE;
        for(int i=0;i<arrbetter.length;i++){
            if(arrbetter[i]>second_better && arrbetter[i]!=largest){
                second_better=arrbetter[i];
            }
        }
        System.out.println(second_better);
        //time complexity is O(n)

        //optimal solution
        int largest_optimal=arr[0];
        int second_optimal=Integer.MIN_VALUE;
        //check if the number is array is greater than largest we assumed and if a number is largest the assumed value becomes second largest
        //and there can be case where number is not greater than largest but it is greater than second largest
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest_optimal){
                second_optimal=largest_optimal;
                largest_optimal=arr[i];
            } else if (arr[i] < largest_optimal && arr[i]>second_optimal) {
                second_optimal = arr[i];
            }
        }
        System.out.println(second_optimal);
        //here also time complexity is O(n) but in this we only require 1 for loop soo a sightly optimal solution

    }
}