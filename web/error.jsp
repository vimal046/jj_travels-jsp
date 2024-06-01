


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JJ Travel</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> 
    </head>
    <body>
        <script>
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: '${message}', // Something went wrong!
            }).then(function () {
                window.location.href='${redirectUrl}';
            });
        </script>
    </body>
</html>