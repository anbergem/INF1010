import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Bergem on 15/04/16.
 */
public class Program extends Application {

    Scene scene;

    BorderPane root;
    GridPane knappepanel;

    VBox skrivepanel;

    /* Selve tabellen vår */
    TableView<Rad> tabell = new TableView<>();

    /* Noe dill dall for at det skal funke */
    /* Dataen som vi skal leggge inn i tabellen */
    ObservableList<Rad> data = FXCollections.observableArrayList();

    TextField skrivefelt1;
    TextField skrivefelt2;

    public class Rad {
        // Nødvendig for at strengen skal vises i tabellen
        private final SimpleStringProperty uttrykk;
        private final SimpleStringProperty svar;

        Rad(String uttrykk, String svar) {
            // this.uttrykk = uttrykk fungere ikke
            // Må lage et nytt object av SimpleStringProperty
            // med strengen som parameter
            this.uttrykk = new SimpleStringProperty(uttrykk);
            this.svar = new SimpleStringProperty(svar);
        }

        /* MÅ HA MED GET-METODER */
        public String getUttrykk() {
            return uttrykk.get();
        }

        /* MÅ HA MED GET-METODER */
        public String getSvar() {
            return svar.get();
        }
    }

    public static void main(String[] args) {
        /* Kjøre programmet! */
        launch(args);

        /* Main-tråden venter på at GUI-tråden skal bli ferdig */

        /* Gjøres ikke før GUI er lukket */
        System.out.println("HEI!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /* Begynner med nodene til skrivepanelet vårt */

        // Skrivefelt
        skrivefelt1 = new TextField("Skriv her");
        skrivefelt2 = new TextField("og her");

        // Lager knapper
        Button pluss = new Button("+");
        Button minus = new Button("-");
        Button gange = new Button("*");
        Button dele = new Button("/");
        Button klarer = new Button("Klarer");

        // Setter bruken til knappen
        pluss.setOnAction(new Knappelytter("pluss"));
        minus.setOnAction(new Knappelytter("minus"));
        gange.setOnAction(new Knappelytter("gange"));
        dele.setOnAction(new Knappelytter("dele"));
        klarer.setOnAction(new Knappelytter("klarer"));

        // Legg til knaper i et knappepanel
        knappepanel = new GridPane();
        knappepanel.add(pluss, 0, 0);
        knappepanel.add(minus, 1, 0);
        knappepanel.add(gange, 0, 1);
        knappepanel.add(dele, 1, 1);
        knappepanel.setAlignment(Pos.CENTER);

        // To forskjellige måter å sette borde på et panel
//        knappepanel.setBorder(new Border(new BorderStroke(Color.RED,
//                BorderStrokeStyle.DASHED,
//                CornerRadii.EMPTY,
//                new BorderWidths(1, 1, 1, 1))));
        knappepanel.setStyle("-fx-border-color: red");

        /* Skrivepanel
        * Legger til skrivefelt og knappepanelet
        * Setter det til å være sentrert */

        skrivepanel = new VBox(10);
        skrivepanel.getChildren().addAll(klarer, skrivefelt1, knappepanel, skrivefelt2);
        skrivepanel.setAlignment(Pos.CENTER);
        skrivepanel.setPadding(new Insets(15));

        /* Tabellen */

        // Lager kolonner
        TableColumn uttrykk = new TableColumn("Uttrykk");
        TableColumn løsning = new TableColumn("Løsning");

        // Setter hva som skal være i kolonnene
        // "uttrykk" referer til 'private final SimpleStringProperty uttrykk' i Rad
        uttrykk.setCellValueFactory(new PropertyValueFactory<>("uttrykk"));
        løsning.setCellValueFactory(new PropertyValueFactory<>("svar"));

        // Setter data (ObservableList) inn i tabellen
        tabell.setItems(data);
        // Legger kolonnene i tabellen
        tabell.getColumns().addAll(uttrykk, løsning);

        // Setter tabellen inn i en FlowPane, for at den skal
        // være lettere å jobbe med
        FlowPane tabellpanel = new FlowPane();
        tabellpanel.getChildren().add(new ScrollPane(tabell));
        tabellpanel.setAlignment(Pos.CENTER);

        /* Hovedpanelet */

        root = new BorderPane();
//        root.setTop(tekst1);
//        root.setLeft(tekst2);
        root.setCenter(tabellpanel);
        root.setRight(skrivepanel);
//        root.setBottom(tekst5);

        /* STANDAROPPSETT */
        /* Scenen */

        scene = new Scene(root, 500, 500);

        /* Stagen */

        primaryStage.setScene(scene);
        primaryStage.setTitle("Kalkulator");
        primaryStage.show();

    }

    class Knappelytter implements EventHandler<ActionEvent> {
        Double en, to;
        String valg;

        Knappelytter(String valg) {
            this.valg = valg;
        }

        /* MÅ ha med for EventHandler
        * velger hva vi skal gjøre ut i fra
        * valget som sendes inn*/
        @Override
        public void handle(ActionEvent event) {
            if (valg.equals("klarer")) {
                data.clear();
                return;
            }
            /* Prøv å konverter teksten til en double */
            try {
                en = Double.parseDouble(skrivefelt1.getText());
                to = Double.parseDouble(skrivefelt2.getText());
            }
            /* Håndter feil - BRUKERVENNLIG :) */
            catch (NumberFormatException e) {
                data.add(new Rad("Ugyldig", ""));
                return;
            }
            /* Utfør opperasjonen og legg det inn i data
            * Data (ObservableList) tar imot Rader, så vi må
            * lage nye rader for å kunne legge ting inn i tabellen
            * vår. Rad tar imot to parametre, uttrykk og svar */
            switch (valg) {
                case "pluss":
//                    System.out.printf("%s + %s = %.2f\n", skrivefelt1.getText(), skrivefelt2.getText(), en+to);
                    data.add(new Rad(String.format("%s + %s\n", skrivefelt1.getText(), skrivefelt2.getText()),
                            String.format("%.2f\n", en + to)));
                    break;
                case "minus":
                    data.add(new Rad(String.format("%s - %s\n", skrivefelt1.getText(), skrivefelt2.getText()),
                            String.format("%.2f\n", en - to)));
//                    System.out.printf("%s - %s = %.2f\n", skrivefelt1.getText(), skrivefelt2.getText(), en-to);
                    break;
                case "gange":
                    data.add(new Rad(String.format("%s * %s\n", skrivefelt1.getText(), skrivefelt2.getText()),
                            String.format("%.2f\n", en * to)));
                    break;
                case "dele":
                    data.add(new Rad(String.format("%s / %s\n", skrivefelt1.getText(), skrivefelt2.getText()),
                            String.format("%.2f\n", en / to)));
                    break;
                default:
                    break;
            }
        }
    }
}
