package com.viralinvaders.actors;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ShotTest {

  public Shot shot = new Shot(155,25, 20);



  @Test
  public void testMoveShot() {
    assertEquals(5, shot.moveShotUp());
  }



  @Test
  public void testMoveShotFalse(){
    shot.setMoveUp(false);
    assertFalse(shot.moveUp);
  }



  @Test
  public void testIsMoveUp() {
    shot.moveUp = true;
    shot.moveShot();
    assertTrue(shot.isMoveUp());
  }
}
