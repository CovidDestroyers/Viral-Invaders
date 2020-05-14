package com.viralinvaders.actors;

import java.awt.*;

public abstract class Actor {

  protected int width;
  protected int height;
  protected int posX;
  protected int posY;
  protected int actorSpeed;

  protected boolean moveRight;
  protected boolean moveLeft;
  protected boolean moveUp;
  protected Color color;

  private boolean readyForRemoval;



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

  public Actor(int posX, int posY, int actorSpeed, int width, int height, Color color) {
    this(posX, posY, actorSpeed, width, height);
    setColor(color);
  }


  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */
  public void addToBoard(Graphics graphics, Color color) {
    graphics.setColor(color);
    graphics.fillRect(getPosX(), getPosY(), getWidth(), getHeight());
  }

  public void addToBoard(Graphics graphics, Color color, int width, int height) {
    graphics.setColor(color);
    graphics.fillRect(getPosX(), getPosY(), width, height);
  }


  protected void moveActorRight() {
    int currentXPos = this.getPosX();
    int xPlusSpeed = currentXPos + this.getActorSpeed();

    this.setPosX(xPlusSpeed);
  }

  protected void moveActorLeft() {
    int currentXPos = this.getPosX();
    int xMinusSpeed = currentXPos- this.getActorSpeed();

    this.setPosX(xMinusSpeed);
  }

  public Rectangle getBounds() {
    return new Rectangle(getPosX(),getPosY(),getWidth(), getHeight());
  }



  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public void setActorSpeed(int actorSpeed) {
    this.actorSpeed = actorSpeed;
  }


  public void setHeight(int height) {
    this.height = height;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public void setReadyForRemoval(boolean readyForRemoval) {
    this.readyForRemoval = readyForRemoval;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public void setMoveLeft(boolean moveLeft) {
    this.moveLeft = moveLeft;
  }

  public void setMoveRight(boolean moveRight) {
    this.moveRight = moveRight;
  }

  public void setMoveUp(boolean moveUp) {
    this.moveUp = moveUp;
  }


  // GET METHODS
  public boolean isMoveRight() {
    return moveRight;
  }

  public boolean isMoveLeft() {
    return moveLeft;
  }

  public Color getColor() {
    return color;
  }

  public boolean isReadyForRemoval() {
    return readyForRemoval;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getActorSpeed() {
    return actorSpeed;
  }

  public int getPosY() {
    return posY;
  }

  public int getPosX() {
    return posX;
  }

  public boolean isMoveUp() {
    return moveUp;
  }


  @Override public String toString() {
    return "Actor{" +
           "width=" + width +
           ", height=" + height +
           ", posX=" + posX +
           ", posY=" + posY +
           ", actorSpeed=" + actorSpeed +
           ", moveRight=" + moveRight +
           ", moveLeft=" + moveLeft +
           ", moveUp=" + moveUp +
           ", color=" + color +
           ", readyForRemoval=" + readyForRemoval +
           '}';
  }
}
