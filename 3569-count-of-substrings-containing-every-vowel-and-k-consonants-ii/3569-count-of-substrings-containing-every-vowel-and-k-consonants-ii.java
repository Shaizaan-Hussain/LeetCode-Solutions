import java.util.HashMap;

class Solution {
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    private long countSubstrings(String word, int k) {
        int n = word.length(), left = 0, consonants = 0;
        long count = 0;
        HashMap<Character, Integer> vowelMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            if (isVowel(c)) {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
            } else {
                consonants++;
            }

            while (vowelMap.size() == 5 && consonants >= k) {
                count += (n - right);
                char leftChar = word.charAt(left++);
                if (isVowel(leftChar)) {
                    vowelMap.put(leftChar, vowelMap.get(leftChar) - 1);
                    if (vowelMap.get(leftChar) == 0) vowelMap.remove(leftChar);
                } else {
                    consonants--;
                }
            }
        }
        return count;
    }

    public long countOfSubstrings(String word, int k) {
        return countSubstrings(word, k) - countSubstrings(word, k + 1);
    }
}
