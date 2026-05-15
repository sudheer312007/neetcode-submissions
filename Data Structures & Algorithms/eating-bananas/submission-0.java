class Solution {
   public int minEatingSpeed(int[] piles, int h) {
        int k = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int start = 1;
        int end = max;

        while (start <= end) {
            int m = start + (end - start) / 2;
            boolean isValidSpeed = checkIfKokoCanEatAtMSpeed(piles, h, m);

            if (isValidSpeed) {
                k = Math.min(k, m);
                end = m - 1;
            } else {
                start = m + 1;
            }
        }


        return k;
    }

    private boolean checkIfKokoCanEatAtMSpeed(int[] piles, int h, int k) {
        int hoursNeededAtCurrentSpeed = 0;
        for (int pile : piles) {
            int hoursForCurrentPileAtCurrentSpeed = pile / k + (pile % k == 0 ? 0 : 1);
            hoursNeededAtCurrentSpeed += hoursForCurrentPileAtCurrentSpeed;
            if (hoursNeededAtCurrentSpeed > h) {
                return false;
            }
        }
        return true;
    }
}
