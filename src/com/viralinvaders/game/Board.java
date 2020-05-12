package com.viralinvaders.game;

import com.viralinvaders.actors.Actor;
import com.viralinvaders.actors.Player;
import com.viralinvaders.actors.VirusArmy;

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
import java.awt.image.BufferedImage;
import java.io.*;



public class Board  extends JPanel implements Runnable, MouseListener {
  public static final int BOARD_WIDTH = 500;
  public static final int BOARD_HEIGHT= 500;

  private boolean inGame = true;
  private int posX = 0;
  private int posY = 0;

  private Dimension dimension;
  private String message = "Click board to start.";
  private BufferedImage image;
  private Thread animator;
  private Player player;



  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Board() {
    player = new Player((BOARD_WIDTH / 2), (BOARD_HEIGHT / 2) + 200, 5 );

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

    // graphics.setColor(Color.YELLOW);
    // graphics.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);

    // For ship/Player
    graphics.setColor(Color.RED);
    graphics.fillRect(player.getPosX(), player.getPosY() , 20, 20);

    // For Bullets
    graphics.setColor(Color.WHITE);
    graphics.fillRect(player.getPosX() + 9, player.getPosY(), 4, 10);

    // Virus Army
    VirusArmy army = new VirusArmy();

    // System.out.println(army.createVirusArmy());
    army.addVirusToBoard(graphics, Color.GREEN);


    // Should probably be in its own method
    if (player.isMoveRight()) {
      int playerX = player.getPosX();
      int xPlusSpeed = playerX += player.getActorSpeed();

      player.setPosX(xPlusSpeed);
    }

    if (player.isMoveLeft()) {
      int playerX = player.getPosX();
      int xMinusSpeed = playerX -= player.getActorSpeed();

      player.setPosX(xMinusSpeed);
    }

    Font mediumFont = new Font("Helvetica", Font.BOLD , 14);
    FontMetrics metrics = this.getFontMetrics(mediumFont);

    graphics.setColor(Color.WHITE);
    graphics.setFont(mediumFont);
    graphics.drawString(getMessage(), xCoord, yCoord);

    // Keeps all the graphics synced
    Toolkit.getDefaultToolkit().sync();
    graphics.dispose();

  }


  @Override
  public void run() {
    long time = System.currentTimeMillis();
    int animationDelay = 50;

    while (true) {
      repaint();
      try {
        time += animationDelay;
        Thread.sleep(Math.max(0, time - System.currentTimeMillis()));
      }
      catch (InterruptedException exception) {
        System.out.println(exception.getMessage());
      }
    }
  }



  public void mouseClicked(MouseEvent mouseEvent, Graphics graphics) {
    int mousePositionX = mouseEvent.getX();
    int mousePositionY = mouseEvent.getY();

    System.out.println("Mouse clicked X coordinate: " + mousePositionX);
    System.out.println("Mouse clicked Y coordinate: " + mousePositionY);

  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {

  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {

//    int mousePositionX = mouseEvent.getX();
//    int mousePositionY = mouseEvent.getY();
//
//    System.out.println("Mouse position X coordinate: " + mousePositionX);
//    System.out.println("Mouse position Y coordinate: " + mousePositionY);
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

      player.setMoveRight(false);
      player.setMoveLeft(false);
    }

    @Override
    public void keyPressed(KeyEvent event) {
      super.keyPressed(event);
      int key = event.getKeyCode();

      System.out.println(event.getKeyCode() + " " + event.getKeyChar());

      if (key == 39) {
        // System.out.println("KEY CODE: " + key);
        player.setMoveRight(true);
      }
      if (key == 37) {
        player.setMoveLeft(true);
      }

      if (key == 32) {
        System.out.println("YOU FIRED AT THE VIRUS");
      }
    }
  }

}


