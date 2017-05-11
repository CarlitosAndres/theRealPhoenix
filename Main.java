import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.glfw.GLFWVidMode;


public class Main {
	
	static int xSize = 1000;
	static int ySize = 1000;

	public static void main(String[] args) {

		if(!glfwInit())
			throw new IllegalStateException("Failed to initiate GLFW!");



		long window = glfwCreateWindow(xSize, ySize, "My First LWJGL-Screen", 0, 0);
		if(window == 0 )
			throw new IllegalStateException("Failed to create Window");



		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (videoMode.width() - xSize)/2, (videoMode.height() - ySize) /2);


		glfwShowWindow(window);
		glfwMakeContextCurrent(window);

		

		GL.createCapabilities();
		while(!glfwWindowShouldClose(window)){
			glfwPollEvents();
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			glBegin(GL_QUADS);
			
			glColor4f(1, 0, 0, 0);
			glVertex2f(-0.5f, 0f);
			
			glColor4f(1, 1, 0, 0);
			glVertex2f(0f, -0.5f);
			
			glColor4f(1, 0, 1, 0);
			glVertex2f(0.5f, 0f);
			
			glColor4f(1, 0, 1, 0);
			glVertex2f(0f, 1f);
			
			glEnd();
			
			glBegin(GL_TRIANGLES);
			
			glColor4f(1, 0, 0, 0);
			glVertex2f(-0.5f, -1f);
			
			glColor4f(1, 1, 0, 0);
			glVertex2f(0.5f, -1f);
			
			glColor4f(1, 0, 1, 0);
			glVertex2f(0f, 0f);
			
			glEnd();
			
			
			glfwSwapBuffers(window);	
		}

		glfwTerminate();
	}

}
