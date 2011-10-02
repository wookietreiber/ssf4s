/* **************************************************************************
 *                                                                          *
 *  Copyright (C)  2011  Christian Krause                                   *
 *                                                                          *
 *  Christian Krause <kizkizzbangbang@googlemail.com>                       *
 *                                                                          *
 ****************************************************************************
 *                                                                          *
 *  This file is part of 'ssf4s'.                                           *
 *                                                                          *
 *  This project is free software: you can redistribute it and/or modify    *
 *  it under the terms of the GNU General Public License as published by    *
 *  the Free Software Foundation, either version 3 of the License, or       *
 *  any later version.                                                      *
 *                                                                          *
 *  This project is distributed in the hope that it will be useful,         *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of          *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the           *
 *  GNU General Public License for more details.                            *
 *                                                                          *
 *  You should have received a copy of the GNU General Public License       *
 *  along with this project. If not, see <http://www.gnu.org/licenses/>.    *
 *                                                                          *
 ****************************************************************************/


package ssf4s

import org.specs2._
import ResourceParser._

class ArticlePublishedSpec extends Specification { def is =

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

  def pubDate(res: String) = ((_: Option[Date]) must beSome) forall {
    parse(res).articles map { _ pubDate }
  }

}
