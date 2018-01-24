package com.phinians.sblendor.gameplay

import com.phinians.sblendor.points.{Development, Gem}

sealed trait Action

case class BuyDevelopment(development: Development) extends Action
case class ReserveDevelopment(development: Development) extends Action
case class Get2SameGems(gem: Gem) extends Action
case class Get3DifferentGems(gems: Gem*) extends Action

case object StartTurn extends Action
case object EndTurn extends Action

sealed trait Result
