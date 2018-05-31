package com.my.controller;

import com.my.pojo.Pro_img;
import com.my.pojo.Product;
import com.my.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author
 * Created by GUOwei on 2018/5/1.
 */
@Controller
@RequestMapping("/images")
public class ImgController {

    @Autowired
    private productService productService;

    /**
     * 图片处理
     * @param request
     * @param files
     * @throws IOException
     */
    @ResponseBody
    @PostMapping(value = "/imageUpload")
    public void uploadImg(HttpServletResponse response, HttpServletRequest request, @RequestParam("files") MultipartFile[] files,String product) throws IOException {
        String product_name = product;
        Product pro = productService.getProductByName(product_name);
        Pro_img pro_img = new Pro_img();
        pro_img.setProduct_id(pro.getProduct_id());
        for (MultipartFile file : files) {
            String[] arr = file.getOriginalFilename().split("\\.");
            String ext = arr[arr.length-1];
            String filePath = request.getSession().getServletContext().getRealPath("images/");
            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            String fileName = String.valueOf(System.currentTimeMillis()) + "." + ext;
            FileOutputStream out = new FileOutputStream(filePath + fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();
            pro_img.setPro_img_url(fileName);
            productService.InsertPro_Img(pro_img);
        }
        response.sendRedirect("../admin.html");
    }
}
