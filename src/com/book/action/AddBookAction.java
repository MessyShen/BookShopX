package com.book.action;

import com.book.entity.BookItem;
import com.book.entity.Books;
import com.book.entity.Categories;
import com.book.service.BookInfoService;
import com.book.service.CategoriesService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class AddBookAction  extends ActionSupport implements RequestAware,
        ServletRequestAware, ServletResponseAware, SessionAware {
    CategoriesService categoriesService;

    public CategoriesService getCategoriesService() {
        return categoriesService;
    }

    public void setCategoriesService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    BookInfoService bookInfoService;

    public BookInfoService getBookInfoService() {
        return bookInfoService;
    }

    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    BookItem bk ;

    public BookItem getBk() {
        return bk;
    }

    public void setBk(BookItem bk) {
        this.bk = bk;
    }

    public String getPicFileName() {
        return picFileName;
    }

    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }

    String picFileName;

    public File getPic() {
        return pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }

    private File pic; // 封装上传文件的属性

    Map<String, Object> request;
    Map<String, Object> session;
    HttpServletRequest req;
    HttpServletResponse resp;

    @Override
    public void setServletResponse(HttpServletResponse resp) {
        this.resp = resp;
    }

    @Override
    public void setServletRequest(HttpServletRequest req) {
        this.req = req;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public String getExtension(String fileName) {
        int position = fileName.lastIndexOf(".");
        return fileName.substring(position);
    }

    public String generateFileName(String fileName){
        System.out.println("Filename" + fileName + " | isbn" + bk.getIsbn());
        String extension = getExtension(fileName);
        return bk.getIsbn() + extension;
    }

    public String addBook() throws IOException {
        System.out.println("add init");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        System.out.println(pic.getName() + " " + bk.getIsbn());
        //setPicFileName(pic.getName());
        String picFileExtName = getExtension(picFileName);
        String str = "";
        boolean flag=(!".png".equals(picFileExtName) && !".jpeg".equals(picFileExtName)
                && !".jpg".equals(picFileExtName) && !".gif".equals(picFileExtName));

        if (flag) {
            str = "{\"success\":\"false\",\"message\":\"图片格式不正确！\"}";
        }else{
            if (picFileName != null) { // 判断是否选择了上传小图图片
                // 得到当前web工程下的upload目录的在本机的绝对路径，如果没有这个文件夹则会创建
                String targetDirectory = ServletActionContext.getServletContext()
                        .getRealPath("/images/BookCovers");
                // 重命名上传文件
                String targetFileName = generateFileName(picFileName);
                // 在指定目录创建文件
                File target = new File(targetDirectory, targetFileName);
                // 把要上传的文件copy过去
                FileUtils.copyFile(pic, target);
                // pi.setPic(targetFileName);
            }
            bk.setPublishDate("2017-09-14 00:00:00.000");

            int result = bookInfoService.addOneBook(bk);
            if (result > 0)
                str = "{\"success\":\"true\",\"message\":\"添加成功！\"}";
            else
                str = "{\"success\":\"false\",\"message\":\"添加失败！\"}";
        }
        out.write(str);
        return "added";
    }

}

