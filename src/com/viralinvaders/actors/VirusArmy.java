package com.viralinvaders.actors;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class VirusArmy {
  private ArrayList<Virus> virusArmy = new ArrayList<>();

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public VirusArmy() {
    createVirusArmy();
  }


  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */
  public void createVirusArmy() {
    int posX = 55;
    int posY = 30;
    int newRowCount = 9;

    for (int i = 0; i < 80; i++) {
      Virus virus = new Virus(posX, posY, 3);
      virusArmy.add(virus);

      posX += 40;
      if (i == newRowCount) {
        posX = 55;
        posY += 40;

        newRowCount += 10;
      }
    }
  }


  public void addArmyToBoard(Graphics graphics, Color color) {
    for (Virus virus : virusArmy) {
      virus.addVirusToBoard(graphics);
    }
  }


  public void moveArmy() {
    for (Virus virus : virusArmy) {
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

    checkBounds();
  }


  /*
   * =============================================
   * =========== Private Methods ================
   * =============================================
   */
  private void checkBounds() {
    for (Virus virus : virusArmy) {
      checkRightSideBound(virus);
      checkLeftSideBound(virus);
    }
  }

  private void checkRightSideBound(Virus virus) {
    if (virus.getPosX() >= 470) {
      setLeftRightTrueFalseForArmy(true, false);
    }
  }

  private void checkLeftSideBound(Virus virus) {
    if (virus.getPosX() <= 5) {
      setLeftRightTrueFalseForArmy(false, true);
    }
  }

  private void setLeftRightTrueFalseForArmy(boolean moveLeft, boolean moveRight) {
    for (Virus virus1 : virusArmy) {
      virus1.setMoveLeft(moveLeft);
      virus1.setMoveRight(moveRight);
    }
  }



}
