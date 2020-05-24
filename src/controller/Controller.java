package controller;

import javafx.application.Platform;
import javafx.stage.Stage;
import model.Game;
import view.GameOverScene;
import view.GameScene;

public class Controller {
	
	private Stage stage;
	private Game game;
	private GameOverScene gameOverScene;
	
	public Controller(Stage mystage) {
		this.stage = mystage;
		game = new Game();
		
		new Thread(game).start();
		GameScene scene = new GameScene(this, game);
		gameOverScene = new GameOverScene(this);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("PROG4 ASS Snake - Lars Versteeg");
		stage.show();
	}
	
	public void Exit() {
		Platform.exit();
	}
	
	public void Pause() {
	
	}
	
	public void setText() {
		game.setText();
	}
	
	public String changeText() {
		return game.getText();
	}
	
	public void GameOver() {
		stage.setScene(gameOverScene);
	}
	
	public void moveSnake(int intDir) {
		game.moveSnake(intDir);
	}
	
	public void setGo(boolean go) {
		game.setGo(go);
	}
	
	
}
