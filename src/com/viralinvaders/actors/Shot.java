package com.viralinvaders.actors;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Shot extends Actor {

  private boolean moveUp;
  public static final ArrayList<Shot> SHOT_ARRAY_LIST = new ArrayList<>();



  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */


  public Shot(int posX, int posY, int actorSpeed) {
    super(posX, posY, actorSpeed);

    setMoveUp(false);
  }

//  public Shot() {
//  }


  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */



  public void addShotToBoard(Graphics graphics, Color color) {
      graphics.setColor(color);
      graphics.fillRect(getPosX(), getPosY(), 3, 7);
    }



  public void moveShot() {
    if (isMoveUp()) {
      moveShotUp();
    }
  }

  private  void moveShotUp() {
    int shotY = getPosY();
    int yMinusSpeed = shotY - actorSpeed;
    setPosY(yMinusSpeed);
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
