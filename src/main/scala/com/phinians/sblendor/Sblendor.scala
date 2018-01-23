package com.phinians.sblendor

import com.phinians.sblendor.Action.{Action, Get2SameGems, Get3DifferentGems}
import com.phinians.sblendor.Token.{Gem, Token}

object Token {
  sealed trait Token

  sealed trait Gem extends Token
  case object Ruby extends Gem
  case object Sapphire extends Gem
  case object Emerald extends Gem
  case object Onyx extends Gem

  case object Gold extends Token
}

object Action {
  sealed trait Action

  case object BuyDevelopment extends Action
  case object ReserveDevelopment extends Action
  case class Get2SameGems(gem: Gem) extends Action
  case class Get3DifferentGems(gems: Gem*) extends Action
}


class Board() {
  private var tier1: Set[Development] = Set.empty
  private var tier2: Set[Development] = Set.empty
  private var tier3: Set[Development] = Set.empty
  private var tokens: List[Token] = List.empty
  private var nobles: Set[Noble] = Set.empty
  private var p_players: List[Player] = List.empty
  private var history: List[Action] = List.empty

  def setCards(t1: Set[Development], t2: Set[Development], t3: Set[Development]): Unit = {
    tier1 = t1
    tier2 = t2
    tier3 = t3
  }

  def setTokens(tkns: List[Token], nbl: Set[Noble], ply: List[Player]) = {
    tokens = tkns
    nobles = nbl
    p_players = ply
  }

  def getTokens(action: Action): Gem = {
    action match {
      case Get2SameGems(gem: Token.Gem) => gem
      case Get3DifferentGems(gems: Token.Gem) => gems
    }
  }

  def players = p_players
}

case class Player(name: String,
                acquiredPrestigePoints: Int,
                boughtDevs: Set[Development],
                reservedDevs: Set[Development],
                nobleVisits: Set[Noble])

case class Development(bonus: Token, prestigePoints: Int, cost: Token*)

case class Noble(prestigePoints: Int, cost: Token*)

case class PlayedAction(who: Player, what: Action)

