package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class EshopApplicationTests {

    @Test
    void testMainWithArguments() {
        String[] args = { "--spring.profiles.active=test" };
        assertDoesNotThrow(() -> EshopApplication.main(args),
                "Application should start without throwing exceptions");
    }

}
