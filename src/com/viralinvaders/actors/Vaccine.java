package com.viralinvaders.actors;

import com.viralinvaders.game.Board;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Vaccine {
  private double vaccineSpeed;
  private int MAX_HEIGHT = 500;
  private double x;
  private double y;

  BufferedImage image;

  public Vaccine(double x, double y, Board board){
    this.x = x;
    this.y = y;
    SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());

    ss.grabImage(1,2,32,32);
  }

  public void speed(){
    y -= 5;
  }

  public void draw(Graphics g){

  }
}
