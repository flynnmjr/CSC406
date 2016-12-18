import processing.core.PApplet;

//maze class
public class Maze extends Main {
	
	private PApplet p;
	int level = 0;
	float x,y;

	
	
	public Maze(PApplet parent){
	
		//set papplet
		p = parent;
	}

	public void display(){
		
		//debug, tb remvoed
		if(frameCount%10==0)
			print(p.mouseX, " ", p.mouseY, "\n");

		p.noCursor();
		p.background(0,0,0);
		
		//level switcher
		switch(level){
		
		case 0:
			stage1();
			break;	
		case 1:
			stage2();
			break;
		case 2:
			stage3();
			break;
		case 3:
			//movie?
			break;
		}


		
		x = p.lerp(x, p.mouseX, (float) 0.05);
		y = p.lerp(y, p.mouseY, (float) 0.05) ;
		p.fill(0,0,0);
		p.ellipse(x, y, 12, 12);
		
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
	    p.rect(200, 0, 60, 600);
	    //win section
	    p.fill(255,0,0);
	    p.rect(200, 550, 60, 50);




	}
	
	private void stage3(){
		
		//maze section
		p.fill(3,173,255);
		p.rect(200,550,60,50);
		p.rect(200,550,840,50);
		p.rect(1000,450,40,150);
		p.rect(200,450,840,30);
		p.rect(200,250,20,230);
		p.rect(200,250,400,10);

	}

	
	//edge check for all levels
	public boolean mouseCheck(){
		
		boolean rec_edges = true;
		
		switch(level){
		case 0:
			//maze edge detection
			if(p.mouseX>=1200 || p.mouseX<=1000){
				rec_edges = false;
			}			
			break;
		case 1:
			if(p.mouseY>=110 || ((p.mouseX<=200 || p.mouseX>=1200) || p.mouseY>=105)){
				rec_edges = false;
			}
			if(p.mouseX<=260 && p.mouseY<=600){
				rec_edges = true;
			}

		
		}
		
		return rec_edges;

	}
	
	private void winCheck(){
		
		//level 1 win checker
		if(p.mouseY<=100 && level==0)
			level += 1;
		if((p.mouseX<=260 && p.mouseX >=200) && (p.mouseY>=550) && level==1)
			level += 1;
			
	}
	
	
}
