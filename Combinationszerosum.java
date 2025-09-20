/*Combination Zero Sum

5

The program must accept N integers as the input. The program must print the number of combinations of the integers (among the N integers) which add up to 0 as the output.

Boundary Condition(s):
2 <= N <= 15
-100 <= Each integer value <= 100

Input Format:
The first line contains N.
The second line contains N integers separated by a space.

Output Format:
The first line contains the number of combinations of the integers (among the N integers) which add up to 0.

Example Input/Output 1:
Input:

10 -5 5 -15 20

Output:
3

Explanation:
The three combinations which add up to 0 are
10, 5,-15
20, -5, -15
5,5

Example Input/Output 2:
Input:
7
10 -5 5 -15 20 5 10

Output:

10 */
import java.util.*;
public class Combinationszerosum {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        for(int ctr=1 ; ctr<(1<<n);ctr++)
        {
            int sum=0;
            for(int idx=0;idx<n;idx++)
            {
                if((ctr & (1<<idx))!=0)
                {
                    sum+=arr[idx];
                }
            }
            if(sum==0)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
