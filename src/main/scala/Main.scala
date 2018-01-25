import com.phinians.sblendor.gameplay.{GameTable, Get3DifferentGems, Player}
import com.phinians.sblendor.consumables._

object Main extends App {

  println("=====================================================")
  println("==============  WELCOME TO SBLENDOR! ================")
  println("=====================================================")

  val p1 = Player("Mang Tacio")
  val p2 = Player("Tiya Pusit")

  val sblendor = GameTable(List(p1, p2))

  println(s"sblendor tokens: ${sblendor.tokens.size}")

//  val noWinner: Boolean = !play.players.exists(_.acquiredPrestigePoints >= 15)

  //sequential
  p1.play(Get3DifferentGems(Onyx, Emerald, Sapphire), sblendor)
  println(s"sblendor tokens: ${sblendor.tokens.size}")
  p1.play(Get3DifferentGems(Onyx, Emerald, Sapphire), sblendor)
  println(s"sblendor tokens: ${sblendor.tokens.size}")


}