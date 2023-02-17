package com.example.ratatouille23.Login;

import com.example.ratatouille23.Utils.CognitoSettings;
import com.example.ratatouille23.homepage.Homepage;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class LoginController {

    @FXML
    TextField userNameTextField;

    @FXML
    TextField passwordTextField;

    @FXML
    Button pulsanteLogin;


    private Stage stage;
    private Scene scene;
    private Parent root;

    // Utilities

    private CognitoSettings cs = new CognitoSettings();


    // Schermate
    private Homepage home = new Homepage();
    private SchermataReimpostaPassword reimpostaPassword = new SchermataReimpostaPassword();


    public void initialize() {
        pulsanteLogin.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> userNameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty(),
                        userNameTextField.textProperty(),
                        passwordTextField.textProperty()
                )
        );

    }


    public void clickPulsanteLogin(ActionEvent event) {
        Login(event);
    }


    public void Login(ActionEvent event) {
        final Map<String, String> authParams = new HashMap<>();
        authParams.put("USERNAME", userNameTextField.getText());
        authParams.put("PASSWORD", passwordTextField.getText());

        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                .region(cs.getRegion())
                .build();

        InitiateAuthRequest authRequest = InitiateAuthRequest.builder()
                .clientId(cs.getAppClientId())
                .authFlow("USER_PASSWORD_AUTH")
                .authParameters(authParams)
                .build();

        try {
            // If you specify an incorrect username/password, an exception is thrown.
            InitiateAuthResponse authResult = cognitoClient.initiateAuth(authRequest);

            // Get the Challenge type
            String challType = authResult.challengeNameAsString();
            if (challType != null){
                if (challType.compareTo("NEW_PASSWORD_REQUIRED") == 0) {
                    System.out.println("The User must change their password. ");
                    //reimpostaPassword.apriSchermataReimpostaPassword(event);

                    // PROVA

                    try {
                        AdminSetUserPasswordRequest passwordRequest = AdminSetUserPasswordRequest.builder()
                                .username(userNameTextField.getText())
                                .userPoolId(cs.getUserPoolID())
                                .password("Ratatouille23!")
                                .permanent(true)
                                .build();

                        cognitoClient.adminSetUserPassword(passwordRequest);
                        System.out.println("The password was successfully changed");

                    } catch (CognitoIdentityProviderException e) {
                        System.err.println(e.awsErrorDetails().errorMessage());
                        System.exit(1);
                    }
                }
            } else {
                System.out.println("Access Token Type : " + authResult.authenticationResult().tokenType());
                System.out.println("Access Token : " + authResult.authenticationResult().accessToken());
                home.apriSchermataHome(event);
            }

        } catch (CognitoIdentityProviderException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Conferma");
            alert.setHeaderText(e.awsErrorDetails().errorMessage());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                //
            }
    } catch(
    IOException e)

    {
        throw new RuntimeException(e);
    }

/*
            final String CLIENT_ID = cs.getAppClientId();
            final String USER_NAME = userNameTextField.getText();
            final String PASSWORD = passwordTextField.getText();
            final Region region = cs.getRegion();

            CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder()
                    .credentialsProvider(DefaultCredentialsProvider.create())
                    .region(region)
                    .build();


            InitiateAuthRequest authRequest = InitiateAuthRequest.builder()
                    .clientId(CLIENT_ID)
                    .authFlow("USER_PASSWORD_AUTH")
                    .authParameters(createAuthParameters(USER_NAME, PASSWORD))
                    .build();

            try {
                InitiateAuthResponse authResult = cognitoClient.initiateAuth(authRequest);

                if (authResult.challengeName() != null) {
                    if (authResult.challengeName().equals(ChallengeNameType.NEW_PASSWORD_REQUIRED.toString())) {
                        try {
                            reimpostaPassword.apriSchermataReimpostaPassword(event);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // The authentication was successful
                        AuthenticationResultType authenticationResult = authResult.authenticationResult();
                        System.out.println("Access token: " + authenticationResult.accessToken());
                    }
                }
            } catch (NotAuthorizedException e) {
                System.out.println("Incorrect username or password");
            } catch (PasswordResetRequiredException e) {
                System.out.println("Password reset is required for the user");
            }
            */

        }



        private static java.util.Map<String, String> createAuthParameters(String userName, String password) {
            java.util.Map<String, String> authParameters = new java.util.HashMap<>();
            authParameters.put("USERNAME", userName);
            authParameters.put("PASSWORD", password);
            return authParameters;
        }

    }

/*

    public void signIn(ActionEvent event) {
        // Cognito user pool details
        String clientId = "6k82cmv89ilsocdetlfcn2l99m";
        String userPoolId = "eu-central-1_aseBjh2cw";
        USERNAME = userNameTextField.getText();
        String password = passwordTextField.getText();

        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("AKIATOOJQDOZYIMLO6P6", "lY9DabY+mn2+3lTDvUCExu6FDESzdbAXw7GQIx9d");

        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds)).region(Region.EU_CENTRAL_1).build();

        Map<String, String> authParams = new HashMap<>();
        authParams.put("USERNAME", USERNAME);
        authParams.put("PASSWORD", password);

        AdminInitiateAuthRequest authRequest = AdminInitiateAuthRequest.builder()
                .authFlow("ADMIN_NO_SRP_AUTH")
                .clientId(clientId)
                .userPoolId(userPoolId)
                .authParameters(authParams)
                .build();


        try {
            AdminInitiateAuthResponse authResult = cognitoClient.adminInitiateAuth(authRequest);
            AuthenticationResultType resultType = authResult.authenticationResult();
            System.out.println("Login successful. Access Token: " + resultType.accessToken());
            if (ChallengeNameType.NEW_PASSWORD_REQUIRED.toString().equals(authResult.challengeNameAsString())) {
                System.out.println("Force password reset required. Resetting password...");
                reimpostaPassword.apriSchermataReimpostaPassword(event);
            } else {
                home.apriSchermataHome(event);
            }
        } catch (NotAuthorizedException ex) {
            System.out.println("Incorrect username or password");
        } catch (UserNotFoundException ex) {
            System.out.println("User not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReimpostaPassword(String utente) {

        /*
        String username = utente;
        String newPassword = nuovaPasswordTextField.getText();
        String temporaryPassword = vecchiaPasswordTextField.getText();

        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("AKIATOOJQDOZYIMLO6P6", "lY9DabY+mn2+3lTDvUCExu6FDESzdbAXw7GQIx9d");

        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds)).region(Region.EU_CENTRAL_1).build();

        AdminSetUserPasswordRequest request = AdminSetUserPasswordRequest.builder().userPoolId("eu-central-1_aseBjh2cw")
                .username(username).password(newPassword).permanent(true)
                .build();

        AdminSetUserPasswordResponse response = cognitoClient.adminSetUserPassword(request);

        System.out.println("Password reset for user " + username + " successful");
        }
 */




