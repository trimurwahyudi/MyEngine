/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.window;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.simplecorporation.myengine.settings.Settings;
import org.simplecorporation.myengine.utils.logger.Logger;
import org.simplecorporation.myengine.utils.messagebox.MessageBox;

public class OpenGLWindow {
	
	/* The method to create the window */
	public static void create() {
		try {
			//Set the attributes of the window
			Display.setTitle("MyEngine Window");
			Display.setDisplayMode(new DisplayMode(640 , 480));
			Display.setResizable(false);
			//Set VSync enabled if this is changed while running it
			//the engine will need to restart
			Display.setVSyncEnabled(Settings.Video.VSync);
			//Update the window to the right settings
			updateSettings();
			//Create the display
			Display.create();
		} catch (LWJGLException e) {
			//Log a message
			//Display an error message box
			MessageBox.showErrorMessage("LWJGL Exception" , "Error in OpenGLWindow create()");
			Logger.log("OpenGLWindow create()" , "LWJGL Exception");
			e.printStackTrace();
		}
	}
	
	/* The method to close the window */
	public static void close() {
		//Close the window
		Display.destroy();
	}
	
	/* The method to set the window to the right settings */
	public static void updateSettings() {
		try {
			//Check if the window settings are right
			if (Display.getTitle() != Settings.Window.Title || Display.getWidth() != Settings.Window.Size.Width ||
					Display.getHeight() != Settings.Window.Size.Height || Display.isFullscreen() != Settings.Window.Fullscreen) {
				//Setup the window
				Display.setTitle(Settings.Window.Title);
				//Check if the window should be full screen
				if (Settings.Window.Fullscreen) {
					//Make the window full screen
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					
					//Find and set the right display mode
					Display.setDisplayMode(getFullscreenDisplayMode(screenSize.width , screenSize.height));
					
					//Make the window full screen
					if (Display.isFullscreen() != Settings.Window.Fullscreen) {
						//Make the window full screen
						Display.setFullscreen(true);
					}
					//Set the window width and height in the Settings
					Settings.Window.Size.Width = Display.getWidth();
					Settings.Window.Size.Height = Display.getHeight();
				} else {
					//Set the screen size
					Display.setDisplayMode(new DisplayMode((int)Settings.Window.Size.Width , (int)Settings.Window.Size.Height));
					//Set VSync to false
					Display.setVSyncEnabled(false);
					//Make sure the window isn't full screen
					if (Display.isFullscreen() != Settings.Window.Fullscreen) {
						Display.setFullscreen(false);
					}
				}
			}
		} catch (LWJGLException e) {
			//Log a message
			Logger.log("OpenGLWindow updateSettings()" , "LWJGL Exception");
			//Display an error message box
			MessageBox.showErrorMessage("LWJGL Exception" , "Error in OpenGLWindow updateSettings()");
			e.printStackTrace();
		}
	}
	
	/* The method to update the window graphics */
	public static void updateGraphics() {
		//Update the display and sync it
		Display.update();
		Display.sync(Settings.Video.MaxFPS);
	}
	
	public static DisplayMode getFullscreenDisplayMode(int width , int height) {
 
		try {
			DisplayMode targetDisplayMode = null;
			DisplayMode[] modes = Display.getAvailableDisplayModes();
			int freq = 0;

			for (int i = 0; i< modes.length; i++) {
				DisplayMode current = modes[i];

				if ((current.getWidth() == width) && (current.getHeight() == height)) {
					if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) {
						if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) {
							targetDisplayMode = current;
							freq = targetDisplayMode.getFrequency();
						}
					}
					
					if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) &&
					    (current.getFrequency() == Display.getDesktopDisplayMode().getFrequency())) {
						targetDisplayMode = current;
						break;
					}
				}
			}
			
			//Return the display mode that hopefully has been found
			return targetDisplayMode;
 
		} catch (LWJGLException e) {
			//Log a message
			Logger.log("OpenGLWindow getFullscreenDisplayMode()" , "LWJGL Exception");
			//Display an error message box
			MessageBox.showErrorMessage("LWJGL Exception" , "Error in OpenGLWindow getFullscreenDisplayMode()");
			e.printStackTrace();
		}
		
		//Return new display mode
		return new DisplayMode(width , height);
	}
	
	/* Is the window still visible */
	public static boolean isVisible() {
		return Display.isVisible();
	}
	
	/* Is a close requested */
	public static boolean isCloseRequested() {
		return Display.isCloseRequested();
	}
	
}