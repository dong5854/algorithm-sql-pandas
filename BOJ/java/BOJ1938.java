import java.io.*;
import java.util.*;

public class BOJ1938 {
	
	
	static class Log {
		int[] cor;
		int row;
		int col;
		char position;
		int cnt;
		
		public Log(int[] cor, char positon, int cnt) {
			this.cor = cor;
			this.row = cor[0];
			this.col = cor[1];
			this.position = positon;
			this.cnt = cnt;
		}
	}

	// 위, 아래, 왼쪽, 오른쪽
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0 , 0, -1, 1};
	
	// 정사각형 한 변의 길이
	static int N;
	
	// 정답
	static int ans;
	
	// 지형 정보
	static char[][] map; 
	
	// 기둥이 세로일 때 방문처리 배열
	static boolean[][] vh;
	// 기둥이 가로일 때 방문처리 배열
	static boolean[][] vv;
	
	// 시작 기둥의 중앙 좌표
	static int[] startCor;
	// 시작 기둥의 가로 세로 여부 (H, V) => (가로, 세로)
	static char startPos;
	
	// 목적지 기둥의 중앙 좌표
	static int[] destCor;
	// 목적지 기둥의 가로 세로 여부 (H, V) => (가로, 세로)
	static char destPos;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		vh = new boolean[N][N];
		vv = new boolean[N][N];
		
		//vh 에서 도달할 수 없는 위치는 미리 방문 처리
		for (int r = 0; r < N; r++) {
			vh[r][0] = true;
			vh[r][N-1] = true;
		}
		
		// vv 에서 도달할 수 없는 위치는 미리 방문 처리
		for (int c = 0; c < N; c++) {
			vv[0][c] = true;
			vv[N-1][c] = true;
		}
		
		ans = 0;
		// 지형 정보 입력
		for (int r = 0; r < N; r++) {
			String row = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = row.charAt(c);
			}
		}
		
		// 목표 기둥 가로 모양 여부 확인
		out : for (int r = 0; r < N; r++) {
			for (int c = 1; c < N; c++) {
				if (map[r][c] == 'E' && map[r][c-1] == 'E') {
					destCor = new int[] {r,c};
					destPos = 'H';
					break out;
				}
			}
		}
		
		// 시작 가로 모양의 기둥 확인
		out: for (int r = 0; r < N; r++) {
			for (int c = 1; c < N; c++) {
				if (map[r][c] == 'B' && map[r][c-1] == 'B') {
					startCor = new int[] {r,c};
					startPos = 'H';
					break out;
				}
			}
		}
		
		// 목표 기둥 세로 모양의 기둥 확인
		out : for (int c = 0; c < N; c++) {
			for (int r = 1; r < N; r++) {
				if (map[r][c] == 'E' && map[r-1][c] == 'E') {
					destCor = new int[] {r,c};
					destPos = 'V';
					break out;
				}
				if (map[r][c] == 'B' && map[r-1][c] == 'B') {
					startCor = new int[] {r,c};
					startPos = 'V';
				}
			}
		}
		
		// 시작 기둥 세로 모양의 기둥 확인
		out : for (int c = 0; c < N; c++) {
			for (int r = 1; r < N; r++) {
				if (map[r][c] == 'B' && map[r-1][c] == 'B') {
					startCor = new int[] {r,c};
					startPos = 'V';
					break out;
				}
			}
		}
		

		
		// 완탐
		bfs(startCor, startPos);
		
		// 정답 출력
		System.out.println(ans);
		br.close();
	}

	static void bfs(int[] curCor, char curPos) {
		ArrayDeque<Log> q = new ArrayDeque<>();
		Log log = new Log(curCor, curPos, 0);
		if (log.position == 'V') {
			vv[log.row][log.col] =  true;
		}
		if (log.position == 'H') {
			vh[log.row][log.col] =  true;
		}
		q.add(log);
		
		while (!q.isEmpty()) {
			Log clog = q.poll();
			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int nr = clog.row + dr[i];
				int nc = clog.col + dc[i];
				// 인덱스 체크
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				// 방문 체크
				if (clog.position == 'V' && vv[nr][nc]) continue;
				if (clog.position == 'H' && vh[nr][nc]) continue;
				// 기둥 체크
				if (clog.position == 'V' && (map[nr][nc] == '1' || map[nr-1][nc] == '1' || map[nr+1][nc] == '1')) continue;
				if (clog.position == 'H' && (map[nr][nc] == '1' || map[nr][nc-1] == '1' || map[nr][nc+1] == '1')) continue;
				
				// 방문처리
				if (clog.position == 'V') {
					vv[nr][nc] = true;
				} else if (clog.position == 'H') {
					vh[nr][nc] = true;
				}
				
				if (nr == destCor[0] && nc == destCor[1] && clog.position == destPos) {
					ans = clog.cnt + 1;
					return;
				}
				
				q.add(new Log(new int[] {nr, nc}, clog.position, clog.cnt + 1));
			}
			
			// 회전
			if (spinAble(clog.cor, clog.position)) {
				if (clog.position == 'V') {
					q.add(new Log(clog.cor, 'H', clog.cnt + 1));
					vh[clog.row][clog.col] = true;
				} else if (clog.position == 'H') {
					q.add(new Log(clog.cor, 'V', clog.cnt + 1));
					vv[clog.row][clog.col] = true;
				}
			}
		}
	}
	
	static boolean spinAble(int[] cor, char pos) {
		// 세로인 경우
		if (pos == 'V') {
			// 이미 방문 한 적 있으면, false
			if (vh[cor[0]][cor[1]]) return false;
			try {
				// 주변에 기둥이 있으면, false
				if (map[cor[0]-1][cor[1]-1] == '1') return false;
				if (map[cor[0]-1][cor[1]+1] == '1') return false;
				if (map[cor[0]][cor[1]-1] == '1') return false;
				if (map[cor[0]][cor[1]+1] == '1') return false;
				if (map[cor[0]+1][cor[1]-1] == '1') return false;
				if (map[cor[0]+1][cor[1]+1] == '1') return false;	
			} catch (ArrayIndexOutOfBoundsException e) {
				// 옆이 벽인 경우
				return false;
			}
		}
		// 가로인 경우
		if (pos == 'H') {
			// 이미 방문 한 적 있으면, false
			if (vv[cor[0]][cor[1]]) return false;
			try {
				// 주변에 기둥이 있으면, false
				if (map[cor[0] - 1][cor[1] - 1] == '1') return false;
				if (map[cor[0] + 1][cor[1] - 1] == '1') return false;
				if (map[cor[0] - 1][cor[1]] == '1') return false;
				if (map[cor[0] + 1][cor[1]] == '1') return false;
				if (map[cor[0] - 1][cor[1] + 1] == '1') return false;
				if (map[cor[0] + 1][cor[1] + 1] == '1') return false;
			} catch (ArrayIndexOutOfBoundsException e) {
				// 옆이 벽인 경우
				return false;
			}
		}
		return true;
	}
}
