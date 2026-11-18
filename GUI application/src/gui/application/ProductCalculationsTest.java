package gui.application;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCalculationsTest {

    @Test
    public void GetVat() {

        double price = 3500.0;

        ProductCalculations calc = new ProductCalculations(price);

        double vat = calc.GetVat();

        assertEquals(525.0, vat);
    }
}