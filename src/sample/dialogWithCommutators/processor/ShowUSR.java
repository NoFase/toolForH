package sample.dialogWithCommutators.processor;

import sample.dialogWithCommutators.commands.LstPra;
import sample.staticVariable.StaticVariables;

public class ShowUSR {
    public ShowUSR() {
        StaticVariables.isCommands.put("LSTPRA", true);
        StaticVariables.connection.sendString(new LstPra().creatingCommand());

    }
}
