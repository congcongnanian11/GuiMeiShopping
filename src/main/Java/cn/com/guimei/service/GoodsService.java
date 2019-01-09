package cn.com.guimei.service;

import cn.com.guimei.pojo.Goods;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsService {

    int addGoods(Goods goods, MultipartFile goodsFile,String filePath);



}
