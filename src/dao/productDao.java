/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.categoryPro;
import models.product;
import util.DBConnection;

/**
 *
 * @author Mun Chan
 */
public class productDao {

    private static productDao instance = null;

    public productDao() {
    }

    public static productDao GetInstance() {
        if (instance == null) {
            instance = new productDao();
        }
        return instance;
    }

    public boolean insert(product pro)
            throws Exception {
        String sql = "INSERT INTO product(`ID`, `NameProduct`, `Price`, `Amount`, `DescripProduct`,  `IDCateProduct`)"
                + "values(?,?,?,?,?,?)";
        try (
                Connection con = DBConnection.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, pro.getID());
            pstmt.setString(2, pro.getNameProduct());
            pstmt.setDouble(3, pro.getPrice());
            pstmt.setInt(4, pro.getAmount());
            pstmt.setString(5, pro.getDescripProduct());
            pstmt.setInt(6, pro.getCate_pro().getIDCatePro());
            return pstmt.executeUpdate() > 0;
        }

    }

    public boolean update(product pro)
            throws Exception {
        String sql = "update product"
                + " set `NameProduct`=?, `Price`=?, `Amount`=?, `DescripProduct`=?,  `IDCateProduct`=? "
                + " where ID= ?";
        try (
                Connection con = DBConnection.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(6, pro.getID());
            pstmt.setString(1, pro.getNameProduct());
            pstmt.setDouble(2, pro.getPrice());
            pstmt.setInt(3, pro.getAmount());
            pstmt.setString(4, pro.getDescripProduct());
            pstmt.setInt(5, pro.getCate_pro().getIDCatePro());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean delete(product pro)
            throws Exception {
        String sql = "delete from product"
                + " where ID= ?";
        try (
                Connection con = DBConnection.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, pro.getID());
            return pstmt.executeUpdate() > 0;
        }
    }

    public product findById(int ID)
            throws Exception {
        String sql = "SELECT product.ID, `NameProduct`, `Price`, `Amount`, `DescripProduct`, `ImageProduct`, `IDCateProduct`  FROM product INNER JOIN categoryproduct ON product.IDCateProduct= categoryproduct.IDCateProduct where product.ID='" + ID + "'";
        try (
                Connection con = DBConnection.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    product pro = new product();
                    pro.setID(rs.getInt("ID"));
                    pro.setNameProduct(rs.getString("NameProduct"));
                    pro.setPrice(rs.getDouble("Price"));
                    pro.setAmount(rs.getInt("Amount"));
                    pro.setDescripProduct(rs.getString("DescripProduct"));
                    pro.setCate_pro(new categoryPro(rs.getInt("cate_pro"), rs.getString("NameCateProduct")));
                    return pro;
                }
            }

        }
        return null;
    }

    public List<product> findAll() throws Exception {
        List<product> listpro = new ArrayList<>();
//        ObservableList<product> listpro = FXCollections.observableArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT product.ID, NameProduct, Price, Amount, DescripProduct, IDCateProduct, categoryproduct.NameCateProduct  FROM product INNER JOIN categoryproduct ON product.IDCateProduct= categoryproduct.IDCateProduct";
            Connection con = DBConnection.openConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                 product pro = new product();
                    pro.setID(rs.getInt("ID"));
                    pro.setNameProduct(rs.getString("NameProduct"));
                    pro.setPrice(rs.getDouble("Price"));
                    pro.setAmount(rs.getInt("Amount"));
                    pro.setDescripProduct(rs.getString("DescripProduct"));
                    pro.setCate_pro(new categoryPro(rs.getInt("cate_pro"), rs.getString("NameCateProduct")));
                listpro.add(pro);
            }
//                return listbook;
        } catch (SQLException e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                rs.close();
                stmt.close();
            } catch (Exception e) {
            }
        }
        return listpro;
    }
}
