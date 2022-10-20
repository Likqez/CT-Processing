import processing.core.PApplet;

public class CarRace extends PApplet {

  final int startPosX = 75;
  final int finishPosX = 725;
  final int carHeight = 10;
  final int carLenght = 10;
  final int carStartPosX = 10;
  final int accCarStartPosX = startPosX + 3;
  final int carPosY = 20;
  final int accCarPosY = 70;
  final int v = 40;
  final int a = 5;
  float carPosX;
  float accCarPosX;
  float t;

  public static void main(String[] args) {
    PApplet.main(CarRace.class);
  }

  public void settings() {
    size(800, 800);
  }

  public void setup() {
    background(255);
    frameRate(60);
  }

  public void draw() {
    background(255);

    strokeWeight(5);
    stroke(0);
    line(startPosX, 0, startPosX, 100); //Start
    line(finishPosX, 0, finishPosX, 100); //Finish

    t = t + 1 / frameRate;

    carPosX = (v * t) + carStartPosX;

    if (carPosX > startPosX) {
      accCarPosX = (a * t * t) / 2 + accCarStartPosX;
    } else accCarPosX = accCarStartPosX;

    if (carPosX >= finishPosX || accCarPosX >= finishPosX) {
      noLoop();
    }

    text("t[s]: " + t, 100, 10);
    text("v[px/s]: " + v, 200, 10);
    text("v[px/s]: " + a*t, 300, 10);

    drawCars();
  }

  public void drawCars() {
    strokeWeight(1);
    stroke(255, 0, 0);
    fill(0);
    rect(carPosX, carPosY, carLenght, carHeight); //Normal Car

    fill(0);
    rect(accCarPosX, accCarPosY, carLenght, carHeight); //Accelerated Car
    stroke(0);
  }
}
