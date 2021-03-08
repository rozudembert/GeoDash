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
	private static boolean leftLevelButton = false;
	private static boolean rightLevelButton = false;
	
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
	
        Font fnt2 = new Font("calibri", 1, 28);
        int width = Game.WIDTH;
        int height = Game.HEIGHT;
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
        	if(leftLevelButton && level > 1) 
        		g.drawImage(texture.button[level + 4], 340, 405, null);
        	else 
        		g.drawImage(texture.button[level - 1], 340, 405, null);
        	
        	//Right Button -> if selected make it in colour
        	if(rightLevelButton && level < 5) 
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
        
        //End Menu
        else if(Game.gameStatus == STATUS.End) {
        	g.drawImage(menu_background, 0, 0, null);        	
        	g.drawString("You did it!", Game.WIDTH/2 - 200, Game.HEIGHT/2);
        	//TODO: Better Graphics
        	//TODO: Buttons        
        	//TODO: Statistics
        }
        
        //Game Over Menu
        else if(Game.gameStatus == STATUS.Dead) {
        	g.drawImage(menu_background, 0, 0, null);        	
        	g.drawString("Game Over! :( ", Game.WIDTH/2 - 200, Game.HEIGHT/2);
        	//TODO: Buttons
        	//TODO: Statistics
        	//TODO: Better Graphics
        }
	}
	
	
	//////////////////////////////////////////////////////////
	
	//Getter and Setter:
	
	public void setPlayButton(boolean playButton) {
		Menu.playButton = playButton;
	}
	public boolean getPlayButton() {
		return playButton;
	}
	public void setLeftLevelButton(boolean leftLevelButton) {
		Menu.leftLevelButton = leftLevelButton;
	}
	public boolean getLeftLevelButton() {
		return leftLevelButton;
	}
	public void setRightLevelButton(boolean rightLevelButton) {
		Menu.rightLevelButton = rightLevelButton;
	}
	public boolean getRightLevelButton() {
		return rightLevelButton;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
}