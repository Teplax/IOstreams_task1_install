import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String path ="C:/Users/tepla/Games/";
        String [] catalogues = {"src","res", "savegames", "temp"};
        StringBuilder progress = new StringBuilder();
        for (String s:catalogues){
            File f = new File(path+s);
            if(f.mkdir()){
                progress.append("Каталог "+f.getName()+" создан");
                progress.append("\n");
            }
        }
//        File src = new File("C:/Users/tepla/Games/src");
//        if(src.mkdirs()){
//            progress.append("Каталог "+src.getName()+" создан");
//            progress.append("/n");
//        }
//        else System.out.println("Каталог не создан!");
//        System.out.println(src.mkdir());





        File srcmain= new File("C:/Users/tepla/Games/src/main");
        if (srcmain.mkdir()){
            progress.append("Каталог "+srcmain.getName()+" создан");
            progress.append("\n");
        }

        File srctest = new File("C:/Users/tepla/Games/src/test");
        if (srctest.mkdir()){
            progress.append("Каталог "+srctest.getName()+" создан");
            progress.append("\n");
        }

        File main = new File(srcmain,"Main.java");
        try {
            if (main.createNewFile()){
                progress.append("Файл "+main.getName()+" создан");
                progress.append("\n");
            }
        } catch (IOException e) {
            progress.append(e.getMessage());
            progress.append("\n");
        }

        File utils = new File(srcmain,"Main.java");
        try {
            if (utils.createNewFile()){
                progress.append("Файл "+utils.getName()+" создан");
                progress.append("\n");
            }
        } catch (IOException e) {
            progress.append(e.getMessage());
            progress.append("\n");
        }

        path ="C:/Users/tepla/Games/res/";
        File drawables = new File(path+"drawables");
        if (drawables.mkdir()){
            progress.append("Каталог "+drawables.getName()+" создан");
            progress.append("\n");
        }

        File vectors = new File(path+"vectors");
        if(vectors.mkdir()){
            progress.append("Каталог "+vectors.getName()+" создан");
            progress.append("\n");
        }

        File icons = new File(path+"icons");
        if(vectors.mkdir()){
            progress.append("Каталог "+icons.getName()+" создан");
            progress.append("\n");
        }

        path="C:/Users/tepla/Games/temp/";
        File temp = new File(path+"temp.txt");
        try {
            if (temp.createNewFile()){
                progress.append("Файл "+temp.getName()+" создан");
                progress.append("\n");
            }
        } catch (IOException e) {
            progress.append(e.getMessage());
            progress.append("\n");
        }

        try (FileWriter writer=new FileWriter(temp,false)) {
            writer.write(progress.toString());
            writer.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}