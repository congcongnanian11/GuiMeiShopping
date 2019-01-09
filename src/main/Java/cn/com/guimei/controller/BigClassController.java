package cn.com.guimei.controller;

import cn.com.guimei.pojo.BigClass;
import cn.com.guimei.pojo.SmallClass;
import com.alibaba.fastjson.JSONArray;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/doBigClass")
public class BigClassController {

    @RequestMapping(value = "/ajaxQuery",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String ajaxQuery(){
        BigClass bigClass1 = new BigClass(1,"家用电器","xx");
        BigClass bigClass2 = new BigClass(2,"手机数码","xx");
        BigClass bigClass3 = new BigClass(3,"日用百货","xx");
        BigClass bigClass4 = new BigClass(4,"书籍","xx");
        ArrayList<BigClass> list = new ArrayList<BigClass>();
        list.add(bigClass1);
        list.add(bigClass2);
        list.add(bigClass3);
        list.add(bigClass4);
        return JSONArray.toJSONString(list);
    }

}
