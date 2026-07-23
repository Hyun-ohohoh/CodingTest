import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Set<String>> reportMember = new HashMap<>();
        Map<String, Integer> reportMail = new HashMap<>();

        for(int i = 0; i < report.length; i++) {
            String str = report[i];
            String fromId = str.split(" ")[0];
            String toId = str.split(" ")[1];

            if(!reportMember.containsKey(fromId)) {
                Set<String> set = new HashSet<>();
                set.add(toId);
                reportMember.put(fromId, set);
            } else {
                Set<String> set = reportMember.get(fromId);
                set.add(toId);
                reportMember.put(fromId, set);
            }
        }

        for(Set<String> set : reportMember.values()) {
            for(String name : set) {
                if(!reportCount.containsKey(name)) {
                    reportCount.put(name, 1);
                } else {
                    reportCount.put(name, reportCount.get(name) + 1);
                }
            }
        }

        for(Map.Entry<String, Integer> entry : reportCount.entrySet()) {
            boolean remove = false;
            if(entry.getValue() >= k) {
                remove = true;
            }

            if(remove) {
                for(Map.Entry<String, Set<String>> entry2 : reportMember.entrySet()) {
                    Set<String> set = entry2.getValue();
                    if(set.contains(entry.getKey())) {
                        if(!reportMail.containsKey(entry2.getKey())) {
                            reportMail.put(entry2.getKey(), 1);
                        } else {
                            reportMail.put(entry2.getKey(), reportMail.get(entry2.getKey()) + 1);
                        }
                    }
                }
            }
        }

        int[] result = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            for(String key : reportMail.keySet()) {
                if(key.equals(id)) {
                    result[i] = reportMail.get(key);
                }
            }
        }

        return result;
    }
}