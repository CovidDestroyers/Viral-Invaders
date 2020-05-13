package com.viralinvaders.actors;

import java.awt.*;
import java.util.ArrayList;

public class Shot extends Actor{

  private boolean moveUp;

  private Shot shot;
  private Ship ship;

  public static final ArrayList<Shot> SHOT_ARRAY_LIST = new ArrayList<>();



  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */


  public Shot(int posX, int posY, int actorSpeed){
    super(posX, posY, actorSpeed);
    createShotArray();
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
    int posX = ship.getPosX();
    int posY = ship.getPosY();

    for (int i = 0; i < 1000; i++) {
      shot = new Shot(ship.getPosX(), ship.getPosY(), 5);
      SHOT_ARRAY_LIST.add(shot);
      posY += 40;
    }
  }




  public void moveShot() {
    for (Shot shot : SHOT_ARRAY_LIST) {
      int shotYaxis = shot.getPosY();
      int shotSpeed = shot.getActorSpeed();

      if (shot.isMoveUp()) {
        int z = shotYaxis + shotSpeed;
        shot.setPosY(z);
      }
    }
    for (Shot shot : SHOT_ARRAY_LIST) {
      int shotNewY = shot.getPosY();

      if (shotNewY <= 0) {
        for (Shot shot1 : SHOT_ARRAY_LIST) {
          shot1.setMoveUp(true);
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



  public void addShotToBoard(Graphics g, Shot shot) {
    g.setColor(Color.PINK);
    g.fillRect( shot.getPosX() + 9 , shot.getPosY(), 4, 10);
  }


  public void drawShot(Graphics graphics) {

  }
}
