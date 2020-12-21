package io.getquill

import scala.quoted._

case class MyQuoted(val ast: String, sub: String)

object MyQuoteMacro {
  inline def myquote(inline content: MyContent): MyQuoted = ${ MyQuoteMacro.apply('content) }
  def apply(content: Expr[MyContent])(using Quotes): Expr[MyQuoted] = {
    import quotes.reflect._
    '{ MyQuoted($content.key, ???) }
  }
}

// If you put this into here, then it works!
/*
object ContextRet {
  def runTestImpl(quoted: Expr[MyQuoted])(using qctx: Quotes): Expr[String] =
    '{ $quoted.ast.toString }

  inline def runAndTest(inline quoted: MyQuoted): String = 
    ${ runTestImpl('quoted) }
}
*/
