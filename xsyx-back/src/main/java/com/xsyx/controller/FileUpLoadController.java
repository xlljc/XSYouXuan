package com.xsyx.controller;

import com.xsyx.dao.EmpLogDao;
import com.xsyx.utils.FileUpLoadUtil;
import com.xsyx.vo.system.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 文件上传控制器
 */
@RestController
public class FileUpLoadController {

    @Autowired
    private EmpLogDao empLogDao;

    /**
     * 文件上传
     * @param file 文件对象
     * @param empId 员工id, 上传需要根据员工id生成日志
     * @param dir 选填 文件在resource文件夹的子路径位置
     * @param request 请求对象
     * @return 消息对象, 包含是否成功, 如果成功, 消息中将包含文件访问路径
     */
    @RequestMapping("/fileUpload")
    public Message upload(@RequestParam("file") MultipartFile file,
                          Integer empId,
                          String dir,
                          HttpServletRequest request) {
        if (empId == null) return new Message(false, "文件上传失败! 未指定员工id!");
        try {
            String fileName = FileUpLoadUtil.upload(file,request,dir);
            empLogDao.addLog(empId,"上传图片到服务器","{\"" + empId + "\": " + empId + ",\"fileName\": \"" + fileName + "\"}");
            return new Message(true,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Message(false,"文件上传失败, 请检查原因!");
    }

}
