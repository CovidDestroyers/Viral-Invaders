package com.viralinvaders.actors;

import java.awt.*;

public class Actor {

  private boolean setForRemoval;
  protected int height;
  protected int width;

  protected int posX;
  protected int posY;
  protected int actorSpeed;

  protected boolean isVisible;


  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Actor() {

  }

  public Actor(int posX, int posY, int actorSpeed) {
    setPosX(posX);
    setPosY(posY);
    setActorSpeed(actorSpeed);
  }


  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public int getActorSpeed() {
    return actorSpeed;
  }

  public void setActorSpeed(int actorSpeed) {
    this.actorSpeed = actorSpeed;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public boolean isVisible() {
    return isVisible;
  }

  public void setVisible(boolean visible) {
    isVisible = visible;
  }


}
