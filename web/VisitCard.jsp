<%-- 
    Document   : VisitCard
    Created on : 02-Dec-2016, 16:47:12
    Author     : Chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitor Information</title>
    </head>
    <%
            String msg = request.getParameter("msg");     //The result of the web service invocation is sent as a parameter called 'result'
            String firstName = request.getParameter("first");
            String lastName = request.getParameter("last");
            String company = request.getParameter("comp");
            String startTime = request.getParameter("start");
            String endTime = request.getParameter("end");
            String hash = request.getParameter("hash");
            String fileName = hash+".jpg";
        %>
    <body>
        <%
            if(msg.equalsIgnoreCase("found")) {
                
            %>
    <div>
        <style scoped>
        body {
            background-color: #008755;
            margin-left: 5%;
            margin-right: 5%;
            border: 2px dotted black;
            padding: 10px 10px 10px 10px;
            font-family: sans-serif;
        }    
    </style>
    </div>
  
    <img src="<%= fileName %>"
         style="float: left;">
    
    <h1>Visitor Information</h1>
    <h2>First Name</h2>
    <p><%= firstName %></p>
    <h2>Last Name</h2>
    <p><%= lastName %></p>
    <h2>Company</h2>
    <p><%= company %></p>
    <h2>Visit schedule from - until</h2>
    <p><%= startTime %> - <%= endTime %></p>
    <%
        } else{
        %>
        
        <h1>No valid visit found for today!</h1>
        
<%
        }
        %>
</body>
</html>
