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
public class product {
   int ID;
   String NameProduct;
   Double Price;
   int Amount;
   String DescripProduct;
//   private byte[] ImageProduct;
   private categoryPro cate_pro;

    public product() {
    }

    public product(int ID, String NameProduct, Double Price, int Amount, String DescripProduct, categoryPro cate_pro) {
        this.ID = ID;
        this.NameProduct = NameProduct;
        this.Price = Price;
        this.Amount = Amount;
        this.DescripProduct = DescripProduct;
//        this.ImageProduct = ImageProduct;
        this.cate_pro = cate_pro;
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

//    public byte[] getImageProduct() {
//        return ImageProduct;
//    }
//
//    public void setImageProduct(byte[] ImageProduct) {
//        this.ImageProduct = ImageProduct;
//    }

    public categoryPro getCate_pro() {
        return cate_pro;
    }

    public void setCate_pro(categoryPro cate_pro) {
        this.cate_pro = cate_pro;
    }
   
}
