import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;


class BasketTest {

    @Test
    public void testAddToCart() {
        String[] products = {"Хллеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        Basket basket = new Basket(products, prices);

        basket.addToCart(0, 2);
        basket.addToCart(1, 2);
        basket.addToCart(2, 2);
        int[] actual = basket.getQuantities();
        int[] expected = {2, 2, 2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLoadFromTxt() {
        Basket basket = Basket.loadFromTxtFile(new File("src/test/resources/test_basket.txt"));

        int[] actualPrices = basket.getPrices();
        int[] expectedPrices = {100, 200, 300};

        Assertions.assertArrayEquals(actualPrices, expectedPrices);
    }

    @Test
    public void testLoadFromTxtWhenFileExist() {
        Basket basket = Basket.loadFromTxtFile(new File("src/test/resources/test_basket.txt"));

        int[] expectedQuantity = {2, 2, 2};
        int[] actualQuantity = basket.getQuantities();
        Assertions.assertArrayEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void testLoadFromTxtWhenFileNotExist() {
        Assertions.assertThrows(RuntimeException.class,
                () -> Basket.loadFromTxtFile(new File("src/test/resources/test_bask.txt")));
    }

}