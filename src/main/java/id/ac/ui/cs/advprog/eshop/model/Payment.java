package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

@Getter
public class Payment {
    private String id;
    private Order order;
    private String method;
    private String status;
    private Map<String, String> paymentData;
    private String[] validMethods = {"BANK_TRANSFER", "VOUCHER"};

    public Payment(String id, Order order, String method, Map<String, String> paymentData) {
    }

    public void setStatus(String status) {
    }
}
