package com.viralinvaders.actors;

import java.awt.*;

public class Shot implements Runnable {

  private int shotSpeed = 10;

  private int shotWidth = 3;
  private int shotLength = 6;

  private int xPos = 0;
  private int shotHeight = 0;
  boolean shotState = true; //only allows one shot at a time.
  VirusArmy virusArmy = null;

  public Shot(int x, int y, VirusArmy va){
    xPos = x;
    shotHeight = y;
    virusArmy = va;
    Thread thread = new Thread(this);
    thread.start();
  }

  private boolean moveShot(){
    if (virusArmy.checkWasHit(xPos, shotHeight)){
      System.out.println("Hit a virus!");
      shotState = false; //reset state to allow to shoot again.
      return true;
    }

    shotHeight -= 2; // Bullet travel speed

    //If bullet goes offscreen then reset it.
    if(shotHeight < 0){
      shotState = false;
      return true;
    }
    return false;
  }

  public void drawShot(Graphics graphics){
    if(shotState){
      graphics.setColor(Color.ORANGE);
    } else {
      graphics.setColor(Color.black); //will blend in to the background when at rest
    }
    graphics.fillOval(xPos, shotHeight, shotWidth, shotLength);
  }

  public boolean getShotState(){
    return shotState;
  }

  //Below is the thread that moves the shot.
  @Override
  public void run() {
    while(true){
      try{Thread.sleep(shotSpeed);
    } catch (InterruptedException e){
        System.out.println("InterruptedException in Shot.java");
      }

      if ((moveShot())){
        break;
      }
    }
  }
}
