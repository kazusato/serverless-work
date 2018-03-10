package kazusato.work.serverless.movie

data class MovieInfoRequest(
        var year: Int = 0,
        var title: String = ""
)