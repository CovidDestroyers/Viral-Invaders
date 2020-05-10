package com.viralinvaders.game;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;



public class Board  extends JPanel implements Runnable, MouseListener {
  static int BOARD_WIDTH = 500;
  static int BOARD_HEIGHT= 500;

  private boolean inGame = true;
  private Dimension d;
  private int posX = 0;
  private int posY = 0;



  @Override
  public void mouseClicked(MouseEvent mouseEvent) {

  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseEntered(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {

  }

  @Override
  public void run() {

  }

  public boolean isInGame() {
    return inGame;
  }

  public void setInGame(boolean inGame) {
    this.inGame = inGame;
  }

  public Dimension getD() {
    return d;
  }

  public void setD(Dimension d) {
    this.d = d;
  }

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }
}


