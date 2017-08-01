import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWVidMode;
public class Tutorial01 {
	
	public static void main(String args[]){
		
		if(!glfwInit())
			throw new  IllegalStateException("Failed to initialize GLFW");
		
		long window = glfwCreateWindow(640, 480, "MY WINDOW", 0, 0);		// glfwGetPrimaryMonitor() Vollbild bei Monitor
		
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		
		if(window == 0)
			throw new IllegalStateException("Failed to create window"); 

		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		
		glfwSetWindowPos(window, (videoMode.width() - 640)/2, (videoMode.height() - 480)/2);
		glfwShowWindow(window);
		
		while(!glfwWindowShouldClose(window))
			glfwPollEvents();
		
		glfwTerminate();
		
	}

}
