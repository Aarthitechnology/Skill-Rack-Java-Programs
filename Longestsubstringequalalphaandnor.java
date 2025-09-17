/*Longest Substring - Equal Alphabets & Digits

2

The program must accept a string S containing lowercase alphabets and digits as the input. The program must print the length L of the longest substring with equal numbers of alphabets and digits in
it.
Note: Optimize the algorithm so that the program executes successfully within the time limit.

Boundary Condition(s):
1 <= Length of S <= 10^5

Input Format:
The first line contains S.

Output Format:
The first line contains L.

Example Input/Output 1:
Input:
ab547b23

Output:
6

Explanation:
The longest substring which contains equal number of alphabets and digits is ab547b whose length is 6.

Example Input/Output 2:
Input:
memory 1terabytes

Output:
2 */
import java.util.*;
public class Longestsubstringequalalphaandnor {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int counter = 0 , position = 0 , maxlen = 0;
        Map<Integer,Integer> posmap = new HashMap<>();
        posmap.put(counter,position);
        for(char ch : str.toCharArray())
        {
            position++;
            if(Character.isAlphabetic(ch))
            {
                counter++;
            }
            else
            {
                counter--;
            }
            if(posmap.containsKey(counter))
            {
                int currlen = position - posmap.get(counter);
                maxlen = Math.max(maxlen,currlen);
            }
            else
            {
                posmap.put(counter,position);
            }
        }
        System.out.println(maxlen);
    }
}
