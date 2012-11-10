/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                                               *
 *  This file is part of the project 'ssf4s'.                                                    *
 *                                                                                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                                               *
 *  This project is free software. It comes without any warranty, to the extent permitted by     *
 *  applicable law. You can redistribute it and/or modify it under the terms of the Do What The  *
 *  Fuck You Want To Public License, Version 2, as published by Sam Hocevar.                     *
 *                                                                                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                                               *
 *  See http://sam.zoy.org/wtfpl/COPYING for more details.                                       *
 *                                                                                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


package scalax.ssf4s

import org.specs2._

class ArticleSummarySpec extends Specification with ResourceParser { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "Article summary specification"                                             ^
                                                                             p^
  "Summaries should not be empty for articles with non-empty samples of"      ^
    "Atom 1.0 feeds"        ! summary("/atom-1.0.xml")                        ^
    "RSS 2.0 feeds"         ! summary("/rss-2.0.xml")                         ^
                                                                             p^
  "Summaries should be empty for articles with empty samples of"              ^
    "Atom 1.0 feeds"        ! nosummary("/atom-1.0-noArtSum.xml")             ^
    "RSS 2.0 feeds"         ! nosummary("/rss-2.0-noArtSum.xml")              ^
                                                                            end
  // -----------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------

  def summary(res: String) = ((_: Option[String]) must beSome) forall {
    parse(res).articles map { _.summary }
  }

  def nosummary(res: String) = ((_: Option[String]) must beNone) forall {
    parse(res).articles map { _.summary }
  }

}
