/*Robot - Stair Climbing

3

There are N stairs to be climbed in a building. A robot can take only S different leaps each containing certain distinct steps
which are passed as the input. The program must print the number of ways C of steps the robot can take to climb exactly
N stairs.

Boundary Condition(s):
1 <= N <= 50
1 <= S <= 10

Input Format:
The first line contains N and S separated by a space.
The second line contains S integer values separated by a space.

Output Format:
The first line contains the C.

Example Input/Output 1:
Input:
52
23

Output:
2

Explanation:
There are 5 steps. The robot can take 2 or 3 steps at a time.
So the possible ways are
2 3 and 3 2

Example Input/Output 2:
Input:
62
15

Output:

Explanation:
The possible ways are
111111
51
15 */
import java.util.*;
public class Robotstairclimbing {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() , s = sc.nextInt();
        int[] leap = new int[s];
        for(int i=0;i<s;i++)
        {
            leap[i] = sc.nextInt();
        }
        long[] ways = new long[n+1];
        ways[0] = 1;
        for(int step=1;step<=n;step++)
        {
            for(int idx = 0;idx<s;idx++)
            {
                if(step >= leap[idx])
                {
                    ways[step] += ways[step - leap[idx]];
                }
            }
        }
        System.out.println(ways[n]);
    }
}
