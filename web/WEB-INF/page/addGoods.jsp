<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <base href="<%=request.getContextPath() %>/" />
    <%@include file="layUI.jsp"%>
    <script src="static/js/jquery-1.8.2.min.js"></script>
    <style>
        input{
            border-radius: 5px;
            height: 30px;
            font-size: 15px;
            padding-left: 5px;
        }
        form{
            width: 80%;
            margin: auto;
            padding: 40px;
        }
    </style>

</head>
<body>
<h3 style="color: red">${error}</h3>
<form action="doGoods/addGoods" method="post" enctype="multipart/form-data">
    <label>商品名称:</label><input type="text" required id="goodsName" name="goodsName"  />
    <span id="msg1"></span><br>
    <label>商品所属小分类:</label>
    <select name="goodsSmalId">
    </select><br>
    <label>商品原价：</label>
    <input type="text" name="goodsMoney"  required/><br>
    <label>剩余数量:</label>
    <input type="number" value="1" name="goodsNumber"  required/><br>
    <label>运费:</label>
    <input type="text" required name="goodsCarriage" value="0"  /><br>
    <label>折扣:</label>
    <select name="goodsDiscId">
        <option value="1">不打折</option>
        <option value="2">0.5折</option>
        <option value="3">0.8折</option>
    </select><br>
    <label>是否新品:</label>
    <select name="goodsType">
        <option value="1">新品</option>
        <option value="0">二手</option>
    </select><br>
    <label>所属商家:</label>
    <select name="goodsSellerId">
        <option value="1">马云电子</option>
    </select>
    <br>
    <label>上传商品图片:</label>
    <input type="file" name="goodsImages" required />
    <b id="imageMsg">文件路径必须是 (文件大小不能超过5M)</b>
    <br>

    <input  type="submit" id="sub"  value="添加" class="layui-btn"/>
</form>
</body>
<script>
    $(function () {
        var smallClassUrl = "doSmallClass/ajaxQuery";
        $.getJSON(smallClassUrl,function(smallClassList){
            $.each(smallClassList,function(index,smallClass){
                $("select[name='goodsSmalId']").append("<option value='"+smallClass.id+"'>"+smallClass.smallName+"</option>");
            });
        });


        $("input[type='file']").change(function(){
            var fileName = $(this).val();
            var fileType = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
            var fileTypeReg = /gif|bmp|png|jpg|jpeg|icon/;
            if(fileTypeReg.test(fileType)){
                $("#imageMsg").html("√");
            }else{
                $("#imageMsg").html("文件路径必须是gif|bmp|png|jpg|jpeg|icon").css("color","red");
                $(this).val("");
            }
        });
    })
</script>
</html>


