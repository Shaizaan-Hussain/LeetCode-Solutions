class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        if (!word.matches("[a-zA-Z0-9]+")) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);
                if ("aeiou".indexOf(ch) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }
        return hasVowel && hasConsonant;

        }
    }
