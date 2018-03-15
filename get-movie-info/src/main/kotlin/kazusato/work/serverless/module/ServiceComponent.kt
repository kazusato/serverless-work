package kazusato.work.serverless.module

import dagger.Component
import kazusato.work.serverless.movie.GetMovieInfo
import kazusato.work.serverless.movie.MovieDocumentRepository
import kazusato.work.serverless.movie.MovieInfoService
import kazusato.work.serverless.movie.MovieLowLevelRepository
import kazusato.work.serverless.movie.MovieRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class])
interface ServiceComponent {

    fun inject(target: GetMovieInfo)

    fun inject(target: MovieInfoService)

    fun inject(target: MovieLowLevelRepository)

    fun inject(target: MovieDocumentRepository)

}
