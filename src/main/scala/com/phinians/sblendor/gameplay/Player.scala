package com.phinians.sblendor.gameplay

import com.phinians.sblendor.consumables.{Development, Gem, Noble, Token}

import scala.collection.mutable.ListBuffer

//Note: Player.play(Action, GameTable) => (Result, PlayedAction)

case class Player(name: String,
                  acquiredPrestigePoints: Int = 0,
                  boughtDevs: Set[Development] = Set.empty,
                  reservedDevs: Set[Development] = Set.empty,
                  nobleVisits: Set[Noble] = Set.empty,
                  tokens: ListBuffer[Token]) {

  import GemChecks._

  def play(action: Action, gameTable: GameTable) = {
    action match {
      case Get3DifferentGems(gem1, gem2, gem3) =>
        List(gem1, gem2, gem3) map { g =>
          if (isAvailableToGet(g, gameTable.tokens)) {
            this.tokens += g
            gameTable.removeGem(g)
          } else {
            throw new Exception(s"Unable to get because it has 0")
          }
        }
      case Get2SameGems(gem) =>

        List(gem, gem) map { g =>
          if (isAvailableToGet(g, gameTable.tokens) && isMoreThan4(g, gameTable.tokens)) {
            this.tokens += g
            gameTable.removeGem(g)
          } else {
            throw new Exception(s"Unable to get because it has 0")
          }
        }
      case _ => throw new Exception("what do you want to do in life young Jedi?")
    }
    println(s"the all new game table ${gameTable.tokens}")
  }
}

object GemChecks {
  //TODO: could use composition here and currying
  val isAvailableToGet: (Gem, List[Token]) => Boolean = (gem, repository) => repository.count(_ == gem) > 0
  val isMoreThan4: (Gem, List[Token]) => Boolean = (gem, repository) => repository.count(_ == gem) >= 4
}
