package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private String productId;
    private String productName;
    private int productQuantity;
    private static int idCounter = 1;

    public void setIdByCounter() {
        this.productId = idCounter++ + "";
    }
}
