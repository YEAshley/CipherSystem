package system.utils;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

    public static String initFileChooser(Stage stage) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        String text = "";
        if (file!= null) {
            BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
            text = br.readLine();
        } else {
            text = "未打开文件！";
        }

        return text;
    }




/*

    */
/**
     * 从文件中读取字符串
     *
     * @param filename：文件名称
     * @return 字符串
     *//*

    public static String getText(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String text = br.readLine();
        br.close();
        System.out.println("\nThe text in the file>>  " + text);
        return text;
    }

    */
/**
     * 往文件中写入字符串
     *
     * @param filename：文件名称
     *//*

    public static void writeText(String filename,String text) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        bw.write(text);
        //bw.flush();
        bw.close();
    }

*/

}
