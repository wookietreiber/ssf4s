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

import scala.xml.Node
import scala.xml.XML

import org.joda.time.format.DateTimeFormatter

import org.scala_tools.time.Implicits._

/** Feed Parser. */
private[ssf4s] trait FeedParser {

  // -----------------------------------------------------------------------
  // tags
  // -----------------------------------------------------------------------

  /** Returns the main identifier tag. */
  def feedTag: String

  /** Returns the feed description tag. */
  def feedDescTag: String

  /** Returns the article tag. */
  def articleTag: String

  /** Returns the article description tag. */
  def articleDescTag: String

  /** Returns the published date tag. */
  def pubDateTag: String

  /** Returns the title tag. */
  def titleTag: String = "title"

  /** Returns the link tag. */
  def linkTag: String = "link"

  // -----------------------------------------------------------------------
  // parsing
  // -----------------------------------------------------------------------

  /** Returns the date parser. */
  def dateFormatter: DateTimeFormatter

  /** Returns the title of the feed. */
  def title(implicit xml: Node): String

  /** Optionally returns the feeds description. */
  def description(implicit xml: Node): Option[String]

  /** Returns the articles of the given feed. */
  def articles(implicit xml: Node): Seq[Article] = xml \\ articleTag map { implicit xml ⇒
    val date = dateFormatter.parseOption(articlePubDate)

    Article(articleTitle, date, articleDesc, articleLinks)
  }

  /** Returns the title of the given article. */
  def articleTitle(implicit xml: Node): String =
    (xml \\ titleTag).text

  /** Returns when the article has been published. */
  def articlePubDate(implicit xml: Node): String =
    (xml \\ pubDateTag).text.trim

  /** Optionally returns the summary of the given article. */
  def articleDesc(implicit xml: Node): Option[String] =
    (xml \\ articleDescTag).headOption map { _.text.trim } filterNot { _ == "" }

  /** Returns the links the article provides. */
  def articleLinks(implicit xml: Node): Seq[String]

  // -----------------------------------------------------------------------
  // extractors
  // -----------------------------------------------------------------------

  /** Optionally returns a parsed feed. */
  def unapply(url: String): Option[Feed] = (XML.load(url) \\ feedTag).headOption map { implicit xml ⇒
    Feed(title, description, articles)
  }

}
