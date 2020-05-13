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
  }

  public Shot() {
  }


  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */



  public void addShotToBoard(Graphics graphics, Color color) {
    for (Shot shot : SHOT_ARRAY_LIST) {
      graphics.setColor(color);
      graphics.fillRect(shot.getPosX(), shot.getPosY(), 3, 7);
    }
  }


  public void createShotArray() {
    System.out.println("create shot array");
    int howMany = 10;

    for (int i = 0; i < howMany; i++) {
      shot = new Shot(player.getPosX(), player.getPosY(), 5);

      SHOT_ARRAY_LIST.add(shot);
    }
  }


  public void moveShot() {
    for (Shot shot : SHOT_ARRAY_LIST) {
      int shotYaxis = player.getPosY();
      int shotSpeed = shot.getActorSpeed();

       if (shot.isMoveUp()) {
         int z = shotYaxis - shotSpeed;
         shot.setPosY(z);
       }
    }
    for (Shot shot : SHOT_ARRAY_LIST){
      int shotNewY = shot.getPosY();

      if (shotNewY <=0 ){
        for (Shot shot1 : SHOT_ARRAY_LIST){
          shot.setMoveUp(true);
        }
      }
    }

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

}
