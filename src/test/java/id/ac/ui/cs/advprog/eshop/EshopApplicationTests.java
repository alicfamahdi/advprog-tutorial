package id.ac.ui.cs.advprog.eshop;

import id.ac.ui.cs.advprog.eshop.EshopApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EshopApplicationTests {

    @Test
    public void testMainWithArguments() {
        String[] args = { "--spring.profiles.active=test" };
        EshopApplication.main(args);
    }

}
