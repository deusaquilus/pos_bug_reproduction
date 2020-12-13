package io.getquill

object Test {

  inline def q2 = MyQuoteMacro.myquote

  def main(args: Array[String]): Unit = {
    println( PullAst.apply( q2 ) )
  }
}
