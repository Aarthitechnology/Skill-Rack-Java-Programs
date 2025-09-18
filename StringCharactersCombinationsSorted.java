/*String Characters - Combinations Sorted

The program must accept a string S as the input. The program must print the combinations of the characters in the string S in sorted order.

Boundary Condition(s):
2 <= Length of S <= 15

Input Format:
The first line contains the string S.

Output Format:
The lines containing the string values representing the combinations of the characters in the string S in sorted order.

Example Input/Output 1:
Input:
abc

Output
a
ab
abc
ac
b
bc
c

Example Input/Output 2:
Input:
virus

Output
i
ir
irs
lru
irus
is
iu
ius
r
rs
ru
rus
s
u
us
V
vi
vir
virs
viru
virus
vis
viu
vius
vr
vrs
vru
vru
vs
vu
vus
 */
import java.util.*;
public class StringCharactersCombinationsSorted {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<String> list = new ArrayList<>();
        for(int ctr=1;ctr<(1<<str.length());ctr++)
        {
            StringBuilder sub = new StringBuilder();
            for(int idx = 0;idx<str.length();idx++)
            {
                if((ctr & (1<<idx))!=0)
                {
                    sub.append(str.charAt(idx));
                }
            }
            list.add(sub.toString());
        }
        Collections.sort(list);
        for(String s : list)
        {
            System.out.println(s);
        }
    }
}
