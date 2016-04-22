import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by Bergem on 22/04/16.
 */
public class TicTacToe  extends Application{

    Scene ticTacScene;
    Scene startScene;

    BorderPane root;

    GridPane brett;

    /* Brukes for løsningen, 1d for diagonal */
    MinStackPane panes [][];
    MinStackPane panes1d [];

    int teller = 0;

    public static void main(String[] args) {
        launch(args);
    }

    public class MinStackPane extends StackPane {
        int id, radId, kolonneId
        String tekst;

        public MinStackPane(int id, String tekst, int radId, int kolonneId) {
            this.id = id;
            this.tekst = tekst;
            this.kolonneId = kolonneId;
            this.radId = radId;
        }
        public void settTekst(String tekst) {this.tekst = tekst;}
        public String hentTekst() {return tekst;}
        public int hentId() {return id;}
        public int getRadId() {return radId;}
        public int getKolonneId() {return kolonneId;}
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        brett = new GridPane();
        panes = new MinStackPane[3][3];
        panes1d = new MinStackPane[9];

        /* Lag rutenett */
        int t = 0;
        for (int r = 0; r < 3; r++) {
            for (int k = 0; k < 3; k++) {
                MinStackPane pane = new MinStackPane(t, " ", r, k);
                pane.setStyle("-fx-border-color: black");
                pane.setOnMouseReleased(new Lytter(pane));
                panes[r][k] = pane;
                panes1d[t] = pane;
                brett.add(pane, k, r);
                t++;
            }
        }

        /* Lag rutene like store og sett brettet i midten 
        * Constraint -> begrensning
        */
        int storrelse = 150;
        for (int i = 0; i < 3; i++) {
            brett.getColumnConstraints().add(new ColumnConstraints(storrelse));
            brett.getRowConstraints().add(new RowConstraints(storrelse));
        }
        brett.setAlignment(Pos.CENTER);

        /* Klarer-knapp */
        Button klarer = new Button("Klarer");
        klarer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (MinStackPane pane : panes1d) {
                    pane.getChildren().clear();
                    pane.settTekst(" ");
                }
            }
        });
        klarer.setAlignment(Pos.CENTER);

        /* DET SAMME! */
        root = new BorderPane(brett);
//        root = new BorderPane();
//        root.getChildren().add(brett);
        root.setTop(new FlowPane(klarer));

        ticTacScene = new Scene(root);
        
        /* Lag startvindu med en knapp for å bytte scene */
        Button startButton = new Button("La oss starte");
        /* Annonym klasse (IKKE PENSUM) */
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Bytt scnee ved knappetrykk
                primaryStage.setScene(ticTacScene);
            }
        });
        FlowPane startRoot = new FlowPane(startButton);
        startScene = new Scene(startRoot);

        primaryStage.setScene(startScene);
        primaryStage.setTitle("TicTacToe");
        primaryStage.show();

    }

    public class Lytter implements EventHandler<MouseEvent> {
        MinStackPane pane;

        public Lytter(MinStackPane pane) {this.pane = pane;}

        @Override
        public void handle(MouseEvent event) {
            if (pane.getChildren().isEmpty()) {
                // String tekst = teller++ % 2 == 0 ? "X" : "O";
                String tekst;
                if (teller % 2 == 0) tekst = "X";
                else tekst = "O";
                Label label = new Label(tekst);
                label.setFont(new Font(40));
                pane.getChildren().add(label);
                pane.settTekst(tekst);
                teller++;
            }
            if (sjekkBrett(pane)) {
                System.out.println("YAY");
            }
        }
    }

    private boolean sjekkBrett(MinStackPane pane) {
        boolean flagg = false;

        if (sjekkRad(pane) || 
            sjekkKolonne(pane) || 
            sjekkDiagonal(pane)) 
            flagg = true;

        return flagg;
    }

    private boolean sjekkRad(MinStackPane pane) {
        boolean flagg = true;
        String tekst = pane.hentTekst();

        /* Holder kolonnen konstant, og går gjennom radene */
        int id = pane.getKolonneId();
        for (int i = 0; i < 3; i++) {
            // Pane'n vår har teksten 'tekst'
            if (panes[i][id] == pane) {}
            else {
                if (!panes[i][id].hentTekst().equals(tekst)) {
                    flagg = false;
                }
            }
        }
        return flagg;
    }

    private boolean sjekkKolonne(MinStackPane pane) {
        boolean flagg = true;
        String tekst = pane.hentTekst();

        /* Holder raden konstant, og går gjennom kolonnene */
        int id = pane.getRadId();
        for (int i = 0; i < 3; i++) {
            if (panes[id][i] == pane) {}
            else {
                if (!panes[id][i].hentTekst().equals(tekst)) {
                    flagg = false;
                }
            }
        }
        return flagg;
    }

    private boolean sjekkDiagonal(MinStackPane pane) {
        boolean flagg = false;
        int id = pane.hentId();

        // Diagonalpane'ene er alle partall
        if (id % 2 != 0) return false;

        // Midt-pane'n. Sjekke begge diagonalene
        else if (id == 4) {
            if (sjekkHøyreDiagonal(pane) || sjekkVenstreDiagonal(pane)) flagg = true;
        }

        // Høyrediagonalen er delelig med 4
        else if (id % 4 == 0) {
            flagg = sjekkHøyreDiagonal(pane);
        }

        // Det er ikke venstrediagonalen
        else {
            flagg = sjekkVenstreDiagonal(pane);
        }
        return flagg;
    }

    private boolean sjekkHøyreDiagonal(MinStackPane pane) {
        boolean flagg = true;
        String tekst = pane.hentTekst();

        // Gå igjennom 0 - 4 - 8
        for (int i = 0; i < 9; i += 4) {
            if (panes1d[i] == pane) {}
            else if (!panes1d[i].hentTekst().equals(tekst)) {
                flagg = false;
            }
        }
        return flagg;
    }

    private boolean sjekkVenstreDiagonal(MinStackPane pane) {
        boolean flagg = true;
        String tekst = pane.hentTekst();

        // Gå igjennom 2 - 4 - 6
        for (int i = 2; i < 7; i += 2) {
            if (panes1d[i] == pane) {}
            else if (!panes1d[i].hentTekst().equals(tekst)) {
                flagg = false;
            }
        }
        return flagg;
    }
}



































