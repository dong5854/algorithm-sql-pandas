import java.io.*;
import java.util.*;

public class CODETREE싸움땅 {
	
	// 상, 우, 하, 좌
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	
	static int N, M, K;
	static Player[] playerList;
	
	static PriorityQueue<Gun>[][] guns;
	static Player[][] players;
	
	static class Gun implements Comparable<Gun>{
		int power;
		public Gun(int power) {
			this.power = power;
		}
		@Override
		public int compareTo(Gun o) {
			return -Integer.compare(this.power, o.power);
		}
		@Override
		public String toString() {
			return String.valueOf(this.power);
		}
	}
	
	static class Player {
		int stat;
		Gun gun;
		int row, col, dir;
		int point;
		
		public Player(int row, int col, int dir, int stat) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.stat = stat;
			this.gun = new Gun(0);
			this.point = 0;
		}
		
		// 1-1. 첫 번째 플레이어부터 순차적으로 본인이 향하고 있는 방향대로 한 칸만큼 이동합니다.
		public void move() {
			int nRow = row + dr[this.dir];
			int nCol = col + dc[this.dir];
			// 만약 해당 방향으로 나갈 때 격자를 벗어나는 경우에는 정반대 방향으로 방향을 바꾸어서 1만큼 이동합니다.
			if (nRow >= N || nCol >= N || nRow < 0 || nCol < 0) {
				if (this.dir == 0) { // 상
					this.dir = 2;	 // 하로 바꿈
				} else if (this.dir == 2) { // 하
					this.dir = 0;			// 상으로 바꿈
				} else if (this.dir == 1) { // 우
					this.dir = 3;			// 좌로 바꿈
				} else if (this.dir == 3) { // 좌 
					this.dir = 1;			// 우로 바꿈
				}
				nRow = row + dr[this.dir];
				nCol = col + dc[this.dir];
			}
			this.row = nRow;
			this.col = nCol;
		}
		
		// 총이 있는 경우, 해당 플레이어는 총을 획득합니다. 
		// 플레이어가 이미 총을 가지고 있는 경우에는 
		//놓여있는 총들과 플레이어가 가지고 있는 총 가운데 공격력이 더 쎈 총을 획득하고, 나머지 총들은 해당 격자에 둡니다.
		public Gun getGun(Gun newGun) {
			// 총이 없으면 가져간다.
			if (this.gun.power == 0) {
				this.gun = newGun;
				return null; 
			}
			// 새 총이 더 좋으면 교체			
			if (newGun.power > this.gun.power) {
				Gun temp = this.gun;
				this.gun = newGun;
				return temp;
			}
			// 지금 총이 더 좋으면 필요없음
			return newGun;
		}
		
		// 2-2-1. 만약 이동한 방향에 플레이어가 있는 경우에는 두 플레이어가 싸우게 됩니다. 해당 플레이어의 초기 능력치와 가지고 있는 총의 공격력의 합을 비교하여 더 큰 플레이어가 이기게 됩니다.
		// 만일 이 수치가 같은 경우에는 플레이어의 초기 능력치가 높은 플레이어가 승리하게 됩니다.
		public boolean fight(Player enemy) {
			// 이긴 경우 true 반환
			if (this.gun.power + this.stat > enemy.gun.power + enemy.stat) {
				this.point += (this.gun.power + this.stat) - (enemy.gun.power + enemy.stat);
				return true;
			}
			// 진 경우 false 반환
			if (this.gun.power + this.stat < enemy.gun.power + enemy.stat) {
				enemy.point += (enemy.gun.power + enemy.stat) - (this.gun.power + this.stat); 
				return false;
			}
			// 합이 같을 경우 초기 능력치 비교
			if (this.stat > enemy.stat) {
				this.point += (this.gun.power + this.stat) - (enemy.gun.power + enemy.stat);
				return true;
			}
			if (this.stat < enemy.stat) {
				enemy.point += (enemy.gun.power + enemy.stat) - (this.gun.power + this.stat);
				return false;
			}
			// 비기는 경우는 없으므로 사실 여기로 올 일이 없다.
			return false;
		}
		
		// 2-2-2. 진 플레이어는 본인이 가지고 있는 총을 해당 격자에 내려놓고,
		public Gun looseGun() {
			Gun gunToDrop = this.gun;
			this.gun = new Gun(0);
			if (gunToDrop.power == 0) {
				return null;
			}
			return gunToDrop;
		}
		
		// 해당 플레이어가 원래 가지고 있던 방향대로 한 칸 이동합니다.
		// 만약 이동하려는 칸에 다른 플레이어가 있거나 격자 범위 밖인 경우에는 
		// 오른쪽으로 90도씩 회전하여 빈 칸이 보이는 순간 이동합니다.
		public void loseMove() {
			int nRow = row + dr[this.dir];
			int nCol = col + dc[this.dir];
			while (nRow < 0 || nCol < 0 || nRow >= N || nCol >= N || players[nRow][nCol] != null) {
				this.dir = (this.dir + 1) % 4;
				nRow = row + dr[this.dir];
				nCol = col + dc[this.dir];
			}
			this.row = nRow;
			this.col = nCol;
		}

		@Override
		public String toString() {
			return "Player [stat=" + stat + ", gun=" + gun + ", row=" + row + ", col=" + col + ", dir=" + dir
					+ ", point=" + point + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		setInfo();
		for (int round = 0; round < K; round++) {
			oneRound();
		}
		for (Player p : playerList) {
			sb.append(p.point).append(" ");
		}
		System.out.println(sb);
	}

	private static void oneRound() {
		for (int m = 0; m < M; m++) {
			Player playerThisTurn = playerList[m];
			// 1-1. 첫 번째 플레이어부터 순차적으로 본인이 향하고 있는 방향대로 한 칸만큼 이동합니다. 만약 해당 방향으로 나갈 때 격자를 벗어나는 경우에는 정반대 방향으로 방향을 바꾸어서 1만큼 이동합니다.
			players[playerThisTurn.row][playerThisTurn.col] = null; // 원래 자리를 비워주고
			playerThisTurn.move(); // 이동
			// 2-1. 만약 이동한 방향에 플레이어가 없다면
			if (players[playerThisTurn.row][playerThisTurn.col] == null) {
				// 해당 칸에 총이 있는지 확인합니다.
				if (!guns[playerThisTurn.row][playerThisTurn.col].isEmpty()) { // 총이 있는 경우,
					// 해당 칸의 가장 강한 총
					Gun toPickup = guns[playerThisTurn.row][playerThisTurn.col].poll();
					// 총이 있는 경우, 해당 플레이어는 총을 획득합니다. 플레이어가 이미 총을 가지고 있는 경우에는 놓여있는 총들과 플레이어가 가지고 있는 총 가운데 공격력이 더 쎈 총을 획득하고,
					Gun toDrop = null;
					if (toPickup != null) {
						toDrop = playerThisTurn.getGun(toPickup);
					}
					if (toDrop != null) { // 나머지 총들은 해당 격자에 둡니다.
						guns[playerThisTurn.row][playerThisTurn.col].offer(toDrop);
					}
				}
			} 
			// 2-2-1. 만약 이동한 방향에 플레이어가 있는 경우에는
			else if (players[playerThisTurn.row][playerThisTurn.col] != null) {
				Player enemy = players[playerThisTurn.row][playerThisTurn.col];
				boolean playThisTurnWins = playerThisTurn.fight(enemy);
				Player lostPlayer, wonPlayer;
				if (playThisTurnWins) { // 현재 플레이어가 이긴 경우
					lostPlayer = enemy;
					wonPlayer = playerThisTurn;
				} else {
					lostPlayer = playerThisTurn;
					wonPlayer = enemy;
				}
				
				// 본인이 가지고 있는 총을 해당 격자에 내려놓고.
				Gun lostGun = lostPlayer.looseGun();
				if (lostGun != null) {
					guns[lostPlayer.row][lostPlayer.col].offer(lostGun);
				}
				// 해당 플레이어가 원래 가지고 있던 방향대로 한 칸 이동합니다. 만약 이동하려는 칸에 다른 플레이어가 있거나 격자 범위 밖인 경우에는 오른쪽으로 90도씩 회전하여 빈 칸이 보이는 순간 이동합니다.
				if (lostPlayer == enemy) { // 기존의 점유중이던 플레이어가 진 경우	
					players[lostPlayer.row][lostPlayer.col] = null; // 기존 칸 비워주고
				}
				lostPlayer.loseMove(); // 이동
				players[lostPlayer.row][lostPlayer.col] = lostPlayer;
				// 만약 해당 칸에 총이 있다면,
				if (guns[lostPlayer.row][lostPlayer.col] != null) {
					// 해당 플레이어는 가장 공격력이 높은 총을 획득하고,
					Gun toPickup = guns[lostPlayer.row][lostPlayer.col].poll();
					// 나머지 총들은 해당 격자에 내려 놓습니다. 다만 패배한 경우 어차피 총이 없다.
					if (toPickup != null) {
						lostPlayer.getGun(toPickup);
					}
				}
				Gun toPickup = guns[wonPlayer.row][wonPlayer.col].poll();
				// 총이 있는 경우, 해당 플레이어는 총을 획득합니다. 플레이어가 이미 총을 가지고 있는 경우에는 놓여있는 총들과 플레이어가 가지고 있는 총 가운데 공격력이 더 쎈 총을 획득하고,
				Gun toDrop = null;
				if (toPickup != null) {
					toDrop = wonPlayer.getGun(toPickup);
				}
				if (toDrop != null) { // 나머지 총들은 해당 격자에 둡니다.
					guns[wonPlayer.row][wonPlayer.col].offer(toDrop);
				}
			}
			// 이동 최종 확정
			players[playerThisTurn.row][playerThisTurn.col] = playerThisTurn;
		}
	}

	private static void setInfo() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		guns = new PriorityQueue[N][N];
		players = new Player[N][N];
		playerList = new Player[M];
		
		// 총 정보 입력
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				guns[r][c] = new PriorityQueue<>();
				int gunPower = Integer.parseInt(st.nextToken());
				guns[r][c].add(new Gun(gunPower));
			}
		}
		
		// 플레이어 정보 입력
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			playerList[m] = new Player(x-1, y-1, d, s);
			players[x-1][y-1] = playerList[m]; 
		}
		br.close();
	}
}
