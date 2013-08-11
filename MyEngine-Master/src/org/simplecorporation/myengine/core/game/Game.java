/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.game;

import org.simplecorporation.myengine.core.input.Input;
import org.simplecorporation.myengine.core.input.event.KeyboardEvent;
import org.simplecorporation.myengine.core.input.event.MouseEvent;
import org.simplecorporation.myengine.core.input.event.MouseMotionEvent;
import org.simplecorporation.myengine.core.input.listener.InputListener;

public class Game extends AbstractGame implements InputListener {
	
	/* The constructor */
	public Game() {
		
	}
	
	/* The method to create the game */
	public void createGame() {
		//Add this input listener
		Input.addListener(this);
		//Create the engine loop
		create();
	}
	
	/* Game method */
	public void gameCreated() {
		
	}
	
	/* Game method */
	public void gameStarted() {
		
	}
	
	/* Game method */
	public void gameUpdate() {
		
	}
	
	/* Game method */
	public void gameRender() {
		
	}
	
	/* Game method */
	public void gameStopped() {
		
	}
	
	/* Game method */
	public void gameClosing() {
		
	}
	
	/* Input method */
	public void onMousePressed(MouseEvent e) {
		
	}
	
	/* Input method */
	public void onMouseReleased(MouseEvent e) {
		
	}
	
	/* Input method */
	public void onMouseClicked(MouseEvent e) {
		
	}
	
	/* Input method */
	public void onMouseMoved(MouseMotionEvent e) {
		
	}
	
	/* Input method */
	public void onKeyPressed(KeyboardEvent e) {
		
	}
	
	/* Input method */
	public void onKeyReleased(KeyboardEvent e) {
		
	}
	
	/* Input method */
	public void onKeyTyped(KeyboardEvent e) {
		
	}
	
}