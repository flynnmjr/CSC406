import processing.core.PApplet;

//maze class
public class Maze extends Main {
	
	private PApplet p;
	int level = 0;
	
	public Maze(PApplet parent){
	
		//set papplet
		p = parent;
	}

	public void display(){
		p.noCursor();
		p.background(0,0,0);
		
		//level switcher
		switch(level){
		
		case 0:
			stage1();
			break;	
		case 1:
			stage2();
		}


		p.fill(0,0,0);
		p.ellipse(p.mouseX, p.mouseY, 12, 12);
		
		winCheck();
	
	}
	
	private void stage1(){
		
		//maze section
		p.fill(3,173,255);
		p.rect(1000,0,200,720);
		//end section
		p.fill(255,0,0);
		p.rect(1000,0,200,100);



	}
	
	private void stage2(){
		
		//maze section
		p.fill(3,173,255);
		p.rect(200,0,1000,100);



	}

	
	//mouse check for level 1
	public boolean mouseCheck1(){
		
		boolean rec_edges = true;
		
		//maze edge detection
		if(p.mouseX>=1200 || p.mouseX<=1000){
			rec_edges = false;
		}
		
		return rec_edges;


	}
	
	private void winCheck(){
		
		//level 1 win checker
		if(p.mouseY<=100 && level==0)
			level += 1;
			
	}
	
	
}
