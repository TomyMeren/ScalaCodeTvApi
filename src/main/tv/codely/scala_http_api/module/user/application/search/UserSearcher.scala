package tv.codely.scala_http_api.module.user.application.search

import tv.codely.scala_http_api.module.user.domain.{User, UserRepository}

/**
 *  Declaramos la operacion searcher de user
 */

final class UserSearcher(repository: UserRepository) {

  def all(): Seq[User] = repository.all()
}
