package controller;

import business.BOFactory;
import business.BOTypes;
import business.SuperBO;
import business.custom.ItemBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ItemDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ItemFormController {
    public TableView tblItem;
    ItemBO bo = BOFactory.getInstance().getBO(BOTypes.ITEM);

    public Label lblNextCustomerCount;
    public JFXTextField txtDescription;
    public JFXTextField txtPrice;
    public JFXTextField txtQuantity;
    public JFXButton btnDelete;
    public JFXTextField txtTestID;
    public JFXTextField txtCode;
    public JFXButton btnClear;

    @FXML
    private TableView<ItemDTO> tblCustomer;

    @FXML
    private TableColumn<ItemDTO, String> clmCode;

    @FXML
    private TableColumn<ItemDTO, String> clmDescription;

    @FXML
    private TableColumn<ItemDTO, String> clmUnitPrice;

    @FXML
    private TableColumn<ItemDTO, String> clmQuantity;

    public void initialize(){
        loadAllItem();

    }

    public void clearOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void saveOnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        String desc = txtDescription.getText();
        double price = Double.valueOf(txtPrice.getText());
        int quantity = Integer.parseInt(txtQuantity.getText());
        ItemDTO itemDTO = new ItemDTO(code, desc, price, quantity);
        try {
            boolean b = bo.addItem(itemDTO);
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION,"Data Added Successfully", ButtonType.OK).show();
                clearAll();
                loadAllItem();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadAllItem(){
        try {
            List<ItemDTO> all = bo.getAll();
            ObservableList<ItemDTO> objects = FXCollections.observableArrayList();
            objects.addAll(all);
            tblItem.setItems(objects);
            setTblItemCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTblItemCellValue(){
        clmCode.setCellValueFactory(new PropertyValueFactory<ItemDTO,String>("itemCode"));
        clmDescription.setCellValueFactory(new PropertyValueFactory<ItemDTO,String>("description"));
        clmUnitPrice.setCellValueFactory(new PropertyValueFactory<ItemDTO,String>("unitPrice"));
        clmQuantity.setCellValueFactory(new PropertyValueFactory<ItemDTO,String>("quantity"));
    }

    public void clearAll(){
        txtCode.clear();
        txtQuantity.clear();
        txtPrice.clear();
        txtDescription.clear();
    }
}
