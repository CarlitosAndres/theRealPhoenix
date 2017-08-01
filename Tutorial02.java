import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

import com.jogamp.opengl.test.junit.util.GLClearColor;



public class Tutorial02 {


	public Tutorial02(){

		if(!glfwInit())
			throw new  IllegalStateException("Failed to initialize GLFW");

		long window = glfwCreateWindow(640, 480, "MY WINDOW", 0, 0);		// glfwGetPrimaryMonitor() Vollbild bei Monitor


		if(window == 0)
			throw new IllegalStateException("Failed to create window"); 

		glfwShowWindow(window);


		glfwMakeContextCurrent(window);  									//i need a context!


		GL.createCapabilities();

		while(!glfwWindowShouldClose(window)){
			glfwPollEvents();

			glClear(GL_COLOR_BUFFER_BIT);

			glBegin(GL_QUADS);
			glColor4f(1,0,0,0);
			glVertex2f(-0.5f, 0.5f);
			
			glColor4f(0,1,0,0);
			glVertex2f(0.5f, 0.5f);
			
			glColor4f(0,0,1,0);
			glVertex2f(0.5f, -0.5f);
			
			
			glColor4f(1,1,1,0);
			glVertex2f(-0.5f, -0.5f);
			
			
			
			glEnd();


			glfwSwapBuffers(window);										//"creating two contexts" hinteres und vorderes Fenster werden
		}																	// vertauscht

		glfwTerminate();
	}

	public static void main(String args[]){

		new Tutorial02();

	}

}
