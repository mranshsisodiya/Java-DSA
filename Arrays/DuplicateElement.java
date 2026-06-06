import java.util.*;
public class DuplicateElement{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        //we know from the problem that the given array is sorted
        //brute force method
        //create a temp array and add all the unique element and we get the duplicate free array
        int temp[]=new int[size];
        int j=0;
        for(int i=0;i<size-1;i++){
            if(arr[i]!=arr[i+1]){
                temp[j++]=arr[i];

            }
        }
        temp[j++]=arr[size-1];
        //copy back to the original array
        for(int i=0;i<j;i++){
            arr[i]=temp[i];
        }
        System.out.println(j);
        //here the time complexity is O(n) but we created an extra array soo space complexity is O(n)
        
    }
}