package cn.com.guimei.controller;

import cn.com.guimei.pojo.Goods;
import cn.com.guimei.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/doGoods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @RequestMapping("/localAddGoods")
    public String localAddGoods(){
        return "addGoods";
    }

    @RequestMapping("/addGoods")
    public String addGoods(Goods goods, MultipartFile goodsImages, HttpServletRequest request) {
        String filePath = request.getRealPath("/static/images/goodsImage");
        int i = goodsService.addGoods(goods,goodsImages,filePath);
        if(i==1){
            request.setAttribute("error","图像文件路径不存在！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }else if(i==2){
            request.setAttribute("error","添加商品失败！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }else if(i==3){
            request.setAttribute("error","上传文件不能操作5MB！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }else if(i==4){
            request.setAttribute("error","文件类型非要求的图像格式！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }

        return "showGoods";
    }

}
