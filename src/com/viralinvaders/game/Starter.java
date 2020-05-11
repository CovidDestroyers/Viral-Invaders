package com.viralinvaders.game;

import javax.swing.JFrame;

public class Starter extends JFrame {

  public Starter() {
    add(new Board());
    setTitle("Board");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(true);
  }


  public static void main(String[] args) {
    new Starter();
  }

}
