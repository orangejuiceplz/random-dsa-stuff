package funalgs.weighted;

import java.lang.module.FindException;

public class MatrixMethod_2_KShiven {

    private Matrix_2_KShiven matrix;
    private int currLength;
    private String[] values;

    public MatrixMethod_2_KShiven(String[] values, double[][] adjacencyMatrix) {
        this.currLength = adjacencyMatrix.length - 1;
        matrix = new Matrix_2_KShiven(adjacencyMatrix.length);
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                matrix.setCosts(i, j, adjacencyMatrix[i][j], values[i]);
            }
        }
        raise();
    }

    public double cost(String from, String to) {
        int rFrom = 0, rTo = 0,cFrom = 0, cTo = 0;
        for (int i = 0; i < currLength; i++) {
            for (int j = 0; j < currLength; j++) {
                if (matrix.getPath(i, j).equals(from)) {
                    rFrom = i;
                    cFrom = j;
                } else if (matrix.getPath(i, j).equals(to)) {
                    rTo = i;
                    cTo = j;
                }
            }
        }
        return matrix.getCost(rFrom, rTo) + matrix.getCost(cFrom, cTo);
    }

    public String path(String from, String to) {
        int rFrom = 0, rTo = 0,cFrom = 0, cTo = 0;

        for (int i = 0; i < currLength; i++) {
            for (int j = 0; j < currLength; j++) {
                if (matrix.getPath(i, j).equals(from)) {
                    rFrom = i;
                    cFrom = j;
                } else if (matrix.getPath(i, j).equals(to)) {
                    rTo = i;
                    cTo = j;
                }
            }
        }
        String pathOne = matrix.getPath(rFrom, cFrom);
        String pathTwo = matrix.getPath(rTo, cTo);
        return pathOne.substring(0, pathOne.length() - 1) + pathTwo;
    }

    private void raise() {
        Matrix_2_KShiven matrix2KShiven = new Matrix_2_KShiven(currLength);
        double leastCost = 0;
        String leastPath = "";
        for (int i = 0; i < currLength; i++) {
            for (int j = 0; j < currLength; j++) {
                for (int k = 0; k < currLength; k++) {
                    double sum = matrix2KShiven.getCost(i, k) + matrix2KShiven.getCost(k, j);
                    if (sum < leastCost) {
                        leastCost = sum;
                        leastPath = matrix2KShiven.getPath(i, j);
                    }
                }
            }
        }
        currLength *= 2;
        matrix2KShiven = new Matrix_2_KShiven(currLength);

        if (leastPath.length() < matrix2KShiven.getLongestPath() && currLength < values.length - 1) {
            raise();
        }
    }


}



