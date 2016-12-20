import processing.core.PApplet;

class Maze /*extends Main*/ {
  /**
    * PApplet p is the name of the applet
    * level is the level of the game we are at
    * x and y will be the x and y corridnates of the mouse
    */
  
    private PApplet p;
    int level = 0;
    float x,y;

  
  /**
    * set papplet
    */
  public Maze(PApplet parent){
  
    p = parent;
  }

  /**
    * display removes the cursor from being shown 
    * It also switches between the levels and brings the 
    * game to the next stage it will enter
    * It also contain the little circle that you use to move around 
    * in the game. by getting the x and y values for the figure
    * It also checks if you won the level.
    */
  public void display(){
    
    //debug, tb remvoed
    //if(frameCount%60==0)
      //print(p.mouseX, " ", p.mouseY, "\n");
      //print("\n", level);

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
      //movie
      break;
    }


    
    x = p.lerp(x, p.mouseX, (float) 0.05);
    y = p.lerp(y, p.mouseY, (float) 0.05) ;
    p.fill(0,0,0);
    p.ellipse(x, y, 12, 12);
    
    winCheck();
  
  }
  
  /**
    * Sets up the maze for stage one 
    */
  
  private void stage1(){
    
    //maze section
    p.fill(3,173,255);
    p.rect(1000,0,200,720);
    //end section
    p.fill(255,0,0);
    p.rect(1000,0,200,100);



  }
  
  /**
    * Set the maze up for stage rwo
    */
  private void stage2(){
    
    //maze section
    p.fill(3,173,255);
    p.rect(200,0,1000,100);
    p.rect(200, 0, 60, 600);
    //win section
    p.fill(255,0,0);
    p.rect(200, 550, 60, 50);


  }
  /**
    *Sets up the maze for stage 3
    */
  private void stage3(){
    
    //maze section
    p.fill(3,173,255);
    p.rect(200,550,840,50);
    p.rect(1000,450,40,150);
    p.rect(200,450,840,30);
    p.rect(200,250,20,230);
    p.rect(200,250,400,10);
    //win section
    p.fill(255,0,0);
    p.rect(600,250,20,10);

  }

  
  /**
    * edge check for all levels
    * Sets rec_edge to true. This is used if the mouse stays in the boxes, then 
    * its true, if it gets outside of the maze then, it sets it as false and its 
    * game over
    */
    
  public boolean mouseCheck(){
    
    boolean rec_edges = true;
    
    switch(level){
    case 0:
      //maze edge detection
      if(p.mouseX>=1200 || p.mouseX<=1000)
        rec_edges = false;  
      break;
    case 1:
      if(p.mouseY>=110 || ((p.mouseX<=200 || p.mouseX>=1200) || p.mouseY>=105))
        rec_edges = false;
      if(p.mouseX<=260 && p.mouseY<=600)
        rec_edges = true;
      break;
    case 2:
      //first rect
      if((p.mouseX<= 200 || p.mouseX >= 1035 || p.mouseY <= 545 || p.mouseY >= 595))
        rec_edges = false;
      //second rect
      if((p.mouseY <= 600 || p.mouseY >= 450) && (p.mouseX >= 990 && p.mouseX <= 1040))
        rec_edges = true;
      //third rect
      if((p.mouseY <= 480 && p.mouseY >= 450) && (p.mouseX >= 200 && p.mouseX <= 1040))
        rec_edges = true;
      //fourth rect
      if((p.mouseY <= 450 && p.mouseY >= 250) && (p.mouseX >= 20 && p.mouseX <= 220))
        rec_edges = true;
      //fifth rect
      if((p.mouseY <= 265 && p.mouseY >= 250) && (p.mouseX >= 200 && p.mouseX <= 595))
        rec_edges = true;
      break;

    
    }
    
    return rec_edges;

  }
  
  /**
    * winCheck checks to see if we have made it to the end of the level( the red box)
    * and if we have, go to the next level or if you are at the last level you assign 
    * the state to 3 
    */
    
  private void winCheck(){
    
    //level 1 win checker
    if(p.mouseY<=100 && level==0)
      level += 1;
    //level 2 win checker
    if((p.mouseX<=260 && p.mouseX >=200) && (p.mouseY>=550) && level==1)
      level += 1;
    //level 3 win checker
    if((p.mouseX <= 620 && p.mouseX >= 590) && (p.mouseY>=250 && p.mouseY<=260 ) && level ==2){
      state = 3;
      
    }
      
  }
  
  
}