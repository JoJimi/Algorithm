class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {             
        int video = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int answer = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int start = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int end = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        
        if(answer >= start && answer <= end){
            answer = end;
        }
        
        for(int i = 0; i < commands.length; i++){
            String command = commands[i];
            
            if(command.equals("prev")){
                answer -= 10;
                if(answer <= 0) answer = 0;
            }
            else if(command.equals("next")){
                answer += 10;
                if(answer >= video) answer = video;
            }
            
            if(answer >= start && answer <= end){
                answer = end;
            }
        }
        
        return String.format("%02d:%02d", answer/60, answer%60);
    }
}