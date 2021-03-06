package com.framework;

import java.awt.image.BufferedImage;

import com.window.ImageLoader;

public class Texture {
	
	BufferedImage image;
	
	SpriteSheet bs, ps, buttonSheet; //Sprite for Block Sheet (bs) and Player Sheet (ps)
	
	//Buttons
	public BufferedImage titleScreen = null;
	public BufferedImage buttonLeft = null, buttonRight = null, buttonLeftActive = null, buttonRightActive = null;
	public BufferedImage buttonPlay = null, buttonPlayActive = null;
	
	
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	private BufferedImage button_sheet = null;
	
	//array to store the images in
	public BufferedImage[] block = new BufferedImage[23]; //array has to have the size of the amount of blocks
	public BufferedImage[] player = new BufferedImage[8];
	public BufferedImage[] button = new BufferedImage[20];
	
	public Texture() {
		
		loadTextures();
		
		getTextures();
	}
	
	public void loadTextures() {
		
		ImageLoader loader = new ImageLoader();
		
		//load the sheets from our files
		try {
			//Player and Block Sheet
			block_sheet = loader.loadImage("/texture/block_sheet.png");
			player_sheet = loader.loadImage("/texture/player_sheet.png");
			button_sheet = loader.loadImage("/buttons/button_sheet.png");
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		buttonSheet = new SpriteSheet(button_sheet);
	}
	
	//assign the images from the sheets to the arrays
	public void getTextures() {
		block[0] = bs.grabImage(1, 1, 64, 64);	//Green Block
		block[1] = bs.grabImage(2, 1, 64, 64);	//Andesite
		block[2] = bs.grabImage(3, 1, 64, 64);	//Stone
		block[3] = bs.grabImage(4, 1, 64, 64);	//Obsidian
		block[4] = bs.grabImage(5, 1, 64, 64);	//Bedrock
		block[5] = bs.grabImage(6, 1, 64, 64);	//Stone
		block[6] = bs.grabImage(7, 1, 64, 64);	//Stone
		block[7] = bs.grabImage(8, 1, 64, 64);	//Stone
		block[8] = bs.grabImage(1, 2, 64, 64);	//Grass
		block[9] = bs.grabImage(2, 2, 64, 64);	//Dirt
		block[10] = bs.grabImage(3, 2, 64, 64);	//Grass
		block[11] = bs.grabImage(4, 2, 64, 64);	//Wood
		block[12] = bs.grabImage(5, 2, 64, 64);	//Wood
		block[13] = bs.grabImage(6, 2, 64, 64);	//Log
		block[14] = bs.grabImage(7, 2, 64, 64);	//Leaves
		block[15] = bs.grabImage(8, 2, 64, 64);	//Endstone
		block[16] = bs.grabImage(1, 3, 64, 64);	//Cobblestone
		block[17] = bs.grabImage(2, 3, 64, 64);	//Stone
		block[18] = bs.grabImage(3, 3, 64, 64);	//Diamonds
		block[19] = bs.grabImage(4, 3, 64, 64);	//Emeralds
		block[20] = bs.grabImage(5, 3, 64, 64);	//Iron
		block[21] = bs.grabImage(6, 3, 64, 64);	//Leaves
		block[22] = bs.grabImage(7, 3, 64, 64);	//Transparent Block
		
		
		player[0] = ps.grabImage(1, 1, 64, 64);
		player[1] = ps.grabImage(2, 1, 64, 64);
		player[2] = ps.grabImage(3, 1, 64, 64);
		player[3] = ps.grabImage(4, 1, 64, 64);
		player[4] = ps.grabImage(5, 1, 64, 64);
		player[5] = ps.grabImage(6, 1, 64, 64);
		player[6] = ps.grabImage(7, 1, 64, 64);
		player[7] = ps.grabImage(8, 1, 64, 64);	//Creeper
		
		button[0] = buttonSheet.grabImage(1, 1, 132, 132);
		button[1] = buttonSheet.grabImage(2, 1, 132, 132);
		button[2] = buttonSheet.grabImage(3, 1, 132, 132);
		button[3] = buttonSheet.grabImage(4, 1, 132, 132);
		button[4] = buttonSheet.grabImage(5, 1, 132, 132);
		button[5] = buttonSheet.grabImage(1, 2, 132, 132);
		button[6] = buttonSheet.grabImage(2, 2, 132, 132);
		button[7] = buttonSheet.grabImage(3, 2, 132, 132);
		button[8] = buttonSheet.grabImage(4, 2, 132, 132);
		button[9] = buttonSheet.grabImage(5, 2, 132, 132);
		button[10] = buttonSheet.grabImage(1, 3, 132, 132);
		button[11] = buttonSheet.grabImage(2, 3, 132, 132);
		button[12] = buttonSheet.grabImage(3, 3, 132, 132);
		button[13] = buttonSheet.grabImage(4, 3, 132, 132);
		button[14] = buttonSheet.grabImage(5, 3, 132, 132);
		button[15] = buttonSheet.grabImage(1, 4, 132, 132);
		button[16] = buttonSheet.grabImage(2, 4, 132, 132);
		button[17] = buttonSheet.grabImage(3, 4, 132, 132);
		button[18] = buttonSheet.grabImage(4, 4, 132, 132);
		button[19] = buttonSheet.grabImage(5, 4, 132, 132);
	}	
}
