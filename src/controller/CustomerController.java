package controller;

import business.BOFactory;
import business.BOTypes;
import business.SuperBO;
import business.custom.impl.CustomerBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import entity.Customer;
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
    public JFXTextField txtID;
    public JFXButton btnClear;

    CustomerBOImpl bo = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);

    public void initialize(){

        lblNextCustomerCount.setText(genarateNewID());
        txtID.requestFocus();
    }

    public void saveOnAction(ActionEvent actionEvent) {
        String id = txtID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        CustomerDTO customerDTO = new CustomerDTO(id, name, address, tel);
        try {
            boolean b = bo.addCustomer(customerDTO);
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION,"Data Added Successfully..").show();
                txtID.clear();
                txtName.clear();
                txtAddress.clear();
                txtTel.clear();
                lblNextCustomerCount.setText(genarateNewID());
                txtID.requestFocus();
            }else{
                new Alert(Alert.AlertType.ERROR,"Data Added not Successfully..").show();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    public void updateOnAction(ActionEvent actionEvent) {

    }

    public void searchOnAction(ActionEvent actionEvent) {

        String id = txtID.getText();
        try {
            Customer customer = bo.searchCustomer(id);
            System.out.println("cONTROLLER :"+ customer.getName());
            if (customer!=null){
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                txtTel.setText(customer.getTel());
            }else{
                new Alert(Alert.AlertType.INFORMATION,"No Customer").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void deleteOnAction(ActionEvent actionEvent) {


        try {
            txtTestID.requestFocus();
            String customID = txtTestID.getText();
            boolean b = bo.deleteCustomer(customID);
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION,"Record Delete Successfully..").show();
                txtName.clear();
                txtName.clear();
                txtAddress.clear();
                txtID.requestFocus();


            }else{new Alert(Alert.AlertType.ERROR,"Record Delete not Successfully..").show();


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

    public void clear(){
        txtID.clear();
        txtAddress.clear();
        txtName.clear();
        txtTel.clear();
    }

    public void clearOnAction(ActionEvent actionEvent) {
        clear();
    }
}
