package DynamicProgramming;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		 if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 1;
	        
	        int N = dungeon.length;
	        int M = dungeon[0].length;
	        int[][] dp = new int[N][M];
	        dp[N - 1][M - 1] = 1 - dungeon[N - 1][M - 1];
	        dp[N - 1][M - 1] = dp[N - 1][M - 1] <= 0 ? 1 : dp[N - 1][M - 1];
	            
	        for(int i = N - 1; i >= 0; --i){
	            for(int j = M - 1; j >= 0; --j){
	                if(i == N - 1 && j == M - 1) continue;
	                int down = i + 1 == N ? Integer.MAX_VALUE : dp[i + 1][j] - dungeon[i][j];
	                int right = j + 1 == M ? Integer.MAX_VALUE : dp[i][j + 1] - dungeon[i][j];
	                int HP = Math.min(down, right);
	                dp[i][j] = HP <= 0 ? 1 : HP;
	            }    
	        }
	        
	        return dp[0][0] ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DungeonGame m = new DungeonGame();

		System.out.println(m.calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 },
				{ -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } }));
	}

}
