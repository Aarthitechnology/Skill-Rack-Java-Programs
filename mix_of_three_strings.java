/*Given 3 string values S1, S2 and S3, find if S3 is a valid mix of the first two string values S1 and S2. The third string value S3 is said to be a mix of the first S1 string and the second S2 string, if it can be formed by interleaving the characters of the first
string and the second string in a way that maintains the left to the right order of occurrence of the characters for S1 and S2 each string. The program must print YES if it is a valid mix. Else the program must print NO as the output.

Boundary Condition(s):
1 <= Length of S1, S2 <= 1000

Input Format:
The first line contains the string S1.
The second line contains the string S2.
The third line contains the string S3.

Output Format:
The first line contains either YES or NO.

Example Input/Output 1:
Input:
mno
xyz
xmnyzo

Output:
YES

Explanation:
The order of occurrence of xyz and mno is preserved in xmnyzo.
Hence the output YES is printed.

Example Input/Output 2:
Input:
MANO
KON
MAKNOON

Output:
YES

Example Input/Output 3:
Input:
MANO
KON
MAKOONN

Output:
NO
Program
------------*/
import java.util.*;
public class mix_of_three_strings {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();
		int i=0,j=0,k=0;
		if(mix(s1,s2,s3,i,j,k))
		{
		    System.out.println("YES");
		}
		else
		{
		    System.out.println("NO");
		}
		sc.close();
	}
	private static boolean mix(String s1,String s2,String s3,int i,int j,int k)
	{
	    while(k<s3.length())
	    {
	        if(i<s1.length() && j<s2.length() && s1.charAt(i)==s3.charAt(k) && s2.charAt(j)==s3.charAt(k))
	        {
	            if(mix(s1,s2,s3,i+1,j,k+1))
	            {
	                return true;
	            }
	            else
	            {
	                return mix(s1,s2,s3,i,j+1,k+1);
	            }
	        }
	        else if(i<s1.length() && s1.charAt(i)==s3.charAt(k))
	        {
	            i++;
	            k++;
	        }
	        else if(j<s2.length() && s2.charAt(j)==s3.charAt(k))
	        {
	            j++;
	            k++;
	        }
	        else
	        {
	            return false;
	        }
	    }
	    return true;
	}
}