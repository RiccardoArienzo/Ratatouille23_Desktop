package com.example.ratatouille23.Test;

import com.example.ratatouille23.Controller.Amministratore.CreaUtenteController;
import com.example.ratatouille23.View.Admin.CreaUtenteView;
import de.saxsys.javafx.test.JfxRunner;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JfxRunner.class)
public class CreaUtenteTest {

    CreaUtenteView creaUtente;
    CreaUtenteController controller;

    @Before
    public void setup(){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/crea-utente.fxml"));
            loader.load();
            this.creaUtente = loader.getController();
            this.creaUtente.setNode(loader.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        controller = creaUtente.getCreaUtenteController();
    }


    @Test
    public void NomeNull_MailNull_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, null, null);
            });
        });
    }

    @Test
    public void NomeNull_MailNull_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, null, "");
            });
        });
    }

    @Test
    public void NomeNull_MailNull_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, null, "Addetto_Alla_Cassa");
            });
        });
    }

    @Test
    public void NomeNull_MailNull_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, null, "Supervisore");
            });
        });
    }

    @Test
    public void NomeNull_MailVuota_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "", null);
            });
        });
    }

    @Test
    public void NomeNull_MailVuota_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "", "");
            });
        });
    }

    @Test
    public void NomeNull_MailVuota_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "", "ciao");
            });
        });
    }



     @Test
    public void NomeNull_MailVuota_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "", "Supervisore");
            });
        });
    }



     @Test
    public void NomeNull_MailNonValida_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "ciao", null);
            });
        });
    }


     @Test
    public void NomeNull_MailNonValida_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "ciao", "");
            });
        });
    }


     @Test
    public void NomeNull_MailNonValida_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "ciao@", "ciao");
            });
        });
    }


     @Test
    public void NomeNull_MailNonValida_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "ciao", "Supervisore");
            });
        });
    }


     @Test
    public void NomeNull_MailValida_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, null, null);
            });
        });
    }


     @Test
    public void NomeNull_MailValida_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "ciao@hotmail.it", "");
            });
        });
    }


     @Test
    public void NomeNull_MailValida_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "ciao@hotmail.it", "ciao");
            });
        });
    }


     @Test
    public void NomeNull_MailValida_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, "ciao@hotmail.it", "Supervisore");
            });
        });
    }



     @Test
    public void NomeVuoto_MailNull_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", null, null);
            });
        });
    }


     @Test
    public void NomeVuoto_MailNull_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", null, "");
            });
        });
    }


    @Test
    public void NomeVuoto_MailNull_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", null, "ciao");
            });
        });
    }


    @Test
    public void NomeVuoto_MailNull_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", null, "Supervisore");
            });
        });
    }


    @Test
    public void NomeVuoto_MailVuota_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, null, null);
            });
        });
    }


    @Test
    public void NomeVuoto_MailVuota_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", "", "");
            });
        });
    }


    @Test
    public void NomeVuoto_MailVuota_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", "", "ciao");
            });
        });
    }


    @Test
    public void NomeVuoto_MailVuota_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", "", "Supervisore");
            });
        });
    }


    @Test
    public void NomeVuoto_MailNonValida_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", "ciao@", null);
            });
        });
    }


    @Test
    public void NomeVuoto_MailNonValida_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", "ciao", "");
            });
        });
    }


    @Test
    public void NomeVuoto_MailNonValida_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", "ciao@", "ciao");
            });
        });
    }


    @Test
    public void NomeVuoto_MailNonValida_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", "ciao@", "Supervisore");
            });
        });
    }


    @Test
    public void NomeVuoto_MailValida_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente(null, null, null);
            });
        });
    }


    @Test
    public void NomeVuoto_MailValida_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", "ciao@", "");
            });
        });
    }


    @Test
    public void NomeVuoto_MailValida_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", "ciao@libero.it", "ciao");
            });
        });
    }


    @Test
    public void NomeVuoto_MailValida_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("", "ciao@libero.it", "Supervisori");
            });
        });
    }


    @Test
    public void NomePieno_MailNull_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", null, null);
            });
        });
    }


    @Test
    public void NomePieno_MailNull_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", null, "");
            });
        });
    }


     @Test
    public void NomePieno_MailNull_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", null, "ciao");
            });
        });
    }


     @Test
    public void NomePieno_MailNull_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", null, "Supervisori");
            });
        });
    }


     @Test
    public void NomePieno_MailVuota_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "", null);
            });
        });
    }



     @Test
    public void NomePieno_MailVuota_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "", "");
            });
        });
    }


     @Test
    public void NomePieno_MailVuota_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "", "ciao");
            });
        });
    }


     @Test
    public void NomePieno_MailVuota_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "", "Supervisori");
            });
        });
    }



     @Test
    public void NomePieno_MailNonValida_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "ciao", null);
            });
        });
    }


     @Test
    public void NomePieno_MailNonValida_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "ciao", "");
            });
        });
    }


     @Test
    public void NomePieno_MailNonValida_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "ciao", "ciao");
            });
        });
    }


     @Test
    public void NomePieno_MailNonValida_GruppoValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "ciao", "Supervisori");
            });
        });
    }


     @Test
    public void NomePieno_MailValida_GruppoNull(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "ciao@libero.it", null);
            });
        });
    }



     @Test
    public void NomePieno_MailValida_GruppoVuoto(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "ciao@libero.it", "");
            });
        });
    }


     @Test
    public void NomePieno_MailValida_GruppoNonValido(){
        Platform.runLater(() -> {
            assertThrows(IllegalArgumentException.class, () -> {
                controller.registraUtente("Marco", "ciao@libero.it", "ciao");
            });
        });
    }


     @Test
    public void NomePieno_MailValida_GruppoValido(){
        Platform.runLater(() -> {
            assertEquals(true, controller.registraUtente("Marco", "ciao@libero.it", "Supervisori"));
        });
    }





}
