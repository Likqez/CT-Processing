import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

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

  //Ploting
  List<Integer> carPosHistory = new ArrayList<>();
  List<Integer> accCarPosHistory = new ArrayList<>();

  public static void main(String[] args) {
    PApplet.main(CarRace.class);
  }

  public void settings() {
    size(1000, 800);
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

    text("t[s]: " + t, 100, 10);
    text("v[px/s]: " + v, 200, 10);
    text("v[px/s]: " + a * t, 300, 10);

    drawCars();
    carPosHistory.add((int) carPosX);
    accCarPosHistory.add((int) accCarPosX);

    if (carPosX >= finishPosX || accCarPosX >= finishPosX) {
      drawGraph((int) frameRate);
      noLoop();
    }
  }

  public void drawGraph(int fps) {
    translate(20, height - 20);
    stroke(0);
    strokeWeight(1);

    int nValues = carPosHistory.size();
    int stepX = (width - 20) / (nValues / fps);

    line(0, 0, width - 20, 0); //X Axis
    for (int i = 0; i < width; i += stepX) {
      line(i, 5, i, - 5);
      text(i/stepX,i-6,15);
    }

    line(0, 0, 0, - height - 20); //Y Axis

    for (int i = 0; i * fps < nValues; i++) {
      strokeWeight(4);
      stroke(0, 255, 0);
      point(i * stepX, - (carPosHistory.get((i * fps))));
      stroke(0, 0, 255);
      point(i * stepX, - (accCarPosHistory.get((i * fps))));
      strokeWeight(1);
    }
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
