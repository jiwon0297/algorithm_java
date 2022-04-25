package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main_16964_DFS스페셜저지 {
	
	static int N;
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static int[] arr, parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			map[i]=new ArrayList<Integer>();
		}
		
		StringTokenizer st = null;
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x].add(y);
			map[y].add(x);
		}
				
		visited = new boolean[N+1];
        parent = new int[N+1];
        arr = new int[N+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		if(arr[1]!=1) {
			System.out.println(0);
			return;
		}
		
		dfs(1,1);
		System.out.println(1);
	}

	private static void dfs(int cur, int idx) {
		visited[cur] = true;

        int count = 0;
        for (int v : map[cur]) {
            if (!visited[v]) {
                visited[v] = true;
                parent[v] = cur;
                count++;
            }
        }

        if (count == 0) return;
        int next = arr[idx+1];
        if (parent[next] != cur) {
            System.out.println(0);
            System.exit(0);
        }
        dfs(next, idx+1);
	}

}

