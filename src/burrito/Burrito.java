package burrito;

/* import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Burrito {

    private String proteins, drink, sides;
    private double cost, coupon, percentOff;
    private boolean bowl, taxExempt;
    private ArrayList<String> toppings;

    Burrito() {

    }

    void addTopping(String topping) {
        this.toppings.add(topping);
    }

    void setProteins(String proteins) {
        this.proteins = proteins;
    }

    void setDrink(String drink) {
        this.drink = drink;
    }

    void setSide(String side) {
        this.sides = side;
    }

    boolean bowl() {
        if (bowl) {
            return bowl;
        }
    }

    boolean burrito() {
        if (!bowl) {
            return !bowl;
        }
    }

    void percentOff(double percentOff) {

    }

    void coupon(double coupon) {

    }

    void removeTopping(String topping) {

    }

    void isTaxExempt() {

    }

    double getCost() {
        return cost;
    }


    @Nested
    public class BurritoTesting {

        Burrito burrito;

        @BeforeEach
        void init() {
            burrito = new Burrito();
        }

        @ParameterizedTest
        @ValueSource(booleans = {true, false})
        void testBowl(boolean isBowl) {
            burrito.bowl = isBowl;
            burrito.bowl();
            assertTrue(burrito.bowl);
        }

        @ParameterizedTest
        @ValueSource(booleans = {false, true})
        void testBurrito(boolean isBowl) {
            burrito.bowl = isBowl;
            burrito.bowl();
            assertFalse(burrito.bowl);
        }

        @ParameterizedTest
        @CsvSource({
                " , chiken",
                "steak, chicken",
                "chicken, "
        })
        void setProteins(String protein) {
            burrito.setProteins(protein);
            assertEquals(protein, burrito.proteins);
        }

        @ParameterizedTest
        @CsvSource({
                ", random drink"
                ""
        })




    }




}

 */
