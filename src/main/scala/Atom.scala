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

/** Atom feed parser. */
object Atom extends FeedParser {
  override lazy val feedTag = "feed"
  override lazy val feedDescTag = "subtitle"
  override lazy val pubDateTag = "updated"
  override lazy val articleTag = "entry"
  override lazy val articleDescTag = "summary"
  override lazy val dateFormatter = forPattern("YYYY-MM-DD'T'HH:mm:ss'Z")

  override def title(implicit xml: XML) = xml \ titleTag text
  override def description(implicit xml: XML) = (xml \ feedDescTag).
    headOption map { _ text } filter { _ nonEmpty }

  override def articleLinks(implicit xml: XML) = xml \\ linkTag flatMap {
    _.attributes.asAttrMap.get("href").toList
  }
}
