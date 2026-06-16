package Arrays;

import java.util.*;
public class RotateArray{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int size= sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        if (arr == null || arr.length <= 1) return;
        int arrbrute[]= arr.clone();
        int arrbetter[]= arr.clone();
        int k=sc.nextInt();
        k=k%size;
        k = ((k % size) + size) % size;
        //we neeed to rotate the array k times to right
        // BRUTE FORCE
        // we run a loop k times and shift the array by 1 position
        //tc = O(n*k) and sc=O(1)
        for(int i=0;i<k;i++){
                int last=arrbrute[size-1];
                for(int j=size-2;j>=0;j--){
                    arrbrute[j+1]=arrbrute[j];
                }
                arrbrute[0]=last;
        }

        //BETTER SOLUTION
        // time complexity will be O(n) but space Complexity will be O(n)
        int temp[]=new int[size];
        for(int i=0;i<size;i++){
            temp[(i+k)%size]=arrbetter[i];
        }
        System.arraycopy(temp, 0, arrbetter, 0, size);

        // (i+k)%size helps like a circular array soo we can rotate without any issue in this

        //OPTIMAL SOLUTION
        //we can do to reverse the whole array and then reverse first k elements and then reverse the n-k elements
        //we get tc as O(n) and sc as O(1)
        if(k==0) return;
        reverse(arr,0, size-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, size-1);

        for(int i=0;i<size;i++){
            System.out.print(arrbrute[i]+" ");
        }
        System.out.println();
        for(int i=0;i<size;i++){
            System.out.print(arrbetter[i]+" ");
        }
        System.out.println();
        System.out.println();
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
    public static void reverse(int arr[], int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}