package com.viralinvaders.game;

import com.viralinvaders.actors.Player;
import com.viralinvaders.actors.Shot;
import com.viralinvaders.actors.VirusArmy;

import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Board extends JPanel implements Runnable {
  public static final int BOARD_WIDTH = 500;
  public static final int BOARD_HEIGHT = 500;

  private boolean inGame = true;
  private int posX = 0;
  private int posY = 0;

  private Thread animator;
  private Shot shot;
  private static final ArrayList<Shot> SHOT_ARRAY_LIST = new ArrayList<>();

  private final Player player;
  private final VirusArmy virusArmy;

  /*
   * =============================================
   * ============= Constructor ==================
   * =============================================
   */
  public Board() {
    player = new Player((BOARD_WIDTH / 2), (BOARD_HEIGHT / 2) + 200, 5);

    addKeyListener(new TAdapter());
    setFocusable(true);
    // setDimension(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    setBackground(Color.BLACK);
    setDoubleBuffered(true);

    shot = new Shot();
    virusArmy = new VirusArmy();


    if (getAnimator() == null || !inGame) {
      setAnimator(new Thread(this));
      getAnimator().start();
    }
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);

    int xCoord = 10;
    int yCoord = HEIGHT - 60;


    // Player/Ship creation
    player.addPlayerToBoard(graphics);
    player.movePlayer();

    //Shots creation
    // Check shot array if isMoveUp
    // get current shots posY
    // subtract the speed
    // set to new current posY

    // re-render all shots
    // go through shot array
    // set color
    // fill rect with shot posX and shotPosY, 3, 7


    if (shot.isMoveUp()) {
      int shootMore = 0;

      while (shootMore < 5) {

        shootMore += 1;
        int shotY = shot.getPosY();
        int shotYminusSpeed = shotY - shot.getActorSpeed();
        shot.setPosY(shotYminusSpeed);

        graphics.setColor(Color.white);
        graphics.fillRect(shot.getPosX() + 8, shot.getPosY(), 4, 10);
      }
    }

    // Virus Army
    virusArmy.addArmyToBoard(graphics, Color.GREEN);
    virusArmy.moveArmy();

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
        Thread.sleep(time - System.currentTimeMillis());
      }
      catch (InterruptedException exception) {
        System.out.println(exception.getMessage());
      }
    }
  }


  /*
   * =============================================
   * =========== Setter Methods ==================
   * =============================================
   */

  public void setInGame(boolean inGame) {
    this.inGame = inGame;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public void setPosY(int posY) {
    this.posY = posY;
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

  public int getPosX() {
    return posX;
  }

  public int getPosY() {
    return posY;
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
      }
    }
  }

}


