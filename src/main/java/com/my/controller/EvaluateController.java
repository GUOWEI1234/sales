package com.my.controller;

import com.my.pojo.Evaluate;
import com.my.pojo.User;
import com.my.service.productService;
import com.my.util.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GUOwei
 * Created by GUOwei on 2018/5/2.
 */
@Controller
@RequestMapping("/evaluate")
public class EvaluateController {

    @Autowired
    private productService productService;

    /**
     * 通过产品id查询该产品的所以评论
     * @param request
     * @return List<Evaluate>
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getEval")
    public Map<String,List> getEval(HttpServletRequest request)throws  Exception{
        String product_id = request.getParameter("product_id");
        Map<String,List> map = new HashMap();
        List<Evaluate> EvaluateList = productService.getEvalByProId(product_id);
        List<String> dataList = new ArrayList<>();
        for(int i=0;i<EvaluateList.size();i++){
            dataList.add(SetData.setData(EvaluateList.get(i).getEva_time()));
        }
        map.put("eva",EvaluateList);
        map.put("dataList",dataList);
        return map;
    }


    /**
     * 插入用户评论数据
     * @param evaluate
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/insertEval")
    public void insertEval(Evaluate evaluate,HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        evaluate.setUser_id(user.getUser_id());
        productService.insertEval(evaluate);
    }

}
