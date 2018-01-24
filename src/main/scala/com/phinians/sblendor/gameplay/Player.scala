package com.phinians.sblendor.gameplay

import com.phinians.sblendor.points.{Development, Noble}

//Note: Player.play(Action, GameTable) => (Result, PlayedAction)

case class Player(name: String,
                  acquiredPrestigePoints: Int = 0,
                  boughtDevs: Set[Development] = Set.empty,
                  reservedDevs: Set[Development] = Set.empty,
                  nobleVisits: Set[Noble] = Set.empty) {

  def play(action: Action, gameTable: GameTable): String = {
    gameTable.evaluate(action)
  }
}