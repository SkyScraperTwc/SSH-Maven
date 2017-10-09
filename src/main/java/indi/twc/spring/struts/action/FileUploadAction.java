package indi.twc.spring.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.*;

@Data
@Controller
@Scope("prototype")
public class FileUploadAction extends ActionSupport{

    private String username;

    //注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File file;

    //提交过来的file的名字
    private String fileFileName;

    //提交过来的file的MIME类型
    private String fileContentType;

    @Override
    public String execute() throws Exception
    {
//        String root = ServletActionContext.getServletContext().getRealPath("/upload");

        String root = "/usr/twc/IdeaProjects/Spring-Struts-Hibernate/WebContent/upload";
        InputStream is = new FileInputStream(file);

        //因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
        System.out.println("file.getName(): " + file.getName());
        System.out.println("file.getPath(): " + file.getPath());

        File file = new File(root, fileFileName);
        if (!file.exists()){
            file.createNewFile();
        }
        OutputStream os = new FileOutputStream(file);

        System.out.println("fileFileName: " + fileFileName);

        byte[] buffer = new byte[5000];
        int length = 0;

        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }
        os.close();
        is.close();
        return SUCCESS;
    }
}
