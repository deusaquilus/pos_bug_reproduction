package io.getquill

object QueryTest {

  inline def q2 = MyQuoteMacro.myquote

  def main(args: Array[String]): Unit = {
    println( ContextRet.runAndTest( q2 ) ) //helloooooooo
  }
}
