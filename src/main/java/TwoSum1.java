public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length; i++) {
            int y = target - nums[i];
            if(map.containsKey(y)) {
                return new int[]{i, map.get(y)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
      int[] arr = [2,7,11,15];
      int target = 9;

      TwoSum1 obj = new TwoSum1();
      obj.twoSum(arr, target);
    }
}
