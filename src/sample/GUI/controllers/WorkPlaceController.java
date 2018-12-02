package sample.GUI.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuItem;
import sample.GUI.otherWindows.MyAlert;
import sample.dialogWithCommutators.commands.LGI;
import sample.dialogWithCommutators.commands.LstTg;
import sample.dialogWithCommutators.processor.FilterMessagesFromServer;
import sample.dialogWithCommutators.processor.ShowUSR;
import sample.network.TCPConnection;
import sample.network.TCPConnectionListener;


import java.io.IOException;

import static sample.staticVariable.StaticVariables.connection;
import static sample.staticVariable.StaticVariables.ipServer;

public class WorkPlaceController extends MainController implements TCPConnectionListener {

    final private String INS = "\n\t\t* * * * *\n";
    private Boolean isConnection = false;

    @FXML
    private TextArea fldWorkPlace;

    @FXML
    private TextArea fldWorkLog;

    @FXML
    void appReconnecting(ActionEvent event) {
        System.out.println(connection.toString());
        if (isConnection) {
            new MyAlert("Вы все еще подключены к серверу!");

        } else {
            try {
                connection = new TCPConnection(this, ipServer, 6000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void appShowUsr(ActionEvent event){
       new ShowUSR();
//    connection.sendString(new LstTg().creatingCommand());

    }


    @FXML
    void initialize() {

        try {
            connection = new TCPConnection(this, ipServer, 6000);
//            out = new ObjectOutputStream(new FileOutputStream("outObject.dat"));

        } catch (IOException e) {}

    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        itDisconnect.setDisable(false);
        itReconnect.setDisable(true);
        itConnect.setDisable(true);
        itShowUsr.setDisable(false);
        isConnection = true;
        System.out.println("Connection ready to IP: " + ipServer);
//        fldWorkLog.setStyle("-fx-text-fill: blue ;");
        fldWorkLog.appendText("Connection ready to IP: " + ipServer + INS);

        connection.sendString(new LGI().creatingCommand());
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
//        fldWorkPlace.appendText(value + "\n");
//        System.out.println(value);
        FilterMessagesFromServer filter = new FilterMessagesFromServer(value);
        if (filter.status()) fldWorkLog.appendText(value + INS);
        else filter.choiceAnalysis();
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        itConnect.setDisable(false);
        itReconnect.setDisable(false);
        itDisconnect.setDisable(true);
        itShowUsr.setDisable(true);
        isConnection = false;
        System.out.println("Disconnect from ip: " + ipServer);
//        fldWorkLog.setStyle("-fx-text-fill: blue ;");
        fldWorkLog.appendText("Disconnect from ip: " + ipServer + INS);
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {

    }
}
