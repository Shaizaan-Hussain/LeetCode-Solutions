class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0])); // Sort by start time

        int coveredDays = 0, lastEnd = 0;

        for (int[] meeting : meetings) {
            int start = Math.max(lastEnd + 1, meeting[0]); // Start fresh from lastEnd + 1
            int end = meeting[1];

            if (start <= end) { // Only add if there's a valid range
                coveredDays += (end - start + 1);
                lastEnd = end; // Update lastEnd
            }
        }

        return days - coveredDays; // Return uncovered days
    }
}