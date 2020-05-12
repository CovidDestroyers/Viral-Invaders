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
      virus = new Virus(posX, posY, 10);
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
    moveArmy();
  }


  public void moveArmy() {
    for (Virus virus : VIRUS_ARMY) {
      int virusLocationXaxis = virus.getPosX();
      int virusSpeed = virus.getActorSpeed();

      if (virus.isMoveRight()) {
        virus.setPosX(virusLocationXaxis += virusSpeed);
        // System.out.println(virus.getPosX());
        System.out.println(virus.posX);
      }

      if (virus.isMoveLeft()) {
        virus.setPosX(virusLocationXaxis -= virusSpeed);
        System.out.println("Position Y: " + virus.getPosX());
      }

      // Check bounds and if at 500px, go the other direction
      if ( virusLocationXaxis >= Board.BOARD_WIDTH) {
        for (Virus virus1 : VIRUS_ARMY) {
          virus1.setMoveLeft(true);
          virus1.setMoveRight(false);
        }
      }

      if (virusLocationXaxis <= 0) {
        for (Virus virus1 : VIRUS_ARMY) {
          virus1.setMoveLeft(false);
          virus1.setMoveRight(true);
        }
      }
    }


  }


  public boolean checkWasHit(int xPos, int shotHeight) {
    return true;
  }
}
