import java.util.*;

class Solution {
    static class Task {
        String name;
        int remainedTime;
        
        Task(String name, int remainedTime){
            this.name = name;
            this.remainedTime = remainedTime;
        }
    }
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));
        
        Stack<Task> stacks = new Stack<>();
        List<String> names = new LinkedList<>();
        
        for(int i = 0 ; i < plans.length - 1; i++) {
            String name = plans[i][0];
            int start = convert(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);
            
            int nextStart = convert(plans[i+1][1]);
            int gap = nextStart - start;
            
            if(playtime <= gap) {
                names.add(name);
                gap -= playtime;
                
                while(gap > 0 && !stacks.isEmpty()){
                    Task task = stacks.pop();
                    String taskName = task.name;
                    int taskTime = task.remainedTime;

                    if(gap - taskTime >= 0) {
                        names.add(taskName);
                        gap -= taskTime;
                    }
                    else {
                        stacks.add(new Task(taskName, taskTime - gap));
                        gap = 0;
                    }
                }
            }
            else {
                stacks.push(new Task(name, playtime - gap));
            }
        }
        names.add(plans[plans.length - 1][0]);
        
        while(!stacks.isEmpty()){
            Task task = stacks.pop();
            names.add(task.name);
        }
        
        return names.toArray(new String[0]);
    }
    private int convert(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
}