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

/** Feed factory. */
object Feed {

  /** Returns a feed by downloading and parsing the URL content. */
  def apply(url: String): Option[Feed] = url match {
    case AtomParser(feed) ⇒ Some(feed)
    case RSSParser(feed)  ⇒ Some(feed)
    case _                ⇒ None
  }

}

/** Holds feed information and its articles.
  *
  * @param title       Returns this feeds title.
  * @param url         Returns the URL identifying this feed.
  * @param description Optionally returns this feeds description.
  * @param articles    Returns this feeds articles, latest first.
  */
case class Feed(title: String, url: String, description: Option[String], articles: Seq[Article]) {

  /** Returns this feeds title. */
  override def toString = title

}
