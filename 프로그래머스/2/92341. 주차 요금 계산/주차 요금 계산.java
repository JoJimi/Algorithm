import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<String> cars = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            
            if(checked(record[1], cars)) continue;
            cars.add(record[1]);
            
            List<Integer> timeList = new ArrayList<>();
            for(int j = i; j < records.length; j++) {
                String[] r = records[j].split(" ");
                if(!record[1].equals(r[1])) continue;
                
                String[] t = r[0].split(":");
                int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
                
                timeList.add(time);
            }
            
            int total = 0;
            if(timeList.size() % 2 == 1) {
                for(int j = 0; j < timeList.size() - 1; j += 2) {
                    int inTime = timeList.get(j);
                    int outTime = timeList.get(j + 1);
                    
                    total += (outTime - inTime);
                }
                total += (1439 - timeList.get(timeList.size() - 1));
                
                if(total <= fees[0]) {
                    pq.add(new int[]{Integer.parseInt(record[1]), fees[1]});
                }
                else {
                    if((total - fees[0]) % fees[2] == 0) 
                        pq.add(new int[]{Integer.parseInt(record[1]), fees[1] + ((total - fees[0]) / fees[2]) * fees[3]});
                    else 
                        pq.add(new int[]{Integer.parseInt(record[1]), fees[1] + ((total - fees[0]) / fees[2] + 1) * fees[3]});
                }
            }
            else {
                for(int j = 0; j < timeList.size(); j += 2) {
                    int inTime = timeList.get(j);
                    int outTime = timeList.get(j + 1);
                    
                    total += (outTime - inTime);
                }
                
                if(total <= fees[0]){
                    pq.add(new int[]{Integer.parseInt(record[1]), fees[1]});
                } 
                else {
                    if((total - fees[0]) % fees[2] == 0) 
                        pq.add(new int[]{Integer.parseInt(record[1]), fees[1] + ((total - fees[0]) / fees[2]) * fees[3]});
                    else 
                        pq.add(new int[]{Integer.parseInt(record[1]), fees[1] + ((total - fees[0]) / fees[2] + 1) * fees[3]});
                }
            }
        }
        int[] answer = new int[cars.size()];
        
        System.out.println(pq.size());
        
        int i = 0;
        while(!pq.isEmpty()) {
            answer[i] = pq.poll()[1];
            i++;
        }
        
        return answer;
    }
    private boolean checked(String car, List<String> cars) {
        for(int i = 0; i < cars.size(); i++) {
            if(car.equals(cars.get(i))) return true;
        }
        return false;
    }
}