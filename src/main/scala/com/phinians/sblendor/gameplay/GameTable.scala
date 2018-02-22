package com.phinians.sblendor.gameplay

import com.phinians.sblendor.model._

object GameTable extends Rules {

  def mainPhase(who: Player, what: PlayerAction): PlayResult = {
    println(s"TURN: Player ${who.name}, Action: $what")
    what match {
      case action: Get3DifferentGems => get3DifferentGems(who, action)
      case action: Get2SameGems => get2SameGems(who, action)
      case _ => throw new Exception("what do you want to do in life young Padawan?")
    }
  }

  // after player ends turn, board should reflect the changes in the global variable
  def endPhase(who: Player, result: PlayResult) = {
    println(s"TURN: Player ${who.name}, Action: $result")
    result match {
      case Success(action: Get3DifferentGems) => decrease3DifferentGems(who, action)
      case Success(action: Get2SameGems) => decrease2SameGems(who, action)
      case e: Failed => throw new Exception(s"use the force because failed: ${e.reason}")
    }
  }

}