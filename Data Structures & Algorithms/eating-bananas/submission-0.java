class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int p:piles) {
            max = Math.max(p, max);
        }

        int min = 1;

        while (min < max) {
            int mid = min + (max-min)/2;
            int hours = countHours(piles, mid);
            if (hours > h) {
                min = mid+1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    public int countHours(int[] piles, int speed) {
        int hours = 0;
        for (int p: piles) {
            hours += p%speed==0?p/speed:p/speed+1;
        }
        return hours;
    }
}
