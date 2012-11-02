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
