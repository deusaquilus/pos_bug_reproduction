package io.getquill

import scala.quoted._

case class MyQuoted(val ast: String, runtimeQuotes: List[String])

object MyQuoteMacro {
  inline def myquote: MyQuoted = ${ MyQuoteMacro.apply }
  def apply(using Quotes): Expr[MyQuoted] = {
    import quotes.reflect._
    '{ MyQuoted("p", ${Expr.ofList(List( '{ "foo" } ))}) }
  }
}

// If you put this into here, then it works!
/*
object ContextRet {

  def runTestImpl(quoted: Expr[MyQuoted])(using qctx: Quotes): Expr[String] = {
    '{ $quoted.ast.toString }
  }

  inline def runAndTest(inline quoted: MyQuoted): String = 
    ${ runTestImpl('quoted) }
}
*/
