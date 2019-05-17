<html>
<body>
<h2>Hello World!</h2>

<c:forEach items="${myObj}" var="note">
         <p> ${note.name}</p><br/>
         <p> ${note.id}</p>


     </c:forEach>
</body>
</html>
