package com.phinians.sblendor.util

import com.phinians.sblendor.points._

object Shuffler {

  def shuffleDevelopments(): (Set[Development], Set[Development], Set[Development]) = {

    val tier1 = Set(Development(bonus = Emerald, 0, Emerald))

    val tier2 = Set(Development(bonus = Emerald, 2, Emerald, Onyx))

    val tier3 = Set(Development(bonus = Emerald, 5, Emerald, Onyx, Sapphire))

    (tier1, tier2, tier3)
  }

  def shuffleNobles(count: Int): Set[Noble] = {

    Set(Noble(prestigePoints = 8, Emerald, Emerald, Emerald))

  }

  def setupTokens(count: Int): List[Token] = {

    List(Emerald, Emerald, Onyx, Sapphire, Gold)

  }

}
