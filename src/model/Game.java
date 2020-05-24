package model;

import java.util.ArrayList;
import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;

public class Game extends Task<Void> {
	
	private String text = "00:00:000";
	private int mins = 0;
	private int secs = 0;
	private int millis = 0;
	
	private boolean exit;
	private boolean pause;
	
	private int width = 6;
	private int height = 2;
	
	private Snake snake;
	private ArrayList<Spot> spots;
	
	private Random random;
	
	// this flags a signal to update the view
	private IntegerProperty changedFlag = new SimpleIntegerProperty();
	
	public int getChangedFlag() {
		return changedFlag.get();
	}
	
	public void setchangedFlag(int newVal) {
		changedFlag.set(newVal);
	}
	
	public IntegerProperty changedFlagProperty() {
		return changedFlag;
	}
	
	public Game() {
		pause = true;
		exit = false;
		spots = new ArrayList<Spot>();
		snake = new Snake(width, height);
		random = new Random();
		
		for (int i = 0; i < 6; i++) {
			Marker mark = null;
			int r = random.nextInt(3);
			switch(r) {
			
			case 0 :
				mark = Marker.MOUSE;
				break;
			case 1 :
				mark = Marker.BEAR;
				break;
			case 2 :
				mark = Marker.FIRE;
				break;
			}
			spots.add(new Spot(random.nextInt(19), random.nextInt(15), mark));
		}
		
	}
	
	public String getText() {
		return text;
	}
	
	public String setText() {
		
			if(millis == 1000) {
				secs++;
				millis = 0;
			}
			if(secs == 60) {
				mins++;
				secs = 0;
			}
			text = ((((mins/10) == 0) ? "0" : "") + mins + ":"
			 + (((secs/10) == 0) ? "0" : "") + secs + ":"
				+ (((millis/10) == 0) ? "00" : (((millis/100) == 0) ? "0" : "")) + millis++);
		return text;
	}
	
	public ArrayList<Spot> getSpots() {
		return spots;
	}

	@Override
	protected Void call() throws InterruptedException {
		myRun();
		return null;
	}
	
	public void myRun() {
		while(!exit) {
			if (!pause) {
				
				System.out.println("test");
			//flag triggering the listener?
			
			changedFlag.set((changedFlag.get() + 1) % 2);
			snake.Move();
			try {
				Thread.sleep(20);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			}
			else {
				try {
					Thread.sleep(1);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void setDir(Direction dir) {
		snake.setDir(dir);
	}
	
	public void Move() {
		snake.Move();
	}
	
	public int getSnakeX() {
		return width;
	}
	
	public int getSnakeY() {
		return height;
	}
	
	public Direction getSnakeDir() {
		return snake.getDir();
	}
	
	public Snake getSnake() {
		return snake;
	}


	public void moveSnake(int intDir) {
		snake.setIntDir(intDir);
	}

	public void setGo(boolean go) {
		pause = go;
	}
	
	public void exit() {
		exit = true;
	}
	
	
	
	
	
	

	
	  
	
	
	
}
