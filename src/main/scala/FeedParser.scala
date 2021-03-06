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
import scala.xml.XML

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

  /** Returns the title of the feed. */
  def title(implicit xml: Node): String

  /** Optionally returns the feeds description. */
  def description(implicit xml: Node): Option[String]

  /** Returns the articles of the given feed. */
  def articles(implicit xml: Node): Seq[Article] = xml \\ articleTag map { implicit xml ⇒
    Article(articleTitle, articlePubDate, articleDesc, articleLinks)
  }

  /** Returns the title of the given article. */
  def articleTitle(implicit xml: Node): String =
    (xml \\ titleTag).text

  /** Returns when the article has been published. */
  def articlePubDate(implicit xml: Node): Option[String] = (xml \\ pubDateTag).text.trim match {
    case s if s.nonEmpty ⇒ Some(s)
    case _               ⇒ None
  }

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
    Feed(title, url, description, articles)
  }

}
