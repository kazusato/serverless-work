package kazusato.work.serverless.movie

import dagger.Component
import dagger.Module
import io.kotlintest.TestCaseContext
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.specs.StringSpec
import kazusato.work.serverless.module.DaggerServiceComponent
import kazusato.work.serverless.module.ServiceModule
import javax.inject.Inject
import javax.inject.Singleton

class MovieRepositoryTest : StringSpec() {

    @Inject
    lateinit var repo: MovieRepository

    override fun interceptTestCase(context: TestCaseContext, test: () -> Unit) {
        DaggerMovieRepositoryTest_MovieRepositoryTestComponent.create().inject(context.spec as MovieRepositoryTest)
        test()
    }

    init {
        "Successfully retrieve 1933/King Kong" {
            val resp = repo.findMovieInfo(1933, "King Kong")
            repo shouldNotBe null
            resp!!.year shouldBe 1933
            resp!!.title shouldBe "King Kong"
        }
    }

    @Singleton
    @Component(modules = [ServiceModule::class])
    interface MovieRepositoryTestComponent {
        fun inject(target: MovieRepositoryTest)
    }

}