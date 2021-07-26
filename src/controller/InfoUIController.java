/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.product;
import dao.productDao;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import models.categoryPro;
import models.productview;
import util.DBConnection;

/**
 * FXML Controller class
 *
 * @author Mun Chan
 */
public class InfoUIController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtamount;
    @FXML
    private TextField txtdis;
    @FXML
    private TextField txtcate;
    @FXML
    private TextField txtprice;
    @FXML
    private Button btnnew;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btnadd;
    @FXML
    private TableView<productview> tblpro;
    @FXML
    private TableColumn<productview, Integer> tblid;
    @FXML
    private TableColumn<productview, String> tblname;
    @FXML
    private TableColumn<productview, Double> tblprice;
    @FXML
    private TableColumn<productview, String> tbldis;
    @FXML
    private TableColumn<productview, Integer> tblamount;
    @FXML
    private TableColumn<productview, String> tblcate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPro();
    }

    public ObservableList<productview> findAll() {
        ObservableList<productview> listpro = FXCollections.observableArrayList();
        Statement stmt;
        ResultSet rs;
        try {
            String sql = "SELECT product.ID, product.NameProduct, product.Price, product.Amount, product.DescripProduct, product.IDCateProduct, categoryproduct.NameCateProduct "
                    + "FROM product INNER JOIN categoryproduct ON product.IDCateProduct= categoryproduct.IDCatePro";
            Connection con = DBConnection.openConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                productview pro = new productview();
                pro.setID(rs.getInt("ID"));
                pro.setNameProduct(rs.getString("NameProduct"));
                pro.setPrice(rs.getDouble("Price"));
                pro.setAmount(rs.getInt("Amount"));
                pro.setDescripProduct(rs.getString("DescripProduct"));
//                pro.setCate_pro(new categoryPro(rs.getInt("cate_pro"), rs.getString("NameCateProduct")));
                    pro.setIDCateProduct(rs.getInt("IDCateProduct"));
                    pro.setNameCateProduct(rs.getString("NameCateProduct"));
                listpro.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listpro;
    }

    public void showPro() {
//        ObservableList<product> list = (ObservableList<product>) productDao.GetInstance().findAll();
        ObservableList<productview> list = findAll();
        tblid.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblname.setCellValueFactory(new PropertyValueFactory<>("NameProduct"));
        tblprice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tblamount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        tbldis.setCellValueFactory(new PropertyValueFactory<>("DescripProduct"));
        tblcate.setCellValueFactory(new PropertyValueFactory<>("NameCateProduct"));
        tblpro.setItems(list);

    }

    private void save() throws Exception {
        String query = "insert into product values(" + txtid.getText() + ",'" + txtname.getText() + "'," + txtprice.getText() + "," + txtamount.getText() + ",'" + txtdis.getText() + "'," + txtcate.getText() + ")";
        excuteQuery(query);
        showPro();
    }

    private void excuteQuery(String query) throws Exception {
        Connection con = DBConnection.openConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void NewAction(ActionEvent event) {
    }

    @FXML
    private void DeleteAction(ActionEvent event) {
    }

    @FXML
    private void UpdateAction(ActionEvent event) {
    }

    @FXML
    private void SaveAction(ActionEvent event) throws Exception {
        if (event.getSource() == btnadd) {
            save();
        }
    }
}
