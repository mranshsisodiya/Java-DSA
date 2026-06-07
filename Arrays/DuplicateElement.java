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

        //optimal solution
        //we can use 2 pointer approach in order to avoid the extra space we are consuming
        int x=0;
        for(int y=1;y<size;y++){
            if(arr[y]!=arr[x]){
                arr[++x]=arr[y];
            }
        }
        System.out.println(x+1); //since array is 0 based indexed soo we return by adding one
        //now here the time complexity is same as brute force that is O(n)
        //but we avoided the extra space soo space complexity is O(1)

        //HFT company optimized solution
        //avoid empty array
        if(arr==null || arr.length==0){
            System.out.println(0);
        }else{
            int k=0;
            for(int i=1;i<arr.length;i++){
                if(arr[k]!=arr[i]){
                    k++;
                    if(k!=i){  //this condition avoids the case for unnecessary write operation which avoid cpu load
                        arr[k]=arr[i];
                    }
                }
            }
            System.out.println(k+1);
        }
    }
}