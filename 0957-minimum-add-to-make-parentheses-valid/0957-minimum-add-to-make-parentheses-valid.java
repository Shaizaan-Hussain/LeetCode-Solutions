class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0; // unmatched '('
        int add = 0;  // extra ')' needed
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--; // match with '('
                } else {
                    add++; // need extra '(' before this ')'
                }
            }
        }
        return open + add; // remaining '(' + needed ')'
    }
}
