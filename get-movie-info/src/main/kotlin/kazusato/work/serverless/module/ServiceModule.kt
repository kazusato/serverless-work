package kazusato.work.serverless.module

import dagger.Module
import dagger.Provides
import kazusato.work.serverless.dynamodb.DynamoDBClientFactory
import kazusato.work.serverless.dynamodb.LambdaDynamoDBClientFactory
import kazusato.work.serverless.movie.MovieInfoService
import kazusato.work.serverless.movie.MovieRepository
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideMovieInfoService(): MovieInfoService {
        val svc = MovieInfoService()
        DaggerServiceComponent.create().inject(svc)
        return svc
    }

    @Provides
    @Singleton
    fun provideMovieRepository(): MovieRepository {
        val repo = MovieRepository()
        DaggerServiceComponent.create().inject(repo)
        return repo
    }

    @Provides
    @Singleton
    fun provideDynamoDBClientFactory(): DynamoDBClientFactory {
//        return RemoteDynamoDBClientFactory()
//        return LocalDynamoDBClientFactory()
        return LambdaDynamoDBClientFactory()
    }

}