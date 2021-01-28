package controller;

import business.BOFactory;
import business.BOTypes;
import business.SuperBO;
import business.custom.impl.CustomerBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.Stream;

public class CustomerController {


    public Label lblNextCustomerCount;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtTel;
    public JFXTextField txtTestID;
    public JFXButton btnDelete;
    public JFXTextField txtID;
    public JFXButton btnClear;


    @FXML
    private TableView<CustomerDTO> tblCustomer;

    @FXML
    private TableColumn<CustomerDTO,String> clmID;

    @FXML
    private TableColumn<CustomerDTO,String> clmName;

    @FXML
    private TableColumn<CustomerDTO, String> clmAddress;

    @FXML
    private TableColumn<CustomerDTO,String> clmTel;


    CustomerBOImpl bo = BOFactory.getInstance().getBO(BOTypes.CUSTOMER);

    public void initialize(){

        lblNextCustomerCount.setText(genarateNewID());
        txtID.requestFocus();
        getAllCustomer();

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
                getAllCustomer();
            }else{
                new Alert(Alert.AlertType.ERROR,"Data Added not Successfully..").show();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    public void updateOnAction(ActionEvent actionEvent) {
        String id = txtID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        CustomerDTO customerDTO = new CustomerDTO(id,name,address,tel);
        try {
            boolean b = bo.updateCustomer(customerDTO);
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION,"Data Updated..",ButtonType.OK).show();
                getAllCustomer();
                clear();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"Data not Updated..",ButtonType.OK).show();
                getAllCustomer();
                clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void searchOnAction(ActionEvent actionEvent) {

        String id = txtID.getText();
        try {
            CustomerDTO customer = bo.searchCustomer(id);
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

        String id = tblCustomer.getSelectionModel().getSelectedItem().getId();
        try {
            boolean b = bo.deleteCustomer(id);
            if (b) {
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Successfully..").show();
                getAllCustomer();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Delete not Successfully..").show();
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

    private void setTblCustomerCellValue() {
        clmID.setCellValueFactory(new PropertyValueFactory<CustomerDTO, String>("id"));
        clmName.setCellValueFactory(new PropertyValueFactory<CustomerDTO, String>("name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<CustomerDTO, String>("address"));
        clmTel.setCellValueFactory(new PropertyValueFactory<CustomerDTO, String>("tel"));
    }
        public void getAllCustomer () {

            try {
                List<CustomerDTO> customer = bo.getAll();
                ObservableList<CustomerDTO> list = FXCollections.observableArrayList();
                list.addAll(customer);
                tblCustomer.setItems(list);
                setTblCustomerCellValue();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


}
