import processing.core.PApplet;

public class Main extends PApplet {
	
	protected int state = 0;
	private Maze mazeRunner;
	
	public void settings(){
		
		size(1280,720);
		smooth(20);
	}
	
	public void setup(){
		
		background(3,173,255);
		frameRate(60);
		imageMode(CENTER);
		cursor();
		noStroke();
		
		//initialize the mazerunner
		mazeRunner = new Maze(this);
		
		//debug
		
	}

	public void draw(){
		
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
		}
	}
	
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
	
	public void gameOver(){
		//placeholder, add play and quit buttons
		background(3,173,255);
		textAlign(CENTER);
		textSize(90);
		fill(0,0,0);
		text("Game Over!", 640, 90);

		
	}

	
	
	public void mouseClicked(){
		
		//if in main menu and click play
		if(state ==0 && mouseX >= 1000 && mouseX <=1200 && mouseY>=550 && mouseY<=600){
			state = 1;
		}

	}
	
	
	//runs the papplet
	public static void main(String[] args) {
		PApplet.main("Main");
	}

}
