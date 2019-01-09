package cn.com.guimei.controller;

import cn.com.guimei.pojo.Customer;
import cn.com.guimei.pojo.Page;
import cn.com.guimei.service.CustomerServiece;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerServiece customerServiece;
    @RequestMapping("/queryAll")
    public String queryAll(String pageNumber){
        Page<Customer> page = customerServiece.queryAll(pageNumber);
        page.setServletURL("/customer/queryAll?pageNumber=");
        return "showCustomer";
    }

}
