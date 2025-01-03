package view;

import controller.UserController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.User;

public class Login extends GridPane{
	Stage stage;
	TextField email, pass;
	Label titleLabel, emailLabel, passwordLabel;
	Button login, goToRegister;
	
	public void initialized() {
		titleLabel = new Label("Welcome back!");
		titleLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");
		emailLabel = new Label("Email:");
		email = new TextField();
		email.setPromptText("Insert email");
		passwordLabel = new Label("Password:");
		pass = new PasswordField();
		pass.setPromptText("Insert password");
		login = new Button("Sign In");
		goToRegister = new Button("No account yet?");
	}
	
	public void setLayout() {
		this.setPadding(new Insets(15));
//		this.setPadding(getInsets());d
        this.setHgap(10);
        this.setVgap(10);
		
        this.add(titleLabel, 0, 0);
        this.add(emailLabel, 0, 1);
		this.add(email, 0, 2);
		this.add(passwordLabel, 0, 3);
		this.add(pass, 0, 4);
		this.add(login, 0, 5);
		this.add(goToRegister, 0, 6);
	}
	
	public void setButton() {
		login.setOnAction(e ->{
			String mail = email.getText();
			String password = pass.getText();
			User user = UserController.Login(mail, password);
			if (user == null) {
				System.out.println("Login failed!");
			}
			else {
				System.out.println("Login successful!");
				new Profile(stage, user);
			}
		});
		goToRegister.setOnAction(e ->{
			new Registration(stage);
			
		});
	}
	
	public Login(Stage stage) {
		this.stage = stage;
		initialized();
		setLayout();
		setButton();
		Scene scene = new Scene(this, 300,300);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();
	}
}
