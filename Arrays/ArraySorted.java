import java.util.*;
public class ArraySorted{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        //brute force method
        //sort the array and check and compare from the given array if it's same then given array was sorted
        //time complexity is O(nlogn)
        int arrsort[]=new int[size];
        for(int i=0;i<arr.length;i++){
            arrsort[i]=arr[i];
        }
        Arrays.sort(arrsort);
        int sortedflag=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=arrsort[i]){
                sortedflag=1;
                break;
            }
        }
        if(sortedflag==0){
            System.out.println("Sorted");
        }else{
            System.out.println("Not Sorted");
        }
        
    }
}