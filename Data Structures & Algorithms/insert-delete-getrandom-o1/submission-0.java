class RandomizedSet {
    
    HashMap<Integer, Integer> map;
    HashSet<Integer> set;
    int num;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.set = new HashSet<>();
        this.num = -1;
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int index = map.size();
        map.put(val, index);
        set.add(index);
        num++;
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        set.remove(map.get(val));
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        System.out.println(set);
        Random rand = new Random();
        int count = rand.nextInt(num+1);
        while (!set.contains(count)) {
            count = rand.nextInt(num+1);
        }
        // System.out.println(count);
        // System.out.println(map);
        // System.out.println(map.get(count));
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue()==count) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */