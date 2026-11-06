class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder() {
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minheap.add(num);
        if(!maxheap.isEmpty() && !minheap.isEmpty() && minheap.peek() < maxheap.peek()){
            int value = minheap.poll();
            maxheap.add(value);
        }
        if(maxheap.size() > minheap.size() + 1){
            minheap.add(maxheap.poll());
        }
        if(minheap.size() > maxheap.size() + 1){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(minheap.size() > maxheap.size()) return minheap.peek();
        if(maxheap.size() > minheap.size()) return maxheap.peek();
        return (((double) maxheap.peek() + (double)minheap.peek()) / 2);
    }
}
