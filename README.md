Simple Syndication Facade for Scala
===================================

This project is supposed to be to [syndication][] what [slf4s][] is to logging.


Using the Simple Syndication Facade for Scala
---------------------------------------------

Retrieving a feed is as easy as passing a URL to the `Feed` factory object:

    scala> import scalax.ssf4s._
    import scalax.ssf4s._
    
    scala> val feed = Feed("http://implicit.ly/rss.xml").get
    feed: scalax.ssf4s.Feed = implicit.ly

Then you can retrieve information of the feed itself and its articles by invoking some low-level
methods on it since `Feed` and `Article` are simple containers:

    scala> feed.title
    res0: String = implicit.ly
    
    scala> feed.description
    res1: Option[String] = Some(Scala software, hot off the presses)
    
    scala> feed.articles
    res2: Seq[scalax.ssf4s.Article] = List(...)
    
    scala> feed.articles map { _.pubDate }
    res3: Seq[Option[String]] = List(...)


Branching Model
---------------

This project follows [this branching model][1]. Please consider the guidelines when opening pull
requests.


[1]: http://nvie.com/posts/a-successful-git-branching-model/
[slf4s]: https://github.com/weiglewilczek/slf4s
[syndication]: http://en.wikipedia.org/wiki/Web_syndication


---

[![endorse](http://api.coderwall.com/wookietreiber/endorsecount.png)](http://coderwall.com/wookietreiber)

