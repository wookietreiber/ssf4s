/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                                               *
 *  Copyright  ©  2011-2012  Christian Krause                                                    *
 *                                                                                               *
 *  Christian Krause  <kizkizzbangbang@googlemail.com>                                           *
 *                                                                                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                                               *
 *  This file is part of 'ssf4s'.                                                                *
 *                                                                                               *
 *  This project is free software: you can redistribute it and/or modify it under the terms      *
 *  of the GNU General Public License as published by the Free Software Foundation, either       *
 *  version 3 of the License, or any later version.                                              *
 *                                                                                               *
 *  This project is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;    *
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.    *
 *  See the GNU General Public License for more details.                                         *
 *                                                                                               *
 *  You should have received a copy of the GNU General Public License along with this project.   *
 *  If not, see <http://www.gnu.org/licenses/>.                                                  *
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
