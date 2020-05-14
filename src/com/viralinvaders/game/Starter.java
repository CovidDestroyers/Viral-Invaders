package com.viralinvaders.game;

import com.viralinvaders.actors.Actor;
import com.viralinvaders.actors.Shot;

import javax.swing.JFrame;
import java.util.concurrent.CompletableFuture;

public class Starter extends JFrame {


  public Starter() {
    Board board = new Board();
    CompletableFuture.runAsync(board);
    add(board);
    setTitle("Viral Invaders");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(false);
  }


  public static void main(String[] args) {
    new Starter();
  }

}
