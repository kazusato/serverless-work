package kazusato.work.serverless.movie

import com.amazonaws.services.dynamodbv2.model.AttributeValue

class MovieMapperRepository: MovieRepository {

    override fun findMovieInfo(year: Int, title: String): MovieInfoResponse? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun buildResponse(resultMap: Map<String, AttributeValue>): MovieInfoResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}