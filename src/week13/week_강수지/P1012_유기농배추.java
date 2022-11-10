package week13.week_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1012_유기농배추 {
	//상하좌우 네 방향 => 방향벡터
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int cnt; // 전역변수로 선언해야한다 !

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine()); // test case
		for (int tc = 0; tc < T; tc++) {
			String s[] = bf.readLine().split(" ");
			M = Integer.parseInt(s[0]); // 가로
			N = Integer.parseInt(s[1]); // 세로
			int K = Integer.parseInt(s[2]); // 배추 위치 개수
			
			map = new int[M][N];
			for (int j = 0; j < K; j++) {
				String s2[] = bf.readLine().split(" ");
				map[Integer.parseInt(s2[0])][Integer.parseInt(s2[1])] = 1;
			} // 배추 위치만큼 배추 심기 !
			
			cnt = 0; // 배추흰지렁이 마리수
			visited = new boolean[M][N];
			
			// 배추 위치마다 dfs 호출 !
			// 배추가 없는 곳에 위치하면 dfs 탈출
			// 다른 배추 위치를 탐색 + cnt++
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		} // test case end
		
	}

	private static void dfs(int i, int j) { // dfs
		visited[i][j] = true;
		
		for (int d = 0; d < 4; d++) { // 4 방향을 탐색
			int x = i + dx[d];
			int y = j + dy[d];
			
			if(x>=0 && y>=0 && x<M && y<N) { // 범위내 존재하고
				if(map[x][y]==1 && !visited[x][y]) { // 방문하지 않은 또다른 배추 위치라면
					dfs(x, y);
				}
			}
		}
	}
}
