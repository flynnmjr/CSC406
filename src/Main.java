import processing.core.PApplet;
import processing.video.*;

public class Main extends PApplet {
	
	/**
	 * state is used to keep track of the state the game is currently in 
	 * For example if you hit an edge of the maze and lose, you will go to the gameOver stage
	 * 
	 * mazeRunner is the actual game. It hold all the mazes that are used for the game
	 * 
	 * myMovie will hold the movie that will be later played when the player makes it 
	 * all three levels 
	 */
	
	protected int state = 0;
	private Maze mazeRunner;
	//private Movie myMovie;
	
	/**
	 * settings sets the size of the screen and set up how smooth the game is.
	 */
	
	public void settings(){
		
		size(1280,720);
		smooth(20);
	}
	/**
	 * setup will setup the background color, the frame rate the image Mode, takes away 
	 * all the edges and initialize mazeRunner
	 */
	public void setup(){
		
		background(3,173,255);
		frameRate(60);
		imageMode(CENTER);
		noStroke();
		
		//initialize the mazerunner
		mazeRunner = new Maze(this);
		
		
	}
	
	/**
	 * reads the cursor. Then switches the state of the game depending on the 
	 * current state of the game. 
	 */

	public void draw(){
		
		//debug, tb remvoed
		if(frameCount%60==0)
			print(mouseX, " ", mouseY, "\n");
		//print("\n", state);

		
		cursor();

		//menu switcher
		switch(state){
		
		case 0:
			mainMenu();
			break;
			
		case 1:
			//maze display
			mazeRunner.display();
			//if mouse is outside maze, game over
			if(!mazeRunner.mouseCheck())
				state=2;
			break;
			
		case 2:
			gameOver();
			break;
		case 3:
			playVideo();
			break;
		}
	}
	/**
	 * This is the main menu. Sets up the main menu with all of the words on it and places
	 * the words accordingly. Allows them to choose if they would like to play or if they would 
	 * like help.
	 */
	private void mainMenu(){
		textAlign(CENTER);
		textSize(90);
		fill(0,0,0);
		text("...The Maze...", 640, 90);
		
		textSize(40);
		text("Test your skills!", 640, 200);
		
		textSize(30);
		text("Reach the goal without touching the walls" + "\n" 
				+ "How steady is your hand?" + "\n"
				+ "Lets find out! Try and beat all three levels!", 640, 350);
		
		textSize(20);
		text("(Loud volume helps)", 640, 600);
		
		//if mouse over play, change color
		if(mouseX >= 1000 && mouseX <=1200 && mouseY>=550 && mouseY<=600)
			fill(90,3,255);
		textSize(70);
		text("PLAY", 1100,600);
		
		//set fill back to black
		fill(0,0,0);
		
		if(mouseX >= 100 && mouseX <=300 && mouseY>=550 && mouseY<=600)
			fill(90,3,255);
		textSize(70);
		text("HELP", 200,600);

		

	}
	/**
	 * gameOver sets the game over screen. It gives the user an option if they would like to play 
	 * again or not. It also, gives them the option to quit.
	 */
	
	public void gameOver(){
		//placeholder, add play and quit buttons
		background(3,173,255);
		textAlign(CENTER);
		textSize(90);
		fill(0,0,0);
		text("Game Over!", 640, 90);
		
		//if mouse over play, change color
		if(mouseX >= 1000 && mouseX <=1200 && mouseY>=550 && mouseY<=600)
			fill(90,3,255);
		textSize(70);
		text("PLAY", 1100,600);
		
		//set fill back to black
		fill(0,0,0);
		
		if(mouseX >= 100 && mouseX <=300 && mouseY>=550 && mouseY<=600)
			fill(90,3,255);
		textSize(70);
		text("QUIT", 200,600);


		
	}
	
	/**
	 * sets the movie as myMove and sets the image of the movie and plays it
	 */
	
	public void playVideo(){
		// Gets the movie and play movie 
		myMovie = new Movie(this, "My Movie.mp4");
		image(myMovie, 0, 0);
		myMovie.play();
		
		
		
		
	}

	
	/**
	 * If not in game states and click play and set state to 1 and set level to 0
	 * quits game on quit button pressed when at state 2
	 * calls video to be played when at level 3
	 */
	public void mouseClicked(){
		
		//If not in game states and click play
		if(state !=1 && mouseX >= 1000 && mouseX <=1200 && mouseY>=550 && mouseY<=600){
			state = 1;
			Maze.level = 0;
		}
		
		//quits game on quit button pressed
		if(state==2 && (mouseX >= 120 && mouseX <= 285) && (mouseY >= 550 && mouseY <= 600)){
			exit();
		}
		// calls video to be played 
		if(Maze.level == 3){
			state = 3;
			
		}
		
	/**
	 * reads moview
	 */
	void movieEvent(Movie m) {
  		m.read();
	}


	}
	
	
	/**
	*runs the papplet
	**/
	public static void main(String[] args) {
		PApplet.main("Main");
	}

}
