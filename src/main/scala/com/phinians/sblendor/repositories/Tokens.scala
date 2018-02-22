package com.phinians.sblendor.repositories

object Tokens {

  var gold: Int = 5

  var diamond: Int = 0
  var emerald: Int = 0
  var onyx: Int = 0
  var ruby: Int = 0
  var sapphire: Int = 0

  def init(count: Int): Unit = {
    diamond = 3 + count
    emerald = 3 + count
    onyx = 3 + count
    ruby = 3 + count
    sapphire = 3 + count
  }

}
