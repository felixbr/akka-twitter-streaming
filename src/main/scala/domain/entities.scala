package domain

case class User(id: String, lang: String, followerCount: Int)

case class Place(country: String, name: String) {
  //override lazy val toString: String = s"$name, $country"
  override lazy val toString: String = "bla"
}

case class Tweet(id: String, user: User, text: String, place: Option[Place])