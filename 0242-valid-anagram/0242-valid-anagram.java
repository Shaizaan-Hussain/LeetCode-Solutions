import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();
        if(s.length() == t.length()){
            char[] s1 = s.toCharArray();
            char[] t1 = t.toCharArray();
            Arrays.sort(s1);
            Arrays.sort(t1);
            boolean result = Arrays.equals(s1, t1);
            if(result){
                return true;
            }
        }
        return false;
    }
}