/*Permutation Nearest Value

The program must accept two integers N and X as the input. The program must print the integer value nearest to X with all the digits in N as the output.

Boundary Condition(s):
10 <= N, X <= 10^8

Input Format:
The first lines contains N.

Output Format:
The first lines contains the integer value nearest to X with all the digits in N as the output.

Example Input/Output 1:
Input:
123 200

Output:
213

Explanation:
The integer value nearest to the 200 with all the digits in 123 is 213.

Example Input/Output 2:
Input:
48871 88555

Output:
88471
 */
import java.util.*;
public class Permutationnearestvalue {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() , x = sc.nextInt();
        String str = String.valueOf(n);
        int arr[] = new int[str.length()];
        for(int i=0;i<str.length();i++)
        {
            arr[i] = str.charAt(i)-'0';
        }
        Set<Integer> result = new HashSet<>();
        permute(arr,0,arr.length-1,result);
        int near = -1;
        int mindiff = Integer.MAX_VALUE;
        for(int num : result)
        {
            int diff = Math.abs(num-x);
            if(diff<mindiff || (mindiff==diff && num<near))
            {
                mindiff = diff;
                near = num;
            }
        }
        System.out.println(near);
    }
    private static void permute(int[] arr,int left,int right,Set<Integer> result)
    {
        if(left == right)
        {
            int number = 0;
            for(int num : arr)
            {
                number = (number*10) + num;
            }
            result.add(number);
            return;
        }
        for(int idx = left;idx<=right;idx++)
        {
            swap(arr,left,idx);
            permute(arr,left+1,right,result);
            swap(arr,left,idx);
        }
    }
    private static void swap(int[] arr,int left,int idx)
    {
        int temp = arr[left];
        arr[left] = arr[idx];
        arr[idx] = temp;
    }
}
