package model;

import java.util.ArrayList;

public class Snake {
	
	private ArrayList<BodyPart> bodyparts;
	
	private Direction dir;
	private int x;
	private int y;
	
	public Snake(int x, int y) {
		this.x = x;
		this.y = y;
		bodyparts = new ArrayList<BodyPart>();
		addTail();
	}
	
	public void Move() {
		int curX = 0;
		int curY = 0;
		int nextX = 0;
		int nextY = 0;
		
		for(int i = 0; i < bodyparts.size(); i++) {
			if (i == 0) {
				nextX = bodyparts.get(i).getX();
				nextY = bodyparts.get(i).getY();
				bodyparts.get(i).setX(x);
				bodyparts.get(i).setY(y);
			}
			else {
				curX = bodyparts.get(i).getX();
				curY = bodyparts.get(i).getY();
				bodyparts.get(i).setX(nextX);
				bodyparts.get(i).setY(nextY);
				nextX = curX;
				nextY = curY;
			}
			
		}
		
		switch(this.dir) {
		case UP:
			dir = Direction.UP;
			y = getY() + 1 * 40;
		
		case DOWN:
			y = getY() + 1 * 40;
		
		case RIGHT:
			x = getX() + 1 * 40;
		
		case LEFT:
			x = getX() - 1 * 40;
		}	
		
		
	}
	
	private void addTail() {
		for (int i = 0; i < 4; i++) {
			bodyparts.add(new BodyPart(x - 1 * (i + 1), y));
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Direction getDir() {
		return dir;
	}
	
	public ArrayList<BodyPart> getBodyParts() {
		return bodyparts;
	}
	
	public void setDir(Direction direction) {
		this.dir = direction;
	}
	
	public void setIntDir(int intDir) {
		if (intDir == 0) {
			dir = Direction.UP;
		}
		else if(intDir == 1) {
			dir = Direction.DOWN;
		}
		else if(intDir == 2) {
			dir = Direction.RIGHT;
		}
		else if(intDir == 3) {
			dir = Direction.LEFT;
		}
	}
	
	
	
	
	
	
	
	
}
