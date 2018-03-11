package kazusato.work.serverless.movie

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import kazusato.work.serverless.module.DaggerServiceComponent
import javax.inject.Inject

class GetMovieInfo : RequestHandler<MovieInfoRequest, MovieInfoResponse> {

    @Inject
    lateinit var movieInfoService: MovieInfoService

    init {
        DaggerServiceComponent.create().inject(this)
    }

    override fun handleRequest(req: MovieInfoRequest, context: Context): MovieInfoResponse {
        return movieInfoService.getMovieInfo(req) ?: MovieInfoResponse(req.year, req.title)
    }
}
