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
    int posX = 15;
    int posY = 30;
    int newRowCount = 11;

    for (int i = 0; i < 96; i++) {
      virus = new Virus(posX, posY, 10);
      army.add(virus);

      posX += 40;
      if (i == newRowCount) {
        posX = 15;
        posY += 40;

        newRowCount += 12;
      }
    }
  }


  public void addVirusToBoard(Graphics graphics, Color color) {
    for (Virus virus : army) {
      graphics.setColor(color);
      graphics.fillRect(virus.getPosX(), virus.getPosY(), 30, 30);
    }

  }



}
