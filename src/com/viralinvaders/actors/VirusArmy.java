package com.viralinvaders.actors;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class VirusArmy {
  private Virus virus;
  private ArrayList<Virus> army = new ArrayList<>(10);

  public VirusArmy() {
    // TODO: Initliase virus army here
    createVirusArmy();
  }


  public void createVirusArmy() {
    int posX = 55;
    int posY = 30;
    int newRowCount = 9;

    for (int i = 0; i < 80; i++) {
      virus = new Virus(posX, posY, 10);
      army.add(virus);

      posX += 40;
      if (i == newRowCount) {
        posX = 55;
        posY += 40;

        newRowCount += 10;
      }
    }
  }


  public void addVirusToBoard(Graphics graphics, Color color) {
    for (Virus virus : army) {
      graphics.setColor(color);
      graphics.fillRect(virus.getPosX(), virus.getPosY(), 30, 30);
    }
  }


  public void moveArmy() {

  }



}
