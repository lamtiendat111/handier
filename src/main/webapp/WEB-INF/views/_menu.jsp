<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;">
 
  <a href="/welcome">Home</a>
 
   <a href="/userInfo">User Info</a>
  
  <a href="/admin">Admin</a>
 
  <c:if test="${pageContext['request'].remoteUser != null}">
     <a href="/logout">Logout</a>
  </c:if>
  
</div>