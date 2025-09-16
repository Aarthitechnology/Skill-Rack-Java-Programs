/*String - Pattern Count KMP Algorithm

The program must accept a string S and a pattern P as the input. The program must print the count of occurrence of the pattern in the given string S as the output.

Boundary Condition(s):
1 <= Length of P <= length of S <= 10^6

Input Format:
The first line contains S.
The second line contains P.

Output Format:
The first line contains a string value "Count=" followed by the count of occurrence of the pattern in the given string.

Example Input/Output 1:
Input:
AaabcbababcaabcdAbcd
abc

Output:
Count=3

Explanation:
Here the given string is AaabcbababcaabcdAbcd and the pattern is abc.
The occurrence of the pattern abc in the given string is highlighted below.
AaabcbababcaabcdAbcd
In the given string, the pattern occurs 3 times.
Hence the output is Count=3.

Example Input/Output 2:
Input:
XyzzxxXyZzyxXyzzxXzz
xXyzz

Output:
Count=1

Example Input/Output 3:
Input
Aa#12aBabc#123abc#abc#123
abc#123

Output:
Count=2 */
import java.util.*;
public class Stringpatterncountkmpalgorithm {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        int slen = s.length();
        int plen = p.length();
        int[] lps = new int[plen];
        lps[0] = 0;
        int idx = 0;
        for(int i=1;i<plen;)
        {
            if(p.charAt(i)==p.charAt(idx))
            {
                lps[i] = idx+1;
                idx++;
                i++;
            }
            else
            {
                if(idx==0)
                {
                    lps[i] = 0;
                    i++;
                }
                else
                {
                    idx = lps[idx-1];
                }
            }
        }
        int c = 0 ;
        for(int sidx = 0 , pidx = 0;sidx<slen;)
        {
            if(s.charAt(sidx)==p.charAt(pidx))
            {
                sidx++;
                pidx++;
                if(pidx == plen)
                {
                    c++;
                    pidx = 0;
                }
            }
            else
            {
                if(pidx==0)
                {
                    sidx++;
                }
                else
                {
                    pidx = lps[pidx-1];
                }
            }
        }
        System.out.println(c);
    }
}
