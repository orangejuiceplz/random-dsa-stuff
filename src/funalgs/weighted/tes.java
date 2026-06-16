package funalgs.weighted;

public class tes {

    public static void main(String[] args) {

        Matrix_2_KShiven matrix2KShiven = new Matrix_2_KShiven(4);

        double inf = Double.POSITIVE_INFINITY;

        matrix2KShiven.setCosts(0, 0, inf, "AA");
        matrix2KShiven.setCosts(0, 1, 8.0, "AB");
        matrix2KShiven.setCosts(0, 2, inf, "AC" );
        matrix2KShiven.setCosts(0, 3, 2.0, "AD");

        matrix2KShiven.toString();
        }
    }


