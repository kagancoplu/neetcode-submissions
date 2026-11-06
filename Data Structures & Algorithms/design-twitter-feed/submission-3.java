class Twitter {
    int count;
    HashMap<Integer,List<int[]>> tweetmap;
    HashMap<Integer,HashSet<Integer>> followmap;
    public Twitter() {
        count = 0;
        tweetmap = new HashMap<>();
        followmap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetmap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        HashSet<Integer> users = new HashSet<Integer>(followmap.getOrDefault(userId, new HashSet<>()));
        users.add(userId);
        for(int u : users){
            List<int[]> tweets = tweetmap.get(u);
            if(tweets != null && !tweets.isEmpty()){
                int index = tweets.size() -1;
                int[] recent = tweets.get(index);
                maxheap.add(new int[]{recent[0],recent[1],u,index - 1});
            }
        }
        while(!maxheap.isEmpty() && res.size() < 10){
            int[] top = maxheap.poll();
            res.add(top[1]);
            int next = top[3];
            if(next >= 0){
                int[] t = tweetmap.get(top[2]).get(next);
                maxheap.add(new int[]{t[0],t[1],top[2],next- 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followmap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followmap.get(followerId).contains(followeeId)){
            followmap.get(followerId).remove(followeeId);
        }
    }
}
