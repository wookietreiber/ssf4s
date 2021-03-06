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

class ArticlePublishedSpec extends Specification with ResourceParser { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "Article publication date specification"                                    ^
                                                                             p^
  "Publication dates should not be empty for non-empty samples of"            ^
    "Atom 1.0 feeds"        ! pubDate("/atom-1.0.xml")                        ^
    "RSS 2.0 feeds"         ! pubDate("/rss-2.0.xml")                         ^
                                                                            end
  // -----------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------

  def pubDate(res: String) = ((_: Option[String]) must beSome) forall {
    parse(res).articles map { _.pubDate }
  }

}
