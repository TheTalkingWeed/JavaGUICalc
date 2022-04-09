import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils  {

    public static  List<String> beolvas(String filename) throws IOException {
        List<String> result = new ArrayList<>();

        String line;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while ((line=br.readLine())!=null){
            result.add(line);
        }

        br.close();
        return result;
    }


    public static void beir(String filename,String username,String password) throws IOException{
        FileWriter fw = new FileWriter(filename,true);


        fw.write(username);
        fw.write(" ");
        fw.write(password);
        fw.write("\n");
        fw.close();
    }


    public static void saveConfig() throws IOException{
        FileWriter fw = new FileWriter("config.txt",false);

        fw.write(String.valueOf(FontFormater.betumeret.getValue()));
        fw.write(";");
        fw.write(String.valueOf(FontFormater.types1.getSelectedItem()));

        fw.close();
    }


    public static String configRead() throws IOException{
        String result="";
         BufferedReader br = new BufferedReader(new FileReader("config.txt"));

         result = br.readLine();

         br.close();
        return result;
    }



}
