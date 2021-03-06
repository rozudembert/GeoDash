/*
 * The camera is following the players movement 
 * on horizontal and vertical axis. 
 * 
 * @author Robert Kelm
 * @version 08.03.2021
 */
package com.window;

import com.framework.GameObject;

public class Camera {

	private float x, y;
	private boolean start = true;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	//maximum/minimum distance between player and top of the screen
	private static float TOP_OFFSET = 192;
	private static float GROUND_OFFSET = 440; 
	
	//camera follows the players movement
	public void update(GameObject player) {
		x = -player.getX() + Game.WIDTH/2 - 200;
		
		//change Y-Coordinate at the beginning
		if(start) {
			y = -player.getY() + 440;
			start = false;
		}
		
		//follow player movement on y-axis if player gets too high		
		if(player.getY() + y < TOP_OFFSET) {
			y = -player.getY() + TOP_OFFSET;
		}
		
		if(player.getY() + y > GROUND_OFFSET) {
			y = -player.getY() + GROUND_OFFSET;
		}
	}
	
	
	//Getter and Setter:
	public void setX(float x) {
		this.x = x;
	}	
	public void setY(float y) {
		this.y = y;
	}	
	public float getX() {
		return x;
	}	
	public float getY() {
		return y;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public boolean getStart() {
		return start;
	}
	
}
