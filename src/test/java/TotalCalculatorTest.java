import org.junit.jupiter.api.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TotalCalculatorTest {

    private final TotalCalculator totalCalculator = new TotalCalculator();

    @Test
    void testGetQuantityPerProductShouldReturnOk() {
        //given
        String currentCart = "ABCDABA";
        //when
        HashMap<String, Integer> actualQuantity = totalCalculator.getQuantityPerProduct(currentCart);
        //then

        assertEquals(prepareGetQuantityPerProduct(), actualQuantity);
    }

    private HashMap<String, Integer> prepareGetQuantityPerProduct() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("A", 3);
        expected.put("B", 2);
        expected.put("C", 1);
        expected.put("D", 1);

        return expected;
    }

    @Test
    void testGetSumShouldReturnSum() {
        //given
        String currentCart = "ABCDABA";
        //when
        double actualSum = totalCalculator.getSum(currentCart);
        //then
        double expected = 13.25;
        assertEquals(expected, actualSum);
    }

    @Test
    void testGetQuantityPerProductShouldThrowNullPointerException() {
        //given
        String currentCart = null;

        assertThrows(NullPointerException.class, () -> totalCalculator.getQuantityPerProduct(currentCart));
    }
}