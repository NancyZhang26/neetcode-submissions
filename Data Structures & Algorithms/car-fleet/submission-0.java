class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < speed.length; i++) {
            map.put(-position[i], speed[i]);
        }

        float lastTime = -1; int fleet = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            float time = (float)(target+entry.getKey()) / (float)entry.getValue();
            if (time > lastTime) {
                lastTime = time;
                fleet++;
            }
        }

        return fleet;
        
    }
}
