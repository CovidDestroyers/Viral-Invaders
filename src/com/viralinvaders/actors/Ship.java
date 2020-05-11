package com.viralinvaders.actors;

import com.viralinvaders.game.Board;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Ship extends Actor implements MouseMotionListener, MouseListener {
  public static final int SHIP_HEIGHT = 25;
  public static final int SHIP_WIDTH = 15;

  private int x = 0;
  private int heightPosition = 0;

  // ViralInvaders viralInvaders = null;

  Vaccine vaccine = null;

  boolean hitState = false;

  // public Vaccine(ViralInvaders vi) {
  //   viralInvaders = vi;
  //   //setting starting position of ship
  //   x = (int) ((ViralInvaders.WIDTH / 2) + (SHIP_WIDTH / 2));
  //   heightPosition = ViralInvaders.HEIGHT - SHIP_HEIGHT - 20;
  // }


  @Override
  public void mouseClicked(MouseEvent e) {
    // VirusArmy army = viralInvaders.getVirusArmy();
    // vaccine = new Vaccine(x + (int) (SHIP_WIDTH / 2), heightPosition, army);

  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // viralInvaders.pauseGame(false);
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // viralInvaders.pauseGame(true);
  }

  @Override
  public void mouseDragged(MouseEvent e) {

  }

  @Override
  public void mouseMoved(MouseEvent e) {
    int newX = e.getX();
    // if (newX > (ViralInvaders.WIDTH - SHIP_WIDTH - 10)) {
    //
    //   //Stop the ship moving off the screen
    //   x = ViralInvaders.WIDTH - SHIP_WIDTH - 10;
    // } else {
    //   //Set the new x position
    //   x = newX;
    // }
  }

  public void drawShip(Graphics g) {
    g.setColor(Color.GREEN);
    // g.fillRect(shipX, shipY, SHIP_WIDTH, SHIP_HEIGHT);
    // if ((vaccine != null) && (vaccine.getVaccineState())) {
    //   vaccine.drawVaccine(g);
    // }
  }

    public boolean checkVaccine(int xVaccine, int yVaccine){

      if ((xVaccine >= x) && (xVaccine <= (x + SHIP_WIDTH))) {
        //X is ok, now lets check the Y range
        if ((yVaccine >= heightPosition) && (yVaccine <= (heightPosition + SHIP_HEIGHT))) {
          //The ship was hit!
          hitState = true;
          return true;
        }
      }
      return false;
    }

    public void hitByAlien () {
      // viralInvaders.infectedShip();
    }

  }
