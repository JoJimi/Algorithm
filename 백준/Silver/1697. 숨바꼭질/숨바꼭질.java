import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int arr[] = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) System.out.println(0);
		else bfs(N);
		
	}
	static public void bfs(int src) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			int num = arr[temp];		

			for(int i = 0; i < 3; i++) {
				int cal;
				
				if(i == 0) cal = temp - 1;
				else if(i == 1) cal = temp + 1;
				else cal = temp * 2;
				
				if(temp == K) {
					System.out.println(num);
					return;
				}
			
				if(cal >= 0 && cal < arr.length && arr[cal] == 0) {
					queue.add(cal);
					arr[cal] = num + 1;
				}
				
				
			}
			
		}
		
	}
}