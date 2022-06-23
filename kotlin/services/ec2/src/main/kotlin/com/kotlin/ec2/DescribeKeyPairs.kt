//snippet-sourcedescription:[DescribeKeyPairs.kt demonstrates how to get information about all instance key pairs.]
//snippet-keyword:[AWS SDK for Kotlin]
//snippet-keyword:[Code Sample]
//snippet-service:[Amazon EC2]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[11/04/2021]
//snippet-sourceauthor:[scmacdon-aws]

/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package com.kotlin.ec2

// snippet-start:[ec2.kotlin.describe_key_pairs.import]
import aws.sdk.kotlin.services.ec2.Ec2Client
import aws.sdk.kotlin.services.ec2.model.DescribeKeyPairsRequest
// snippet-end:[ec2.kotlin.describe_key_pairs.import]

/**
To run this Kotlin code example, ensure that you have setup your development environment,
including your credentials.

For information, see this documentation topic:
https://docs.aws.amazon.com/sdk-for-kotlin/latest/developer-guide/setup.html
 */

suspend fun main() {
    describeEC2Keys()
}

// snippet-start:[ec2.kotlin.describe_key_pairs.main]
suspend fun describeEC2Keys() {

    Ec2Client { region = "us-west-2" }.use { ec2 ->
        val response = ec2.describeKeyPairs(DescribeKeyPairsRequest{})
        response.keyPairs?.forEach { keyPair ->
            println("Found key pair with name ${keyPair.keyName} and fingerprint ${ keyPair.keyFingerprint}")
        }
    }
}
// snippet-end:[ec2.kotlin.describe_key_pairs.main]