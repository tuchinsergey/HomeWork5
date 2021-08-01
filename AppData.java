package HomeWork5;

import java.io.*;
import java.util.ArrayList;

public class AppData{
    private String[] header;
    private Integer[][] data;

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public AppData() {
    }
    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String headerStr = rowToString(header);
            writer.write(headerStr);
            for (Integer[] row: data) {
                writer.write(rowToString(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private <T> String rowToString(T[] row) {
        String result = "";

        for (int i = 0; i < row.length; i++) {
            result = result + row[i]. toString();
            if (i != row.length-1){
                result += ";";
            }
        }
        result +="\n";
        return result;
    }
    public void load(String filename) {
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                header = bufferedReader.readLine(). split(";");
                ArrayList<Integer[]> datalist = new ArrayList<>();
                String tempString;
                while ((tempString = bufferedReader.readLine()) != null) {
                    datalist.add(stringToDataRow(tempString));
                }
                data = datalist.toArray(new Integer[][]{{}});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Integer[] stringToDataRow(String str) {
        String[] strings = str.split(";");
        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }
}
