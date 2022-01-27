package user.kmCHIB.bot.commands;

import java.io.*;
import java.util.ArrayList;

/* TO DO
- add a type of data args (name of data, data)
- make a reader
- make a writer
- dont use binary search for now since we are not making a lot
name:38210390238
 */
public class heldData {
    private String filepath;

    public heldData(String filepath){
        this.filepath = filepath;
    }

    public void createData(String name, String data){
        saveData(name + ":" + data);

    }
    public void updateData(String name, String input){
        ArrayList<String> total  = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();;
            while (line != null){
                total.add(line);
                String[] listData = line.split(":");
                if (listData[0].equalsIgnoreCase(name)){
                    try(PrintWriter writer = new PrintWriter(filepath)) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < total.size()-1; i++)
                        {
                            sb.append(total.get(i));
                            sb.append('\n');
                        }
                        sb.append(name + ":" + input);
                        sb.append('\n');
                        writer.write(sb.toString());

                    }
                    catch(FileNotFoundException e){}
                    total.clear();
                    line = reader.readLine();
                }
                line = reader.readLine();
                saveData(line);
            }
            reader.close();
        }
        catch (IOException exception)
        {exception.printStackTrace();}
    }

    public String searchHDataByName(String name){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();;
            while (line != null){
                String[] listData = line.split(":");
                if (listData[0].equalsIgnoreCase(name)){
                    return listData[1];
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException exception)
        {exception.printStackTrace();}

        return null; //end searchHData
    }

    private void saveData(String message){
        ArrayList<String> total = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line = br.readLine();
            while (line != null)
            {
                total.add(line);
                line = br.readLine();

            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try(PrintWriter writer = new PrintWriter(filepath))
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < total.size(); i++)
            {
                sb.append(total.get(i));
                sb.append('\n');
            }
            sb.append(message);
            sb.append('\n');
            writer.write(sb.toString());
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

