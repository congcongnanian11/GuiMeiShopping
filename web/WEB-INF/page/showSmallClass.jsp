<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath() %>/" />
    <%@include file="layUI.jsp"%>
    <style>
        input,select{
            border-radius: 5px;
            height: 30px;
            font-size: 15px;
            padding-left: 5px;
        }
    </style>
    <script src="static/js/jquery-1.8.2.min.js"></script>
    <script>
        function del(id) {
            var delStatus = window.confirm("是否确认删除id="+id+"小分类");
            if(delStatus){
                open("doSmallClass/delById?smallId="+id,"iframe_context");
            }
        }
        if(${not empty error}){
            alert("${error}")
        }

        $(function(){
            var url = "/doBigClass/ajaxQuery";
            $.getJSON(url,function(bigClassList){
                $.each(bigClassList,function(index,bigClass){
                    $("select[name='smallBigId']").append("<option value='"+bigClass.id+"'>"+bigClass.bigName+"</option>");
                });
            });
        });
    </script>
</head>
<body>
<form action="/doSmallClass/query" method="post">
    <label>小分类编号:</label>
    <input type="text" name="id" placeholder="请输入小分类" />
    <label>小分类名称:</label>
    <input type="text" name="smallName" placeholder="请输入小分类名称"  />
    <label>大分类名称:</label>
    <select name="smallBigId">
        <option value="0">请选择</option>
    </select>
    <input class="layui-btn " type="submit"  value="查询"/>
</form>
<c:choose>

    <c:when test="${not empty Page.pageData}">
        <table id="stu" width="90%" class="layui-table" lay-size="sm">
            <tr>
                <th>编号</th>
                <th>小分类名称</th>
                <th>大分类名称</th>
                <th>小分类描述</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach items="${Page.pageData}" var="sc">
                <tr>
                    <td>${sc.id}</td>
                    <td>${sc.smallName}</td>
                    <td>${sc.bigClass.bigName}</td>
                    <td>${sc.smallText}</td>
                    <td><b class="layui-btn layui-btn-sm" onclick="del(${sc.id})">删除</b></td>
                    <td><a class="layui-btn layui-btn-sm" href="doSmallClass/queryById?id=${sc.id}">修改</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6">
                    <%@include file="PageUtil.jsp"%>
                </td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <h3>暂无大分类信息</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
