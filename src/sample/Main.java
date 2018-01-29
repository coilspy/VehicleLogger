package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    /*@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 250, 300));
        primaryStage.show();
    }*/
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("register");
        Pane panel = new Pane();
        int i = 2;
        Text textFieldTitle = new Text("Competitor ID");
        TextField textField = new TextField("Enter competitor ID");
        ObservableList<String> items = FXCollections.observableArrayList();
        ListView<String> registeredList = new ListView<String>();
        registeredList.setPrefSize(560, 200);
        registeredList.setCellFactory(TextFieldListCell.forListView());
        registeredList.setEditable(false);
        textField.prefWidth(30);
        textField.prefHeight(100);
        ArrayList<String> list = new ArrayList<String>();
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(textField.getText() == "Enter competitor ID");
                if (textField.getText() != "Enter competitor ID") {
                    registeredList.getItems().add(0, textField.getText() + ";<Time>;");
                    registeredList.edit(0);
                    list.add(textField.getText() + ";<Time>;");
                    System.out.println(textField.getText() + " was registered.");
                    textField.clear();
                }
            }
        });

        GridPane root = new GridPane();
        root.setPadding(new Insets(20, 20, 20, 20));
        // root.add(panel,2,4);
        root.add(textFieldTitle, 1, 1);
        root.add(textField, 1, 2);
        root.add(btn, 2, 2);
        root.add(registeredList, 1, 4);
        Scene scene = new Scene(root, 600, 300);

        primaryStage.setTitle("Race");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
