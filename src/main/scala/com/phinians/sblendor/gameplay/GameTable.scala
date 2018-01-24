package com.phinians.sblendor.gameplay

import com.phinians.sblendor.points.{Development, Gem, Noble, Token}
import com.phinians.sblendor.util.Shuffler

class GameTable(players: Player*) {

  private var _tier1: Set[Development] = Set.empty
  private var _tier2: Set[Development] = Set.empty
  private var _tier3: Set[Development] = Set.empty
  private var _tokens: List[Token] = List.empty
  private var _nobles: Set[Noble] = Set.empty
  private var _players: List[Player] = List.empty
  private var _history: List[Action] = List.empty

  private def setup(): Unit = {
    val playersCount: Int = setPlayers(players:_*).size
    shuffleDevelopments()
    shuffleNobles(playersCount)
    setTokens(playersCount)
  }

  private def setPlayers(players: Player*): List[Player] = {
    _players ++ players
  }

  private def shuffleDevelopments(): Unit = {
    val developments = Shuffler.shuffleDevelopments()
    _tier1 = developments._1
    _tier2 = developments._2
    _tier3 = developments._3
  }

  private def shuffleNobles(count: Int): Unit = {
    _nobles = Shuffler.shuffleNobles(count)
  }

  private def setTokens(count: Int): Unit = {
    _tokens = Shuffler.setupTokens(count)
  }

  private def getTokens(action: Action): Gem = {
    action match {
      case Get2SameGems(gem: Gem) => gem
      case Get3DifferentGems(gems: Gem) => gems
    }
  }

  def evaluate(action: Action): String = {
    action match {
      case BuyDevelopment(dev) =>
        println(s"$dev bought, is player's gem enough, put on the players bought")
        "bought, is player's gem enough, put on the players bought"
      case ReserveDevelopment(dev) =>
        println(s"$dev reserve, give gold")
        "reserve, give gold"
      case Get2SameGems(gem) =>
        println(s"get 2 $gem")
        "get 2"
      case Get3DifferentGems(gems) =>
        Token.evaluate(_tokens, gems)
        println(s"get 3 $gems")
        "get 3"
      case _ => ""
    }
  }
}
