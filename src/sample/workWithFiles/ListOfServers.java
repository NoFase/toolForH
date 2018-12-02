package sample.workWithFiles;

import workWithFiles.ReadFromFile;
import workWithFiles.WriteToFile;

import java.io.IOException;
import static sample.staticVariable.StaticVariables.listOfServers;

public class ListOfServers {


    public void reading(){
        try {
            ReadFromFile rf = new ReadFromFile("servers.txt");
            String[] lines = rf.reading().toString().split("\n");
            for (String x: lines){
                String[] partOfLine = x.split(":");
//                первая часть это название вторая это IP
                if (partOfLine.length > 1)listOfServers.put(partOfLine[0], new String[]{partOfLine[1], partOfLine[2]});
//                else listOfServers.put("none", "none");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writing(String abr) throws IOException {
        String name, ip;
        name = listOfServers.get(abr)[0];
        ip = listOfServers.get(abr)[1];
        new WriteToFile("servers.txt").writing(abr + ":" + name + ":" + ip + "\n");
    }
}
