package OA;

public class Q_06_Slowest_Keys {


    public char slowestKey(int[] releaseTimes, String keyPressed) {

        char[] keys = keyPressed.toCharArray();
        int n = releaseTimes.length;

        char ans = 'a';
        int longestDuration = 0;
        int pressedTime;
        int duration;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                pressedTime = 0;
            } else {
                pressedTime = releaseTimes[i - 1];
            }

            duration = releaseTimes[i] - pressedTime;

            if (duration == longestDuration) {
                if (keys[i] < ans) {
                    ans = keys[i];
                }
            } else if (duration > longestDuration) {
                ans = keys[i];
                longestDuration = duration;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }

}
