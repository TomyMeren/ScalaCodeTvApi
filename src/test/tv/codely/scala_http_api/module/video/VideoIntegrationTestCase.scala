package tv.codely.scala_http_api.module.video

import tv.codely.scala_http_api.module.IntegrationTestCase
import tv.codely.scala_http_api.module.video.infraestructure.dependency_injection.VideoModuleDependencyContainer

protected[video] trait VideoIntegrationTestCase extends IntegrationTestCase {

  protected val container = new VideoModuleDependencyContainer

  protected val repository = container.repository

}
