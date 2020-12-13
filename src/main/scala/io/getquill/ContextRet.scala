package io.getquill

import scala.quoted._

object ContextRet {
  def runTestImpl(quoted: Expr[MyQuoted])(using qctx: Quotes): Expr[String] =
    '{ $quoted.ast.toString }

  inline def runAndTest(inline quoted: MyQuoted): String = 
    ${ runTestImpl('quoted) }
}
