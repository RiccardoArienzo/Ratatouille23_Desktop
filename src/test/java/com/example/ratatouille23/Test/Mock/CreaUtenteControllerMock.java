package com.example.ratatouille23.Test.Mock;

public class CreaUtenteControllerMock {
/*
    public void registraUtente(String username, String mail, String gruppo){

        try {
            if (!(verificaCorrettezzaEmail(mail))) {
                throw new IllegalArgumentException("Mail non valida.");
            }

            // Creazione di un'istanza del client CognitoIdentityProvider
            CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder().region(Region.EU_CENTRAL_1).build();

            AdminCreateUserRequest richiestaCreazioneUtente = AdminCreateUserRequest.builder()
                    .username(username)
                    .desiredDeliveryMediums(DeliveryMediumType.EMAIL)
                    .userAttributes(AttributeType.builder()
                            .name("email")
                            .value(mail)
                            .build())
                    .userPoolId("eu-central-1_aseBjh2cw")
                    .build();

            // Invio della richiesta di registrazione
            AdminCreateUserResponse rispostaCreazioneUtente = cognitoClient.adminCreateUser(richiestaCreazioneUtente);

            // Salviamo in una variabile il nome del gruppo selezionato dalla combobox
            String nomeGruppo = gruppo;

            if (!(verificaGruppoCorretto(gruppo))) {
                throw new IllegalArgumentException("Gruppo non valido.");
            }

            UserType nuovoUtente = rispostaCreazioneUtente.user();
            GroupType group = GroupType.builder().groupName(nomeGruppo).build();

            AdminAddUserToGroupRequest addUserToGroupRequest = AdminAddUserToGroupRequest.builder()
                    .userPoolId("eu-central-1_aseBjh2cw")
                    .username(nuovoUtente.username())
                    .groupName(nomeGruppo)
                    .build();

            AdminAddUserToGroupResponse addUserToGroupResult = cognitoClient.adminAddUserToGroup(addUserToGroupRequest);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operazione corretta");
            alert.setHeaderText("L'operazione è andata a buon fine.");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
            }



        } catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Errore durante l'inserimento");
            alert.setContentText(e.getMessage());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
            }

        }

 */
}
