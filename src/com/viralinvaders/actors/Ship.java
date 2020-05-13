package com.viralinvaders.actors;

import com.viralinvaders.game.Board;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Ship extends Actor implements MouseMotionListener, MouseListener {

  Shot shot = null;

  boolean wasHit = false;

  @Override
  public void mouseClicked(MouseEvent me) {
    shot = new Shot(posX, posY, 5);
  }

  @Override
  public void mouseMoved(MouseEvent me) {
    int newXPos = me.getX();
    if (newXPos > (width - 10)) {
      posX = width - 10;
    } else {
      posX = newXPos;
    }
  }


  public void drawShip(Graphics graphics) {
    graphics.setColor(Color.GREEN);
    graphics.fillOval(posX, posY, width, height);
    if ((shot != null)) {
      shot.drawShot(graphics);
    }
  }

  public boolean checkWasHit(int xShot, int yShot) {
    if ((xShot >= posX) && (xShot <= (posX + width))) {
      if ((yShot >= posY) && (yShot <= (posY + height))) {
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
