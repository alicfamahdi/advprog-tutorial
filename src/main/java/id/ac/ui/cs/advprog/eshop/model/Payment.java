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
        this.id = id;
        this.order = order;
        this.method = method;
        this.paymentData = paymentData;
        this.status = "PENDING";

        processMethod(method);
    }

    public void setStatus(String status) {
        String[] validStatus = {"PENDING", "SUCCESS", "REJECTED"};

        if (Arrays.stream(validStatus).noneMatch(item -> item.equals(status))) {
            this.status = status;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void processMethod(String method) {
        boolean isValid = false;

        if (method.equals("VOUCHER")) {
            isValid = validateVoucherCode();
        } else if (method.equals("BANK_TRANSFER")) {
            isValid = validateBankTransfer();
        }
        else {
            throw new IllegalArgumentException("Invalid method: " + method);
        }

        if (isValid) {
            this.status = "SUCCESS";
            this.order.setStatus(OrderStatus.SUCCESS.getValue());
        } else {
            this.status = "REJECTED";
            this.order.setStatus(OrderStatus.FAILED.getValue());
        }
    }

    public boolean validateVoucherCode() {
        String voucherCode = paymentData.get("voucherCode");

        if (voucherCode == null || voucherCode.isEmpty()) {
            return false;
        }

        if (voucherCode.length() != 16) {
            return false;
        } else if (!voucherCode.startsWith("ESHOP")) {
            return false;
        } else {
            int counter = 0;
            for(int i = 0; i < voucherCode.length(); i++){
                if(Character.isDigit(voucherCode.charAt(i))){
                    counter++;
                }
            }
            return counter == 8;
        }
    }

    public boolean validateBankTransfer(){
        String bankName = paymentData.get("bankName");
        String referenceCode = paymentData.get("referenceCode");
        return bankName != null && referenceCode != null && !bankName.isEmpty() && !referenceCode.isEmpty();
    }

}
