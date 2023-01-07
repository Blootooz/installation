import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder stringBuilderb = new StringBuilder();
        //1. В папке Games создайте несколько директорий: src, res, savegames, temp.
        //2. В каталоге src создайте две директории: main, test.
        // 4. В каталог res создайте три директории: drawables, vectors, icons.
        List<File> folderList = Arrays.asList(
                new File("C:\\Users\\Shhiva\\Documents\\Games", "temp"),
                new File("C:\\Users\\Shhiva\\Documents\\Games", "src"),
                new File("C:\\Users\\Shhiva\\Documents\\Games", "res"),
                new File("C:\\Users\\Shhiva\\Documents\\Games", "savegames"),
                new File("C:\\Users\\Shhiva\\Documents\\Games\\src", "main"),
                new File("C:\\Users\\Shhiva\\Documents\\Games\\src", "test"),
                new File("C:\\Users\\Shhiva\\Documents\\Games\\res", "drawables"),
                new File("C:\\Users\\Shhiva\\Documents\\Games\\res", "vectors"),
                new File("C:\\Users\\Shhiva\\Documents\\Games\\res", "icons")
        );
        // 3. В подкаталоге main создайте два файла: Main.java, Utils.java.
        //5. В директории temp создайте файл temp.txt.
        List<File> fileList = Arrays.asList(
                new File("C:\\Users\\Shhiva\\Documents\\Games\\src\\main", "Main.java"),
                new File("C:\\Users\\Shhiva\\Documents\\Games\\src\\main", "Utils.java"),
                new File("C:\\Users\\Shhiva\\Documents\\Games\\temp", "temp.txt")
        );

        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) stringBuilderb.append("Catalog" + folder + " create\n");
            else stringBuilderb.append("Catalog " + folder + " not created\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) stringBuilderb.append("File " + file + " create\n");
                else stringBuilderb.append("File " + file + " not created\n");
            } catch (IOException ex) {
                stringBuilderb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("C:\\Users\\Shhiva\\Documents\\Games\\temp\\temp.txt", false)) {
            log.write(stringBuilderb.toString());
            log.flush();
        } catch (IOException ex) {
            stringBuilderb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Shhiva\\Documents\\Games\\temp\\temp.txt"))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) System.out.println(s);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}