class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long min = Long.MAX_VALUE;
        for (int t : times) {
            if (t < min) min = t;
        }

        long startTime = min, endTime = min * n, midTime = 0, tempN = 0;

        while (startTime <= endTime) {
            midTime = (startTime + endTime)/2;
            tempN = 0;
            for (int t : times) {
                tempN += midTime/t;
            }
            
            // 입국심사한 인원 많으면 범위 축소
            if (tempN >= n) {
                answer = midTime;
                endTime = midTime - 1;   
            // 입국심사한 인원이 적으면 범위 확장
            } else {
                startTime = midTime + 1;
            }
        }
        
        return answer;
    }
}