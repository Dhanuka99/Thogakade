package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public ImageView imgClose;

    public void btnCustomerOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("../view/CustomerForm.fxml")));
        stage.setScene(scene);
        stage.show();

    }

    public void btnStockOnMouseClicked(MouseEvent mouseEvent) {
    }

    public void btnPurchesOnMouseClicked(MouseEvent mouseEvent) {
    }
}
