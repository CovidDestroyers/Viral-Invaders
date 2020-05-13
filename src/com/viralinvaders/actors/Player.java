package com.viralinvaders.actors;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends Actor {

  private boolean moveRight;
  private boolean moveLeft;

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

  public void addPlayerToBoard(Graphics graphics) {
    graphics.setColor(Color.RED);
    graphics.fillRect(getPosX(), getPosY(), 20, 20);
  }


  public void movePlayer(Player player) {
    if (player.isMoveRight()) {
      movePlayerRight(player);
    }

    if (player.isMoveLeft()) {
      movePlayerLeft(player);
    }
  }


  // TODO: Look this over again for ideas on collision detection
  // public boolean checkWasHit(int xShot, int yShot) {
  //   if ((xShot >= posX) && (xShot <= (posX + width))) {
  //     if ((yShot >= posY) && (yShot <= (posY + height))) {
  //       wasHit = true;
  //
  //       System.out.println("You were hit!");
  //       return true;
  //     }
  //   }
  //   return false;
  // }

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS

  public void setMoveLeft(boolean moveLeft) {
    this.moveLeft = moveLeft;
  }


  public void setMoveRight(boolean moveRight) {
    this.moveRight = moveRight;
  }


  // GET METHODS
  public boolean isMoveLeft() {
    return moveLeft;
  }

  public boolean isMoveRight() {
    return moveRight;
  }

  /*
   * =============================================
   * =========== Private Methods ================
   * =============================================
   */
  private void movePlayerRight(Player player) {
    int playerX = player.getPosX();
    int xPlusSpeed = playerX + player.getActorSpeed();

    player.setPosX(xPlusSpeed);
  }

  private void movePlayerLeft(Player player) {
    int playerX = player.getPosX();
    int xMinusSpeed = playerX - player.getActorSpeed();

    player.setPosX(xMinusSpeed);
  }

}
