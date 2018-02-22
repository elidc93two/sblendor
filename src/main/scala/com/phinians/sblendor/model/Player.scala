package com.phinians.sblendor.model

import scala.collection.mutable.ListBuffer

//Note: Player.play(Action, GameTable) => (Result, PlayedAction)

case class Player(name: String,
                  points: PrestigePoints = 0,
                  boughtDevs: Set[Development] = Set.empty,
                  reservedDevs: Set[Development] = Set.empty,
                  nobleVisits: Set[Noble] = Set.empty,
                  tokens: ListBuffer[Token] = ListBuffer.empty)