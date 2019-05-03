<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%! static int index ;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<f:view>
<div id="all">

<div id="upload">
<h:form id="form" enctype="multipart/form-data">
Wskaz plik do konwersji :
</br>
</br>
<h:inputFile id="file" value="#{bean.file}"/>  
</br>
</br>
<h:commandButton value="Wyslij" action="#{bean.upload}"/>
</br>
</br>
</h:form>
</div>

<div id = "out">
</br>
</br>
<div id="org">
Obraz oryginalny
</br>
</br>
<h:panelGroup layout="block">
<h:graphicImage value="#{bean.original}"/>
</h:panelGroup>

</div>

</br>
</br>

<div id="min">

Obraz po dylatacji
</br>
</br>
<h:panelGroup layout="block">
<h:graphicImage value="#{bean.min}"/>
</h:panelGroup>
</div>
</br>
</br>

<div id= "max"> 
Obraz po erozji
</br>
</br>
<h:panelGroup layout="block" >
<h:graphicImage value="#{bean.max}"/>
</h:panelGroup>
</div>
</br>
</br>

</div>
</div>
</f:view>
</body>
</html>