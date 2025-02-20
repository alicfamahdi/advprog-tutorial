package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EshopApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testMainWithArguments() {
        String[] args = { "--spring.profiles.active=test" };
        EshopApplication.main(args);
    }
}
