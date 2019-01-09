package cn.com.guimei.service.impl;

import cn.com.guimei.pojo.Customer;
import cn.com.guimei.pojo.Page;
import cn.com.guimei.service.CustomerServiece;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerServiece {
    public Page<Customer> queryAll(String num) {
        Page<Customer> page = new Page<Customer>();
        //默认访问首页
        int pageNumber = 1;
        if(num!=null){
            pageNumber = Integer.parseInt(num);
        }
        int pageSize = 5;
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        //找mappper接口
        //page.setTotalRecode();
        //page.setPageData();

        return page;
    }
}
