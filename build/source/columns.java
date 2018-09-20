import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class columns extends PApplet {

int increment = 30;
int multiplier = 3;
int v = 50;
int colour = 1;
int dir = 1;

public void setup()
{
  background(0);
  

}

public void draw()
{
  if (v > height)
  {
    v = 0;
  }
  v += 3;

  if (colour >= 255)
  {
    dir = -1;
  }
  else if (colour == 0)
  {
    dir = 1;
  }

  colour += dir;

  for (int i = 0; i < height; i++)
  {
    int a = (i * increment) % 90;
    stroke(colour, increment);
    line(0, i, a, i);
    line(increment * multiplier, i, a + (increment * multiplier), i);
    line(increment * 6, i, a + (increment * 6), i);
    line(increment * 9, i, a + (increment * 9), i);
    line(increment * 12, i, a + (increment * 12), i);
    line(increment * 15, i, a + (increment * 15), i);
    line(increment * 18, i, a + (increment * 18), i);
  }
  stroke(colour, random(210, 220));
  line(0, v, width, v);
  //circleMask();
}

public void circleMask()
{
  PGraphics circleMask = createGraphics(width, height, P2D);
  circleMask.beginDraw();
  circleMask.background(0);
  circleMask.fill(255);
  circleMask.ellipse(width/2, height/2, width/1.3f, height/1.3f);
  circleMask.endDraw();
  blend(circleMask,0,0,width,height,0,0,width,height,MULTIPLY);
}
  public void settings() {  size(600, 600, P2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "columns" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
