/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.categoryPro;
import util.DBConnection;

/**
 * FXML Controller class
 *
 * @author Mun Chan
 */
public class CategoryProController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtname;
    @FXML
    private Button btnnew;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btnadd;
    @FXML
    private TableView<categoryPro> tblpro;
    @FXML
    private TableColumn<categoryPro, Integer> tblid;
    @FXML
    private TableColumn<categoryPro, String> tblname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showCate();              
    }    
        public ObservableList<categoryPro> findAll() {
        ObservableList<categoryPro> listc = FXCollections.observableArrayList();
        Statement stmt;
        ResultSet rs;
        try {
            String sql = "SELECT * FROM categoryproduct";
            Connection con = DBConnection.openConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                categoryPro c = new categoryPro();
                c.setIDCatePro(rs.getInt("IDCatePro"));
                c.setNameCateProduct(rs.getString("NameCateProduct"));
                listc.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listc;
    }

    public void showCate() {
        ObservableList<categoryPro> list = findAll();
        tblid.setCellValueFactory(new PropertyValueFactory<>("IDCatePro"));
        tblname.setCellValueFactory(new PropertyValueFactory<>("NameCateProduct"));
        tblpro.setItems(list);

    }

    private void save() throws Exception {
        String query = "insert into categoryproduct values(" + txtid.getText() + ",'" + txtname.getText() + "')";
        excuteQuery(query);
        showCate();
    }
    private void update() throws Exception{
        String query = "update categoryproduct set NameCateProduct='"+txtname.getText()+"' where IDCatePro="+ txtid.getText()+"";
        excuteQuery(query);
        showCate();
    }
     private void delete()throws Exception{
        String query = "DELETE FROM categoryproduct WHERE IDCatePro = "+ txtid.getText();
         excuteQuery(query);
         showCate();
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
    private void ActionNew(ActionEvent event) {
    }

    @FXML
    private void ActionDelete(ActionEvent event) throws Exception {
        if (event.getSource() == btndelete) {
            delete();
        }
    }

    @FXML
    private void ActionUp(ActionEvent event) throws Exception {
         if (event.getSource() == btnupdate) {
            update();
        }
    }

    @FXML
    private void ActionAdd(ActionEvent event) throws Exception {
        if (event.getSource() == btnadd) {
            save();
        }
    }
    
}
