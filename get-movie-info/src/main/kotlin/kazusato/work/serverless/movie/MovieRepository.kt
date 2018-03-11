package kazusato.work.serverless.movie

import com.amazonaws.services.dynamodbv2.model.AttributeValue
import kazusato.work.serverless.dynamodb.DynamoDBClientFactory
import javax.inject.Inject

class MovieRepository {

    @Inject
    lateinit var clientFactory: DynamoDBClientFactory

    fun findMovieInfo(year: Int, title: String): MovieInfoResponse? {
        val client = clientFactory.createClient()
        val result = client.getItem("Movies", hashMapOf<String, AttributeValue>(
                "year" to AttributeValue().withN(year.toString()),
                "title" to AttributeValue(title)
        ))
        return buildResponse(result.item)
    }

    fun buildResponse(resultMap: Map<String, AttributeValue>): MovieInfoResponse {
        val resp = MovieInfoResponse()

        resp.year = resultMap.get("year")!!.n.toInt(10)
        resp.title = resultMap.get("title")!!.s

        val details = MovieDetails()
        resp.details = details

        val detailMap = resultMap.get("info")!!.m
        details.actors.addAll(detailMap.get("actors")!!.l.map { it.s })
        details.directors.addAll(detailMap.get("directors")!!.l.map { it.s })
        details.genres.addAll(detailMap.get("genres")!!.l.map { it.s })
        details.imageUrl = detailMap.get("image_url")!!.s
        details.plot = detailMap.get("plot")!!.s
        details.rank = detailMap.get("rank")!!.n.toInt(10)
        details.rating = detailMap.get("rating")!!.n.toInt(10)
        details.releaseDate = detailMap.get("release_date")!!.s
        details.runningTimeSecs = detailMap.get("running_time_secs")!!.n.toInt(10)

        return resp
    }

}