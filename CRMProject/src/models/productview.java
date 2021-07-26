/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Mun Chan
 */
public class productview {
   int ID;
   String NameProduct;
   Double Price;
   int Amount;
   String DescripProduct;
   int IDCateProduct;
   String NameCateProduct;

    public productview() {
    }

    public productview(int ID, String NameProduct, Double Price, int Amount, String DescripProduct, int IDCateProduct, String NameCateProduct) {
        this.ID = ID;
        this.NameProduct = NameProduct;
        this.Price = Price;
        this.Amount = Amount;
        this.DescripProduct = DescripProduct;
        this.IDCateProduct = IDCateProduct;
        this.NameCateProduct = NameCateProduct;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String NameProduct) {
        this.NameProduct = NameProduct;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getDescripProduct() {
        return DescripProduct;
    }

    public void setDescripProduct(String DescripProduct) {
        this.DescripProduct = DescripProduct;
    }

    public int getIDCateProduct() {
        return IDCateProduct;
    }

    public void setIDCateProduct(int IDCateProduct) {
        this.IDCateProduct = IDCateProduct;
    }

    public String getNameCateProduct() {
        return NameCateProduct;
    }

    public void setNameCateProduct(String NameCateProduct) {
        this.NameCateProduct = NameCateProduct;
    }
   
}
