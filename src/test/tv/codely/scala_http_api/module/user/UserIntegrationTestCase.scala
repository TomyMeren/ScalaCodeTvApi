package tv.codely.scala_http_api.module.user

import tv.codely.scala_http_api.module.IntegrationTestCase
import tv.codely.scala_http_api.module.user.infraestructure.dependency_injection.UserModuleDependencyContainer
import tv.codely.scala_http_api.module.user.infraestructure.repository.InMemoryUserRepository

protected[user] trait UserIntegrationTestCase extends IntegrationTestCase {

  protected val container = new UserModuleDependencyContainer

  protected val repository: InMemoryUserRepository = container.repository

}
