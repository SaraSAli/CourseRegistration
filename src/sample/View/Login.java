package sample.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;


import java.awt.*;

import static javafx.geometry.HPos.RIGHT;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Course Registration");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Student Application Login");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        Text actiontarget = new Text();
        grid.add(actiontarget, 0, 6);
        grid.setColumnSpan(actiontarget, 2);
        grid.setHalignment(actiontarget, RIGHT);
        actiontarget.setId("actiontarget");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                String struserName = userTextField.getText();
                String pwVal = pwBox.getText();

                if (struserName == null || "".equalsIgnoreCase(struserName) || "null".equalsIgnoreCase(struserName) || pwVal == null || "".equalsIgnoreCase(pwVal) || "null".equalsIgnoreCase(pwVal)) {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Please provide username and password");
                    return;
                }

                if ("admin".equalsIgnoreCase(struserName) && "admin".equalsIgnoreCase(pwVal)) {
                    WelcomePage s = new WelcomePage();
                    try {
                        s.start(primaryStage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if ("student".equalsIgnoreCase(struserName) && "student".equalsIgnoreCase(pwVal)) {
                    NormalWelcome s = new NormalWelcome();
                    s.start(primaryStage);
                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Please provide valid user name and password");
                    return;
                }


            }
        });

        //Scene scene = new Scene(grid, 300, 275);
        Scene scene = new Scene(grid, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("C:\\Users\\El-Sa7er\\IdeaProjects\\Course Registration\\src\\sample\\icons\\icon.png")));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
