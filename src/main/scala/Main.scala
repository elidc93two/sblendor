import com.phinians.sblendor.gameplay.{GameTable, Get3DifferentGems, Player}
import com.phinians.sblendor.points.Onyx

object Main extends App {

  println("=====================================================")
  println("==============  WELCOME TO SBLENDOR! ================")
  println("=====================================================")

  val p1 = Player("Mang Tacio")
  val p2 = Player("Tiya Pusit")

  val sblendor = new GameTable(p1, p2)


//  val noWinner: Boolean = !play.players.exists(_.acquiredPrestigePoints >= 15)

  //sequential
  p1.play(Get3DifferentGems(Onyx), sblendor)
  p1.play(Get3DifferentGems(Onyx), sblendor)


}