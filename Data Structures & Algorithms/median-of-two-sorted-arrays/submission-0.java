class Solution {
    
   double median = Double.MAX_VALUE;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;

        if (size1 > size2) {
            findMedianSortedArraysHelper(nums2, nums1);
        } else {
            findMedianSortedArraysHelper(nums1, nums2);
        }

        return median;
    }

    private double findMedianSortedArraysHelper(int[] nums1, int[] nums2) {
        int start = 0;
        int end = nums1.length;


        while (start <= end) {
            int m = start + (end - start) / 2;
            int temp = isValidSplit(nums1, nums2, m);

            if (temp == 0) {
                return median;
            } else if (temp == -1) {
                end = m - 1;
            } else {
                start = m + 1;
            }
        }
        return -1;
    }

    private int isValidSplit(int[] nums1, int[] nums2, int m) {
        int leftHalfCount = ((nums1.length + nums2.length) / 2) + (nums1.length + nums2.length) % 2;

        int leftNums1Last = m - 1 >= 0 ? nums1[m - 1] : Integer.MIN_VALUE;
        int leftNums2Last = leftHalfCount - m - 1 >=0 ? nums2[leftHalfCount - m - 1] : Integer.MIN_VALUE;


        int rightNums1First = m <= nums1.length - 1 ? nums1[m] : Integer.MAX_VALUE;
        int rightNums2First = leftHalfCount - m <= nums2.length-1 ? nums2[leftHalfCount - m] : Integer.MAX_VALUE;

        if (leftNums1Last <= rightNums2First && leftNums2Last <= rightNums1First) {
            if ((nums1.length + nums2.length) % 2 == 0) {
                median = (double) (Math.max(leftNums1Last, leftNums2Last) + Math.min(rightNums1First, rightNums2First)) / 2;
            } else {
                median = Math.max(leftNums1Last, leftNums2Last);
            }
            return 0;

        } else if (leftNums1Last > rightNums2First) {
            //reduce no of elements taken from nums1
            return -1;
        } else {
            return 1;
        }
    }
}
