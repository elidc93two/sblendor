package com.phinians.sblendor.gameplay

import com.phinians.sblendor.consumables.{Development, Gem, Noble, Token}
import com.phinians.sblendor.util.Shuffler

import scala.collection.mutable.ListBuffer

object GameTable {
  def apply(players: List[Player]): GameTable = {
    val gameTable = new GameTable()
    gameTable.setup(players)
    gameTable
  }

}

class GameTable() {

  private var _tier1: Set[Development] = Set.empty
  private var _tier2: Set[Development] = Set.empty
  private var _tier3: Set[Development] = Set.empty
  private var _tokens: ListBuffer[Token] = ListBuffer.empty
  private var _nobles: Set[Noble] = Set.empty
  private var _players: List[Player] = List.empty
  private var _history: List[Action] = List.empty

  def setup(players: List[Player]): Unit = {
    val playersCount: Int = setPlayers(players).size
    shuffleDevelopments()
    shuffleNobles(playersCount)
    setTokens(playersCount)
  }

  private def setPlayers(players: List[Player]) = {
    _players ++= players
    _players
  }

  private def shuffleDevelopments(): Unit = {
    val developments = Shuffler.shuffleDevelopments()
    _tier1 = developments._1
    _tier2 = developments._2
    _tier3 = developments._3
  }

  private def shuffleNobles(count: Int): Set[Noble] = {
    _nobles = Shuffler.shuffleNobles(count)
    _nobles
  }

  private def setTokens(count: Int): List[Token] = {
    _tokens ++= Shuffler.setupTokens(count)
    _tokens.toList
  }

  def tokens: List[Token] = {
    _tokens.toList
  }

  def removeGem(gem: Gem) = {
    _tokens -= gem
  }


}
