class Solution {
    public String mergeAlternately(String word1, String word2) {
        int a = word1.length();
    int b = word2.length();
    StringBuilder str = new StringBuilder();

    int minLen = Math.min(a, b);

    for (int i = 0; i < minLen; i++) {
        str.append(word1.charAt(i));
        str.append(word2.charAt(i));
    }

    if (a > b) {
        str.append(word1.substring(b));
    } else {
        str.append(word2.substring(a));
    }

    return str.toString();
    }
}