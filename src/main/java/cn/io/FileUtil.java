package cn.io;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther liuzhuochuan
 * @create 2022-03-29-19:55
 **/

//获取一个目录下的所有文件并用一个List存储
@Component
public class FileUtil {

    //获取指定路径的File对象
    private final File dir;
    //LinkedMap存储File对象
    private final LinkedHashMap<File,Integer> files = new LinkedHashMap<File, Integer>();
    //构造器传入一个路径
    @Autowired
    public FileUtil(String dir) {
        this.dir = new File(dir);
    }

    //    遍历当前目录下的所有文件并添加到List集合中
    public void addDicFiles() {
        addDicFiles(dir,-1);
    }

    //    遍历指定目录下的所有文件并添加到files
    public void addDicFiles(File dir,int i) {
        if (dir.isDirectory()) {
//            获取当前目录下的文件
            File[] fs = dir.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return true;
                }
            });

            assert fs != null;
            for (File f : fs) {
//            将fs数组转换成List并添加到files
                files.put(f,i);
                addDicFiles(f,i+1);
            }
        }
    }

    public void retrieve(){
        addDicFiles();
        for(Map.Entry<File,Integer> f : files.entrySet()){
            for(int i=0;i<f.getValue();i++){
                System.out.print("\t");
            }
            System.out.println("|--" + f.getKey().getName());
        }
    }
}
