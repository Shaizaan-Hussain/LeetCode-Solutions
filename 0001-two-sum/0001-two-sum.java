class Solution {
    public int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] res = new int[2];
    for(int i=0;i<nums.length;i++){
        int rem = target - nums[i];
        if(map.containsKey(rem)){
            int value = map.get(rem);
            res[0] = value;
            res[1] = i;
            break;
        }
     map.put(nums[i], i);
    }
   return res;
    }
}

