/*
 * For navigation between playing to select level, design etc.
 * 
 * @author Robert Kelm
 * @version 08.03.2021
 */

package com.window;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.framework.Texture;
import com.framework.ImageLoader;
import com.window.Game.STATUS;

public class Menu{
	
	private BufferedImage titleScreen = null;
	private BufferedImage buttonPlay = null, buttonPlayActive = null;
	private BufferedImage menu_background = null;
	
	//boolean for the selected buttons
	private static boolean playButton = true;
	private static boolean main_leftButton = false;
	private static boolean main_rightButton = false;
	
	private static boolean death_retry = false;
	private static boolean death_backToMenu = false;
	
	private static boolean final_retry = false;
	private static boolean final_nextLevel = false;
	private static boolean final_backToMenu = false;
	
	Texture texture;
	
	private int level = 1;

	public Menu(Game game, Controller controller, Texture texture) {
		this.texture = texture;
		graphics();
	}
	
	//to load graphics from the files
	public void graphics() {
		ImageLoader loader = new ImageLoader();
		
		try {
			titleScreen = loader.loadImage("/TitleScreen.png");
			buttonPlay = loader.loadImage("/buttons/Play.png");
			buttonPlayActive = loader.loadImage("/buttons/PlayActive.png");
			menu_background = loader.loadImage("/background/menu_background.png");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		//Wow so empty :O	
	}
	
	public void render(Graphics g) {
	
		int width = Game.WIDTH;
        int height = Game.HEIGHT;
		int q = 200;
		int j = 64;
        
        
        Font fnt2 = new Font("calibri", 1, 28);
        g.setFont(fnt2);

        Color buttonYellow = new Color(255,168,0);
        
        
        
        //Title Screen
        if(Game.gameStatus == STATUS.StartMenu) {
        	g.drawImage(titleScreen, 0, 0, null);
            	
        	g.setFont(fnt2);
        	g.setColor(buttonYellow);
        	g.drawString("Press SPACE to continue", width / 2 + 200, height / 2 + 150);
        }        
       
        //Main Menu
        else if(Game.gameStatus==STATUS.Menu) {
        	
        	//background
        	g.drawImage(menu_background, 0, 0, null);
        	
        	//Left Button -> if selected make it in colour
        	if(main_leftButton && level > 1) 
        		g.drawImage(texture.button[level + 4], 340, 405, null);
        	else 
        		g.drawImage(texture.button[level - 1], 340, 405, null);
        	
        	//Right Button -> if selected make it in colour
        	if(main_rightButton && level < 5) 
        		g.drawImage(texture.button[level + 16], 830, 405, null);
        	else if (level == 5) 
        		g.drawImage(texture.button[0], 340, 405, null);
        	else 
        		g.drawImage(texture.button[level + 11], 830, 405, null);
        	
        	//Play Button
        	if(playButton) {
        		g.drawImage(buttonPlayActive, 503, 532, null);
        		g.setColor(buttonYellow);
        	}
        	else {
        		g.setColor(Color.white);
        		g.drawImage(buttonPlay, 503, 532, null);
        	}
        	g.drawString("< Level: " + (level) + " >", 575, 580);  	
        }        
        
        //Game Over Menu
        else if(Game.gameStatus == STATUS.Dead) {
        	//g.drawImage(menu_background, 0, 0, null);        	
        	//g.drawString("Game Over! :( ", Game.WIDTH/2 - 200, Game.HEIGHT/2);
        	
        	//Play Again Button
        	if(death_retry) {
        		g.setColor(buttonYellow);
        		g.drawRect(width /2 - q/2, height/2 - 50, q, q);
        	}
        	else {
        		g.setColor(Color.white);
        		g.drawRect(width /2 - q/2, height/2 - 50, q, q);
        	}
        	g.drawString("Play Again", width/2 - 26,  height/2 + 60);
        	
        	if(death_backToMenu) {
        		g.setColor(buttonYellow);
        		g.drawRect(width / 2 - 500, height / 2, q, j);
        	}
        	else {
        		g.setColor(Color.WHITE);
        		g.drawRect(width / 2 - 500, height / 2, q, j);
        	}
	        g.drawString("Back To Menu", width / 2 - 430, height / 2 + (j / 2) + 10);
        }
        
        //End Menu
        else if(Game.gameStatus == STATUS.End) {
        	g.drawImage(menu_background, 0, 0, null);        	
        	g.drawString("You did it!", Game.WIDTH/2 - 200, Game.HEIGHT/2 - 200);
        	        	
        	if(final_retry) g.setColor(buttonYellow);
        	else g.setColor(Color.WHITE);
        	g.drawRect(width /2 - q/2, height/2 - 50, q, q);
        	g.drawString("Play Again", width/2 - 26,  height/2 + 60);
        	
        	//Back To Menu Button
        	if(final_backToMenu) g.setColor(buttonYellow);
        	else g.setColor(Color.WHITE);
        	g.drawRect(width / 2 - 500, height / 2, q, j);
	        g.drawString("Back To Menu", width / 2 - 430, height / 2 + (j / 2) + 10);
	        
	        //next Level Button
	        if(final_nextLevel) g.setColor(buttonYellow);
        	else g.setColor(Color.WHITE);
        	g.drawRect(width / 2 + 500 - q, height / 2, q, j);
	        g.drawString("Next Level", width / 2 + 500 - q, height / 2 + (j / 2) + 10);
        }
        
        
	}
	
	
	//////////////////////////////////////////////////////////
	
	//Getter and Setter:
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	
	public void setMainPlayButton(boolean playButton) {
		Menu.playButton = playButton;
	}
	public boolean getMainPlayButton() {
		return playButton;
	}
	public void setMainLeftLevelButton(boolean leftLevelButton) {
		Menu.main_leftButton = leftLevelButton;
	}
	public boolean getMainLeftLevelButton() {
		return main_leftButton;
	}
	public void setMainRightLevelButton(boolean rightLevelButton) {
		Menu.main_rightButton = rightLevelButton;
	}
	public boolean getMainRightLevelButton() {
		return main_rightButton;
	}
	
	public void set_death_retry(boolean x) {
		Menu.death_retry = x;
	}
	public boolean get_death_retry() {
		return death_retry;
	}
	public void set_death_backToMenu(boolean x) {
		Menu.death_backToMenu = x;
	}
	public boolean get_death_backToMenu() {
		return death_backToMenu;
	}
	
	public void set_final_retry(boolean x) {
		Menu.final_retry = x;
	}
	public boolean get_final_retry() {
		return final_retry;
	}
	public void set_final_backToMenu(boolean x) {
		Menu.final_backToMenu = x;
	}
	public boolean get_final_backToMenu() {
		return final_backToMenu;
	}
	public void set_final_nextLevel(boolean x) {
		Menu.final_nextLevel = x;
	}
	public boolean get_final_nextLevel() {
		return final_nextLevel;
	}
	
}