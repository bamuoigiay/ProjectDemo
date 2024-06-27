/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

/**
 *
 * @author LENOVO
 */
public class ProductDTO {
    private int productID;
    private String productName;
    private String Status;
    private int Price;
    private int Amount;

    public ProductDTO() {
    }

    public ProductDTO(int productID, String productName, String Status, int Price, int Amount) {
        this.productID = productID;
        this.productName = productName;
        this.Status = Status;
        this.Price = Price;
        this.Amount = Amount;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }
    
}