package tv.codely.scala_http_api.module.user.infraestructure.repository

import tv.codely.scala_http_api.module.user.domain.{User, UserRepository}

final class InMemoryUserRepository extends UserRepository {

  private val users = Seq(
    User("deacd129-d419-4552-9bfc-0723c3c4f56a", "Edufasio"),
    User("b62f767f-7160-4405-a4af-39ebb3635c17", "Edonisio"),
  )

  def all(): Seq[User] = users
}
