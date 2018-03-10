package kazusato.work.serverless.module

import dagger.Module
import dagger.Provides
import kazusato.work.serverless.movie.MovieInfoService
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideMovieInfoService(): MovieInfoService {
        return MovieInfoService()
    }

}