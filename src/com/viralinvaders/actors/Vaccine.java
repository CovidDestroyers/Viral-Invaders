package com.viralinvaders.actors;

public class Vaccine implements Runnable {
  private static final int VACCINE_HEIGHT = 5;
  private static final int VACCINE_WIDTH = 2;
  private static final int VACCINE_SPEED = 15;

  private int x = 0;
  private int vaccineHeight = 0;

  boolean vaccineState = true;
  VirusArmy virusArmy = null;

  public Vaccine(int xVal, int yVal, VirusArmy va){
    x = xVal;
    vaccineHeight = yVal;
    virusArmy = va;
    Thread thread = new Thread(this);
    thread.start();
  }

  private boolean moveVaccine() {
    if (virusArmy.checkVaccine(x, vaccineHeight)) {
      System.out.println("HIT!");
      vaccineState = false;
    }
    return true;
  }


  @Override
  public void run() {

  }
}
