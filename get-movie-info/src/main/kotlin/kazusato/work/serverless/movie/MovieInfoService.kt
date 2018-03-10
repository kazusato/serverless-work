package kazusato.work.serverless.movie

class MovieInfoService {

    fun getMovieInfo(req: MovieInfoRequest): MovieInfoResponse {
        val resp = MovieInfoResponse()
        resp.year = req.year
        resp.title = req.title

        return resp
    }

}