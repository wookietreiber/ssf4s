Simple Syndication Facade for Scala
===================================

This project is supposed to be to syndication what [slf4s][2] is to logging.


Using ssf4s
-----------

Retrieving a feed is as easy as passing a URL to the `Feed` factory object:

```text
scala> import scalax.ssf4s._
import scalax.ssf4s._

scala> val feed = Feed("http://implicit.ly/rss.xml")
feed: scalax.ssf4s.Feed = implicit.ly
```

Then you can retrieve information of the feed itself and its articles by
invoking some low-level methods on it since `Feed` and `Article` are simple
containers:

```text
scala> feed.title
res0: String = implicit.ly

scala> feed.description
res1: Option[String] = Some(Scala software, hot off the presses)

scala> feed.articles
res2: Seq[scalax.ssf4s.Article] = List(...)

scala> feed.articles map { _ pubDate }
res3: Seq[Option[scalax.ssf4s.package.DateTime]] = List(...)
```


Branching Model
---------------

This project follows [this branching model][1]. Please consider the guidelines
when opening pull requests.

[1]: http://nvie.com/posts/a-successful-git-branching-model/
[2]: https://github.com/weiglewilczek/slf4s


---

[![endorse](http://api.coderwall.com/wookietreiber/endorsecount.png)](http://coderwall.com/wookietreiber)

