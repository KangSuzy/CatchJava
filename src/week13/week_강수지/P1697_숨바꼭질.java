package week13.week_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P1697_숨바꼭질 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String s[] = bf.readLine().split(" ");
		int N = Integer.parseInt(s[0]); // 수빈이의 위치
		int K = Integer.parseInt(s[1]); // 동생의 위치

		// 수빈이가 동생한테 갈 수 있는 방법
		// 빼기, 더하기, 곱하기 ..

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N); // 수빈이의 현재점 : 출발지

		// 최대값으로 배열 초기화 ..
		boolean[] visited = new boolean[200001]; // 방문처리 배열
		int[] tmp = new int[200001]; // 이동시간을 누적으로 저장할 배열

		while (!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true; // 방문처리

			// 종료조건
			// 수빈이가 동생이랑 같은 위치일때
			if (cur == K) {
				System.out.println(tmp[cur]);
				return;
			}

			// 범위내 존재하면 .. 이동 가능한지 확인
			if (cur - 1 >= 0 && !visited[cur - 1]) {
				visited[cur-1] = true;
				tmp[cur-1] = tmp[cur]+1;
				q.offer(cur-1);
			}

			if (cur + 1 < 200001 && !visited[cur + 1]) {
				visited[cur+1] = true;
				tmp[cur+1] = tmp[cur]+1;
				q.offer(cur+1);
			}

			if (cur *2 < 200001 && !visited[cur * 2]) {
				visited[cur*2] = true;
				tmp[cur*2] = tmp[cur]+1;
				q.offer(cur*2);
			}

		}
	}

}
