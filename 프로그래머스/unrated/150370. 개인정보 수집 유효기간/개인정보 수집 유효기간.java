import java.util.*;
import java.time.LocalDate;

class Solution {
    Map<String, Integer> expiredMap = new HashMap<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todays = today.split("\\.");
        for (String term : terms) {
            String[] t = term.split(" ");
            expiredMap.put(t[0], Integer.parseInt(t[1]));
        }

        int count = 1;
        List<Integer> answer = new ArrayList<>();
        for (String privacy : privacies) {
            String[] p = privacy.split(" ");
            String[] pDay = p[0].split("\\.");
            if (isExpired(pDay, p[1], todays))
                answer.add(count);
            count++;
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }

    public boolean isExpired(String[] pDay, String expiredType, String[] todays) {
        int expMM = expiredMap.get(expiredType);
        int pYYYY = Integer.parseInt(pDay[0]) + expMM / 12;
        int pMM = Integer.parseInt(pDay[1]) + expMM % 12;
        int pDD = Integer.parseInt(pDay[2]);
        if (pMM > 12) {
            pYYYY++;
            pMM = pMM - 12;
        }
        LocalDate expiredDay = LocalDate.of(pYYYY, pMM, pDD);
        LocalDate today = LocalDate.of(Integer.parseInt(todays[0]), Integer.parseInt(todays[1]), Integer.parseInt(todays[2]));
        return expiredDay.isBefore(today) || expiredDay.isEqual(today);
    }
}