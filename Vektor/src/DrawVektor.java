import processing.core.PApplet;
import processing.core.PVector;

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

    var a = new PVector(4 * step, 2 * step);
    var b = new PVector(3 * step, 0);
    var res = PVector.add(a, b);
    var p = new PVector(3 * step, 3 * step);

    drawVektor(p, a, 0, 255, 0);
    drawVektor(p, b, 255, 0, 0);
    drawVektor(p, res, 0, 0, 255);
    noLoop();
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
    fill(255, 0, 0);
    for (int i = 0; i < 10; i++) {
      text(i, step * i, yoff);
      text(i, - xoff, - step * i);

      stroke(255, 0, 0);
      strokeWeight(2);
      line(step * i, 3, step * i, - 3);
      line(3, - step * i, - 3, - step * i);
    }
  }

  public void drawVektor(PVector p, PVector vector, int r, int g, int b) {
    stroke(r, g, b);
    strokeWeight(2);
    line(p.x, - p.y, vector.x+p.x, - (p.y + vector.y));
  }
}
