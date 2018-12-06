package com.teacher.web.servlet;

import com.teacher.model.Course;
import com.teacher.model.HomeWork;
import com.teacher.model.User;
import com.teacher.server.WorkSubmitService;
import com.teacher.server.serverImpl.WorkSubmitServiceImpl;
import com.teacher.utils.MyBeanUtils;
import com.teacher.utils.OfficeOperate;
import com.teacher.utils.UUIDUtils;
import com.teacher.web.base.BaseServlet;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "WorkSubmitServlet",urlPatterns = "/WorkSubmit")
public class WorkSubmitServlet extends BaseServlet {
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 4; // 4MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 5; // 5MB
    private static final String UPLOAD_DIRECTORY = "upload";

    public String WorkSubmitUI(HttpServletRequest request, HttpServletResponse response  ) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if(isNotLogin(user,request)) return "/info.jsp";
        Course course = new Course(request.getParameter("workId"),request.getParameter("workName"),Integer.parseInt(request.getParameter("workTime")),null);
        request.getSession().setAttribute("nowPlace",course.getCourse_name()+"<br>第"+course.getCourse_time()+"次作业");
        request.getSession().setAttribute("submitCourse",course);
        return "editormd.jsp";
    }

    public String SeeSubmitUI(HttpServletRequest request, HttpServletResponse response  ) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if(isNotLogin(user,request)) return "/info.jsp";
        Course course = new Course(request.getParameter("workId"),request.getParameter("workName")
                ,Integer.parseInt(request.getParameter("workTime")),null);
        String readPath = request.getServletContext().getRealPath("./") + UPLOAD_DIRECTORY+ File.separator ;
        WorkSubmitService workSubmitService = new WorkSubmitServiceImpl();
        String fileName = "";
        try {
            HomeWork homeWork = workSubmitService.readFileInfo(user,course);
            if (homeWork != null){
                fileName = homeWork.getTaskContent();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder html = new StringBuilder("");
        if (isDoc(fileName) ==  2){
            html.append("<div class=\"col embed-responsive embed-responsive-4by3\"><iframe  src=\"./pdfjs/web/viewer.html?file=../../upload/").append(fileName).append("\" ></iframe></div>");
        }else if (isDoc(fileName) == 1){
            fileName = readPath + fileName;
            File file = new File(fileName);
            if (file.exists()){
                try(FileReader fileReader = new FileReader(file.getAbsoluteFile());
                    BufferedReader bufferedReader = new BufferedReader(fileReader) ){
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null){
                        html.append(line);
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.getSession().setAttribute("homeworkInfo", html.toString());
        request.getSession().setAttribute("nowPlace",course.getCourse_name()+"<br>第"+course.getCourse_time()+"次作业");
        request.getSession().setAttribute("submitCourse",course);
        return "seeMyHomework.jsp";
    }

    public String WorkSubmit(HttpServletRequest request, HttpServletResponse response  ) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if(isNotLogin(user,request)) return "/info.jsp";
        Course course = new Course(request.getParameter("workId"),null
                ,Integer.parseInt(request.getParameter("workTime")),null);
        String msg = "";
        String savePath = request.getServletContext().getRealPath("./") + UPLOAD_DIRECTORY+ File.separator ;
        String fileName ;
        try {
            fileName = upLoadFile(request);
            if (isDoc(fileName) == 0){
                int dot = fileName.lastIndexOf('.');
                String destFile = fileName.substring(0, dot)+".pdf";
                OfficeOperate.Office2PDF(savePath+fileName,savePath+destFile);
                fileName = destFile;
            }
            System.out.println("IN WorkSubmit fileName = "+ fileName);
            WorkSubmitService workSubmitService = new WorkSubmitServiceImpl();
            workSubmitService.saveFile(user,fileName,course);
            msg = "已提交作业!";
        } catch (FileUploadException | IOException | SQLException e) {
            msg = "提交作业失败!";
            e.printStackTrace();
        }
        request.setAttribute("msg",msg);
        return "info.jsp";
    }
    public String uploadImages(HttpServletRequest request, HttpServletResponse response  ) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if (!ServletFileUpload.isMultipartContent(request)) {  // 检测是否为多媒体上传
            return null;
        }
        JSONObject resultJson = new JSONObject();
        /*
         * 以下是上传文件部分
         */
        try {
            String filename = upLoadFile(request);
            resultJson.put("success",1);
            resultJson.put("message","上传成功");
            resultJson.put("url","upload/"+filename);
            response.getWriter().println(resultJson);
        } catch (FileUploadException | IOException e) {
            resultJson.put("success",1);
            resultJson.put("message","上传失败");
            e.printStackTrace();
        }

        return null;
    }

    private boolean isNotLogin(User user, HttpServletRequest request){
        if ( user == null){
            String msg = "请先登录!";
            request.setAttribute("msg",msg);
            return true;
        }
        return false;
    }

    private String upLoadFile(HttpServletRequest request) throws FileUploadException, IOException {
        // 配置上传参数
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        fileItemFactory.setSizeThreshold(MEMORY_THRESHOLD);// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        fileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));// 设置临时存储目录
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        servletFileUpload.setFileSizeMax(MAX_FILE_SIZE);
        servletFileUpload.setSizeMax(MAX_REQUEST_SIZE);
        servletFileUpload.setHeaderEncoding("UTF-8");
        String uploadPath = request.getServletContext().getRealPath("./") + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
//        使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
        String filename =null;
        List<FileItem> list = servletFileUpload.parseRequest(request);
        for(FileItem item : list){
            //如果fileitem中封装的是普通输入项的数据
            if(item.isFormField()){
                String name = item.getFieldName();
                //解决普通输入项的数据的中文乱码问题
                String value = item.getString("UTF-8");
                //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                System.out.println(name + "=" + value);
                if ("text".equals(name) && (!value.equals("")) && !value.isEmpty()){
                    String savePath = request.getServletContext().getRealPath("./") + UPLOAD_DIRECTORY+ File.separator ;
                    String fileName =  UUIDUtils.getCode()+".sub";
                    File file = new File(savePath + fileName);
                    if (!file.exists()){
                        file.createNewFile();
                    }
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
                    bufferedWriter.write(value);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    System.out.println("Wirten file = " + savePath +fileName);
                    return fileName;
                }
            }else{
                //如果fileitem中封装的是上传文件
                //得到上传的文件名称，
                filename = item.getName();
                System.out.println(filename);
                if(filename==null || filename.trim().equals("")){
                    continue;
                }
                filename = UUIDUtils.getCode()+(filename.substring(filename.lastIndexOf("\\")+1)).substring(filename.lastIndexOf("."));
                //filename.substring(filename.lastIndexOf("\\")+1);
                //获取item中的上传文件的输入流
                InputStream in = item.getInputStream();
                //创建一个文件输出流
                FileOutputStream out = new FileOutputStream(uploadPath + File.separator  + filename);
                //创建一个缓冲区
                byte buffer[] = new byte[1024];
                //判断输入流中的数据是否已经读完的标识
                int len = 0;
                //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                while((len=in.read(buffer))>0){
                    //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                    out.write(buffer, 0, len);
                }
                in.close();
                out.close();
                item.delete();
            }
        }

        return filename;
    }

    /**
     *
     * @param fileName
     * @return 0 is DOC file ,1 is sub file ,2 is pdf ,other number other files
     */
    private int isDoc(String fileName){
        if ((fileName.substring(fileName.lastIndexOf(".")+1)).equals("doc")){
            return 0;
        }else if((fileName.substring(fileName.lastIndexOf(".")+1)).equals("sub")){
            return 1;
        }else if((fileName.substring(fileName.lastIndexOf(".")+1)).equals("pdf")){
            return 2;
        }
        return -1;
    }
}
