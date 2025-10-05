/*Minimum Swaps - Ascending Order

5

3

The program must accept N integers from 1 to N in any order as the input. The program must print the minimum number of swaps required to order those N integers in ascending order as the output.

Boundary Condition(s):
1 <= N <= 1000

Input Format:
The first line contains N.
The second line contains N integers separated by a space.

Output Format:
The first line contains the minimum number of swaps required.

Example Input/Output 1:
Input:

23154

Output:

Explanation:
The integers 5 and 4 can be swapped.
Now the integers become 2 3 1 4 5.
Then the integers 2 and 1 can be swapped.
Now the integers become 1 3 2 4 5.
Then the integers 3 and 2 can be swapped.
Now the integers become 1 2 3 4 5.
So at least 3 swaps are required.
Hence 3 is printed.

Example Input/Output 2:
Input:
7
2763541

Output:
4 */
import java.util.*;
public class Minimumswapascendingorder {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(sorted[i],i);
        }
        boolean visited[] = new boolean[n];
        int minswap = 0;
        for(int i=0;i<n;i++)
        {
            if(map.get(arr[i])==i || visited[i])
            {
                continue;
            }
            int swap = 0;
            int j=i;
            while(!visited[j])
            {
                visited[j] = true;
                j = map.get(arr[j]);
                swap++;
            }
            if(swap>1)
            {
                minswap+=(swap-1);
            }
        }
        System.out.println(minswap);
    }
}
