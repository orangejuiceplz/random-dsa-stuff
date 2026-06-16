package funalgs;

public class maingraph {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C", "D", "E"};
        int[][] a = new int[5][5];
        a[0][1] = 1;
        a[1][2] = 1;
        a[2][3] = 1;
        a[3][4] = 1;
        a[4][0] = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 1) {
                    a[i][j] = 0;
                }
            }
        }
        Graph_2_KShiven<String> shiven = new Graph_2_KShiven<>(arr, a);
        shiven.printAllCycles();

    }
}
