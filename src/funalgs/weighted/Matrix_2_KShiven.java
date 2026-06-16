package funalgs.weighted;

public class Matrix_2_KShiven {

    private double[][] costs;
    private String[][] paths;

    public Matrix_2_KShiven(int num) {
        costs = new double[num][num];
        paths = new String[num][num];
    }

    public void setCosts(int row, int column, double cost, String path) {
        costs[row][column] = cost;
        paths[row][column] = path;
    }

    public double getCost(int row, int column) {
        return costs[row][column];
    }
    public String getPath(int row, int column) {
        return paths[row][column];
    }

    public int getLongestPath() {
        int longestPath = 0;

        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[0].length; j++) {
                int current = paths[i][j].length();
                if (current > longestPath) {
                    longestPath = current;
                }
            }
        }
        return longestPath;
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                int length = paths[i][j].length();
                String row = getPath(i, j).substring(i, i + 1);
                String column = getPath(i, j).substring(length - 1);
                String cost = (getCost(i, j) == Double.POSITIVE_INFINITY) ? "Infinity" : String.valueOf(getCost(i, j));
                string += row + "To" + column + getPath(i, j) + " with a cost of " + cost;
            }
            string += "\n";
        }
        return string;
    }
}
