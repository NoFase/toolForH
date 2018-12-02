package sample.dialogWithCommutators.commands;

import sample.staticVariable.StaticVariables;

public class LstPra implements Command {

    private StringBuffer command;

    public LstPra() {
        command = new StringBuffer().append("LST PRA:;");
        StaticVariables.isCommands.put("LSTPRA", true);
    }

    @Override
    public String creatingCommand() {
        return command.toString();
    }
}
