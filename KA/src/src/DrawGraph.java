package src;

import processing.core.PApplet;

public class DrawGraph extends PApplet {
  int stepX, i, x = -200;

  public static void main(String[] args) {
    PApplet.main(DrawGraph.class);
  }

  public void settings() {
    size(800, 800);
  }

  public void setup() {
    background(255);
    frameRate(60);
  }

  public void draw() {
    translate(300, height - 200);
    stroke(0);
    strokeWeight(1);

    line(- 300, 0, width, 0); //X-Axis
    line(0, 200, 0, - height); // Y-Axis


    int valLin = (4 * x + 60);
    int valPar = (int) Math.pow(x, 2) / 20;

    if(valLin == valPar) {
      stroke(0,0,255);
      strokeWeight(10);
      point(x, -valPar);
    }

    strokeWeight(5);
    stroke(255,0,0);
    point(x, -valLin); // Lin
    stroke(0,255,0);
    point(x,-valPar); //Par

    i++;
    //if (i % 5 == 0)
      x++;


  }

}
