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
import ResourceParser._

class FeedDescriptionSpec extends Specification { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "Feed description specification"                                            ^
                                                                             p^
  "Feed descriptions should not be empty for non-empty samples of"            ^
    "Atom 1.0 feeds"        ! desc("/atom-1.0.xml")                           ^
    "RSS 2.0 feeds"         ! desc("/rss-2.0.xml")                            ^
                                                                             p^
  "Feed descriptions should be empty for non-description samples of"          ^
    "Atom 1.0 feeds"        ! nodesc("/atom-1.0-noDesc.xml")                  ^
    "RSS 2.0 feeds"         ! nodesc("/rss-2.0-noDesc.xml")                   ^
                                                                             p^
  "Feed descriptions should be empty for empty description samples of"        ^
    "Atom 1.0 feeds"        ! nodesc("/atom-1.0-emptyDesc.xml")               ^
    "RSS 2.0 feeds"         ! nodesc("/rss-2.0-emptyDesc.xml")                ^
                                                                            end
  // -----------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------

  def desc(res: String) = parse(res).description must beSome
  def nodesc(res: String) = parse(res).description must beNone

}
