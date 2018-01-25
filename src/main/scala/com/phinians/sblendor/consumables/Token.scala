package com.phinians.sblendor.consumables

sealed trait Token
sealed trait Gem extends Token

case object Ruby extends Gem
case object Sapphire extends Gem
case object Emerald extends Gem
case object Onyx extends Gem
case object Gold extends Token