package sample.dialogWithCommutators.processor;

import sample.staticVariable.StaticVariables;
import sun.plugin2.message.Message;

import java.util.Map;

import static sample.staticVariable.StaticVariables.connection;

public class FilterMessagesFromServer {
    private String message;

    public FilterMessagesFromServer(String message) {
        this.message = message;
        if (message == null) connection.disconnect();
    }

    public boolean status(){
         if (message.contains("logged in successfully")) return true;
        return false;
    }

    public void choiceAnalysis (){
        for (Map.Entry<String, Boolean> entry: StaticVariables.isCommands.entrySet()){
            if (entry.getValue()) analyze(entry.getKey());
        }
    }

    private void analyze(String key) {
        switch (key){
            case "LSTPRA":
                new FilterLstPra(message);
                break;
            case "LSTMSBR":
                new FilterLstMsbr(message);
                break;
        }

    }
}
