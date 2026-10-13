class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(!freq.containsKey(nums[i])) {
                freq.put(nums[i], 1);
            } else {
                freq.replace(nums[i], freq.get(nums[i])+1);
            }
        }

        // create a min-heap with K keys which have the highest freq
        // each element: int[]{number, frequency}
        // min-heap by frequency: the lowest frequency sits on top
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] -        b[1]);
        
        for (int key : freq.keySet()){
            int[] entry = {key, freq.get(key)};
            heap.add(entry);
        }

        int size = heap.size();
        if(size == k){
            int[] result = new int[k];
            for (int i = 0; i < k; i++ ){
                result[i] = heap.peek()[0];
                heap.poll();
            }
            return result;
        }
        while (size > k){
            heap.poll();
            size--;
        }

        int[] result = new int[k];
        int i = 0;
        while (i < k){
            result[i] = heap.peek()[0];
            heap.poll();
            i++;
        }
        return result;
    }
}
