import java.util.*;
public class Minimumoperationszeroton {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		while(n>0)
		{
		    if(n%2==0)
		    {
		        count++;
		        n=n/2;
		    }
		    else
		    {
		      count++;
		      n--;
		    }
		    if(n==0)
		    {
		        System.out.println(count);
		        break;
		    }
		}
	}
}