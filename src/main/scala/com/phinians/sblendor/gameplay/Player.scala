package com.phinians.sblendor.gameplay

import com.phinians.sblendor.consumables.{Development, Gem, Noble}

//Note: Player.play(Action, GameTable) => (Result, PlayedAction)

case class Player(name: String,
                  acquiredPrestigePoints: Int = 0,
                  boughtDevs: Set[Development] = Set.empty,
                  reservedDevs: Set[Development] = Set.empty,
                  nobleVisits: Set[Noble] = Set.empty) {

  def play(action: Action, gameTable: GameTable) = {
    action match {
      case Get3DifferentGems(gem1, gem2, gem3) => {
        val thereIsAGem: Gem => Boolean = gem => gameTable.tokens.count(_ == gem) > 0
        List(gem1, gem2, gem3) map { g =>
          if (thereIsAGem(g)) {
            gameTable.removeGem(g)
          } else {
            throw new Exception(s"Unable to get because it has 0")
          }
        }
      }
      case _ => throw new Exception("what do you want to do in life young Jedi?")
    }
    println(s"the all new game table ${gameTable.tokens}")
  }
}