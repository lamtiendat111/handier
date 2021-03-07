<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


    <jsp:include page="_menu.jsp" />
 
 
    <h1>Message : ${message}</h1>
   
    <security:authorize access="hasRole('ROLE_ADMIN')">
This zone will be visible to ADMin only.<br/>
You have Supervisor role.<br/>
</security:authorize>
<security:authorize access="hasRole('ROLE_USER')">
This zone will be visible to USER only.<br/>
You have Supervisor role.<br/>
</security:authorize>
<security:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
This zone will be visible to ADMin , USER only.<br/>
You have Supervisor role.<br/>
</security:authorize>
