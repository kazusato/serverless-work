package kazusato.work.serverless.movie

import javax.inject.Inject

class MovieInfoService {

    @Inject
    lateinit var repo: MovieRepository

    fun getMovieInfo(req: MovieInfoRequest): MovieInfoResponse? {
        val resp = repo.findMovieInfo(req.year, req.title)

        return resp
    }

}