package kazusato.work.serverless.movie

import com.amazonaws.services.dynamodbv2.model.AttributeValue

interface MovieRepository {
    fun findMovieInfo(year: Int, title: String): MovieInfoResponse?
}