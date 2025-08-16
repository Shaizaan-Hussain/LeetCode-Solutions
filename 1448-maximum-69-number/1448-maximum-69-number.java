class Solution {
    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        int max = num;  // start with original number

        for (int i = 0; i < str.length(); i++) {
            char[] chars = str.toCharArray(); // make a copy
            if (chars[i] == '9') {
                chars[i] = '6';
            } else {
                chars[i] = '9';
            }
            int curr = Integer.valueOf(new String(chars));
            max = Math.max(max, curr);
        }
        return max;
    }
}
