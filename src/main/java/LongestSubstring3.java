import java.util.HashSet;

public class LongestSubstring3 {

    public static void main(String[] args) {
        LongestSubstring3 longestSubstring = new LongestSubstring3();
        System.out.println(longestSubstring.lengthOfLongestSubstring("aab"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int start=0;
        int end=0;
        int maxLen=1;
        int currentLen=0;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(start));
        end=end+1;
        currentLen=1;
        while(end<s.length()){
            char a=s.charAt(end);
            if(!set.contains(a)) {
                set.add(a);
                currentLen++;
                maxLen = Math.max(currentLen, maxLen);
            }else{
                while(set.contains(a)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(a);
                currentLen=set.size();
            }
            end=end+1;
        }
        return maxLen;
    }
}
