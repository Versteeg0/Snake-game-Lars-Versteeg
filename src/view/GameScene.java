package view;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Game;
import model.Snake;

public class GameScene extends Scene {

	private DrawPane dp;
	private BorderPane root;
	private DashBoard dashboard;
	
	public GameScene(Controller controller, Game game) {
		super(new Pane());
		
		//making the panes for the scene
		dp = new DrawPane(game);
		root = new BorderPane();
		dashboard = new DashBoard(controller);
		
		//setting the positions of the panes
		root.setCenter(dp);
		root.setBottom(dashboard);
		
		//setting the root of the scene
		setRoot(root);
		
		
	}

}
