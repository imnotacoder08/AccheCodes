public class Solution {

public double findMedianSortedArrays(int[] nums1, int[] nums2) {

	int sz1 = nums1.length, sz2 = nums2.length;
	int combinedSize = sz1 + sz2;			
	int half = combinedSize / 2;
	int maxLoop = half + 1;
	int[] ml = new int[maxLoop];

	if (combinedSize == 0) return 0d;

	if (sz1 == 0) {
		ml = nums2;
		maxLoop = 0;
	}
	if (sz2 == 0) {
		ml = nums1;
		maxLoop = 0;
	}

	int p1 = 0, p2 = 0;

	for (int i = 0; i < maxLoop; i++) {
		Integer v1 = null, v2 = null;
		if (p1 < sz1) v1 = nums1[p1];
		if (p2 < sz2) v2 = nums2[p2];

		if (v1 == null && v2 == null) {
			i = maxLoop;   // exit out
		} else if (v1 == null) {
			ml[i] = v2;
			p2++;
		} else if (v2 == null) {
			ml[i] = v1;
			p1++;
		} else if (v1 < v2) {
			ml[i] = v1;
			p1++;
		} else {
			ml[i] = v2;
			p2++;
		}
	}

	return (double) (((combinedSize) % 2 > 0) ? ml[half] : (double)(ml[half-1] + ml[half]) / 2d);
}
}