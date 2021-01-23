package controller;

import business.BOFactory;
import business.BOTypes;
import business.SuperBO;
import business.custom.impl.CustomerBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class CustomerController {


    public Label lblNextCustomerCount;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtTel;
    public JFXTextField txtTestID;
    public JFXButton btnDelete;

    CustomerBOImpl bo = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);

    public void initialize(){
        lblNextCustomerCount.setText(genarateNewID());
    }

    public void saveOnAction(ActionEvent actionEvent) {
        String id = lblNextCustomerCount.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        CustomerDTO customerDTO = new CustomerDTO(id, name, address, tel);
        try {
            boolean b = bo.addCustomer(customerDTO);
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION).show();
                lblNextCustomerCount.setText(genarateNewID());
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR).show();
        }


    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
        txtTestID.setVisible(true);
        String customID = txtTestID.getText();

    }

    public void deleteOnAction(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.INFORMATION,"Please Enter Customer ID", ButtonType.OK).show();

        txtTestID.setVisible(true);

        try {
            txtTestID.requestFocus();
            String customID = txtTestID.getText();
            boolean b = bo.deleteCustomer(customID);
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION).show();
                txtName.clear();
                txtName.clear();
                txtAddress.clear();
                txtName.requestFocus();


            }else{new Alert(Alert.AlertType.ERROR).show();


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String genarateNewID(){
        String id = null;
        try {
             id = bo.getID();


        } catch (Exception e) {
            e.printStackTrace();
        }return id;

    }
}
