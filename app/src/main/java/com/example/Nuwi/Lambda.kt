package com.example.Nuwi

import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;

interface Lambda {
    /**
     * Invoke the Lambda function "AndroidBackendLambdaFunction".
     * The function name is the method name.
     */
    @LambdaFunction
    fun AndroidBackendLambdaFunction(request: RequestClass?): ResponseClass?
}