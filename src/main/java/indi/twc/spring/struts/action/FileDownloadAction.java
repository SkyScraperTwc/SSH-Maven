package indi.twc.spring.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@Data
@Controller
@Scope("prototype")
public class FileDownloadAction extends ActionSupport {

    private String fileName;//下载文件的名称

    //下载源
    public InputStream getInputStream() throws IOException {
//      String path =ServletActionContext.getServletContext().getRealPath(fileName);//获取文件路径
        String path = "/usr/twc/IdeaProjects/Spring-Struts-Hibernate/WebContent/upload/" + fileName;
        System.out.println("getInputStream......path="+path);
        File file = new File(path);
        return FileUtils.openInputStream(file);
    }

    //下载文件名称
    public String getDownloadFileName() throws Exception{
        String downloadFileName="";
        String[] filenames=fileName.split("/");
        //System.out.println(filenames[filenames.length-1]);
        downloadFileName= URLEncoder.encode(filenames[filenames.length-1], "UTF-8");//解决下载中文命名文件乱码问题
        System.out.println("downloadFileName-------"+downloadFileName);
        return downloadFileName;
    }

    @Override
    public String execute() throws Exception
    {
        return SUCCESS;
    }
}
