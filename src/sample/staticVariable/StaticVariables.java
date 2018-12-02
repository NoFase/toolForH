package sample.staticVariable;


import sample.dialogWithCommutators.customers.Customer;
import sample.network.TCPConnection;

import java.util.HashMap;

public class StaticVariables {
    public static HashMap<String, String[]> listOfServers = new HashMap<String, String[]>();
    public static String loginName;
    public static String ipServer;
    public static String ipLocalWS = "10.188.4.154";
    public static String passwordForLogin;
    public static TCPConnection connection;
    public static HashMap<String, Boolean> isCommands = new HashMap<>();
    public static HashMap<String, Customer> customers = new HashMap<>();

    {
        isCommands.put("LSTPRA", false);
        isCommands.put("LSTMSBR", false);
        isCommands.put("LSTVSBR", false);
    }

}
