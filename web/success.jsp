<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head> 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <title>JJ Travel</title>
    </head>
    <body>
        <script>
            Swal.fire({
                title: "${messageTitle}",
                text: "${message}",
                icon: "success"
            }).then(() => {
                
                window.location.href = "${redirectUrl}";
            });

        </script>
    </body>
</html>
