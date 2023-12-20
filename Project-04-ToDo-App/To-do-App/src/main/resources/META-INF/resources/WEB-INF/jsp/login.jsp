<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
</head>

<body>
    <h1>Welcome to Login Page!!</h1>
    <form:form action="login" modelAttribute="credentials">
        <label for="name">Enter Name</label>
        <form:input path="name" />
        
        <label for="password">Enter Password</label>
        <form:password path="password" />
        
        <input type="submit">
    </form:form>
</body>

</html>