package com.example.ratatouille23.Model;

import com.example.ratatouille23.Utils.CognitoSettings;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class Utente {

    static String username;
    static String group;

    public static void setUsername(String username) {
        Utente.username = username;
    }

    public static void setGroup(String group) {
        Utente.group = group;
    }

    public static String getUsername() {
        return username;
    }

    public static String getGroup() {
        return group;
    }

    public static String Login(String username, String password) {
        final Map<String, String> authParams = new HashMap<>();
        authParams.put("USERNAME", username);
        authParams.put("PASSWORD", password);

        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                .region(CognitoSettings.getRegion())
                .build();

        InitiateAuthRequest authRequest = InitiateAuthRequest.builder()
                .clientId(CognitoSettings.getAppClientId())
                .authFlow("USER_PASSWORD_AUTH")
                .authParameters(authParams)
                .build();

        // If you specify an incorrect username/password, an exception is thrown.
        InitiateAuthResponse authResult = cognitoClient.initiateAuth(authRequest);

        // Settiamo lo username
        Utente.setUsername(username);

        // Get the Challenge type
        String challType = authResult.challengeNameAsString();


            if (challType != null) {
                // The user has a challenge, it must change its password.
                return challType;

            } else {

                // Otteniamo lo username
                GetUserRequest userRequest = GetUserRequest.builder()
                        .accessToken(authResult.authenticationResult().accessToken())
                        .build();

                GetUserResponse userResponse = cognitoClient.getUser(userRequest);
                System.out.println("Lo username è: " + userResponse.username());

                Utente.setUsername(userResponse.username());

                // Otteniamo il gruppo
                AdminListGroupsForUserRequest listGroupsRequest = AdminListGroupsForUserRequest.builder()
                        .username(userResponse.username())
                        .userPoolId(CognitoSettings.getUserPoolID())
                        .build();

                AdminListGroupsForUserResponse listGroupsResponse = null;
                try {
                    listGroupsResponse = cognitoClient.adminListGroupsForUser(listGroupsRequest);
                } catch (CognitoIdentityProviderException e) {
                    System.out.println("Error getting groups for user: " + e.getMessage());
                }

                // Stampare il nome del gruppo a cui appartiene l'utente
                if (listGroupsResponse != null && !listGroupsResponse.groups().isEmpty()) {
                    String groupName = listGroupsResponse.groups().get(0).groupName();
                    System.out.println("User belongs to group: " + groupName);


                    Utente.setGroup(groupName);
                } else {
                    System.out.println("User doesn't belong to any group.");
                }

                System.out.println("Access Token Type : " + authResult.authenticationResult().tokenType());
                System.out.println("Access Token : " + authResult.authenticationResult().accessToken());
                return null;
            }
    }

    public static void ReimpostaPasswordPrimoAccesso(String password) throws CognitoIdentityProviderException {
        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                .region(CognitoSettings.getRegion())
                .build();

        AdminSetUserPasswordRequest passwordRequest = AdminSetUserPasswordRequest.builder()
                .username(Utente.getUsername())
                .userPoolId(CognitoSettings.getUserPoolID())
                .password(password)
                .permanent(true)
                .build();

        cognitoClient.adminSetUserPassword(passwordRequest);
        System.out.println("The password was successfully changed");
    }
}
