package view;

import controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class DashBoard extends HBox {
	
	private Controller controller;
	
	//creating constants for the Pane
	private final int PANEHEIGHT = 50;
	private final int BUTTONWIDTH = 80;
	
	//Creating the objects for the dashboards
	private Timeline timeline;
	private Text text;
	private boolean go = true;
	
	private ToggleButton pauseButton;
	private Button exitButton;
	private Slider speedSlider;
	
	public DashBoard(Controller Controller) {
		this.controller = Controller;
		
		setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
		setSpacing(20);
		setAlignment(Pos.CENTER);
		setPrefHeight(PANEHEIGHT);
		setMinHeight(PANEHEIGHT);
		setMaxHeight(PANEHEIGHT);
		
		//Initializing the objects
		createButtons();
		createSlider();
		createLabel();
		
		pauseButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				KeyCode code = event.getCode();
					switch (code) {
					case UP:
						System.out.println("UP");
						controller.moveSnake(0);
						break;
					case DOWN:
						System.out.println("DOWN");
						controller.moveSnake(1);
						break;
					case LEFT:
						System.out.println("LEFT");
						controller.moveSnake(2);
						break;
					case RIGHT:
						System.out.println("RIGHT");
						controller.moveSnake(3);
						break;
					default:
						break;
					}
				
			}	
		
		});
		
	
		
		getChildren().addAll(pauseButton, exitButton, speedSlider, text);
	}
	
	private void createButtons() {
		//creating the pause button with its properties
		pauseButton = new ToggleButton("Start");
		pauseButton.setPrefWidth(BUTTONWIDTH);
		pauseButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(pauseButton.isSelected()) {
					go = !go;
					timeline.play();
		            pauseButton.setText("Stop");
		            controller.setGo(go);
		            System.out.println("testAA");
				}
				else {
					 timeline.pause();
			         go = true;
			         pauseButton.setText("Start");
			         controller.setGo(go);
			         System.out.println("TestBB");
				}
			}
				
		}); 
		
		//creating the exit button with its properties
		exitButton = new Button("Exit");
		exitButton.setOnAction(e -> handleExit());
	}
	
	private void createSlider() {
		speedSlider = new Slider();
		speedSlider.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		speedSlider.setPrefSize(200, 100);
		speedSlider.setDisable(true);
		speedSlider.setMax(12);
		speedSlider.setMajorTickUnit(1);
		speedSlider.setShowTickMarks(true);
		speedSlider.setShowTickLabels(true);
		
	}
	
	private void createLabel() {
		text = new Text("00:00:000");
		timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
            	controller.setText();
				text.setText(controller.changeText());
			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(false);
		
	}
	
	private void handleExit() {
		controller.Exit();
	}
	
	
	
	
}
