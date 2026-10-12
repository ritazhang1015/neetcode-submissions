class TimeMap {
    public Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new TreeMap<>());
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";
        else if(timeMap.get(key).containsKey(timestamp)){
            return timeMap.get(key).get(timestamp);
        } else if (timeMap.get(key).floorKey(timestamp) != null){
            int k = timeMap.get(key).floorKey(timestamp);
            return timeMap.get(key).get(k);
        } else return "";
    }
}
