package com.viralinvaders.actors;

import java.awt.*;
import java.util.ArrayList;

public class Shot extends Actor {

  private boolean moveUp;

  private Shot shot;
  private Player player;

  public static final ArrayList<Shot> SHOT_ARRAY_LIST = new ArrayList<>();



  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */


  public Shot(int posX, int posY, int actorSpeed) {
    super(posX, posY, actorSpeed);
    // createShotArray();
  }

  public Shot() {

  }


  public void addShotToBoard(Graphics graphics, Color color) {
    for (Shot shot : SHOT_ARRAY_LIST) {
      graphics.setColor(color);
      graphics.fillRect(shot.getPosX(), shot.getPosY(), 3, 7);
    }
  }



  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */


  public void createShotArray() {
    int posX = player.getPosX();
    int posY = player.getPosY();

    for (int i = 0; i < 1000; i++) {
      shot = new Shot(player.getPosX(), player.getPosY(), 5);
      SHOT_ARRAY_LIST.add(shot);
      posY += 40;
    }
  }


  public void moveShot() {
    Shot s = new Shot();

    System.out.println("MoveShot called");

    for (Shot shot : SHOT_ARRAY_LIST) {
      int shotYaxis = shot.getPosY();
      int shotSpeed = shot.getActorSpeed();

      shotYaxis -= 20;

      // if (shot.isMoveUp()) {
      //   int z = shotYaxis - shotSpeed;
      //   shot.setPosY(z);
      // }
      //
      // int shotNewY = shot.getPosY();
      //
      // if (shotNewY <= 0) {
      //   for (Shot shot1 : SHOT_ARRAY_LIST) {
      //     shot1.setMoveUp(false);
      //   }
      // }
    }
  }


  public void fire() {

  }



  /*
   * =============================================
   * =========== Getter Methods ================
   * =============================================
   */


  public boolean isMoveUp() {
    return moveUp;
  }





  /*
   * =============================================
   * =========== Setter Methods ================
   * =============================================
   */


  public void setMoveUp(boolean moveUp) {
    this.moveUp = moveUp;
  }


  public void drawShot(Graphics graphics) {

  }
}
