package tv.codely.scala_http_api.module.user.infraestructure.dependency_injection

import tv.codely.scala_http_api.module.user.application.UserSearcher

/**
 * Contenedor con todas las acciones de user
 */

final class UserModuleDependencyContainer {
  val userSearcher = new UserSearcher
}
