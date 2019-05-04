package javaFX8dialog;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DialogController {

	@FXML
	private AnchorPane rootPane;

	@FXML
	private TextField txfMessage;
	@FXML
	private TextField txfDetail;

	@FXML
	private Button btnInfo;
	@FXML
	private Button btnQuestion;
	@FXML
	private Button btnWarning;
	@FXML
	private Button btnError;

	@FXML
	private TextField txfResponse;

	@FXML
	void initialize() {
		assert txfMessage != null : "fx:id=\"txfMessage\" was not injected: check your FXML file 'DialogBox.fxml'.";
		assert txfDetail != null : "fx:id=\"txfDetail\" was not injected: check your FXML file 'DialogBox.fxml'.";

		assert btnInfo != null : "fx:id=\"btnInfo\" was not injected: check your FXML file 'DialogBox.fxml'.";
		assert btnQuestion != null : "fx:id=\"btnQuestion\" was not injected: check your FXML file 'DialogBox.fxml'.";
		assert btnWarning != null : "fx:id=\"btnWarning\" was not injected: check your FXML file 'DialogBox.fxml'.";
		assert btnError != null : "fx:id=\"btnError\" was not injected: check your FXML file 'DialogBox.fxml'.";

		assert txfResponse != null : "fx:id=\"txfResponse\" was not injected: check your FXML file 'DialogBox.fxml'.";

		this.txfMessage.setText("Enter dialog box main message.");
		this.txfDetail.setText("Enter dialog box detailed message.");
	}

	@FXML
	void btnInfoOnAction(ActionEvent event) throws IOException {
		showDialogBox(AlertType.INFORMATION);
	}

	@FXML
	void btnQuestionOnAction(ActionEvent event) throws IOException {
		showDialogBox(AlertType.CONFIRMATION);
	}

	@FXML
	void btnWarningOnAction(ActionEvent event) throws IOException {
		showDialogBox(AlertType.WARNING);
	}

	@FXML
	void btnErrorOnAction(ActionEvent event) throws IOException {
		showDialogBox(AlertType.ERROR);
	}

	protected void showDialogBox(AlertType type) throws IOException {
		Alert alert = new Alert(type);
		alert.setTitle("JavaFX 8 dialog box");
		alert.getDialogPane().setHeaderText(this.txfMessage.getText());
		alert.getDialogPane().setContentText(this.txfDetail.getText());
		Optional<ButtonType> result = alert.showAndWait();

		String s = "no present";
		if (result.isPresent()) {
			if (alert.getResult() == ButtonType.OK) {
				s = "OK";
			} else if (alert.getResult() == ButtonType.CANCEL) {
				s = "Cancel";
			} else {
				s = "?";
			}
		}
		this.txfResponse.setText("\"" + s + "\" button has been pressed.");
	}
}
