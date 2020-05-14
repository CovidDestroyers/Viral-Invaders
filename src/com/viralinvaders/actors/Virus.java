package com.viralinvaders.actors;

import java.awt.*;

public class Virus extends Actor {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Virus(int posX, int posY, int actorSpeed) {
    super(posX, posY, actorSpeed);

    setMoveLeft(false);
    setMoveRight(true);
    setReadyForRemoval(false);
    setWidth(30);
    setHeight(30);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */
  public void addVirusToBoard(Graphics graphics) {
    graphics.setColor(Color.GREEN);
    graphics.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
  }


  public void checkVirusWasHit(Shot shot) {
    if (getBounds().intersects(shot.getBounds())) {
      System.out.println("You were hit");
      setReadyForRemoval(true);
    }
  }


  @Override
  public String toString() {
    return "Virus{" +
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
