class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for(int i = 0; i < bookings.length; i++){
            int start = bookings[i][0];
            int end = bookings[i][1];
            for(int j = start; j <= end; j++){
                res[j - 1] += bookings[i][2];
            }
        }
        return res;
    }
}