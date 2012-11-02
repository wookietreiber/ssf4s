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

import scala.xml.Node

import org.joda.time.format.DateTimeFormat

/** RSS feed parser. */
private[ssf4s] object RSSParser extends FeedParser {
  override lazy val feedTag        = "rss"
  override lazy val feedDescTag    = "description"
  override lazy val pubDateTag     = "pubDate"
  override lazy val articleTag     = "item"
  override lazy val articleDescTag = "description"
  override lazy val dateFormatter  = DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss Z")

  override def title(implicit xml: Node) = (xml \\ "channel" \ titleTag).text

  override def description(implicit xml: Node) = (xml \\ "channel" \ feedDescTag).
    headOption map { _.text } filter { _.nonEmpty }

  override def articleLinks(implicit xml: Node) = xml \\ linkTag map {
    _.text
  }
}
