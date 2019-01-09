package cn.com.guimei.dao;

import cn.com.guimei.pojo.SmallClass;

import java.util.List;
import java.util.Map;

public interface SmallClassMapper {

   /*
    查询:
    级联查询:
   */
     int getTotalRecode(SmallClass sc);
     List<SmallClass> getPageData(Map<String,Object> map);
    /*修改:*/
     int update(SmallClass sc);
   /* 删除：*/
     int delete(int sc_id);
    /*添加操作：*/
     int add(SmallClass sc);

     SmallClass queryById(int id);

    List<SmallClass> smallClassQueryAll();

}
