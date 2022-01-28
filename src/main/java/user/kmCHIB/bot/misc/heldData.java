package user.kmCHIB.bot.misc;

import java.io.*;
import java.util.ArrayList;

/* TODO
✔ add a type of data args (name of data, data)
✔ make a reader
✔ make a reader
- doesn't read the first line
- dont use binary search for now since we are not making a lot
 */
public class heldData {
    private String filepath;

    public heldData(String filepath) {
        this.filepath = filepath;
    }

    public void createData(String name, String data) {
        saveData(name + ":" + data);
    }

    public void updateData(String target, String input) {
        try {
            ArrayList<String> total = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            String[] aline = line.split(":");
            total.add(line);
            while (!(aline[0].equalsIgnoreCase(target))){
                line = reader.readLine();
                aline = line.split(":");
                if (!(aline[0].equalsIgnoreCase(target))) total.add(line);

            }line = reader.readLine(); //skips the data line
            writingBase(target + ":" + input, total);

            total.clear();

            while (line != null){
                System.out.println(total);
                total.add(line);
                line = reader.readLine();
            }
            for (String v : total){
                saveData(v);
            }

            reader.close();
        }catch(IOException exception) {}
    }

    public String searchHDataByName(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            ;
            while (line != null) {
                String[] listData = line.split(":");
                if (listData[0].equalsIgnoreCase(name)) {
                    return listData[1];
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return null; //end searchHData
    }

    private void saveData(String message) {
        ArrayList<String> total = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line = br.readLine();

            while (line != null) {
                total.add(line);
                line = br.readLine();

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(filepath)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < total.size(); i++) {
                sb.append(total.get(i));
                sb.append('\n');
            }
            sb.append(message);
            sb.append('\n');
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    private void writingBase(String object, ArrayList<String> total){
        try (PrintWriter writer = new PrintWriter(filepath)) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < total.size(); i++) {
                sb.append(total.get(i));
                sb.append('\n');
            }
            sb.append(object);
            sb.append('\n');

            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
