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
public class categoryPro {
    int IDCatePro;
    String NameCateProduct;

    public categoryPro() {
    }

    public categoryPro(int IDCatePro, String NameCateProduct) {
        this.IDCatePro = IDCatePro;
        this.NameCateProduct = NameCateProduct;
    }

    public categoryPro(String namecateproduct) {
        this.NameCateProduct = namecateproduct;
    }

    public int getIDCatePro() {
        return IDCatePro;
    }

    public void setIDCatePro(int IDCatePro) {
        this.IDCatePro = IDCatePro;
    }

    public String getNameCateProduct() {
        return NameCateProduct;
    }

    public void setNameCateProduct(String namecateproduct) {
        this.NameCateProduct = namecateproduct;
    }
}
