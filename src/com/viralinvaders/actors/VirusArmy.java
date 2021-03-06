package com.viralinvaders.actors;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

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
      Virus virus = new Virus(posX, posY, 2);

      virusArmy.add(virus);
      posX += 40;

      if (i == newRowCount) {
        posX = 55;
        posY += 40;
        newRowCount += 10;
      }
    }
  }


  public void addArmyToBoard(Graphics graphics) {
    for (int i = 0; i < virusArmy.size(); i++) {
      Virus virus = virusArmy.get(i);

      if (virus.isReadyForRemoval()) {
        virusArmy.remove(virus);
      }
      else {
        virus.addVirusToBoard(graphics);
      }
    }
  }


  public void moveArmy() {
    for (Virus virus : virusArmy) {
      if (virus.isMoveRight()) {
        virus.moveActorRight();
      }

      if (virus.isMoveLeft()) {
        virus.moveActorLeft();
      }
    }
    checkBounds();
  }

  public void checkArmyForHits(Shot shot) {
    for (Virus virus : virusArmy) {
      virus.checkVirusWasHit(shot);
    }
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


  public int size() {
    return virusArmy.size();
  }

  public Collection<? extends Actor> getArmy() {
    return virusArmy;
  }


  @Override
  public String toString() {
    return "VirusArmy{" +
           "virusArmy=" + getArmy() +
           ", size=" + size() +
           '}';
  }
}
