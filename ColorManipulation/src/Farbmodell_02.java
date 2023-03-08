import processing.core.PApplet;
import processing.core.PImage;

public class Farbmodell_02 extends PApplet {

  public static void main(String[] args) {
    PApplet.main(Farbmodell_02.class);
  }
  PImage bildAlt;
  PImage bildNeu;

  @Override
  public void settings() {
    size(1000, 800);
  }

  public void setup() {
    background(255);
    bildAlt = loadImage("kuehe.jpg");
    image(bildAlt, 0, 0);  // Anzeige von bildAlt; linke obere Ecke: (0,0)

    bildAlt = loadImage("kuehe.jpg");
    bildNeu = grauStufenDurchschnitt(bildAlt);
    image(bildNeu, 500, 0);

    bildAlt = loadImage("kuehe.jpg");
    bildNeu = grauStufenNaturlich(bildAlt);
    image(bildNeu,500,400);

    bildAlt = loadImage("kuehe.jpg");
    bildNeu = invertiere(bildAlt);
    image(bildNeu,0,400);

  }

  public PImage grauStufenDurchschnitt(PImage originalBild) {

    for (int x = 0; x < originalBild.pixelWidth; x++) {
      for (int y = 0; y < originalBild.pixelHeight; y++) {
        final float red = red(originalBild.get(x, y));
        final float blue = blue(originalBild.get(x, y));
        final float green = green(originalBild.get(x, y));
        final float m = (red + blue + green) / 3F;
        originalBild.set(x, y, color(m));
      }
    }

    return originalBild;
  }

  public float grauStufeMax(PImage originalBild) {
    float max = 0;
    for (int x = 0; x < originalBild.pixelWidth; x++) {
      for (int y = 0; y < originalBild.pixelHeight; y++) {
        final float red = red(originalBild.get(x, y));
        final float blue = blue(originalBild.get(x, y));
        final float green = green(originalBild.get(x, y));
        final float m = (red + blue + green) / 3F;
        max = m > max ? m : max;
      }
    }

    return max;
  }

  public float grauStufeMin(PImage originalBild) {
    float min = 0;
    for (int x = 0; x < originalBild.pixelWidth; x++) {
      for (int y = 0; y < originalBild.pixelHeight; y++) {
        final float red = red(originalBild.get(x, y));
        final float blue = blue(originalBild.get(x, y));
        final float green = green(originalBild.get(x, y));
        final float m = (red + blue + green) / 3F;
        min = m < min ? m : min;
      }
    }

    return min;
  }

  public PImage grauStufenNaturlich(PImage originalBild) {

    for (int x = 0; x < originalBild.pixelWidth; x++) {
      for (int y = 0; y < originalBild.pixelHeight; y++) {
        final float red = red(originalBild.get(x, y));
        final float blue = blue(originalBild.get(x, y));
        final float green = green(originalBild.get(x, y));
        final float m = (red*.299F + blue*.114F + green*.587F) / 3F;
        originalBild.set(x, y, color(m));
      }
    }

    return originalBild;
  }

  public PImage invertiere(PImage originalBild) {

    for (int x = 0; x < originalBild.pixelWidth; x++) {
      for (int y = 0; y < originalBild.pixelHeight; y++) {
        final float red = red(originalBild.get(x, y));
        final float blue = blue(originalBild.get(x, y));
        final float green = green(originalBild.get(x, y));
        originalBild.set(x, y, color(red,green,blue)*-1);
      }
    }

    return originalBild;
  }
}
