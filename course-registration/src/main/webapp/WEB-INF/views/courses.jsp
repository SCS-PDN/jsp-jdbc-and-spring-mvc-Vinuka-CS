<html>
<head>
    <title>Course Listing</title>
</head>
<body>
    <h1>Available Courses</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Course Name</th>
                <th>Instructor</th>
                <th>Credits</th>
                <th>Register</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course['name']}</td>
                    <td>${course['instructor']}</td>
                    <td>${course['credits']}</td>
                    <td>
                        <form action="/register/${course['course_id']}" method="POST">
                            <button type="submit">Register</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
