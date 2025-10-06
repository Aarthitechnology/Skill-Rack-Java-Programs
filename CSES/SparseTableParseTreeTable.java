/*Sparse Table (used in Range Minimum Query, RMQ), which is also a kind of parse tree table representation.*/
import java.util.*;
public class SparseTableParseTreeTable {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int row = 0;
        while(Math.pow(2, row)<n)
        {
            row++;
        } 
        int[][] table = new int[row][n];
        for(int i=0;i<n;i++)
        {
            table[0][i] = arr[i];
        }
        for(int i=1;i<row;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j+(1<<(i-1))<n)
                {
                    table[i][j] = Math.min(table[i-1][j],table[i-1][j+(1<<(i-1))]);
                }
            }
        }
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(table[i][j]>=0)
                    System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }
}
