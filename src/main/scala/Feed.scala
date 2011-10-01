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

/** Feed factory. */
object Feed {

  // -----------------------------------------------------------------------
  // factory methods
  // -----------------------------------------------------------------------

  /** Returns a feed by downloading and parsing the URL content. */
  def apply(url: String): Feed = apply(xml.XML.load(url))

  /** Returns a feed by parsing the XML content. */
  def apply(xml: XML): Feed = xml match {
    case RSS(feed) => feed
    case Atom(feed) => feed
  }

  // -----------------------------------------------------------------------
  // parsers
  // -----------------------------------------------------------------------

  /** RSS feed parser. */
  object RSS {
    /** Optionally returns a parsed feed. */
    def unapply(xml: XML) = (xml \\ "rss").headOption map { xml =>
      val title = xml \\ "channel" \ "title" text
      val items = xml \\ "item" map { xml => Article(xml \\ "title" text) }
      new Feed(title, items)
    }
  }

  /** Atom feed parser. */
  object Atom {
    /** Optionally returns a parsed feed. */
    def unapply(xml: XML) = (xml \\ "feed").headOption map { xml =>
      val title = xml \ "title" text
      val items = xml \\ "entry" map { xml => Article(xml \\ "title" text) }
      new Feed(title, items)
    }
  }

}

/** Holds feed information and its articles.
  *
  * @param title Returns this feeds title.
  * @param articles Returns this feeds articles, latest first.
  */
case class Feed(title: String, articles: Seq[Article]) {
  /** Returns this feeds title. */
  override def toString = title
}
