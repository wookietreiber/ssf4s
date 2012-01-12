Simple Syndication Facade for Scala
===================================

This project is supposed to be to syndication what [slf4s][2] is to logging.


Using ssf4s
-----------

```text
scala> import scalax.ssf4s._
import scalax.ssf4s._

scala> val feed = Feed("http://implicit.ly/rss.xml")
feed: scalax.ssf4s.Feed = implicit.ly

scala> feed.title
res0: String = implicit.ly

scala> feed.description
res1: Option[String] = Some(Scala software, hot off the presses)

scala> feed.articles
res4: Seq[scalax.ssf4s.Article] = List(...)
```


Branching Model
---------------

This project follows [this branching model][1]. Please consider the guidelines
when opening pull requests.

[1]: http://nvie.com/posts/a-successful-git-branching-model/
[2]: https://github.com/weiglewilczek/slf4s

