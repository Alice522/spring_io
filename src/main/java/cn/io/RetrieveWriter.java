package cn.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @auther liuzhuochuan
 * @create 2022-03-30-9:40
 **/
@Component
public class RetrieveWriter {

    private final FileWriter fileWriter;
    private final Map<File,Integer> files;

//    构造函数，传入一个FileUtil对象和FileWriter对象
    @Autowired
    public RetrieveWriter(FileUtil fileUtil,FileWriter fileWriter) {
        this.files = fileUtil.getFiles();
        this.fileWriter = fileWriter;
    }

    public void writerFile() throws IOException {
//        创建一个Buffered输出流
        BufferedWriter writer = new BufferedWriter(fileWriter);

//        遍历文件Map并把文件名输出
        for(Map.Entry<File,Integer> f : files.entrySet()){
            for(int i=0;i<f.getValue();i++){
                System.out.print("\t");
                writer.write('\t');
            }
            System.out.println("|--" + f.getKey().getName());
            writer.write("|--" + f.getKey().getName() + "\n");
        }

//        流的刷新和关闭
        writer.close();
    }
}
