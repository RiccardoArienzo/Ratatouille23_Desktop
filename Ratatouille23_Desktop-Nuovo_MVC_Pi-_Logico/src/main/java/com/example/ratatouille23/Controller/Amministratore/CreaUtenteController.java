package com.example.ratatouille23.Controller.Amministratore;

import com.example.ratatouille23.Model.DAO.DAOImplUnirest.UtenteDAOImplUnirest;
import com.example.ratatouille23.Model.DAO.DAOInterface.UtenteDAO;
import com.example.ratatouille23.Model.DTO.UtenteDTO;
import com.example.ratatouille23.Model.Utente;
import com.example.ratatouille23.View.Admin.CreaUtenteView;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

import java.util.List;

public class CreaUtenteController {

    CreaUtenteView creaUtente;
    UtenteDAO utenteDAO;

    public CreaUtenteController(CreaUtenteView view){
        this.creaUtente = view;
        utenteDAO = new UtenteDAOImplUnirest();
    }


    // Event Handler

    public void onBtnRegistraUtenteClicked(){
       UserType nuovoUtente = registraUtente();
       if (nuovoUtente != null){
           UtenteDTO utente = new UtenteDTO();
           utente.setEmail(creaUtente.getEmailText());
           utente.setGruppo(creaUtente.getTipoDipendenteComboBox().toString());
           utente.setUsername(creaUtente.getUsernameText());
           utenteDAO.addUtente(utente);
       }
    }

    // Logic

    public boolean verificaCampiVuoti(){
        if (creaUtente.getEmailText().isEmpty() && creaUtente.getUsernameText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public UserType registraUtente() {

        // Creazione di un'istanza del client CognitoIdentityProvider
        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder().region(Region.EU_CENTRAL_1).build();

        AdminCreateUserRequest richiestaCreazioneUtente = AdminCreateUserRequest.builder()
                .username(creaUtente.getUsernameText())
                .desiredDeliveryMediums(DeliveryMediumType.EMAIL)
                .userAttributes(AttributeType.builder()
                        .name("email")
                        .value(creaUtente.getEmailText())
                        .build())
                .userPoolId("eu-central-1_aseBjh2cw")
                .build();

        // Invio della richiesta di registrazione
        AdminCreateUserResponse rispostaCreazioneUtente = cognitoClient.adminCreateUser(richiestaCreazioneUtente);

        // Salviamo in una variabile il nome del gruppo selezionato dalla combobox
        String nomeGruppo = (String) creaUtente.getTipoDipendenteComboBox().getValue();

        UserType nuovoUtente = rispostaCreazioneUtente.user();
        GroupType group = GroupType.builder().groupName(nomeGruppo).build();

        AdminAddUserToGroupRequest addUserToGroupRequest = AdminAddUserToGroupRequest.builder()
                .userPoolId("eu-central-1_aseBjh2cw")
                .username(nuovoUtente.username())
                .groupName(nomeGruppo)
                .build();

        AdminAddUserToGroupResponse addUserToGroupResult = cognitoClient.adminAddUserToGroup(addUserToGroupRequest);

        //TODO aggiungere un dialog che conferma se la registrazione sia andata a buon fine o eventualmente che errore c'è stato
        System.out.println("Registration successful. Confirmation code: " + rispostaCreazioneUtente.user());
        return rispostaCreazioneUtente.user();
    }



        // Utility

    public void fillGroupsCombobox(){
        // Creazione di un'istanza del client CognitoIdentityProvider
        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder().region(Region.EU_CENTRAL_1).build();

        ListGroupsRequest listGroupsRequest = ListGroupsRequest.builder()
                .userPoolId("eu-central-1_aseBjh2cw")
                .build();

        ListGroupsResponse listGroupsResponse = cognitoClient.listGroups(listGroupsRequest);


        // Popola la combobox con la lista dei gruppi ottenuta dalla risposta
        List<GroupType> groups = listGroupsResponse.groups();
        for (GroupType group : groups) {
            creaUtente.getTipoDipendenteComboBox().getItems().add(group.groupName());
        }
    }

}
