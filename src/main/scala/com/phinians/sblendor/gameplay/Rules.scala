package com.phinians.sblendor.gameplay

import com.phinians.sblendor.model._
import com.phinians.sblendor.repositories.{Players, Tokens}

trait Rules {

  def setup(players: Player*): PlayResult = {
    if (playersAreMoreThanOne(players) & playersAreLessThanFour(players)) {
      Players.list = players
      Tokens.init(players.size)
      Success
    } else Failed
  }

  //could use Either[Boolean, ErrorMessage]
  def playersAreMoreThanOne(list: Seq[Player]): Boolean = list.lengthCompare(1) > 0
  def playersAreLessThanFour(list: Seq[Player]): Boolean = list.lengthCompare(4) <= 0
  def gemIsNotDuplicated(gems: Gem*): Boolean = gems.size == gems.toSet.size
  def gemIsAvailable(gem: Gem): Boolean = {
    gem match {
      case Emerald => Tokens.emerald != 0
      case Diamond => Tokens.diamond != 0
      case Onyx => Tokens.onyx != 0
      case Ruby => Tokens.ruby != 0
      case Sapphire => Tokens.sapphire != 0
      case _ => false
    }
  }
  def gemHasAtLeastFour(gem: Gem): Boolean = {
    gem match {
      case Emerald => Tokens.emerald >= 4
      case Diamond => Tokens.diamond >= 4
      case Onyx => Tokens.onyx >= 4
      case Ruby => Tokens.ruby >= 4
      case Sapphire => Tokens.sapphire >= 4
      case _ => false
    }
  }

  def get3DifferentGems(who: Player, action: Get3DifferentGems): PlayResult = {
    val check1 = List(gemIsAvailable(action.gem1), gemIsAvailable(action.gem2), gemIsAvailable(action.gem3)).reduce(_&_)
    val check2 = gemIsNotDuplicated(action.gem1, action.gem2, action.gem3)
    if (check1 && check2) Success(action)
    else Failed(action, s"wenk wenk wenk $check1")
  }

  def get2SameGems(who: Player, action: Get2SameGems): PlayResult = {
    val check = gemHasAtLeastFour(action.gem)
    if (check) Success(action)
    else Failed(action, "boink boink boink")
  }

  // end phase

  def decrease3DifferentGems(who: Player, action: Get3DifferentGems): PlayResult = {
    val gems = List(action.gem1, action.gem2, action.gem3)
    gems.foreach {
      case Emerald => Tokens.emerald -= 1
      case Diamond => Tokens.diamond -= 1
      case Onyx => Tokens.onyx -= 1
      case Ruby => Tokens.ruby -= 1
      case Sapphire => Tokens.sapphire -= 1
      case _ => ???
    }
    Success
  }

  def decrease2SameGems(who: Player, action: Get2SameGems): PlayResult = {
    action.gem match {
      case Emerald => Tokens.emerald -= 2
      case Diamond => Tokens.diamond -= 2
      case Onyx => Tokens.onyx -= 2
      case Ruby => Tokens.ruby -= 2
      case Sapphire => Tokens.sapphire -= 2
      case _ => ???
    }
    Success
  }
}
