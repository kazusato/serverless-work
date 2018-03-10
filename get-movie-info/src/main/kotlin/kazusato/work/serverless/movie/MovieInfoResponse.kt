package kazusato.work.serverless.movie

data class MovieInfoResponse(
        var year: Int = 0,
        var title: String = "",
        var details: MovieDetails = MovieDetails()
)