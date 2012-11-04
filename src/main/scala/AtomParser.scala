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

/** Atom feed parser. */
private[ssf4s] object AtomParser extends FeedParser {
  override lazy val feedTag        = "feed"
  override lazy val feedDescTag    = "subtitle"
  override lazy val pubDateTag     = "updated"
  override lazy val articleTag     = "entry"
  override lazy val articleDescTag = "summary"

  override def title(implicit xml: Node) = (xml \ titleTag).text

  override def description(implicit xml: Node) = (xml \ feedDescTag).
    headOption map { _.text } filter { _.nonEmpty }

  override def articleLinks(implicit xml: Node) = xml \\ linkTag flatMap {
    _.attributes.asAttrMap.get("href").toList
  }
}
