package Arrays;
import java.util.*;
public class IntersectionOfSortedArray {
    public static void main (String[] args){
        Scanner sc= new Scanner(System.in);
        int size1=sc.nextInt();
        int size2=sc.nextInt();
        int arr1[]= new int[size1];
        int arr2[]= new int[size2];
        for(int i=0;i<size1;i++){
            arr1[i]=sc.nextInt();
        }
        for(int i=0;i<size2;i++){
            arr2[i]=sc.nextInt();
        }

        //brute Force
        int arrbrute1[]=arr1.clone();
        int arrbrute2[]=arr2.clone();
        int visitedIndex[]=new int[arrbrute2.length];
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<arrbrute1.length;i++){
            for(int j=0;j<arrbrute2.length;j++){
                if(arrbrute1[i]==arrbrute2[j] && visitedIndex[j]==0){
                    ans.add(arrbrute1[i]);
                    visitedIndex[j]=1;
                    break;
                }
            }
        }
        for(int val : ans) System.out.print(val+" ");
        System.out.println();
        //time complexity = O(nm) sc=O(n) // for visited array
        //optimal solution
        //using 2 pointers
        List<Integer> union=new ArrayList<>();
        int i=0, j=0;
        while(i<size1 && j<size2){
            if(arr1[i]<arr2[j]){
                i++;
            }else if(arr1[i]>arr2[j]){
                j++;
            }else{
                union.add(arr1[i]);
                i++; j++;
            }
        }
        for(int val : union) System.out.print(val+" ");
        //tc=O(n+m) sc =(1)
    }
}

