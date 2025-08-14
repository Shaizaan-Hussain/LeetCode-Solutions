class Solution {
    public String largestGoodInteger(String num) {
        String maxstr = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            String str = num.substring(i, i + 3);
            if (str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2)) {
                if (maxstr.isEmpty() || str.charAt(0) > maxstr.charAt(0)) {
                    maxstr = str;
                }
            }
        }
        return maxstr;
    }
}