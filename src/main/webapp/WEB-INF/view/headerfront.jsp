<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html" charset="utf-8" />-->
        <link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.servletContext.contextPath}" />/css/basic.css" />
        <link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.servletContext.contextPath}" />/css/tabs.css" />
        <link type="text/css" href="${pageContext.servletContext.contextPath}/css/flick/jquery-ui-1.8.17.custom.css" rel="stylesheet" />
        <title>RadStore</title>
        <script type="text/javascript" src="<c:url value="/script/jquery-1.7.1.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/script/jquery-ui-1.8.17.custom.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/script/script.js" />"></script>

    </head>
    <body>
        <h3>
            RadStore
        </h3>

        <div id="header">
            <ul id="primary">
                <li><a class="current" href="<c:out value="${pageContext.servletContext.contextPath}" />/frontpage">VALMISTUS</a></li>
                <li><a href="<c:out value="${pageContext.servletContext.contextPath}" />/storage">VARASTO</a></li>
                <li><a href="<c:out value="${pageContext.servletContext.contextPath}" />/admin">HALLINTA</a></li>
            </ul>

            <%@include file="headerDate.jsp" %>
        </div>
        <div id="main">