package controller;

import business.BOFactory;
import business.BOTypes;
import business.SuperBO;
import business.custom.impl.CustomerBOImpl;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class CustomerController {


    public Label lblNextCustomerCount;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtTel;

    CustomerBOImpl bo = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);

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
            }new Alert(Alert.AlertType.ERROR).show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }
}
