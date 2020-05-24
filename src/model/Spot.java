package model;

public class Spot {
	
	private int x;
	private int y;
	private Marker marker;
	
	public Spot (int x, int y, Marker mark) {
		this.x = x;
		this.y = y;
		this.marker = mark;
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Marker getMarker() {
		return marker;
	}
	
	
}
