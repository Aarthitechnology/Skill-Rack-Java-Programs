/*Hotel Queries
 Time limit: 1.00 s
Memory limit: 512 MB

There are n hotels on a street. For each hotel you know the number of free rooms. Your task is to assign hotel rooms for groups of tourists. All members of a group want to stay in the same hotel.
The groups will come to you one after another, and you know for each group the number of rooms it requires. You always assign a group to the first hotel having enough rooms. After this, the number of free rooms in the hotel decreases.
Input
The first input line contains two integers n and m: the number of hotels and the number of groups. The hotels are numbered 1,2,\ldots,n.
The next line contains n integers h_1,h_2,\ldots,h_n: the number of free rooms in each hotel.
The last line contains m integers r_1,r_2,\ldots,r_m: the number of rooms each group requires.
Output
Print the assigned hotel for each group. If a group cannot be assigned a hotel, print 0 instead.
Constraints

1 \le n,m \le 2 \cdot 10^5
1 \le h_i \le 10^9
1 \le r_i \le 10^9

Example
Input:
8 5
3 2 4 1 5 5 2 6
4 4 7 1 1

Output:
3 5 0 1 1
 */
import java.util.*;
import java.io.*;

public class HotelQueries {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int N = 1;
        while (N < n) N <<= 1;

        long[] hotel = new long[2 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hotel[i + N] = Long.parseLong(st.nextToken());
        }

        
        for (int i = N - 1; i >= 1; i--) {
            hotel[i] = Math.max(hotel[2 * i], hotel[2 * i + 1]);
        }

        
        st = new StringTokenizer(br.readLine());
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int rooms = Integer.parseInt(st.nextToken());
            long ans = hotelrooms(hotel, 1, 0, N - 1, rooms, N);
            if (ans == -1) out.append("0 ");
            else out.append(ans).append(" ");
        }

        System.out.println(out.toString().trim());
    }

    private static long hotelrooms(long[] hotel, int node, int nodeleft, int noderight, int rooms, int N) {
        if (hotel[node] < rooms) {
            return -1;
        }
        if (nodeleft == noderight) {
            hotel[node] -= rooms;
            return nodeleft + 1; 
        }

        int mid = (nodeleft + noderight) / 2;
        long lefthotel = hotelrooms(hotel, 2 * node, nodeleft, mid, rooms, N);
        if (lefthotel != -1) {
            hotel[node] = Math.max(hotel[2 * node], hotel[2 * node + 1]);
            return lefthotel;
        }

        long righthotel = hotelrooms(hotel, 2 * node + 1, mid + 1, noderight, rooms, N);
        hotel[node] = Math.max(hotel[2 * node], hotel[2 * node + 1]);
        return righthotel;
    }
}

