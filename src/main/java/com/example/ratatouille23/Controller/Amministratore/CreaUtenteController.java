package com.example.ratatouille23.Controller.Amministratore;

import com.example.ratatouille23.View.Admin.CreaUtenteView;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreaUtenteController {

    CreaUtenteView creaUtente;
    private CognitoIdentityProviderClient cognitoClient;

    public CreaUtenteController(CreaUtenteView view){
        this.creaUtente = view;
        cognitoClient = CognitoIdentityProviderClient.builder().region(Region.EU_CENTRAL_1).build();

    }


    // Event Handler

    public void onBtnRegistraUtenteClicked(String username, String mail, String group){
        registraUtente(username, mail, group);
    }

    // Logic

    public boolean verificaCampiVuoti(){
        if (creaUtente.getEmailText().isEmpty() && creaUtente.getUsernameText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public boolean registraUtente(String username, String mail, String gruppo){

        try {
            if (!(verificaCorrettezzaEmail(mail))) {
                throw new IllegalArgumentException("Mail non valida.");
            }

            if(!(verificaUsername(username))){
                throw new IllegalArgumentException("Username non valido. Inserisci uno username non vuoto.");
            }

            if (!(verificaGruppoCorretto(gruppo))) {
                throw new IllegalArgumentException("Gruppo non valido.");
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
                return true;
            }



        } catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Errore durante l'inserimento");
            alert.setContentText(e.getMessage());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                return false;
            }

        }
        return false;
    }




        // Utility

    public void riempiComboboxGruppi(){
        // Creazione di un'istanza del client CognitoIdentityProvider


        ListGroupsResponse listGroupsResponse = ottieniGruppiCognito();

        // Popola la combobox con la lista dei gruppi ottenuta dalla risposta
        List<GroupType> groups = listGroupsResponse.groups();
        for (GroupType group : groups) {
            creaUtente.getTipoDipendenteComboBox().getItems().add(group.groupName());
        }
    }

    public boolean verificaCorrettezzaEmail(String email) throws IllegalArgumentException {
        if(email==null)
            throw new IllegalArgumentException();
        Pattern path = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})");
        Matcher m = path.matcher(email);
        return m.matches();
    }

    public ListGroupsResponse ottieniGruppiCognito(){
        ListGroupsRequest listGroupsRequest = ListGroupsRequest.builder()
                .userPoolId("eu-central-1_aseBjh2cw")
                .build();
        return cognitoClient.listGroups(listGroupsRequest);
    }
    public boolean verificaGruppoCorretto(String gruppo){
        ObservableList<String> items = creaUtente.getTipoDipendenteComboBox().getItems();
        return items.contains(gruppo);
    }

    public boolean verificaUsername(String user) {
        return user != null && !user.isEmpty();
    }

}
