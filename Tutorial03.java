import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;


public class Tutorial03 {


	float color_red = 0;
	float color_blue = 1;
	float x = 0;
	float y = 0;
	long window;
	float speed = 0.0004f;
	private long lastTime;
	private long fps;


	public Tutorial03(){

		if(!glfwInit())
			throw new  IllegalStateException("Failed to initialize GLFW");

		window = glfwCreateWindow(1000, 1000, "MY WINDOW", 0, 0);		// glfwGetPrimaryMonitor() Vollbild bei Monitor

		if(window == 0)
			throw new IllegalStateException("Failed to create window"); 

		glfwShowWindow(window);

		glfwMakeContextCurrent(window);  									//i need a context!

		GL.createCapabilities();
		
		glEnable(GL_TEXTURE_2D);
		
		Texture tex = new Texture("./res/anivia.png");


		while(!glfwWindowShouldClose(window)){

			
			if(System.currentTimeMillis() - lastTime >= 1000){
				System.out.println(fps);
				fps = 0;
				lastTime = System.currentTimeMillis();
				
			}
			fps++;
			
			

			if(glfwGetKey(window, GLFW_KEY_SPACE) == GL_TRUE)
				speed = 0.0008f;
			else{
				speed = 0.0004f;}

			move();

			glfwPollEvents();


			glClear(GL_COLOR_BUFFER_BIT);
			
			tex.bind();
			
			glBegin(GL_QUADS);
			
			glTexCoord2f(0,1);
			glVertex2f(0+x, 0f+y);
			
			glTexCoord2f(0,0);
			glVertex2f(0+x, 0.1f+y);
			
			glTexCoord2f(1,0);
			glVertex2f(0.1f+x, 0.1f+y);
			
			glTexCoord2f(1,1);
			glVertex2f(0.1f+x, 0+y);
			glEnd();


			glfwSwapBuffers(window);										//"creating two contexts" hinteres und vorderes Fenster werden
		}																	// vertauscht

		glfwTerminate();
	}


	void move(){
		if(glfwGetKey(window, GLFW_KEY_RIGHT) == GL_TRUE){
			x += speed;
			color_red = 1;
			color_blue = 0;
		}
		else if(glfwGetKey(window, GLFW_KEY_LEFT) == GL_TRUE){
			x -= speed;
			color_red = 1;
			color_blue = 0;
		}
		else if(glfwGetKey(window, GLFW_KEY_UP) == GL_TRUE){
			y += speed;
			color_red = 1;
			color_blue = 0;
		}
		else if(glfwGetKey(window, GLFW_KEY_DOWN) == GL_TRUE){
			y -= speed;
			color_red = 1;
			color_blue = 0;
		}
		else{
			color_red = 0;
			color_blue = 1;
		}

		if(x>=0.9f)
			x = -0.9f;
		if(x<=-1f)
			x = 0.89f;
		if(y>=0.9f)
			y = -0.99f;
		if(y<=-1f)
			y = 0.89f;
	}





	public static void main(String args[]){

		new Tutorial03();

	}

}
