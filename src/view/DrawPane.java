package view;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.BodyPart;
import model.Game;
import model.Snake;
import model.Spot;


public class DrawPane extends Pane {
	
	private final int PANEWIDTH = 760;
	private final int PANEHEIGHT = 600;
	
	private final int height = 40;
	private final int width = 40;
	
	private Image bear;
	private Image mouse;
	private Image fire;
	
	private Game game;
	private GraphicsContext gc;
	private Canvas c;
	
	private ArrayList<Spot> spots;
	
	
	
	
	public DrawPane(Game game) {
		setPrefSize(PANEWIDTH, PANEHEIGHT);
		c = new Canvas(PANEWIDTH, PANEHEIGHT);
		
		setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		this.game = game;
		
		
		game.changedFlagProperty().addListener(e -> draw());
		

		getChildren().addAll(c);
	}
	
	private void createSnake() {
		Snake snake = game.getSnake();
		
		gc.setFill(Color.RED);
		gc.fillOval(game.getSnakeX() * width, game.getSnakeY() * height, width, height);
		
		for (BodyPart bodypart : snake.getBodyParts()) {
			gc.setFill(Color.YELLOW);
			gc.fillOval((bodypart.getX() * width) , bodypart.getY() * height, width, height);
		}
		
		
	}
	
	private void createSpots() {
		
		for (Spot spot : game.getSpots()) {
			switch(spot.getMarker()) {
			case BEAR:
				bear = new Image("bear.png");
				gc.drawImage(bear, spot.getX() * width, spot.getY() * height, width, height);
				break;
			
			case MOUSE:
				mouse = new Image("mouse.png");
				gc.drawImage(mouse, spot.getX() * width, spot.getY() * height, width, height);
				break;
			
			case FIRE:
				fire = new Image("fire.png");
				gc.drawImage(fire, spot.getX() * width, spot.getY() * height, width, height);
				
				break;
			default :
				break;
			}
		}
		

	}
	
	private void draw() {
		gc = c.getGraphicsContext2D();
		gc.clearRect(0, 0, c.getWidth(), c.getHeight());
		for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 19; x++) {
                if (y % 2 == 0) {
                    if (x % 2 == 0) {
                        gc.setFill(Color.GREY);
                        gc.fillRect(width * x, height * y, width, height);
                    } else {
                        gc.setFill(Color.WHITE);
                        gc.fillRect(width * x, height * y, width, height);
                    }
                } else {
                    if (x % 2 == 0) {
                        gc.setFill(Color.WHITE);
                        gc.fillRect(width * x, height * y, width, height);
                    } else {
                        gc.setFill(Color.GREY);
                        gc.fillRect(width * x, height * y, width, height);
                    }
                }
            }
        }
		createSnake();
		createSpots();
	}
	
	
	
	
	
}
