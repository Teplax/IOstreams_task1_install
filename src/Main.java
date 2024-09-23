import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //создаём список путей к папкам, которые следует создать
        List<String> catalogues = List.of("C:/Users/tepla/Games/src","C:/Users/tepla/Games/res",
                "C:/Users/tepla/Games/savegames", "C:/Users/tepla/Games/temp","C:/Users/tepla/Games/src/main",
                "C:/Users/tepla/Games/src/test", "C:/Users/tepla/Games/res/drawables",
                "C:/Users/tepla/Games/res/vectors","C:/Users/tepla/Games/res/icons");

        //создаём список файлов для создания
        List<String> files = List.of("C:/Users/tepla/Games/src/main/Main.java",
                "C:/Users/tepla/Games/src/main/Utils.java","C:/Users/tepla/Games/temp/temp.txt");

        //переменная для записи в лог-файл
        StringBuilder progress = new StringBuilder();

        //вызываем метод создания папок,
        progress.append(catCreate(catalogues));

        //создаём файлы
        progress.append(fileCreate(files));

        //записываем лог выполнения программы в файл
        writeLog("C:/Users/tepla/Games/temp/temp.txt",progress);


    }

    //метод записи лога в файл принимает путь к файлу и переменную лога
    public static void writeLog(String logFileName, StringBuilder log){
        //открываем поток для записи в файл
        try (FileWriter writer=new FileWriter(logFileName,false)) {
            //вызываем метод для записи содержимого в файл
            writer.write(log.toString());
            //очищаем буфер
            writer.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    //метод создания файлов принимает список файлов в виде абсолютных путей к ним
    public static StringBuilder fileCreate(List<String> fileNames){
        //создаём переменную лога, которую будет возвращать метод
        StringBuilder log = new StringBuilder();
        //запускаем цикл по списку файлов
        for(String file:fileNames){
            //создаём экземпляр класса File для текущего элемента списка
            File temp = new File(file);
            try {//пробуем создать файл на жёстком диске
                if (temp.createNewFile()){
                    //если операция прошла успешно - добавляем соответствующую запись в лог
                    log.append("Файл "+temp.getName()+" в папке "+ temp.getParent()+" успешно создан");
                    log.append("\n");
                }
            } catch (IOException e) {
                //в случае ошибки - помещаем в лог её текст
                log.append(e.getMessage());
                log.append("\n");
            }
        }
        //возвращаем лог
        return log;
    }

    //метод создания папок, принимающий список абсолютных путей к ним
    public static StringBuilder catCreate (List<String> catNames){
        //создадим переменную лога
        StringBuilder log = new StringBuilder();
        //пробежимся циклом по всем элементам списка путей
        for(String catName: catNames){
            //создаём экземпляр класса File для текущего элемента списка
            File temp= new File(catName);
            if (temp.mkdir()){
                //в случае успешного создания каталога добавляем соотвествующую запись в лог
                log.append("Каталог "+temp.getName()+" по адресу "+temp.getPath()+" успешно создан");
                log.append("\n");
            }
            //если каталог создать не удалось - добавляем в лог сообщение об ошибке
            else log.append("Ошибка создания каталога "+temp.getName());
        }
        //возвращаем лог
        return log;
    }
}