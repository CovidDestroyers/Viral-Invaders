package com.viralinvaders.actors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTest {
  Player player;

  @Before
  public void setUp() throws Exception {
    player = new Player(250, 250, 5);
  }

  @Test
  public void testMoveActorRight() {
    player.moveActorRight();
    assertEquals(255, player.getPosX());
  }

  @Test
  public void moveActorLeft() {
  }

  @Test
  public void getBounds() {
  }
}
