package kazusato.work.serverless.dynamodb

import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder

class DynamoDBUtil {

    companion object {
        fun getLocalClient(): AmazonDynamoDB {
            return AmazonDynamoDBClientBuilder.standard()
                    .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration(
                            "http://localhost:8000", "ap-northeast-1"
                    )).build()
        }

        fun getClient(region: Regions): AmazonDynamoDB {
            return AmazonDynamoDBClientBuilder.standard()
                    .withCredentials(ProfileCredentialsProvider("dynamodb-demo"))
                    .withRegion(region).build()
        }
    }

}
