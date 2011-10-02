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

/** Feed Parser. */
trait FeedParser {

  // -----------------------------------------------------------------------
  // tags
  // -----------------------------------------------------------------------

  /** Returns the main identifier tag. */
  def idTag: String

  /** Returns the article tag. */
  def articleTag: String

  /** Returns the article summary tag. */
  def articleSummaryTag: String

  /** Returns the published tag. */
  def pubTag: String

  /** Returns the title tag. */
  def titleTag: String = "title"

  /** Returns the link tag. */
  def linkTag: String = "link"

  // -----------------------------------------------------------------------
  // parsing
  // -----------------------------------------------------------------------

  /** Returns the title of the feed. */
  def title(xml: XML): String

  /** Returns the articles of the given feed. */
  def articles(xml: XML): Seq[Article] = xml \\ articleTag map { xml =>
    Article (
      articleTitle(xml),
      articlePublishedAt(xml),
      articleSummary(xml),
      articleLinks(xml)
    )
  }

  /** Returns the title of the given article. */
  def articleTitle(xml: XML): String =
    xml \\ titleTag text

  /** Returns when the article has been published. */
  def articlePublishedAt(xml: XML): String =
    xml \\ pubTag text

  /** Optionally returns the summary of the given article. */
  def articleSummary(xml: XML): Option[String] =
    (xml \\ articleSummaryTag).headOption map { _.text.trim } filterNot { _ == "" }

  /** Returns the links the article provides. */
  def articleLinks(xml: XML): Seq[String]

  // -----------------------------------------------------------------------
  // extractors
  // -----------------------------------------------------------------------

  /** Optionally returns a parsed feed. */
  def unapply(xml: XML): Option[Feed] = (xml \\ idTag).headOption map { xml =>
    Feed(title(xml), articles(xml))
  }

}
