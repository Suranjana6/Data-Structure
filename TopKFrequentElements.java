// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)-> a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()):a.getValue()-b.getValue());

        for(Map.Entry entry: map.entrySet()){
            pq.offer(entry);

            if(pq.size()>k){
                pq.remove();
            }
        }
        int idx=0;
        int[] res=new int[k];

        while(!pq.isEmpty()){
            res[idx++]=pq.poll().getKey();
        }

        return res;
    }
}
