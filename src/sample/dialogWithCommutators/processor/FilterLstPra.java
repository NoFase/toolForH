package sample.dialogWithCommutators.processor;


import sample.dialogWithCommutators.customers.*;
import sample.staticVariable.StaticVariables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterLstPra {
//    private String message;
    private String[] line;
    private int totalPra = 0;

    public FilterLstPra(String message) {
//        this.message = message;

        String regex = "^\\s\\d{5,}\\s";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(message);
//        System.out.println(message + "\n" + message.matches(regex) + "\n" + message.contains(regex));
        if (m.find()) {
            line = message.split("\\s+");
//            System.out.println("===============>>>");
            StaticVariables.customers.put(line[1], new CustomerPra(line[1], line[2], line[4], line[5],line[6]));
            System.out.println("===> " + message);
        }
        else if (message.contains("Number of results =")){
            String[] lex = message.split("=");
            StringBuffer l = new StringBuffer(lex[1].trim());
            l.deleteCharAt(l.length()-1);
            totalPra = Integer.parseInt(l.toString());
            StaticVariables.isCommands.put("LSTPRA", false);
        }
//        else if (message.contains("---    END")) {
//            StaticVariables.isCommands.put("LSTPRA", false);
//            System.out.println(message);
//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
//        }
        else System.out.println(message);
//        System.out.println(StaticVariables.customers.size() + " === " + totalPra);
//        System.out.println(totalPra + "<=== total");
    }
}
