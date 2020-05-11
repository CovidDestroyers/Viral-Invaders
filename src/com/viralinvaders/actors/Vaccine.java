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

//
//    shotHeight = shotHeight - 2;
//    //We could have written this as
//    //shotHeight -= 2;
//
//    //Now check we haven't gone off the screen
//    if (shotHeight < 0) {
//      shotState = false;
//      return true;
//    }
//
//    return false;
//  }
//
//  /**
//   * Draw the image of the shot
//   */
//  public void drawShot(Graphics g) {
//    if (shotState) {
//      g.setColor(Color.white);
//    } else {
//      g.setColor(Color.black);
//    }
//    g.fillRect(x, shotHeight, SHOT_WIDTH, SHOT_HEIGHT);
//  }
//
//  public boolean getShotState() {
//    return shotState;
//  }
//
//  /**
//   * The thread that moves the shot
//   */
//  public void run() {
//    while(true) {
//      try {
//        Thread.sleep(shotSpeed);
//      } catch(InterruptedException ie) {
//        //Ignore this exception
//      }
//
//      //Use this line for super bullets
//      //
//      //moveShot()
//      //
//      //or this for normal bullets
//      //
//      //if (moveShot()) {
//      // break;
//      //}
//
//      if (moveShot()) {
//        break;
//      }
//
//    }
//  }
//
//}
