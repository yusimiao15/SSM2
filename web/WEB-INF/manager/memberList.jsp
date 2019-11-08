<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
       <script type="text/javascript">
               function num(PageIndex){
               $("#PageIndex").val(PageIndex);
               $("#fo").submit();
               }
        </script>        

     	<link type="text/css" rel="stylesheet" href="css/style.css" />
         <div>
             <% if(request.getAttribute("msg")!=null){%>
             alert(<%=request.getAttribute("msg")%>)
             <%}%>
             <form action="${pageContext.request.contextPath }/queryByPage" method="post"  id="fo">
             <input type="hidden" name="pageIndex" id="PageIndex">
                  用户名:<input type="text" name="loginName"  value="${easybuy_user.loginName }">
                  姓名:<input type="text" name="userName" value="${easybuy_user.userName }" >
                  性别:
		<input type="radio" name="sex" id="sex" checked="checked" value="1">男
		<input type="radio" name="sex" id="sex" value="0">女
                  电话:<input type="text" name="mobile" value="${easybuy_user.mobile }">
             <input type="submit" value="搜索">
             </form>
         </div>
		<div class="m_right">
            <p></p>           
            <div class="mem_tit">详细信息</div>  
            <table border="0" class="order_tab" style="width:920px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
            <c:forEach items="${pagebean.dataList}" var="cart" varStatus="status"> 
              <tr>                                                                                                                                                    
                <td width="25%">${cart.loginName}</td>
                <td width="25%">${cart.userName}</td>
                <td width="20%">${cart.sex==1?"男":"女"}</td>
                <td width="30%">${cart.mobile}</td> 
                <td><a href="">修改</a><a href="">删除</a></td>                
              </tr>                      
            </c:forEach>
            </table>   
             <a href="javascript:;" onclick="num(${1})">首页</a>  
             <a href="javascript:;" onclick="num(${pagebean.pageIndex-1})">上一页</a>                 
             <a href="javascript:;" onclick="num(${pagebean.pageIndex+1})">下一页</a> 
             <a href="javascript:;" onclick="num(${pagebean.pageCount})">尾页</a><br/>                           
        </div>
    