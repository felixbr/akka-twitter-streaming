package domain

case class User(id: String, lang: String, followerCount: Int)

case class Place(country: String, name: String) {
    override lazy val toString = s"$name, $country"
}

case class Tweet(id: String, user: User, text: String, place: Option[Place])