<%-- 
    Document   : cabs
    Created on : Apr 16, 2024, 10:07:01 AM
    Author     : VIMAL SUKU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>JJ Travel</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- fonts -->
        <link href="https://fonts.googleapis.com/css?family=Baloo+Chettan+2:400,500,600,700|Poppins:400,600,700&display=swap"
              rel="stylesheet">
        <!-- font awesome css-->
        <link rel="stylesheet" type="text/css"
              href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="css/booking.css">
        <link rel="stylesheet" href="css/admin-login.css">
    </head>

    <body>
        <div class="header_section">
            <div class="container-fluid">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="Fetch?action=indexHotel">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Fetch?action=indexCab">Cabs</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Fetch?action=indexDest">Top Destination</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="about.jsp">About</a>
                            </li>
                        </ul>
                        <form class="form-inline my-2 my-lg-0">
                            <div class="login_btn">
                                <ul>
                                    <li><a href="#adminLogin" data-toggle="modal">Admin Login</a></li>
                                    <li><a href="#adminLogin" data-toggle="modal"><i class="fa fa-user" aria-hidden="true"></i></a>
                                    </li>
                                </ul>
                            </div>
                        </form>
                    </div>
                </nav>
            </div>
        </div>

        <!-- Cab section start -->
        <div class="hotels_section layout_padding">
            <div class="search_bt"><a href="#bookCab" data-toggle="modal">Book Cabs</a></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="hotels_taital">Cabs</h1>
                    </div>
                </div>
                <div class="hotels_section_2">
                    <div class="row">
                        <c:forEach var="cab" items="${listOfCab}">
                            <div class="col-md-4 my-3">
                                <div class="box_main">
                                    <div class="image_1"><img src="${cab.cabImageLoc}"></div>
                                    <h4 class="prid_text">${cab.cabName}</h4>
                                    <p class="korem_text">${cab.cabDescription}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cab section end -->

        <!-- Cab Book Modal HTML -->

        <div id="bookCab" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="Booking" method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Book Cab</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Enter Location</label>
                                <input type="text" name="location" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" name="name" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Email ID</label>
                                <input type="email" name="emailId" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Mobile No</label>
                                <input type="text" name="mobileNo" class="form-control" required>
                            </div>
                            <input type="hidden" name="action" value="cabBook">
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info" value="Submit">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Cab Book Modal End  -->

        <!--Admin Login start-->
        <div id="adminLogin" class="modal  fade">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <form action="Authendication?action=login" method="post" class="form-horizontal">
                        <h3 class="admin-header">Admin Login</h3>
                        <div class="form-group">
                            <input type="text" name="name" class="form-control" placeholder="Email or Username">
                        </div>
                        <div class="form-group help">
                            <input type="password" name="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">log in</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!--Admin Login end-->

        <!-- footer section start -->
        <div class="footer_section layout_padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <h3 class="footer_text">Information</h3>
                        <div class="footer_menu">
                            <ul>
                                <li><a href="#">About US</a></li>
                                <li><a href="#">Press Centre</a></li>
                                <li><a href="#">Best Price Guarantee</a></li>
                                <li><a href="#">Travel News</a></li>
                                <li><a href="#">Jobs</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="#">Terms of Use</a></li>
                                <li><a href="#">Feedback</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <h3 class="footer_text">Address</h3>
                        <p class="dummy_text">No.1, Gemini Parson Complex,Kodambakkam High Road, Tirumurthy Nagar,Nungambakkam,
                            Chennai,Tamil Nadu, India – 600006</p>
                        <h5 class="phone_text">Phone Number :</h5>
                        <p class="number_text"><a href="#">+91 9940882200</a></p>
                        <h5 class="phone_text">Email :</h5>
                        <p class="number_text"><a href="#">mail@jjtravels.in</a></p>
                    </div>
                    <div class="col-md-4">
                        <h3 class="footer_text">Newsletter</h3>
                        <form id="myForm" action="Booking" method="post">
                            <div class="form-group">
                                <textarea class="update_mail" type="email" placeholder="Enter Your Email" rows="5" name="email"></textarea>
                                <input type="hidden" name="action" value="newsLetter">
                                <div class="subscribe_bt"><a id="submitForm">Subscribe</a></div>
                            </div>
                        </form>
                        <div class="footer_social_icon">
                            <ul>
                                <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer section end -->
        <!-- copyright section start -->
        <div class="copyright_section">
            <div class="container">
                <p class="copyright_text"> 2024 All Rights Reserved.</p>
            </div>
        </div>
        <!-- copyright section end -->
        <!-- Javascript files-->
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.0.0.min.js"></script>
        <script src="js/plugin.js"></script>
        <!-- sidebar -->
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/custom.js"></script>
        <!-- javascript -->
        <script src="js/owl.carousel.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
        <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
        <script>
            // Material Select Initialization
            $(document).ready(function () {
                $('.mdb-select').materialSelect();
            });
        </script>
        <script>
            $('#datepicker').datepicker({
                uiLibrary: 'bootstrap'
            });
        </script>
        <script>
            $('#timepicker').timepicker({
                uiLibrary: 'bootstrap'
            });
        </script>
         <script>
            // JavaScript to submit the form when the anchor tag is clicked
            document.getElementById("submitForm").addEventListener("click", function () {
                document.getElementById("myForm").submit();
            });
        </script>
    </body>

</html>