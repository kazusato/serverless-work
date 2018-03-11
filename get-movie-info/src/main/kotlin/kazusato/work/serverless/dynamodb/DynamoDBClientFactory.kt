package kazusato.work.serverless.dynamodb

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB

interface DynamoDBClientFactory {

    fun createClient(): AmazonDynamoDB

}