package cn.com.guimei.service.impl;

import cn.com.guimei.dao.SmallClassMapper;
import cn.com.guimei.pojo.Page;
import cn.com.guimei.pojo.SmallClass;
import cn.com.guimei.service.SmallClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmallClassServiceImpl implements SmallClassService {
    @Resource
    SmallClassMapper smallClassMapper;

    public Page<SmallClass> smallClassQuery(String num, SmallClass smallClass) {
        int pageNumber = 1;
        int pageSize = 5;
        if(num!=null && num.length()>0){
            pageNumber = Integer.parseInt(num);
        }
        int pageIndex = (pageNumber-1)*pageSize;
        Map<String,Object> pageMap = new HashMap<String, Object>();
        pageMap.put("sc",smallClass);
        pageMap.put("pageIndex",pageIndex);
        pageMap.put("pageSize",pageSize);

        //设置Servlet的URL地址
        Long id = smallClass.getId()!=null?smallClass.getId():0;
        Long smallBigId = smallClass.getSmallBigId()!=null?smallClass.getSmallBigId():0;
        String smallName = smallClass.getSmallName()!=null && smallClass.getSmallName().length()>0?smallClass.getSmallName():"";


        Page<SmallClass> page = new Page<SmallClass>();
        page.setServletURL("/doSmallClass/query?id="+id+"&smallName="+smallName+"&smallBigId="+smallBigId+"&pageNumber=");
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        page.setTotalRecode(smallClassMapper.getTotalRecode(smallClass));
        page.setPageData(smallClassMapper.getPageData(pageMap));
        return page;
    }

    public int smallClassUpdateById(SmallClass smallClass) {
        return 0;
    }

    public int smallClassDeleteById(int id) {

        return smallClassMapper.delete(id);
    }

    public int smallClassAdd(SmallClass smallClass) {
        return 0;
    }

    public SmallClass smallClassQueryById(int id) {
        if(id>0){
            return smallClassMapper.queryById(id);
        }
        return null;
    }

    public List<SmallClass> smallClassQueryAll() {
        return smallClassMapper.smallClassQueryAll();
    }
}
