package com.viralinvaders.actors;
import com.viralinvaders.game.Starter;

import java.awt.event.*;
import java.awt.*;

public class Ship extends Actor implements MouseMotionListener, MouseListener {

  public int shipHeight = 25;
  public int shipWidth = 15;

  private int xPos = 0;
  private int yPos = 0;

  Starter starter = null;
  Shot shot = null;

  boolean wasHit = false;

  public Ship(Starter start){
    starter = start;
    xPos = ((Starter.WIDTH/2) + (shipWidth/2));
    yPos = Starter.HEIGHT-shipHeight-20;
  }

  @Override
  public void mouseClicked(MouseEvent me) {
    VirusArmy army = starter.getVirusArmy();
    shot = new Shot((xPos + shipWidth/2), shipHeight, army);
  }

  @Override
  public void mouseMoved(MouseEvent me) {
    int newXPos = me.getX();
    if (newXPos > (Starter.WIDTH-shipWidth-10)){
      xPos = Starter.WIDTH-shipWidth-10;
    } else{
      xPos = newXPos;
    }
  }


  public void drawShip(Graphics graphics){
    graphics.setColor(Color.GREEN);
    graphics.fillOval(xPos, yPos, shipWidth, shipHeight);
    if ((shot != null) && (shot.getWasHit())){
      shot.drawShot(graphics);
    }
  }

  public boolean checkWasHit( int xShot, int yShot){
    if((xShot >= xPos) && (xShot <= (xPos+shipWidth))){
      if ((yShot >= yPos) && (yShot <= (yPos+shipHeight))){
        wasHit = true;

        System.out.println("You were hit!");
        return true;
      }
    }
    return false;
  }

  // Unused MouseListeners
  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {

  }

}
