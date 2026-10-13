class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            if (!seen.contains(nums[i])) seen.add(nums[i]);
        }

        int maxLen = 1;
        int[] arr = seen.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        int slow = 0;
        int fast = 1;
        while(fast < arr.length){
            if(arr[fast-1] + 1 == arr[fast]){
                if((fast - slow +1) > maxLen) maxLen = (fast-slow+1);
                fast++;
            } else {
                slow = fast;
                fast = slow + 1;
            }
        }

        return maxLen;
    }
}
