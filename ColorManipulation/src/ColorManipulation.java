import processing.core.PApplet;

import java.awt.*;

public class ColorManipulation extends PApplet {

  public static void main(String[] args) {
    PApplet.main(ColorManipulation.class);
  }

  int f1, f2;

  @Override
  public void settings() {
    size(1000,800);
  }

  @Override
  public void setup() {
    f1 = color(165,0,255);
    f2 = 0xa600ff;

    f1 += blue(0);
    f1 += green(128);
    System.out.printf("%x", f1);
  }

  @Override
  public void draw() {

  }
}
