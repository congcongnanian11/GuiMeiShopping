package cn.com.guimei.controller;

import cn.com.guimei.pojo.Page;
import cn.com.guimei.pojo.SmallClass;
import cn.com.guimei.service.SmallClassService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/doSmallClass")
public class SmallClassController {
    @Resource
    SmallClassService smallClassService;
    @RequestMapping("/query")
    public String queryAll(String pageNumber, SmallClass smallClass, HttpServletRequest request){
        Page<SmallClass> page = smallClassService.smallClassQuery(pageNumber,smallClass);


        request.setAttribute("Page",page);
        return "showSmallClass";
    };
    @RequestMapping("/delById")
    public String delById(String smallId,HttpServletRequest request){
        int id = smallId!=null?Integer.parseInt(smallId):0;
        int i = smallClassService.smallClassDeleteById(id);
        if(i==0){
            request.setAttribute("error","不能删除该小分类！该小分类中有对应的商品信息！");
        }
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/doSmallClass/query";
    }

   @RequestMapping("/queryById")
   public String queryById(String id,HttpServletRequest request){
        int i = id!=null && id.length()>0?Integer.parseInt(id):0;

        SmallClass smallClass = smallClassService.smallClassQueryById(i);
        if(smallClass!=null){
            request.setAttribute("smallClass",smallClass);
            return "UpateSmallClass";
        }
       request.setAttribute("error","修改失败！");
       return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/doSmallClass/query";
   }

   @RequestMapping(value = "/ajaxQuery",produces = "application/json;charset=utf-8")
   @ResponseBody
   public String ajaxQuery(){
        return JSONArray.toJSONString(smallClassService.smallClassQueryAll());
   }

}
