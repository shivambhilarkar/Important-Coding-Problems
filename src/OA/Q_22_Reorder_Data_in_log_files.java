package OA;

import java.util.PriorityQueue;

public class Q_22_Reorder_Data_in_log_files {

    public String[] reorderLogFile(String[] logs) {
        if (logs.length == 0) {
            return logs;
        }

        //PriorityQueue with custom compare function which compares string after spaces
        PriorityQueue<String> queue = new PriorityQueue<>((w1, w2) -> {
            if (w1.substring(w1.indexOf(" ") + 1).equals(w2.substring(w2.indexOf(" ") + 1))) {
                return w1.compareTo(w2);
            } else {
                return w1.substring(w1.indexOf(" ") + 1).compareTo(w2.substring(w2.indexOf(" ") + 1));
            }
        });

        int index = 0;
        String[] result = new String[logs.length];

        for (String log : logs) {
            if (isLogDigit(log) == false) {
                queue.add(log);
            }
        }

        while (queue.isEmpty() == false) {
            result[index++] = queue.poll();
        }

        for (String log : logs) {
            if (isLogDigit(log)) {
                queue.add(log);
            }
        }
        while (queue.isEmpty() == false) {
            result[index++] = queue.poll();
        }

        return result;
    }

    private boolean isLogDigit(String log) {
        return Character.isDigit(log.charAt(log.indexOf(" ") + 1));
    }

    public static void main(String[] args) {

    }
}
