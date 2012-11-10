The [Simple Syndication Facade for Scala][ssf4s] is supposed to be to [syndication][] what [slf4s][]
is to logging.

    scala> import scalax.ssf4s._
    import scalax.ssf4s._
    
    scala> val feed = Feed("http://implicit.ly/rss.xml").get
    feed: scalax.ssf4s.Feed = implicit.ly


[ssf4s]: https://github.com/wookietreiber/ssf4s
[slf4s]: https://github.com/weiglewilczek/slf4s
[syndication]: http://en.wikipedia.org/wiki/Web_syndication

