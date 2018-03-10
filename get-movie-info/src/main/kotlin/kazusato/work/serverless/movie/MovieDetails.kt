package kazusato.work.serverless.movie

data class MovieDetails(
        var actors: MutableList<String> = mutableListOf(),
        var directors: MutableList<String> = mutableListOf(),
        var genres: MutableList<String> = mutableListOf(),
        var imageUrl: String = "",
        var plot: String = "",
        var rank: Int = 0,
        var rating: Int = 0,
        var releaseDate: String = "",
        var runningTimeSecs: Int = 0
)