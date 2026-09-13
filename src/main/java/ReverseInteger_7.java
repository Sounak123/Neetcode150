public class ReverseInteger_7 {
    public int reverse(int x) {
        String s = String.valueOf(x);
        char[] arr = s.toCharArray();

        if(arr.length<2){
            return x;
        }

        int start = (arr[0] != '-')? 0:1;
        int end = arr.length-1;
        char temp;
        while(start<end) {
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

        long finalVal = Long.parseLong(String.valueOf(arr));

        return (finalVal>Integer.MAX_VALUE || finalVal<Integer.MIN_VALUE)? 0: (int)finalVal;

    }

    public static void main(String[] args) {
        ReverseInteger_7 obj = new ReverseInteger_7();
        obj.reverse(123);
        obj.reverse(-123);
        obj.reverse(-123);
    }
}
