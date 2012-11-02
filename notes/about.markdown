The [Simple Syndication Facade for Scala][1] is supposed to be to syndication what [slf4s][2] is to
logging. Retrieving a feed is as easy as:

    scala> import scalax.ssf4s._
    import scalax.ssf4s._

    scala> val feed = Feed("http://implicit.ly/rss.xml")
    feed: scalax.ssf4s.Feed = implicit.ly


[1]: https://github.com/wookietreiber/ssf4s
[2]: https://github.com/weiglewilczek/slf4s

