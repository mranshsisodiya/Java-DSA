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
        int second=-1;//for empty array and if the hole array has just 1 number
        for(int i=arrbrute.length-2;i>=0;i--){
            if(arrbrute[i] !=arrbrute[arrbrute.length-1]){
                second=arrbrute[i];
                break;
            }
        }
        System.out.println(second);
        //time complexity will be O(nlogn) due to sorting

        
    }
}