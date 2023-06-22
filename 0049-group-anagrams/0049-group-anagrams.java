import java.util.*;
import java.util.Map.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sorted = Stream.of(s.split("")).sorted().collect(Collectors.joining());
            if (map.containsKey(sorted)) {
                List<String> l = map.get(sorted);
                l.add(s);
                map.put(sorted, l);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(sorted, l);
            }
        }


        List<List<String>> ls = new ArrayList<>();
        for (
                Entry<String, List<String>> entry : map.entrySet()) {
            ls.add(entry.getValue());
        }
        return ls;
    }
}