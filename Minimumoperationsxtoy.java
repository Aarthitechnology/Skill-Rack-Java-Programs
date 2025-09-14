/*Minimum Operations - X to Y

The program must accept two integers X and Y as the input. The program must print the minimum number of operations required to convert the integer X to Y. There are two types of operations which are given below.
- Double the integer
- Subtract one from the integer

Boundary Condition(s):
1 <= X, Y <= 10^8

Input Format:
The first line contains X and Y separated by a space.

Output Format:
The first line contains the minimum number of operations required to convert the integer X to Y.

Example Input/Output 1:
Input:
58

Output:

Explanation:
Here X = 5 and Y = 8.
1st operation = 5 - 1 = 4
2nd operation = 4 * 2 = 8

Example Input/Output 2:
Input:
10 1

Output:

9

Example Input/Output 3:
Input:
4 35

Output:

8 */
import java.util.*;
public class Minimumoperationsxtoy {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt() , y = sc.nextInt();
        int count = 0;
        if(x>=y)
        {
            System.out.println(x-y);
            return;
        }
        while(y>x)
        {
            if(y%2==0)
            {
                count++;
                y=y/2;
            }
            else
            {
                count++;
                y=y+1;
            }
        }
        count+=(x-y);
        System.out.println(count);
        sc.close();
    }
}
