package com.viralinvaders.actors;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VirusArmy {
  private Virus virus;
  private ArrayList<Virus> army = new ArrayList<>(10);

  public VirusArmy() {
    // TODO: Initliase virus army here
    createVirusArmy();
  }


  public ArrayList<Virus> createVirusArmy() {
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
    return  army;
  }


  public void addVirusToBoard(Graphics graphics) {
    for (Virus virus : army) {
      graphics.setColor(Color.GREEN);
      graphics.fillRect(virus.getPosX(), virus.getPosY(), 30, 30);
    }

  }



}
