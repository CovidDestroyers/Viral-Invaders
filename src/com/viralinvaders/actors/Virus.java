package com.viralinvaders.actors;

public class Virus extends Actor {

  private boolean moveRight;
  private boolean moveLeft;
  private boolean isVisible;

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Virus(int posX, int posY, int actorSpeed) {
    super(posX, posY, actorSpeed);

    setMoveLeft(false);
    setMoveRight(true);
    setVisible(true);
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

  public void setVisible(boolean visible) {
    isVisible = visible;
  }


  // GET METHODS
  public boolean isMoveLeft() {
    return moveLeft;
  }

  public boolean isMoveRight() {
    return moveRight;
  }

  public boolean isVisible() {
    return isVisible;
  }
}
