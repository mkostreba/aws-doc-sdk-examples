// snippet-sourcedescription:[DescribeCollection.kt demonstrates how to retrieve the description of an Amazon Rekognition collection.]
//snippet-keyword:[AWS SDK for Kotlin]
// snippet-service:[Amazon Rekognition]
// snippet-keyword:[Code Sample]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[11-05-2021]
// snippet-sourceauthor:[scmacdon - AWS]
/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/
package com.kotlin.rekognition

// snippet-start:[rekognition.kotlin.describe_collection.import]
import aws.sdk.kotlin.services.rekognition.RekognitionClient
import aws.sdk.kotlin.services.rekognition.model.DescribeCollectionRequest
import kotlin.system.exitProcess
// snippet-end:[rekognition.kotlin.describe_collection.import]

/**
To run this Kotlin code example, ensure that you have setup your development environment,
including your credentials.

For information, see this documentation topic:
https://docs.aws.amazon.com/sdk-for-kotlin/latest/developer-guide/setup.html
 */


suspend fun main(args: Array<String>){

    val usage = """
    Usage: 
        <collectionId> 

    Where:
        collectionId - the id of the collection to describe. 
    """

    if (args.size != 1) {
        println(usage)
        exitProcess(0)
    }

    val collectionId = args[0]
    println("Describing the Amazon Rekognition  $collectionId")
    describeColl(collectionId)
    }

// snippet-start:[rekognition.kotlin.describe_collection.main]
suspend fun describeColl(collectionName: String) {

     val request = DescribeCollectionRequest {
            collectionId = collectionName
     }

    RekognitionClient { region = "us-east-1" }.use { rekClient ->
        val response = rekClient.describeCollection(request)
        println("The collection Arn is ${response.collectionArn}" )
        println("The collection contains this many faces ${response.faceCount}")
    }
}
// snippet-end:[rekognition.kotlin.describe_collection.main]