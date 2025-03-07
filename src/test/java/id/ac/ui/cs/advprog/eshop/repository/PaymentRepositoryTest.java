package id.ac.ui.cs.advprog.eshop.repository;


import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Payment> paymentList;
    List<Product> products;
    Order order;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        paymentList = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        products.add(product1);
        products.add(product2);

        order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Safira Sudrajat");

        paymentData = new HashMap<String, String>();

    }

    @Test
    void testGetAllPayments() {
        Iterator<Payment> paymentIterator = paymentList.iterator();
        assertTrue(paymentIterator.hasNext());
    }
}

/*
Payment’s service has these functions:
public Payment addPayment(Order order, String method, Map<String, String> paymentData)
This method will create a new payment object for the current order. This method will also automatically save the new payment object to PaymentRepository.
public Payment setStatus(Payment payment, String status)
This method will set status for the current payment.
If the payment status is set to “SUCCESS”, then the status of the Order object that is related to the Payment object will also be “SUCCESS”.
If the payment status is set to “REJECTED”, then the status of the Order object that is related to the Payment object will be “FAILED”.
public Payment getPayment(String paymentId)
This method will get the Payment object by its paymentId.
public Payment getAllPayments()
This method will return all Payment objects.

 */
