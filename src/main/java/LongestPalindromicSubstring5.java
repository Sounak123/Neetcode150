public class LongestPalindromicSubstring5 {

    public static void main(String[] args) {
        LongestPalindromicSubstring5 longestPalindromicSubstring = new LongestPalindromicSubstring5();
        //System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("aaaa"));
    }

    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        String maxString = "";
        for(int i=1; i<s.length();i++) {
            String maxOdd = maxLengthOdd(s,i);
            maxString=maxOdd.length()>maxString.length()? maxOdd:maxString;
            String maxEven = maxLengthEven(s, i-1, i);
            maxString=maxEven.length()>maxString.length()? maxEven:maxString;
        }
        return maxString;
    }

    public String maxLengthOdd(String s, int position) {
        int left=position-1;
        int right=position+1;
        while(left>=0 && right<s.length()) {
            if(s.charAt(left)==s.charAt(right)) {
                left--;
                right++;
            }else{
                break;
            }
        }
        return s.substring(left+1,right);
    }

    public String maxLengthEven(String s, int positionA, int positionB) {
        if(s.charAt(positionA) != s.charAt(positionB)) return "";
        positionA--;
        positionB++;
        while(positionA>=0 && positionB<s.length()) {
            if(s.charAt(positionA) == s.charAt(positionB)) {
                positionA--;
                positionB++;
            }
            else break;
        }
        return s.substring(positionA+1, positionB);
    }
}
