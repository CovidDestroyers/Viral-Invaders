package com.viralinvaders.actors;

public class Player extends Actor {

  private boolean moveRight;
  private boolean moveLeft;

  /*
   * =============================================
   * ============= Constructors ==================
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

}
