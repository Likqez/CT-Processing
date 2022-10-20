import processing.core.PApplet;

public class DrawGraph extends PApplet {

  int nValues = 100;
  int[] yLin = new int[nValues];
  int[] yPar = new int[nValues];
  int stepY, stepX;

  public static void main(String[] args) {
    PApplet.main(DrawGraph.class);
  }

  public void settings() {
    size(1000, 1000);
  }

  public void setup() {
    background(255);

    // Generate Values
    for (int i = 0; i < nValues; i++) {
      yLin[i] = 4 * i + 60;
      yPar[i] = (int) Math.pow(i, 2) / 10;
    }

    stepX = (width - 20) / nValues;
  }

  public void draw() {
    translate(20, height - 20);
    stroke(0);
    strokeWeight(1);

    line(0, 0, width - 20, 0); //X Axis
    for (int i = 0; i < width; i += stepX)
      line(i, 5, i, - 5);

    line(0, 0, 0, - height - 20); //Y Axis

    for (int i = 0; i < nValues; i++) {
      strokeWeight(4);
      stroke(0, 255, 0);
      point(i * stepX, - (yPar[i]));
      stroke(0, 0, 255);
      point(i * stepX, - (yLin[i]));
      strokeWeight(1);
    }
    noLoop();
  }

}
