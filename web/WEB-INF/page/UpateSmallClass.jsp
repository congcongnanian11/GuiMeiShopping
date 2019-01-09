<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

    <script>
        $(function(){
            var url = "doBigClass/ajaxQuery";
            $.getJSON(url,function(bigClass){
                $.each(bigClass,function (index,bg) {
                    $("select[name='smallBigId']").append("<option value='"+bg.id+"'>"+bg.bigName+"</option>");
                });
                $("option[value='${smallClass.smallBigId}']").attr("selected",true);

            });

            //验证输入的小分类名称是否重名
            $("input[name='bigName']").blur(function(){
                var url = "do";
                $.post(url,function(status){
                    if(status!="exists"){
                        alert("该小分类名称已经存在！");
                        $("input[type='submit']").attr("disabled",true);
                    }else{
                        $("input[type='submit']").attr("disabled",false);
                    }
                },"text");
            });

        });
    </script>

</head>
<body>

    <form action="/doBigClass?action=updateById" method="post">
        <label>编号:</label><input type="text"  name="id" value="${smallClass.id}" readonly/><br>
        <label>小分类类名称:</label><input type="text" name="bigName" value="${smallClass.smallName}" /><br>
        <label>小分类所属大分类名称:</label>
        <select name="smallBigId">
        </select><br>
        <label>描述信息:</label><input type="text" name="bigText" value="${smallClass.smallText}" /><br>
        <input disabled  type="submit" value="保存修改" class="layui-btn"/>
    </form>
</body>
</html>


