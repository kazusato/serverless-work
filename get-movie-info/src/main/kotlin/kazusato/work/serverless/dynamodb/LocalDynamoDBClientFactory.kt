package kazusato.work.serverless.dynamodb

import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder

class LocalDynamoDBClientFactory : DynamoDBClientFactory {

    override fun createClient(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration(
                        "http://localhost:8000", "ap-northeast-1"
                )).build()
    }

}