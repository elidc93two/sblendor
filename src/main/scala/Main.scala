import com.phinians.sblendor._

object Main extends App {
  println("Hello, World!")

  val tier1 = Set(Development(bonus = Token.Emerald, 0, Token.Emerald))

  val tier2 = Set(Development(bonus = Token.Emerald, 2, Token.Emerald, Token.Onyx))

  val tier3 = Set(Development(bonus = Token.Emerald, 5, Token.Emerald, Token.Onyx, Token.Sapphire))

  val nobles = Set(Noble(prestigePoints = 8, Token.Emerald, Token.Emerald, Token.Emerald))

  val players = List(Player("Mang Tacio", 0, Set.empty, Set.empty, Set.empty))

  val tokens = List(Token.Emerald, Token.Emerald, Token.Onyx, Token.Sapphire)

  val play =new Board()
  play.setCards(tier1, tier2, tier3)
  play.setTokens(tokens, nobles, players)


  val noWinner: Boolean = !play.players.exists(_.acquiredPrestigePoints >= 15)

  while (noWinner) {
    println(play.getTokens(Action.Get2SameGems(Token.Emerald)))
  }

}