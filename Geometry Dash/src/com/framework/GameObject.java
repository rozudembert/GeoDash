/*
 * abstract class used to manage player, block, coin and other GameObjects
 * 
 * @author Robert Kelm
 * @version 08.02.2021
 */

package com.framework;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {
	
	//x and y coordinates
	protected float x, y;
	protected boolean visible;
	protected ObjectId id; 
	protected float gravity;
	
	//vertical and horizontal velocity of the object 
	protected float velX = 0f, velY = 0f;
	
	//boolean to check if player is jumping/falling
	protected boolean falling = true;
	protected boolean jumping = false;
	
	public GameObject(float x, float y, ObjectId id) {
		this.x = x;
		this.y = y;		
		this.id = id;
	}
	
	public abstract void update(LinkedList<GameObject> object);	
	public abstract void render(Graphics graphics);
	public abstract Rectangle getBorder();
	public abstract Polygon getBorderPoly();
	public abstract Rectangle getExtendedBorder();
	
	////////////////////////////
	
	//Getters and Setters:
	
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
	
	public void setVelX(float velX) {
		this.velX = velX;
	}
	
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	public float getVelX() {
		return velX;
	}
	
	public float getVelY() {
		return velY;
	}
	
	public void setID(ObjectId id) {
		this.id = id;
	}	
		
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	public ObjectId getId() {
		return id;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public boolean getVisible() {
		return visible;
	}
	
	public float getGravity() {
		return gravity;
	}
}
