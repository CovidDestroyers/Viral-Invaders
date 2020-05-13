package com.viralinvaders.game;

import com.viralinvaders.actors.Player;
import com.viralinvaders.actors.Shot;
import com.viralinvaders.actors.VirusArmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;



public class Board  extends JPanel implements Runnable {
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
  private VirusArmy army;
  private Shot shot;




  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Board() {
    player = new Player((BOARD_WIDTH / 2), (BOARD_HEIGHT / 2) + 200, 5 );

    addKeyListener(new TAdapter());
    setFocusable(true);
    setDimension(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    setBackground(Color.BLACK);
    setDoubleBuffered(true);

    shot = new Shot();
    army = new VirusArmy();


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


    /*
     * =============================================
     * ============= Create Ship ===================
     * =============================================
     */
    graphics.setColor(Color.RED);
    graphics.fillRect(player.getPosX(), player.getPosY() , 20, 20);



    /*
     * =============================================
     * ================  Shots =====================
     * =============================================
     */
    // Check shot array if isMoveUp
    // get current shots posY
    // subtract the speed
    // set to new current posY

    // re-render all shots
      // go through shot array
      // set color
      // fill rect with shot posX and shotPosY, 3, 7


    if (shot.isMoveUp()) {
      int shotY = shot.getPosY();
      int shotYminusSpeed = shotY -= shot.getActorSpeed();

      shot.setPosY(shotYminusSpeed);

      graphics.setColor(Color.white);
      graphics.fillRect(shot.getPosX()+8, shot.getPosY(), 4, 10);
    }

    // shot.addShotToBoard(graphics, Color.white);


    /*
     * =============================================
     * ============== Virus Army ===================
     * =============================================
     */

    army.addArmyToBoard(graphics, Color.GREEN);

    army.moveArmy();


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


  /*
   * =============================================
   * =========== Getter Methods ==================
   * =============================================
   */


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


  /*
   * =============================================
   * =========== Getter Methods ==================
   * =============================================
   */



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
        shot = new Shot(player.getPosX(), player.getPosY(), 3);
        shot.setMoveUp(true);

        // shot.moveShot();
        System.out.println("YOU FIRED AT THE VIRUS");
      }
    }
  }

}


