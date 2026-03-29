import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        
        for(String record : records) {
            String[] r = record.split(" ");
            
            String[] t = r[0].split(":");
            int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            
            String car = r[1];
            String type = r[2];
            
            if(type.equals("IN")) {
                inTime.put(car, time);
            }
            else {
                int tt = inTime.remove(car);
                total.put(car, total.getOrDefault(car, 0) + (time - tt));
            }
        }
        
        for(String str : inTime.keySet()) {
            total.put(str, total.getOrDefault(str, 0) + (1439 - inTime.get(str)));
        }
        
        List<String> cars = new ArrayList<>(total.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        
        for(int i = 0; i < answer.length; i++){
            int time = total.get(cars.get(i));
            
            if(time <= fees[0]) answer[i] = fees[1];
            else {
                if((time - fees[0]) % fees[2] == 0) {
                    answer[i] = fees[1] + (time - fees[0]) / fees[2] * fees[3];
                }
                else {
                    answer[i] = fees[1] + ((time - fees[0]) / fees[2] + 1) * fees[3];
                }
            }
        }
        
        return answer;
    }
}