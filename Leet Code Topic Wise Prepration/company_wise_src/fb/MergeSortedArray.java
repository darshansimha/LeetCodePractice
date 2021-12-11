package Dec_11;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// Null or Empty Array case
		if ((nums1 == null && nums2 == null) || (n == 0 && m == 0)) {
			return;
		}
		// If num2 is empty one is null
		if ((n != 0 && m == 0)) {
			return;
		}
		int p1 = m - 1; // This points to the rear of nums1
		int p2 = n - 1;// This points to the rear of nums2
		int p = m + n - 1;// This points to the first available slot on the right i.e. 0

		while (p >= 0) {
			if (p2 < 0) {
				return;
			}
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p] = nums1[p1];
				p1--;
			} else {
				nums1[p] = nums2[p2];
				p2--;
			}
			p--;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
