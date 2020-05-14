package com.viralinvaders.actors;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends Actor {

  /*
   * =============================================
   * ============= Constructor ==================
   * =============================================
   */
  public Player(int posX, int posY, int actorSpeed) {
    super(posX, posY, actorSpeed);
    setMoveLeft(false);
    setMoveRight(false);
  }


  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void addToBoard(Graphics graphics) {
    graphics.setColor(Color.RED);
    graphics.fillRect(getPosX(), getPosY(), 20, 20);
  }


  public void movePlayer() {
    if (this.isMoveRight()) {
      movePlayerRight();
    }

    if (this.isMoveLeft()) {
      movePlayerLeft();
    }
  }

  /*
   * =============================================
   * =========== Private Methods ================
   * =============================================
   */
  private void movePlayerRight() {
    int playerX = this.getPosX();
    int xPlusSpeed = playerX + this.getActorSpeed();

    this.setPosX(xPlusSpeed);
  }

  private void movePlayerLeft() {
    int playerX = this.getPosX();
    int xMinusSpeed = playerX - this.getActorSpeed();

    this.setPosX(xMinusSpeed);
  }


  @Override
  public String toString() {
    return "Player{" +
           "width=" + width +
           ", height=" + height +
           ", posX=" + posX +
           ", posY=" + posY +
           ", actorSpeed=" + actorSpeed +
           ", moveRight=" + moveRight +
           ", moveLeft=" + moveLeft +
           ", moveUp=" + moveUp +
           ", color=" + color +
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
