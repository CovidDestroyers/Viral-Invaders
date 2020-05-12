package com.viralinvaders.actors;

import com.viralinvaders.game.Board;

import java.awt.*;

public class Shot extends Actor implements Runnable {

  private int shotSpeed = 10;

  boolean shotState = true; //only allows one shot at a time.
  VirusArmy virusArmy = null;

  public Shot() {

  }


  public Shot(int posX, int height, VirusArmy va){
    posX = getPosX();
    height = getHeight();
    virusArmy = va;
    Thread thread = new Thread(this);
    thread.start();
  }

  public Shot(int i, int height) {
  }

  public boolean moveShot(){
    if (virusArmy.checkWasHit(posX, height)){
      System.out.println("Hit a virus!");
      shotState = false; //reset state to allow to shoot again.
      return true;
    }

    height -= 2; // Bullet travel speed

    //If bullet goes offscreen then reset it.
    if(height < 0){
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
    graphics.fillOval(posX, height, width, shotSpeed);
  }


  public void addShotToBoard(Graphics graphics, Player player) {
    graphics.setColor(Color.PINK);
    graphics.fillRect( player.getPosX() + 9 , player.getPosY(), 4, 10);
  }


  public boolean getShotState(){
    return shotState;
  }

  //Below is the thread that moves the shot.
  @Override
  public void run() {
    while(true){
      try{
        Thread.sleep(shotSpeed);
      } catch (InterruptedException e){
        System.out.println("InterruptedException in Shot.java");
      }

      if ((moveShot())){
        break;
      }
    }
  }

  public boolean getWasHit() {
    if(isVisible){
      System.out.println("get Points checkWasHit");
    }
   return false;
  }
}
