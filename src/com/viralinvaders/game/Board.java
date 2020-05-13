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
  private final Player player;
  private final VirusArmy virusArmy;
  private Shot shot;


  /*
   * =============================================
   * ============= Constructor ==================
   * =============================================
   */
  public Board() {
    player = new Player((BOARD_WIDTH / 2), (BOARD_HEIGHT / 2) + 200, 5);
//    shot = new Shot(player.getPosX(), player.getPosY(), 5);
    virusArmy = new VirusArmy();



    addKeyListener(new TAdapter());
    setFocusable(true);
    // setDimension(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    setBackground(Color.BLACK);
    setDoubleBuffered(true);

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


    // Player/Ship creation
    graphics.setColor(Color.RED);
    graphics.fillRect(player.getPosX(), player.getPosY(), 20, 20);
    player.movePlayer(player);


    //Virus Army Creation
    virusArmy.addArmyToBoard(graphics, Color.GREEN);
    virusArmy.moveArmy();



    // Shot Creation
//    shot.addShotToBoard(graphics, Color.WHITE);
//    shot.moveShot(shot);
    if (!Shot.SHOT_ARRAY_LIST.isEmpty()){
      for (Shot shots: Shot.SHOT_ARRAY_LIST){
        if (shots.isMoveUp()){
          shots.addShotToBoard(graphics, Color.white);
          shots.moveShot();
        }else{
          Shot.SHOT_ARRAY_LIST.remove(shots);

        }
      }
    }

    //Shots creation
    // Check shot array if isMoveUp
    // get current shots posY
    // subtract the speed
    // set to new current posY

    // re-render all shots
    // go through shot array
    // set color
    // fill rect with shot posX and shotPosY, 3, 7
    

    // Should probably be in its own method
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
      } catch (InterruptedException exception) {
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
//      int key = event.getKeyCode();

      player.setMoveRight(false);
      player.setMoveLeft(false);
      shot.setMoveUp(true);
    }

    @Override
    public void keyPressed(KeyEvent event) {
      super.keyPressed(event);
      int key = event.getKeyCode();

      System.out.println(event.getKeyCode() + " " + event.getKeyChar());

      if (key == 39) {
//         System.out.println("KEY CODE: " + key);
        player.setMoveRight(true);
      }
      if (key == 37) {
        player.setMoveLeft(true);
      }

      if (key == 32) {
        shot = new Shot(player.getPosX(), player.getPosY(), 5);
        shot.setMoveUp(true);
        Shot.SHOT_ARRAY_LIST.add(shot);
//        shot.moveShot();
      }
    }
  }

}


