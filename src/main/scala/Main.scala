import com.phinians.sblendor.gameplay._
import com.phinians.sblendor.model._

object Main extends App {

  println(
    """
      |=====================================================
      |==============  WELCOME TO SBLENDOR! ================
      |=====================================================
    """.stripMargin)

  val player1 = Player("Mang Tacio")
  val player2 = Player("Tiya Pusit")

  val setup = GameTable.setup(player1, player2)
  setup match {
    case Success =>
      val result = GameTable.mainPhase(player1, Get3DifferentGems(Onyx, Sapphire, Ruby))
      GameTable.endPhase(player1, result)
      val result2 = GameTable.mainPhase(player1, Get3DifferentGems(Onyx, Sapphire, Ruby))
      GameTable.endPhase(player1, result2)
      val result3 = GameTable.mainPhase(player1, Get3DifferentGems(Onyx, Sapphire, Ruby))
      GameTable.endPhase(player1, result3)
      val result4 = GameTable.mainPhase(player1, Get3DifferentGems(Onyx, Sapphire, Ruby))
      GameTable.endPhase(player1, result4)
      val result5 = GameTable.mainPhase(player1, Get3DifferentGems(Onyx, Sapphire, Ruby))
      GameTable.endPhase(player1, result5)

      val result6 = GameTable.mainPhase(player2, Get2SameGems(Onyx))
      GameTable.endPhase(player2, result6)


    case _ =>
      throw new Exception("setup failed")
  }

//  val noWinner: Boolean = !play.players.exists(_.acquiredPrestigePoints >= 15)
//
//  //sequential
//  p1.play(Get3DifferentGems(Onyx, Emerald, Sapphire), sblendor)
//  println(s"sblendor tokens: ${sblendor.tokens.size}")
//  p1.play(Get3DifferentGems(Onyx, Emerald, Sapphire), sblendor)
//  println(s"sblendor tokens: ${sblendor.tokens.size}")


}