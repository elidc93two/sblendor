package com.phinians.sblendor.gameplay

import com.phinians.sblendor.model.{Development, Gem}

sealed trait PlayerAction
case class BuyDevelopment(development: Development) extends PlayerAction
case class ReserveDevelopment(development: Development) extends PlayerAction
case class Get2SameGems(gem: Gem) extends PlayerAction
case class Get3DifferentGems(gem1: Gem, gem2: Gem, gem3: Gem) extends PlayerAction

sealed trait PlayResult
case object Success extends PlayResult
case object Failed extends PlayResult
case class Success(action: PlayerAction) extends PlayResult
case class Failed(action: PlayerAction, reason: String) extends PlayResult
