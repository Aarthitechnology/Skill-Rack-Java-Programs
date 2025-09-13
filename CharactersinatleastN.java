/*The program must accept N string values as the input. The program must print the common characters that are present in N or N-1 string values in sorted order as the output.
Note: At least one character is always present in N or N-1 string values.

Boundary Condition(s):
3 <= N <= 10^4
1 <= Length of each string <= 10^4

Input Format:
The first line contains N.
The next N lines, each containing a string.

Output Format:
The first line contains the common characters in sorted order that are present in N or N-1 string values in sorted order.

Example Input/Output 1:
Input:

orange
apple
pineapple

Output:
aelnp

Explanation:
The common characters that are present in 3 or 2 string values are a, e, I, n and p.
Hence the output is aelnp

Example Input/Output 2:
Input:

HardWork
HomeWork
Hungry
Wood

Output:
HWor
 */
import java.util.*;
public class CharactersinatleastN{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Character,Integer> count = new HashMap<>();
		for(int i=0;i<n;i++)
		{
		    Set<Character> current = new HashSet<>();
		    String s = sc.next();
		    for(char ch : s.toCharArray())
		    {
		        current.add(ch);       
		    }
		    for(char ch : current)
		        count.put(ch,count.getOrDefault(ch,0)+1);
		    
		}
		List<Character> list = new ArrayList<>();
		for(char ch : count.keySet())
		{
		    if(count.get(ch)>=n-1)
		    {
		        list.add(ch);
		    }
		}
		Collections.sort(list);
		for(char ch : list)
		{
		    System.out.print(ch);
		}
	}
}
