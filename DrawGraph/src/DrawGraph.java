import processing.core.PApplet;
public class DrawGraph extends PApplet {

  public static void main(String[] args) {
    PApplet.main(DrawGraph.class);
  }

  int nValues = 15;

  int[] yLin = new int[nValues];
  int[] yPar = new int[nValues];

  int maxValue;
  int stepY;
  int stepX;

  public void settings() {
    size(1000, 1000);
  }

  public void setup() {

    for (int i = 0; i < nValues; i++) {
      yLin[i] = (int) (0.5 * i + 60);
      yPar[i] = (int) Math.pow(i, 2);
    }

    background(255);

    if (max(yLin) < max(yPar)) {
      maxValue = max(yPar);
    } else maxValue = max(yLin);

    stepX = 980 / nValues;
    stepY = 980 / maxValue;

    print(stepX);
  }

  public void draw() {
    translate(20, 980);
    stroke(0);

    line(0, 0, pixelWidth, 0); //X Axis
    line(0, 0, 0, - pixelHeight); //Y Axis

    for (int i = 0; i < nValues; i++) {
      strokeWeight(2);
      stroke(0, 255, 0);
      point(i * stepX, - (yPar[i]));
      stroke(0, 0, 255);
      point(i * stepX, -(yLin[i]));
      strokeWeight(1);
    }
  }

}
