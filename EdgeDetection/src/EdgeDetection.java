import processing.core.PApplet;
import processing.core.PImage;

public class EdgeDetection extends PApplet {

  public static void main(String[] args) {
    PApplet.main(EdgeDetection.class);
  }

  PImage img;
  boolean green;

  @Override
  public void settings() {
    size(1000, 1000);
  }

  @Override
  public void setup() {
    img = loadImage("test.png");
    background(255);
    image(img, 0, 0);
    detectEdges();
  }

  public void detectEdges() {
    for (int y = 0; y < img.height - 1; y++) {
      for (int x = 0; x < img.width - 1; x++) {
        final int currentColor = img.get(x, y);
        stroke(0, 255, 0);

        if (currentColor != img.get(x + 1, y)) {
          point(x + 1, y);
          green = ! green;
          continue;
        }

        if(green && currentColor == img.get(x + 1, y))
          point(x+1,y);

      }


    }
  }
}
