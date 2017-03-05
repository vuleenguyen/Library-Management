package com.mum.edu.library.ui;

import java.util.List;

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
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.apache.commons.lang.StringUtils;

import com.mum.edu.library.model.Employee;

public class Login extends Application {
	private TextField userNameTxt;
	private PasswordField passWordTxt;
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library");
        primaryStage.getIcons().add(new Image(Login.class.getResourceAsStream("manu.png")));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        //setting id for CSS styling
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userNamelbl = new Label("User Name:");
        grid.add(userNamelbl, 0, 1);

        userNameTxt = new TextField();
        grid.add(userNameTxt, 1, 1);

        Label passwordlbl = new Label("Password:");
        grid.add(passwordlbl, 0, 2);

        passWordTxt = new PasswordField();
        grid.add(passWordTxt, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        //setting id for CSS styling
        actiontarget.setId("actiontarget");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	// missing validator 
//            	validator
            	List<Employee> libraryEmployee = DefaultData.LIBRARY_EMPLOYEE;
            	for(Employee employee : libraryEmployee) {
            		if (employee.getIdNumber() != Integer.parseInt(getUserNameValue())) {
            			continue;
            		}
            		if (StringUtils.equals(employee.getPassword(), getPasswordValue())) {
            			System.out.println("Login successfully");
//            			secondWindow.show();
            		}
            	}
            }
        });


        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        
        scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
        primaryStage.show();
    }

	public TextField getUserNameTxt() {
		return userNameTxt;
	}

	public PasswordField getPassWordTxt() {
		return passWordTxt;
	}
	
	public String getUserNameValue() {
		return userNameTxt.getText();
	}
	
	public String getPasswordValue() {
		return passWordTxt.getText();
	}
    
}