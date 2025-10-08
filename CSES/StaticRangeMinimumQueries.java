/*Static Range Minimum Queries
 Time limit: 1.00 s
Memory limit: 512 MB

Given an array of n integers, your task is to process q queries of the form: what is the minimum value in range [a,b]?
Input
The first input line has two integers n and q: the number of values and queries.
The second line has n integers x_1,x_2,\dots,x_n: the array values.
Finally, there are q lines describing the queries. Each line has two integers a and b: what is the minimum value in range [a,b]?
Output
Print the result of each query.
Constraints

1 \le n,q \le 2 \cdot 10^5
1 \le x_i \le 10^9
1 \le a \le b \le n

Example
Input:
8 4
3 2 4 5 1 1 5 3
2 4
5 6
1 8
3 3

Output:
2
1
1
4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StaticRangeMinimumQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int row = log[n] + 1;
        int[][] table = new int[row][n];

        for (int i = 0; i < n; i++) {
            table[0][i] = arr[i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j + (1 << i) <= n; j++) {
                table[i][j] = Math.min(table[i - 1][j], table[i - 1][j + (1 << (i - 1))]);
            }
        }

        StringBuilder out = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            int len = right - left + 1;
            int k = log[len];
            out.append(Math.min(table[k][left], table[k][right - (1 << k) + 1])).append("\n");
        }

        System.out.print(out);
    }
}
