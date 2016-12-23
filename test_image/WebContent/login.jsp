<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

    <%
    String randcode=(String)session.getAttribute("randomString");
    String command = request.getParameter("command");
    String anthCode = request.getParameter("authCode");

    if ("ok".equalsIgnoreCase(command)) {
        if (anthCode != null && anthCode.equalsIgnoreCase(randcode)) {
        	response.sendRedirect("/test_image/LoginSuccessful.jsp");
        } else{
            out.println("验证码错误！");

        }

    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入</title>
<style type="text/css">
		html{background:#D2D460;text-align:center;}
		body{width:778px;margin:0 auto;background:#fff;text-align:left;}
</style>
<script type="text/javascript" language=JavaScript>
    function change(field) {
        var timenow = new Date().getTime();
        field.src="test?d=" + timenow; 
        document.URL=location.href;
    }
    function checkForm(){
        //用户名为空
        if(form1.username.value==""){
            alert("用户名不能为空");
            form1.username.focus();
            return false;
         }
        //密码和确认密码都不能为空
       if(form1.password.value=""){
            alert("密码密码不能为空！");
            form1.psd1.focus();
            return false;
        }
        return true;
      }
</script>
</head>
<body>
<form action="login.jsp" method="post" name="form1">
<table>
    <tr>
    <td>用户名：</td>
    <td><input type="text" name="username"></td>
    </tr>
    
    <tr>
    <td>密码：</td>
    <td><input type="password" name="password"></td>
    </tr>
    
     <tr>
    <td>验证码：</td>
    <td>
        <input type="hidden" name="command" value="ok">
        <input id="authCode" name="authCode" type="text" size="8" maxlength="6">
        <img src="test" alt="验证码" onClick="change(this);">
    </td>
    </tr>
    
    <tr>
      <td><input type="reset" value="重填"></td>
      <td><input type="submit" value="登陆" onClick="checkForm();"></td>
     </tr>
</table>   
</form>
</body>
</html>