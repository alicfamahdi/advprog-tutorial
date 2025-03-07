package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentTest {
    Order order;
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<Product>();
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

//    happy order
    @Test
    void testCreatePaymentEmptyOrder() {
        this.order = null;

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("26299032-6747-46e8-ae48-aac9e4707e75", order, "BANK_TRANSFER", paymentData);
        });
    }

//    empty order
    @Test
    void testCreatePaymentEmptyOrder() {
        this.order = null;

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("26299032-6747-46e8-ae48-aac9e4707e75", order, "BANK_TRANSFER", paymentData);
        });
    }

//    right method
    @Test
    void testCreatePaymentInvalidPaymentData() {
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, String> invalidPaymentData = new HashMap<>();
            invalidPaymentData.put("BANK_TRANSFER", "BANK_TRANSFER");
            Payment payment = new Payment("26299032-6747-46e8-ae48-aac9e4707e75", order, "BANK_TRANSFER", invalidPaymentData);
        });
    }

//    wrong method
    @Test
    void testCreatePaymentInvalidPaymentData() {
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, String> invalidPaymentData = new HashMap<>();
            invalidPaymentData.put("BANK_TRANSFER", "BANK_TRANSFER");
            Payment payment = new Payment("26299032-6747-46e8-ae48-aac9e4707e75", order, "BANK_TRANSFER", invalidPaymentData);
        });
    }

//    right paymentdata
    @Test
    void testCreatePaymentInvalidPaymentData() {
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, String> invalidPaymentData = new HashMap<>();
            invalidPaymentData.put("BANK_TRANSFER", "BANK_TRANSFER");
            Payment payment = new Payment("26299032-6747-46e8-ae48-aac9e4707e75", order, "BANK_TRANSFER", invalidPaymentData);
        });
    }

//    wrong payment data
    @Test
    void testCreatePaymentInvalidPaymentData() {
        assertThrows(IllegalArgumentException.class, () -> {
            Map<String, String> invalidPaymentData = new HashMap<>();
            invalidPaymentData.put("BANK_TRANSFER", "BANK_TRANSFER");
            Payment payment = new Payment("26299032-6747-46e8-ae48-aac9e4707e75", order, "BANK_TRANSFER", invalidPaymentData);
        });
    }
}

/*
Payment Feature Description
Payment’s model has these attributes:
id: String
method: String to save a sub-feature name.
status: String
paymentData: Map<String, String> to save payment sub-feature data.
==================================================
Payment by Voucher Code Sub-feature Description
Cash on Delivery sub-feature will fill the Map<String, String> paymentData parameter when creating new Payment using this key-value pairs:
“voucherCode”: the voucher code
The payment status will automatically be “SUCCESS” if the voucher code follows these rules:
The voucher code must be 16 characters long, and
The voucher code must be started with “ESHOP”, and
The voucher code must contain 8 numerical characters.
Valid voucher code example is: “ESHOP1234ABC5678”. If the voucher code is invalid, the payment status will automatically be “REJECTED”.

Payment by Bank Transfer Sub-feature Description
Bank Transfer sub-feature will fill the Map<String, String> paymentData parameter when creating new Payment using this key-value pairs:
“bankName”: the bank name.
“referenceCode”: the reference code shown in the transfer invoice.
The payment status will automatically be “REJECTED” if one of those information is empty (empty string or null).

 */
