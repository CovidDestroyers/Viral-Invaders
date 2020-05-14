package com.viralinvaders.actors;

import java.awt.*;

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
  public void addVirusToBoard(Graphics graphics) {
    graphics.setColor(Color.GREEN);
    graphics.fillRect(getPosX(), getPosY(), 30, 30);
  }

  // public void moveVirus(Virus v)



  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  public void setVisible(boolean visible) {
    isVisible = visible;
  }


  public boolean isVisible() {
    return isVisible;
  }


  @Override
  public String toString() {
    return "Virus{" +
           "moveRight=" + moveRight +
           ", moveLeft=" + moveLeft +
           ", isVisible=" + isVisible +
           ", visible=" + isVisible() +
           "} " + super.toString();
  }
}
