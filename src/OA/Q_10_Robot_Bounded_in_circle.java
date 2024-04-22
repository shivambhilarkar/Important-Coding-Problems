package OA;

public class Q_10_Robot_Bounded_in_circle {

    public boolean isRobotBounded(String instructions) {
        if (instructions.isEmpty()) return true;

        int x = 0;
        int y = 0;
        int index = 0;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (char ch : instructions.toCharArray()) {
            if (ch == 'L') {
                index = (index + 1) % 4;
            } else if (ch == 'R') {
                index = (index + 3) % 4;
            } else {
                x = x + directions[index][0];
                y = y + directions[index][1];
            }
        }
        return x == 0 && y == 0 || index != 0;

    }

    public static void main(String[] args) {

    }
}
