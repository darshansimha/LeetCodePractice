package DynamicProgramming;

public class MaximumPointsYouCanObtainFromCards {

	public int maxScore(int[] cardPoints, int k) {
		if (cardPoints == null || k <= 0 || cardPoints.length == 0) {
			return 0;
		}
		int maxScore = 0;
		int n = cardPoints.length;
		int[] frontSet = new int[k + 1];
		int[] rearSet = new int[k + 1];

		for (int i = 0; i < k; i++) {
			frontSet[i + 1] = frontSet[i] + cardPoints[i];
			rearSet[i + 1] = rearSet[i] + cardPoints[n - i - 1];
		}

		int currentScore = 0;
		
		for (int i = 0; i <= k; i++) {
			currentScore = frontSet[i] + rearSet[k - i];
			maxScore = Math.max(maxScore, currentScore);
		}

		return maxScore;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
