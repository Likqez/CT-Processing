import processing.core.PApplet;
import processing.core.PImage;

public class Image extends PApplet {

  public static void main(String[] args) {
    PApplet.main(Image.class);
  }

  PImage bildAlt, bildNeu;

  public void settings() {
    size(1000, 800);
  }

  public void setup() {
    background(255);
    bildAlt = loadImage("see.jpg");
    image(bildAlt, 0, 0);  // Anzeige von bildAlt; linke obere Ecke: (0,0)

    // Aufgaben 7
    bildNeu = spiegleHorizontal(bildAlt);
    image(bildNeu, 500, 0);

    //Aufgabe 8
    save("spiegelsee.jpg");

    //AUfgabe 10
    bildNeu = spiegleVertikal(bildAlt);
    image(bildNeu, 0, 333); // 333 = höhe des see.jpg
    // Aufgabe 11
    image(spiegleHorizontal(bildNeu), 500, 333);

    // Aufgabe 11 90°
    image(roate90DegreesRight(bildAlt), 0, 500);
  }

  // Methode spiegelt Bild horizontal
  PImage spiegleHorizontal(PImage originalbild) {
    int breite = originalbild.width;
    int hoehe = originalbild.height;
    PImage neuesBild = createImage(breite, hoehe, RGB);
    for (int x = 0; x < breite; x++) {
      for (int y = 0; y < hoehe; y++) {
        neuesBild.set(x, y, originalbild.get(breite - 1 - x, y));
      }
    }
    return neuesBild;
  }

  // Methode aus Aufgabe 10 hier ergänzen
  PImage spiegleVertikal(PImage originalbild) {
    final int breite = originalbild.width;
    final int hoehe = originalbild.height;
    PImage neuesBild = createImage(breite, hoehe, RGB);
    for (int x = 0; x < breite; x++) {
      for (int y = 0; y < hoehe; y++) {
        neuesBild.set(x, y, originalbild.get(x, hoehe - 1 - y));
      }
    }
    return neuesBild;
  }

  PImage roate90DegreesRight(PImage originalbild) {
    final int breite = originalbild.width;
    final int hoehe = originalbild.height;
    PImage neuesBild = createImage(hoehe, breite, RGB);


    return neuesBild;
  }

  public void draw() {

  }

}
