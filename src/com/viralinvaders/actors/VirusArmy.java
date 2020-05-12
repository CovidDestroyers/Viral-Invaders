package com.viralinvaders.actors;

import com.viralinvaders.game.Board;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class VirusArmy {
  private Virus virus;
  public static final ArrayList<Virus> VIRUS_ARMY = new ArrayList<>();

  public VirusArmy() {
    // TODO: Initliase virus army here
    createVirusArmy();
  }


  public void createVirusArmy() {
    int posX = 55;
    int posY = 30;
    int newRowCount = 9;

    for (int i = 0; i < 80; i++) {
      virus = new Virus(posX, posY, 3);
      VIRUS_ARMY.add(virus);

      posX += 40;
      if (i == newRowCount) {
        posX = 55;
        posY += 40;

        newRowCount += 10;
      }
    }
  }


  public void addArmyToBoard(Graphics graphics, Color color) {
    for (Virus virus : VIRUS_ARMY) {
      graphics.setColor(color);
      graphics.fillRect(virus.getPosX(), virus.getPosY(), 30, 30);
    }
    // moveArmy();
  }


  public void moveArmy() {
    for (Virus virus : VIRUS_ARMY) {
      int virusLocationXaxis = virus.getPosX();
      int virusSpeed = virus.getActorSpeed();

      if (virus.isMoveRight()) {
        int z = virusLocationXaxis + virusSpeed;
        virus.setPosX(z);
      }

      if (virus.isMoveLeft()) {
        int k = virusLocationXaxis - virusSpeed;
        virus.setPosX(k);
      }
    }

    // Check bounds and if at 500px, go the other direction
    for (Virus virus : VIRUS_ARMY) {
      int virusNewX = virus.getPosX();

      if (virusNewX >= 470) {
        for (Virus virus1 : VIRUS_ARMY) {
          virus1.setMoveLeft(true);
          virus1.setMoveRight(false);
        }
      }

      if (virusNewX <= 5) {
        for (Virus virus1 : VIRUS_ARMY) {
          virus1.setMoveLeft(false);
          virus1.setMoveRight(true);
        }
      }
    }
    // end of bounds check

  }


  public boolean checkWasHit(int xPos, int shotHeight) {
    return true;
  }
}
