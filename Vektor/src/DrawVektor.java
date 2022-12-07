import processing.core.PApplet;

import java.awt.*;

public class DrawVektor extends PApplet {


  private int xoff, yoff, step;

  public static void main(String[] args) {
    PApplet.main(DrawVektor.class);
  }

  public void settings() {
    size(1200, 800);
  }

  public void setup() {
    xoff = 20;
    yoff = 20;
  }

  public void draw() {
    background(255);
    translate(xoff, height - yoff);
    drawGrid();
    labelGrid();
  }

  public void drawGrid() {
    stroke(1);
    strokeWeight(2);
    line(0, 0, 0, - height + yoff); //Y-Axis
    line(0, 0, width - xoff, 0); //X-Axis

    step = min(height - yoff, width - xoff) / 10;
    for (int i = 1; i < 10; i++) {
      strokeWeight(1);

      line(step * i, 0, step * i, - height + yoff); //X Line
      line(0, - step * i, step * 9, - step * i); //Y Line
    }
  }

  public void labelGrid() {
    fill(255,0,0);
    for (int i = 0; i < 10; i++) {
      text(i, step*i, yoff);
      text(i, -xoff, -step*i);

      stroke(255,0,0);
      strokeWeight(2);
      line(step*i,3,step*i, -3);
      line(3,-step*i,-3, -step*i);
    }
  }
}
