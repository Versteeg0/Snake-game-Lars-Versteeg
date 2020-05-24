package view;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameOverScene extends Scene {

	private Controller cont;
	
	private Text text;
	
	private VBox root;
	private final int PANEWIDTH = 760;
	private final int PANEHEIGHT = 600;
	
	private Label gameover;
	
	public GameOverScene(Controller controller) {
		super(new Pane());
		cont = controller;
		
		createLabel();
		createTimer();
		
		setRoot();
	}
	
	private void createLabel() {
		gameover = new Label();
		gameover.setText("Game Over");
		gameover.setFont(new Font("Arial", 40));
	}
	
	private void createTimer() {
		text = new Text();
		text.setText("00:00:000");
		text.setText(cont.changeText());
	}
	
	private void setRoot() {
		//creating the properties for the root pane
		root = new VBox();
		root.setPrefSize(PANEWIDTH, PANEHEIGHT);
		root.setAlignment(Pos.CENTER);
		root.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		
		root.getChildren().addAll(gameover, text);
		setRoot(root);
	}
	
	

}
