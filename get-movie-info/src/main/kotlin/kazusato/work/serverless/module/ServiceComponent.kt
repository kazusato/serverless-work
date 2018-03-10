package kazusato.work.serverless.module

import dagger.Component
import kazusato.work.serverless.movie.GetMovieInfo
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class])
interface ServiceComponent {

    fun inject(target: GetMovieInfo)

}
