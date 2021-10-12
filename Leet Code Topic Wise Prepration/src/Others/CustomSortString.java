package Others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CustomSortString {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : T.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder s = new StringBuilder();
        for(char c : S.toCharArray()) {
        	if(map.containsKey(c)) {
        		for(int i = 0; i < map.get(c); i++) {
        			s.append(c);
        		}
        		map.put(c, 0);
        	}
        }
        Set<Character> c = map.keySet();
        Iterator<Character> h = c.iterator();
        while(h.hasNext()) {
        	Character c1  = h.next();
        	if(map.get(c1) != 0) {
        		for(int i = 0; i < map.get(c1); i++) {
        			s.append(c1);
        		}
        	}
        	h.remove();
        }
        
        return s.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomSortString c = new CustomSortString();
		System.out.println(c.customSortString("cba", "abcd"));
	}

}
