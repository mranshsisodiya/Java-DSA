package Arrays;

import java.awt.*;
import java.util.*;
import java.util.List;

public class UnionOfSortedArray{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int size1=sc.nextInt();
        int arr1[]=new int[size1];
        for(int i=0;i<size1;i++){
            arr1[i]=sc.nextInt();
        }
        int size2=sc.nextInt();
        int arr2[]=new int[size2];
        for(int i=0;i<size2;i++){
            arr2[i]=sc.nextInt();
        }
        //BRUTE FORCE
        //take a list and add both the array in that and sort it then remove the duplicate
        //tc=O((n+m)log(n+m)) and sc=O(n+m)

        int arr1brute[]=arr1.clone();
        int arr2brute[]=arr2.clone();
        List<Integer> combined= new ArrayList<>();
        for(int i=0;i<size1;i++){
            combined.add(arr1brute[i]);
        }
        for(int val : arr2brute) combined.add(val); // a different type of for loop
        Collections.sort(combined);
        List<Integer> result_brute= new ArrayList<>();
        if(combined.isEmpty()){
            for(int i=0;i<result_brute.size();i++){
                System.out.println(result_brute.get(i));
                return;
            }
        }
        result_brute.add(combined.get(0));
        for(int i=1;i<combined.size();i++){
            if(!combined.get(i).equals(combined.get(i-1))){
                result_brute.add(combined.get(i));
            }
        }
        for(int i=0;i<result_brute.size();i++){
            System.out.print(result_brute.get(i)+" ");
        }
        System.out.println();

        //BETTER SOLUTION
        //by using set we can avoid the sort and uniqueness
        //Time Complexity: O((N+M) log (N+M)) - Inserting into TreeSet is log(size) and Space Complexity: O(N+M)
        Set<Integer> set = new TreeSet<>(); //treeset keeps unique elements and sorted
        for(int val: arr1) set.add(val);
        for(int val: arr2) set.add(val);
        for(int val:set) System.out.print(val+" ");
        System.out.println();


        //OPTIMAL SOLUTION
        //by using 2 pointers we will linearly traverse whole sorted array and add unique elements in sorted way
        //tc=O(n+m) and sc=O(n+m)
        List<Integer> union=new ArrayList<>();
        int i=0, j=0;
        while(i<size1 && j<size2){
            if(arr1[i]<=arr2[j]){
                if(union.isEmpty()|| !union.get(union.size()-1).equals(arr1[i])){
                    union.add(arr1[i]);
                }
                if(arr1[i]==arr2[j]) j++;
                i++;

            }else{
                if(union.isEmpty()|| !union.get(union.size()-1).equals(arr2[j])){
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<size1){
            if(union.isEmpty() ||union.get(union.size()-1) != arr1[i]){
                union.add(arr1[i]);
            }i++;
        }
        while (j<size2){
            if(union.isEmpty() ||union.get(union.size()-1) != arr2[j]){
                union.add(arr2[j]);
            }j++;
        }

        for(int val: union) System.out.print(val+" ");
    }
}
