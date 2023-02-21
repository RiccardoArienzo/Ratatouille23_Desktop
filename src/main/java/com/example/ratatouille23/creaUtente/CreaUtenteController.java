package com.example.ratatouille23.creaUtente;

import com.example.ratatouille23.Utils.CognitoSettings;
import com.example.ratatouille23.homepage.Homepage;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.ListGroupsResponse;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreaUtenteController {



    @FXML
    TextField nomeUtenteTextField;
    @FXML
    TextField emailTextField;
    @FXML
    ComboBox tipoDipendenteComboBox;
    @FXML
    Button pulsanteRegistraUtente;

    private Homepage homepage = new Homepage();

    public void initialize(){
        // Creazione di un'istanza del client CognitoIdentityProvider
        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder().region(Region.EU_CENTRAL_1).build();

        ListGroupsRequest listGroupsRequest = ListGroupsRequest.builder()
                .userPoolId("eu-central-1_aseBjh2cw")
                .build();

        ListGroupsResponse listGroupsResponse = cognitoClient.listGroups(listGroupsRequest);
        // Popola la combobox con la lista dei gruppi ottenuta dalla risposta
        List<GroupType> groups = listGroupsResponse.groups();
        for (GroupType group : groups) {
            tipoDipendenteComboBox.getItems().add(group.groupName());
        }
        pulsanteRegistraUtente.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> nomeUtenteTextField.getText().isEmpty()  || emailTextField.getText().isEmpty() || tipoDipendenteComboBox.getValue() == null,
                        nomeUtenteTextField.textProperty(),
                        emailTextField.textProperty(),
                        tipoDipendenteComboBox.valueProperty()
                )
        );


    }


    public void clickPulsanteIndietro(ActionEvent event) {
        try {
            if (verificaCampiVuoti()) {
                homepage.apriSchermataHome(event);
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Conferma");
                alert.setHeaderText("Sei sicuro di voler tornare indietro?");
                alert.setContentText("I dati inseriti non verranno salvati.");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    homepage.apriSchermataHome(event);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void clickPulsanteRegistraUtente(ActionEvent event){
        registraUtente();
    }


    public boolean verificaCampiVuoti(){
        if (emailTextField.getText().isEmpty() && nomeUtenteTextField.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public void registraUtente(){

        // Creazione di un'istanza del client CognitoIdentityProvider
        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder().region(Region.EU_CENTRAL_1).build();

        AdminCreateUserRequest richiestaCreazioneUtente = AdminCreateUserRequest.builder()
                .username(nomeUtenteTextField.getText())
                .desiredDeliveryMediums(DeliveryMediumType.EMAIL)
                .userAttributes(AttributeType.builder()
                        .name("email")
                        .value(emailTextField.getText())
                        .build())
                .userPoolId("eu-central-1_aseBjh2cw")
                .build();

        // Invio della richiesta di registrazione
        AdminCreateUserResponse rispostaCreazioneUtente = cognitoClient.adminCreateUser(richiestaCreazioneUtente);

        // Salviamo in una variabile il nome del gruppo selezionato dalla combobox
        String nomeGruppo = (String) tipoDipendenteComboBox.getValue();

        UserType nuovoUtente = rispostaCreazioneUtente.user();
        GroupType group = GroupType.builder().groupName(nomeGruppo).build();

        AdminAddUserToGroupRequest addUserToGroupRequest = AdminAddUserToGroupRequest.builder()
                .userPoolId("eu-central-1_aseBjh2cw")
                .username(nuovoUtente.username())
                .groupName(nomeGruppo)
                .build();

        AdminAddUserToGroupResponse addUserToGroupResult = cognitoClient.adminAddUserToGroup(addUserToGroupRequest);
        //TODO aggiungere un dialog che conferma se la registrazione sia andata a buon fine o eventualmente che errore c'è stato
        //System.out.println("Registration successful. Confirmation code: " + rispostaCreazioneUtente.user());


    }


}

