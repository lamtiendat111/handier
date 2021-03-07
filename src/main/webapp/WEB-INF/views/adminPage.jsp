<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<html>
<head>
<title>${title}</title>
</head>
<body>
    <jsp:include page="_menu.jsp" />
 
    <h2>Admin Page</h2>
 
 
    <h3>Welcome : ${pageContext['request'].remoteUser}</h3>
    <p>This is protected page!</p>

</body>
</html>