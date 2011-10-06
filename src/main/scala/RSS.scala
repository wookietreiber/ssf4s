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

/** RSS feed parser. */
object RSS extends FeedParser {
  override lazy val feedTag = "rss"
  override lazy val feedDescTag = "description"
  override lazy val pubDateTag = "pubDate"
  override lazy val articleTag = "item"
  override lazy val articleDescTag = "description"
  override lazy val dateFormatter = forPattern("EEE, dd MMM yyyy HH:mm:ss Z")

  override def title(implicit xml: XML) = xml \\ "channel" \ titleTag text
  override def description(implicit xml: XML) = (xml \\ "channel" \ feedDescTag).
    headOption map { _ text } filter { _ nonEmpty }

  override def articleLinks(implicit xml: XML) = xml \\ linkTag map { _ text }
}
