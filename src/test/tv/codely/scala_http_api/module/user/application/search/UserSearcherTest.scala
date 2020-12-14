package tv.codely.scala_http_api.module.user.application

import tv.codely.scala_http_api.module.user.UserUnitTestCase
import tv.codely.scala_http_api.module.user.infraestructure.stub.UserStub

final class UserSearcherTest extends UserUnitTestCase {
  private val searcher = new UserSearcher(repository)

  "Users Searcher" should {
    "search all existing users" in {
      val existingUser        = UserStub.random
      val anotherExistingUser = UserStub.random
      val existingUsers       = Seq(existingUser, anotherExistingUser)

      shouldSearchAllUsers(existingUsers)

      searcher.all() should be(existingUsers)
    }
  }

}
