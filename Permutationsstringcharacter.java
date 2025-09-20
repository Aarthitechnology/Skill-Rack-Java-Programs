import java.util.*;
public class Permutationsstringcharacter {
   public static void main(String args[])
   {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        char[] arr = str.toCharArray();
        permute(arr,0,n-1);
   }
   private static void permute(char[] arr,int left,int right)
   {
        if(left==right)
        {
            System.out.println(new String(arr));
            return;
        }
        for(int idx=left;idx<=right;idx++)
        {
            swap(arr,left,idx);
            permute(arr,left+1,right);
            swap(arr,left,idx);
        }
   }
   private static void swap(char[] arr,int left,int idx)
   {
        char temp = arr[left];
        arr[left] = arr[idx];
        arr[idx] = temp;
   }
}
