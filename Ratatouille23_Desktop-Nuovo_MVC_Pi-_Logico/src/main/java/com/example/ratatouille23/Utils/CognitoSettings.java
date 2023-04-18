package com.example.ratatouille23.Utils;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;

public abstract class CognitoSettings {

    static final String userPoolId = "eu-central-1_aseBjh2cw";
    static final String appClientID = "6k82cmv89ilsocdetlfcn2l99m";
    static final String accessKey = "AKIATOOJQDOZYIMLO6P6";
    static final String secretAccessKey = "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";
    static final Region cognitoRegion = Region.EU_CENTRAL_1;


    public static String getUserPoolID(){
        return userPoolId;
    }
    public static String getAppClientId(){
        return appClientID;
    }

    public static String getAccessKey(){
        return accessKey;
    }

    public static String getSecretAccessKey(){
        return secretAccessKey;
    }

    public static Region getRegion(){
        return cognitoRegion;
    }
}
