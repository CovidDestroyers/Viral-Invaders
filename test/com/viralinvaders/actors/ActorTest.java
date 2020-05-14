package com.viralinvaders.actors;

import com.viralinvaders.actors.Player;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

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
  public void testMoveActorLeft() {
    player.moveActorLeft();
    assertEquals(245, player.getPosX());
  }

  @Test
  public void testGetBounds() {
    player.setWidth(45);
    player.setHeight(75);

    Rectangle playerBounds = player.getBounds();

    assertEquals(250, playerBounds.getX(), .001);
    assertEquals(250, playerBounds.getY(), .001);
    assertEquals(45, playerBounds.getWidth(), .001);
    assertEquals(75, playerBounds.getHeight(), .001);
  }
}
