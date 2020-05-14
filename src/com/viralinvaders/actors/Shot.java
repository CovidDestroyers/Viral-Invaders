package com.viralinvaders.actors;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class Shot extends Actor {

  public static final ArrayList<Shot> SHOT_ARRAY_LIST = new ArrayList<>();

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Shot(int posX, int posY, int actorSpeed) {
    super(posX, posY, actorSpeed);
    setMoveUp(false);
    setWidth(3);
    setHeight(7);
  }


  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void addShotToBoard(Graphics graphics, Color color) {
      graphics.setColor(color);
      graphics.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
    }


  public void moveShot() {
    if (isMoveUp()) {
      moveShotUp();
    }
  }

  int moveShotUp() {
    int shotY = getPosY();
    int yMinusSpeed = shotY - actorSpeed;
    setPosY(yMinusSpeed);

    return getPosY();
  }


  public String toString() {
    return "Shot{" +
           "width=" + width +
           ", height=" + height +
           ", posX=" + posX +
           ", posY=" + posY +
           ", actorSpeed=" + actorSpeed +
           ", moveRight=" + moveRight +
           ", moveLeft=" + moveLeft +
           ", moveUp=" + moveUp +
           ", color=" + color +
           ", SHOT_ARRAY_LIST=" + SHOT_ARRAY_LIST +
           ", bounds=" + getBounds() +
           ", moveRight=" + isMoveRight() +
           ", moveLeft=" + isMoveLeft() +
           ", color=" + getColor() +
           ", readyForRemoval=" + isReadyForRemoval() +
           ", width=" + getWidth() +
           ", height=" + getHeight() +
           ", actorSpeed=" + getActorSpeed() +
           ", posY=" + getPosY() +
           ", posX=" + getPosX() +
           ", moveUp=" + isMoveUp() +
           '}';
  }
}
