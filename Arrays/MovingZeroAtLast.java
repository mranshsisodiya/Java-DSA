import java.util.*;
public class MovingZeroAtLast{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

        //let's look at the brute force approach
        //we will create a temp array and store all the non zero elements from the starting index
        int temp[]=new int[size];
        int k=0;
        for(int i=0;i<size;i++){
            if(arr[i]!=0){
                temp[k++]=arr[i];
            }
        }
        //to print the final array
        for(int i=0;i<size;i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println();
        //this gives the time complexity of O(n) and space complexity as O(n)

        //optimal solution
        //we will use 2 pointers approach to avoid creating an extra array
        int j=0;
        for(int i=0;i<size;i++){
            if(arr[i]!=0){
                if(j!=i){
                    arr[j]=arr[i];
                    arr[i]=0;
                }
                j++;
            }
        }
        //to print the final array
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        //this give time complexity as O(n) but space complexity as O(1)
    }
}