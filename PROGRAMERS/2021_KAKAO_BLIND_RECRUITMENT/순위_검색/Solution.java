import java.util.*;

class Solution {    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        
        String[] lan = {"cpp", "java", "python", "-"};
        String[] job = {"frontend", "backend", "-"};
        String[] exp = {"junior", "senior", "-"};
        String[] food = {"chicken", "pizza", "-"};
        
        for(String l : lan) {
            for(String j : job) {
                for(String e : exp) {
                    for(String f : food) {
                        map.put(l + " " + j + " " + e + " " + f, new ArrayList<Integer>());
                    }
                }
            }    
        }
        
        for(String line: info) {
            int lastSpaceIndex = line.lastIndexOf(" ");
            String condition = line.substring(0, lastSpaceIndex);
            int score = Integer.parseInt(line.substring(lastSpaceIndex + 1));
            
            String[] tokens = condition.split(" ");

            for (int i = 0; i < (1 << 4); i++) {
                String key = "";
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) != 0) {
                        key += "-";
                    } else {
                        key += tokens[j];
                    }
                    if (j < 3) key += " ";
                }

                map.get(key).add(score);
            }
        }
        
         for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
             
            Collections.sort(value);
        }
        
        for(int i=0; i<query.length; ++i) {
            String line = query[i];
            int lastSpaceIndex = line.lastIndexOf(" ");
            String condition = line.substring(0, lastSpaceIndex);
            String score = line.substring(lastSpaceIndex + 1);
            String[] conditionArr = condition.split("and");
            
            String key = "";
            for(String con : conditionArr) {
                con = con.trim();
                
                key += con + " ";
            }
            
            key = key.substring(0, key.length() - 1);
            ArrayList<Integer> list = map.get(key);
            
            int l = 0;
            int r = list.size() - 1;
            int mid = 0;
            while(l <= r) {
                mid = (l + r) / 2;
                
                if(list.get(mid) < Integer.parseInt(score)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            
            answer[i] = list.size() - l;
        }
            
        return answer;
    }
}