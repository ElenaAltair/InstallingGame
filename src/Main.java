import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {

        //В папке Games создайте несколько директорий: src, res, savegames, temp.
        myMkdir("D://Games//src");
        myMkdir("D://Games//res");
        myMkdir("D://Games//savegames");
        myMkdir("D://Games//temp");

        //В каталоге src создайте две директории: main, test.
        myMkdir("D://Games//src//main");
        myMkdir("D://Games//src//test");

        //В подкаталоге main создайте два файла: Main.java, Utils.java.
        myMkFile("D://Games//src//main", "Main.java");
        myMkFile("D://Games//src//main", "Utils.java");

        //В каталог res создайте три директории: drawables, vectors, icons.
        myMkdir("D://Games//res//drawables");
        myMkdir("D://Games//res//vectors");
        myMkdir("D://Games//res//icons");

        //В директории temp создайте файл temp.txt.
        myMkFile("D://Games//temp", "temp.txt");

        myFileWriter("D://Games//temp//temp.txt", log.toString());

    }

    public static void myMkdir(String dirPath) {
        // определяем объект для каталога
        File dir = new File(dirPath);
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

        if (dir.mkdir()) {
            log.append(timeStamp).append(" Каталог ").append(dirPath).append(" был создан.\n");
        } else {
            log.append(timeStamp).append(" Что-то пошло не так. Каталог ").append(dirPath).append(" не был создан.\n");
        }

    }

    public static void myMkFile(String dirPath, String fileName) {
        File myFile = new File(dirPath, fileName);
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        //создадим файл
        try {
            if (myFile.createNewFile())
                log.append(timeStamp).append(" Файл ").append(fileName).append(" в каталоге ").append(dirPath).append(" был создан.\n");

        } catch (IOException e) {
            log.append(timeStamp).append(" Что-то пошло не так. Файл ").append(fileName).append(" в каталоге ").append(dirPath).append(" не был создан.\n");
        }
    }

    public static void myFileWriter(String fileName, String fileText) {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(fileText);
            log.append(timeStamp).append(" Файл ").append(fileName).append(" был записан.\n");
        } catch (IOException e) {
            log.append(timeStamp).append(" Что-то пошло не так. Файл ").append(fileName).append(" не был записан.\n");
        }
    }

}
