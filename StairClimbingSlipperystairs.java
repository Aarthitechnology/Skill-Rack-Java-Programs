/*Stair Climbing - Slippery stairs

There are N stairs to be climbed in a building. A robot can take only S different leaps each containing certain distinct steps which are passed as the input. But T stairs are slippery and hence the robot will slip to the bottom stair if it lands on a slippery stair. The slippery stair numbers are passed as the input.
The program must print the number of ways C of steps the robot can take to climb N stairs.

Boundary Condition(s):
1 <= N <= 50
1 <= S <= 10
1 <= T <= N

Input Format:
The first line contains N, S and T separated by a space.
The second line contains S integer values separated by a space.
The third line contains T integer values separated by a space.

Output Format:
The first line contains the value of C.

Example Input/Output 1:
Input:
521

23
2

Output:

2

Explanation:
There are 5 steps. The robot can take 2 or 3 steps at a time.
So the possible ways are
32
1 2 2 (as the robot will slip to step 1 when it lands on step 2 which is slippery)

Example Input/Output 2:
Input:
621
23

2

Output:

Explanation:
The possible ways are
1 2 3 (as the robot will slip to step 1 when it lands on step 2 which is slippery)
1 3 2 (as the robot will slip to step 1 when it lands on step 2 which is slippery)
33

3
 */
import java.util.*;
public class StairClimbingSlipperystairs {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),s=sc.nextInt(),t=sc.nextInt();
        List<Integer> slippery = new ArrayList<>();
        int[] leap = new int[s];
        for(int i=0;i<s;i++)
        {
            leap[i] = sc.nextInt();
        }
        for(int i=0;i<t;i++)
        {
            int slip = sc.nextInt();
            slippery.add(slip);
        }
        long[] ways = new long[n+1];
        ways[0] = 1;
        for(int step=1;step<=n;step++)
        {
            for(int l=0;l<s;l++)
            {
                if(step>=leap[l])
                {
                    ways[step]+=ways[step-leap[l]];
                }
            }
            if(slippery.contains(step))
            {
                int last = step-1;
                while(slippery.contains(last) && last>0)
                {
                    last--;
                }
                if(last>0)
                {
                    ways[last]+=ways[step];
                }
                ways[step]=0;
            }
        }
        System.out.println(ways[n]);
    }
}
