package kazusato.work.serverless.dynamodb

import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder


class LambdaDynamoDBClientFactory : DynamoDBClientFactory {

    companion object {
        const val REGION_KEY: String = "kazusato.work.serverless.dynamodb.region"
    }

    override fun createClient(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder.standard().withRegion(region()).build()
    }

    private fun region(): Regions {
        val regionName = System.getenv("AWS_DEFAULT_REGION")
                ?: throw IllegalStateException("No DynamoDB region")

        return Regions.fromName(regionName)
    }

}