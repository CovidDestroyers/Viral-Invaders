package com.viralinvaders.actors;

import java.awt.*;

public class Actor {

  protected int width;
  protected int height;

  protected int posX;
  protected int posY;
  protected int actorSpeed;

  private boolean setForRemoval;


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

  public Actor(int posX, int posY, int actorSpeed, int width, int height) {
    this(posX, posY, actorSpeed);
    setWidth(width);
    setHeight(height);
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

  public boolean isSetForRemoval() {
    return setForRemoval;
  }

  public void setSetForRemoval(boolean setForRemoval) {
    this.setForRemoval = setForRemoval;
  }


}
