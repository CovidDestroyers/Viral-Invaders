package com.viralinvaders.game;

import com.viralinvaders.actors.VirusArmy;

import javax.swing.JFrame;

public class Starter extends JFrame {

  VirusArmy army = null;


  public Starter() {
    add(new Board());
    setTitle("Board");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(false);
  }


  public static void main(String[] args) {
    new Starter();
  }

  public VirusArmy getVirusArmy() {
    return army;
  }

}
