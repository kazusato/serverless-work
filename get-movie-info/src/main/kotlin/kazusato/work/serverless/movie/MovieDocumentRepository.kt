package kazusato.work.serverless.movie

import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.document.GetItemOutcome
import com.amazonaws.services.dynamodbv2.document.Item
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import kazusato.work.serverless.dynamodb.DynamoDBClientFactory
import java.math.BigDecimal
import javax.inject.Inject

class MovieDocumentRepository: MovieRepository {

    @Inject
    lateinit var clientFactory: DynamoDBClientFactory

    override fun findMovieInfo(year: Int, title: String): MovieInfoResponse? {
        val client = clientFactory.createClient()
        val docClient = DynamoDB(client)

        val table = docClient.getTable("Movies")
        val outcome = table.getItemOutcome("year", 1933, "title", "King Kong")

        return buildResponse(outcome)
    }

    fun buildResponse(outcome: GetItemOutcome): MovieInfoResponse {
        val resp = MovieInfoResponse().apply {
            val item = outcome.item

            year = item.getInt("year")
            title = item.getString("title")

            val infoMap = item.getMap<Any>("info")
            details = MovieDetails().apply {
                actors = infoMap.get("actors") as MutableList<String>
                directors = infoMap.get("directors") as MutableList<String>
                genres = infoMap.get("genres") as MutableList<String>
                imageUrl = infoMap.get("image_url") as String
                plot = infoMap.get("plot") as String
                rank = (infoMap.get("rank") as BigDecimal).toInt()
                rating = (infoMap.get("rating") as BigDecimal).toInt()
                releaseDate = infoMap.get("release_date") as String
                runningTimeSecs = (infoMap.get("running_time_secs") as BigDecimal).toInt()
            }

        }

        return resp
    }

}