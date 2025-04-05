import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] country;
    static int[] rank;
    static List<int[]> sortedList = new ArrayList<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2) -> {
        if (o1[1] != o2[1]) {
            return o2[1] - o1[1];
        }
        if (o1[2] != o2[2]) {
            return o2[2] - o1[2];
        }
        if (o1[3] != o2[3]) {
            return o2[3] - o1[3];
        }
        return o1[0] - o2[0];
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        country = new int[N][4];
        rank = new int[N+1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] arr : country) {
            pq.offer(arr);
        }

        while (!pq.isEmpty()) {
            sortedList.add(pq.poll());
        }

        int count = 0;
        int currentRank = 1;
        int prevGold = -1, prevSilver = -1, prevBronze = -1;

        for(int i = 0; i < N; i++){
            count++;
            int[] result = sortedList.get(i);

            if(prevGold == result[1] && prevSilver == result[2] && prevBronze == result[3]){
                rank[result[0]] = currentRank;
            }
            else {
                currentRank = count;
                rank[result[0]] = currentRank;
            }

            prevGold = result[1];
            prevSilver = result[2];
            prevBronze = result[3];
        }

        System.out.println(rank[K]);
    }
}
