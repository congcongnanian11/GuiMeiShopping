package cn.com.guimei.service.impl;

import cn.com.guimei.dao.GoodsMapper;
import cn.com.guimei.pojo.Goods;
import cn.com.guimei.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    public int addGoods(Goods goods, MultipartFile goodsFile,String filePath) {
        //判断filePath路基是否真实存在
        File file = new File(filePath);
        if(file.exists()){
            //获取文件名称
            String goodsImageName = goodsFile.getOriginalFilename();
            //获取文件大小
            long fileSize = goodsFile.getSize();
            if(goodsImageName.toLowerCase().endsWith(".gif") ||
                goodsImageName.toLowerCase().endsWith(".bmp") ||
                goodsImageName.toLowerCase().endsWith(".jpeg") ||
                goodsImageName.toLowerCase().endsWith(".icon") ||
                goodsImageName.toLowerCase().endsWith(".jpg")
            ){
                if(fileSize<=1024*1024*5){
                    try {
                        //执行写入操作
                        goodsFile.transferTo(new File(file,"/"+goodsImageName));
                        //执行数据库写入操作
                        goods.setGoodsImage(goodsImageName);
                        int i = goodsMapper.add(goods);
                        if(i>0){
                            return 0;
                        }else{
                            //写入数据库失败
                            return 2;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    return 3;
                }
            }else{
                return 4;
            }


        }
        //写入商品图像失败(文件路径不存在)
        return 1;
    }
}
