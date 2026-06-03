class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if(stones.length == 1) return 1;


        for(int s : stones){
            pq.add(s);
        }

        while(pq.size() > 1){
            int big = pq.poll();
            int small = pq.poll();

            if(big != small){
                small = big - small;
                pq.add(small);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
