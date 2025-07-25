class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        int count = 1;

        str.append(s.charAt(0)); // Always include the first character

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1; // Reset the count when characters differ
            }

            if (count < 3) {
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}
