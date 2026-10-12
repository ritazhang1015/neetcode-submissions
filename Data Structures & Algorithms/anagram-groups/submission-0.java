class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        // when should i declare the List<String> to be a ArrayList, or other Class instead of interface

        for (int i = 0; i < strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String word = new String(arr);
            List<String> cur = new ArrayList<>();
            cur.add(strs[i]);
            if(map.containsKey(word)) {
                map.get(word).add(strs[i]);
            }
            else {map.put(word, cur);}
        }

        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}
