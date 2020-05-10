package com.viralinvaders.game;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
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
  static int BOARD_WIDTH = 640;
  static int BOARD_HEIGHT= 480;

  private boolean inGame = true;
  private int posX = 0;
  private int posY = 0;

  private Dimension dimension;
  private String message = "Click board to start.";
  private BufferedImage image;
  private Thread animator;



  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Board() {
    addKeyListener(new TAdapter());
    addMouseListener(this);
    setFocusable(true);
    setDimension(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    setBackground(Color.BLACK);
    setDoubleBuffered(true);

    if (animator == null || !inGame) {
      animator = new Thread(this);
      animator.start();
    }
  }


  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void paint(Graphics graphics) {
    int xCoord = 10;
    int yCoord = HEIGHT - 60;

    super.paint(graphics);

    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);

    Font mediumFont = new Font("Helvetica", Font.BOLD , 14);
    FontMetrics metrics = this.getFontMetrics(mediumFont);

    graphics.setColor(Color.BLACK);
    graphics.setFont(mediumFont);
    graphics.drawString(getMessage(), xCoord, yCoord);

    if (inGame) {
      // graphics.drawImage(image, 0, 0, 200, 200, null);
    }

    Toolkit.getDefaultToolkit().sync();
    graphics.dispose();

  }


  @Override
  public void run() {
    long time = System.currentTimeMillis();
    long beforeTime = System.currentTimeMillis();
    long timeDiff;
    long sleep;

    int animationDelay = 500;

    while (true) {
      repaint();

      try {
        time += animationDelay;

        Thread.sleep(Math.max(0, time - System.currentTimeMillis()));

      } catch (InterruptedException exception) {
        System.out.println(exception.getMessage());
      }
    }


  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int mousePositionX = mouseEvent.getX();
    int mousePositionY = mouseEvent.getY();

    System.out.println("Mouse clicked X coordinate: " + mousePositionX);
    System.out.println("Mouse clicked Y coordinate: " + mousePositionY);
  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {
    int mousePositionX = mouseEvent.getX();
    int mousePositionY = mouseEvent.getY();

    System.out.println("Mouse position X coordinate: " + mousePositionX);
    System.out.println("Mouse position Y coordinate: " + mousePositionY);
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



  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS
  public void setInGame(boolean inGame) {
    this.inGame = inGame;
  }

  public void setDimension(Dimension dimension) {
    this.dimension = dimension;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

  public void setAnimator(Thread animator) {
    this.animator = animator;
  }


  // GET METHODS
  public boolean isInGame() {
    return inGame;
  }

  public Dimension getDimension() {
    return dimension;
  }

  public int getPosX() {
    return posX;
  }

  public int getPosY() {
    return posY;
  }

  public String getMessage() {
    return message;
  }

  public BufferedImage getImage() {
    return image;
  }

  public Thread getAnimator() {
    return animator;
  }



  /*
   * =============================================
   * =========== Private Class ===================
   * =============================================
   */

  private class TAdapter extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent event) {
      super.keyReleased(event);

      int key = event.getKeyCode();
    }

    @Override
    public void keyPressed(KeyEvent event) {
      super.keyPressed(event);

      int key = event.getKeyCode();

      if (key == 39) {
        System.out.println("KEY CODE: " + key);
      }
    }
  }

}


