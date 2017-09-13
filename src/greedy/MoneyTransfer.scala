package greedy

import java.io.PrintWriter
import scala.collection.mutable.ListBuffer
import scala.Console._

/**
  * Created by nhan on 6/5/16.
  */
object MoneyTransfer {
  def sum = (x: Int, y: Int, a: Array[Int]) => x + y
  val w = new PrintWriter(System.out)

  def main(args: Array[String]) {
    val nBank = readInt()
    val banks = readLine().split(" ").map(x => x.toInt).to[ListBuffer]

    w.println(exec(banks))

    w.flush()
    w.close()
  }

  def exec(arr: ListBuffer[Int]): Int = {
    var step = 0

    while (true) {
      val result = getMaxTransfer(arr)
      if (result._1 == 0) {
        if (step == 0) {
          return 0
        } else {
          step += 1
          return step
        }
      } else {
        //transfer
        trans(result._2, result._3, arr)
        //increase step
        step += 1
      }
    }

    0
  }

  def getMaxTransfer(array: ListBuffer[Int]): (Int, Int, Int) = {
    var max = -1
    var max_pair = (0, 0)
    (0 to array.size - 1).foreach { i =>
      if (array(i) + array(nextIndex(i, array.size)) > max && array(i) != 0) {
        max = array(i) + array(nextIndex(i, array.size))
        max_pair = (i, nextIndex(i, array.size))
      }
    }

    if (max == 0) {
      (0, 0, 0)
    } else {
      (max, max_pair._1, max_pair._2)
    }
  }

  def trans(from: Int, to: Int, arr: ListBuffer[Int]): Unit = {
    arr(to) += arr(from)
    arr(from) = 0
  }

  def nextIndex = (x: Int, limit: Int) => if (x + 1 == limit) {
    (x + 1) % limit
  } else {
    x + 1
  }
}
