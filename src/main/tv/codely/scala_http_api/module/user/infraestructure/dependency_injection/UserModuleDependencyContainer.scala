package tv.codely.scala_http_api.module.user.infraestructure.dependency_injection

import tv.codely.scala_http_api.module.user.application.search.UserSearcher
import tv.codely.scala_http_api.module.user.infraestructure.repository.InMemoryUserRepository

/**
 * Contenedor con todas las acciones de user
 */

final class UserModuleDependencyContainer {
  val repository = new InMemoryUserRepository

  val userSearcher = new UserSearcher(repository)
}
