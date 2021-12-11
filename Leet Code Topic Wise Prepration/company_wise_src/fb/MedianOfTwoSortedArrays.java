package Dec_04;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
			return 0.0;
		}
		if(nums1.length == 0 && nums2.length != 0) {
			return medianOfAnArray(nums2);
		}
		if(nums1.length != 0 && nums2.length == 0) {
			return medianOfAnArray(nums1);
		}
		int[] A;
		int[] B;

		if (nums1.length < nums2.length) {
			A = nums1;
			B = nums2;
		} else {
			A = nums2;
			B = nums1;
		}

		int total = A.length + B.length;
		int half = total / 2;

		int left = 0;
		int right = A.length - 1;
		int ALeft, ARight, BLeft, BRight = 0;

		int AMid, BMid;
		while (true) {
			AMid = (left + right) / 2;

			ALeft = (AMid >= 0) ? A[AMid] : Integer.MIN_VALUE;

			ARight = (AMid + 1 < A.length) ? A[AMid + 1] : Integer.MAX_VALUE;

			BMid = half - AMid - 2;

			BLeft = (BMid >= 0) ? A[BMid] : Integer.MIN_VALUE;

			BRight = (BMid + 1 < B.length) ? A[BMid + 1] : Integer.MAX_VALUE;

			if (BLeft <= ARight && ALeft <= BRight) {
				if (total % 2 != 0) {
					return Math.min(ARight, BRight);
				} else {
					return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
				}
			} else if (ALeft > BRight) {
				right = AMid - 1;
			} else {
				left = AMid + 1;
			}
		}

	}
	private double medianOfAnArray(int[] arr) {
		int len = arr.length;
		int mid = len/2;
		if(len %2 == 0) {
			return (arr[mid] + arr[mid + 1])/2.0;
		} else {
			return arr[mid];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
