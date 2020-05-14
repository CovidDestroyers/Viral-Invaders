package com.viralinvaders.game;

import com.viralinvaders.actors.Player;
import com.viralinvaders.actors.Shot;
import com.viralinvaders.actors.VirusArmy;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Board extends JPanel implements Runnable {
  public static final int BOARD_WIDTH = 500;
  public static final int BOARD_HEIGHT = 500;

  private int posX = 0;
  private int posY = 0;

  private Thread animator;
  private final Player player;
  private final VirusArmy virusArmy;


  /*
   * =============================================
   * ============= Constructor ==================
   * =============================================
   */
  public Board() {
    player = new Player((BOARD_WIDTH / 2), (BOARD_HEIGHT / 2) + 200, 5);
    virusArmy = new VirusArmy();



    addKeyListener(new WatchMyKeys());
    setFocusable(true);
    // setDimension(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    setBackground(Color.BLACK);
    setDoubleBuffered(true);

    if (getAnimator() == null) {
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

    // Shot
    if (!Shot.SHOT_ARRAY_LIST.isEmpty()){
      for (int i = 0; i < Shot.SHOT_ARRAY_LIST.size(); i++){
        Shot shot = Shot.SHOT_ARRAY_LIST.get(i);
        if (shot.isMoveUp()){
          shot.addShotToBoard(graphics, Color.white);
          shot.moveShot();
        }
        else{
          Shot.SHOT_ARRAY_LIST.remove(shot);
        }
        virusArmy.checkArmyForHits(shot);
      }
    }

    player.addToBoard(graphics);
    virusArmy.addArmyToBoard(graphics);
    virusArmy.moveArmy();
    player.movePlayer();

    Toolkit.getDefaultToolkit().sync();
    graphics.dispose();
  }


  @Override
  public void run() {
    long time = System.currentTimeMillis();
    int animationDelay = 65;

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

  private class WatchMyKeys extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent event) {
      super.keyReleased(event);

      player.setMoveRight(false);
      player.setMoveLeft(false);
    }

    @Override
    public void keyPressed(KeyEvent event) {
      super.keyPressed(event);
      int key = event.getKeyCode();

      if (key == 39) {
        player.setMoveRight(true);
      }

      if (key == 37) {
        player.setMoveLeft(true);
      }

      if (key == 32) {
        Shot newShot = new Shot(player.getPosX(), player.getPosY(), 5);
        newShot.setMoveUp(true);
        Shot.SHOT_ARRAY_LIST.add(newShot);
      }
    }
  }
}


