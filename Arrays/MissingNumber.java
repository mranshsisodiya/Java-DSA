import java.util.*;
public class MissingNumber {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        //in this question we are going to find one missing number from an array
        //BRUTE FORCE
        //we will sort the array and check if next number is +1 of the previous number if not return the correct number
        int arrbrute[]=arr.clone();
        Arrays.sort(arrbrute);
        if(arr[0]!=0){
            System.out.println(0);
        }
        for(int i=0;i<size-1;i++){
            if(arrbrute[i]+1!=arrbrute[i+1]){
                System.out.println(arrbrute[i]+1);
                break;
            }
        }
        if(arr[size-1]!=size){
            System.out.println(size);
        }
        //time complexity is O(nlogn) and space complexity is O(1) or O(logn) due to sorting


        //BETTER Approach
        //we will use algebra to find out that is we will find the sum of 0 to n and then compare it with sum of array and return the difference
        int arrbetter[]=arr.clone();
        long sum=(long) size*(size+1)/2;  //to avoid integer overflow
        long actualsum=0;
        for(int i=0;i<size;i++){
            actualsum+=arrbetter[i];
        }
        System.out.println(sum-actualsum);
        //time complexity=O(n) sc=O(1);
        //this might seem as an optimal solution but here is a catch the integer overflow can actually break the code if it goes to long overflow then aur code is destroyed
        //soo we need a method that avoids overflow

        //OPTIMAL solution
        //use XOR property to get the result it avoids overflow and is more fast
        int xor=size;
        for(int i=0;i<size;i++){
            xor=xor^i^arr[i];
        }
        System.out.println(xor);
        //time complexity=O(n) sc=O(1);
        sc.close(); //to avoid memory leak
    }
}
