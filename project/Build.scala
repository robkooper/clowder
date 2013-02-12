import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "medici-play"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "com.novus" %% "salat" % "1.9.1",
      "securesocial" % "securesocial_2.9.1" % "2.0.8",
      "com.rabbitmq" % "amqp-client" % "3.0.0",
      "org.elasticsearch" % "elasticsearch" % "0.20.1",
      "com.spatial4j" % "spatial4j" % "0.3",
      "org.mongodb" %% "casbah" % "2.5.0",
      "org.scalaj" %% "scalaj-collection" % "1.2"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      routesImport += "Binders._",
      templatesImport += "org.bson.types.ObjectId",
      resolvers += Resolver.url("SecureSocial Repository", url("http://securesocial.ws/repository/releases/"))(Resolver.ivyStylePatterns)
    )
}
