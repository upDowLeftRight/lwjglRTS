package renderEngine;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;

public class Display {
	public Display() {
		
		final int WIDTH = 640;
		final int HEIGHT = 480;
		
		if(!glfwInit()) {
			System.err.println("Failed to initialize GLFW!");
			System.exit(1);
		}
		
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		long win = glfwCreateWindow(WIDTH, HEIGHT, "RTS", 0, 0);
		if(win == 0) {
			throw new IllegalStateException("Failed to create a window!");
		}
	
		glfwShowWindow(win);
		
		glfwMakeContextCurrent(win);
		
		GL.createCapabilities();
		
		while(!glfwWindowShouldClose(win)) {
			glfwPollEvents();
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			glBegin(GL_QUADS);
				//glColor4f
				glVertex2f(-0.5f, 0.5f);
				glVertex2f(0.5f, 0.5f);
				glVertex2f(0.5f, -0.5f);
				glVertex2f(-0.5f, -0.5f);
			glEnd();
			
			glfwSwapBuffers(win);
		}
		
		glfwTerminate();
	}
	
	public static void main(String[] args) {
		new Display();
	}
}
