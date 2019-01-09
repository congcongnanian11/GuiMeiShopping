package cn.com.guimei.service;

import cn.com.guimei.pojo.Customer;
import cn.com.guimei.pojo.Page;

public interface CustomerServiece {

    Page<Customer> queryAll(String pageNumber);

}
