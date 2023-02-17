package com.example.ratatouille23.Utils;

import software.amazon.awssdk.regions.Region;

public class CognitoSettings {

    String userPoolId = "eu-central-1_aseBjh2cw";
    String appClientID = "6k82cmv89ilsocdetlfcn2l99m";
    String accessKey = "AKIATOOJQDOZYIMLO6P6";
    String secretAccessKey = "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";
    Region cognitoRegion = Region.EU_CENTRAL_1;


    public String getUserPoolID(){
        return userPoolId;
    }
    public String getAppClientId(){
        return appClientID;
    }

    public String getAccessKey(){
        return accessKey;
    }

    public String getSecretAccessKey(){
        return secretAccessKey;
    }

    public Region getRegion(){
        return cognitoRegion;
    }
}
