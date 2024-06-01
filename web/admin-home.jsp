<%-- 
    Document   : admin-home
    Created on : Apr 16, 2024, 10:05:56 AM
    Author     : VIMAL SUKU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/admin-home.css">
        <link rel="stylesheet" href="css/crud-table.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>JJ Travel</title>



    </head>

    <body id="body-pd">
        <header class="header" id="header">
            <div class="header_toggle"> <i class='bx bx-menu' id="header-toggle"></i> </div>
        </header>
        <div class="l-navbar" id="nav-bar">
            <nav class="nav">
                <div> <a href="#" class="nav_logo"> <i class='bx bx-trip nav_logo-icon'></i> <span class="nav_logo-name">J J
                            Travels</span></a>
                    <div class="nav_list">
                        <a href="Fetch?action=adminHotel"  class="nav_link active"><i class='bx bxs-hotel nav_icon'></i><span class="nav_name">Hotels</span></a>
                        <a href="Fetch?action=adminCab"  class="nav_link"><i class='bx bxs-car nav_icon'></i><span class="nav_name">Cabs</span></a>
                        <a href="Fetch?action=adminDest"  class="nav_link"><i class='bx bxs-directions nav_icon'></i> <span class="nav_name">Destination</span></a>
                        <a href="AdminFetch?action=Booking"  class="nav_link"><i class='bx bx-library nav_icon'></i> <span class="nav_name">Booking Details</span> </a>
                        <a href="AdminFetch?action=newsLetter"  class="nav_link"> <i class='bx bxs-user-detail nav_icon'></i> <span class="nav_name">Subscribers</span> </a>
                    </div>
                </div> <a href="Authendication?action=logout" class="nav_link"> <i class='bx bx-log-out nav_icon'></i> <span
                        class="nav_name">SignOut</span> </a>
            </nav>
        </div>
        <!--Container Main start-->
        <div class="height-100 ">
            <!-- Hotel Section starting here -->
            <div class="Hotel-Container">
                <div id="hotels" class="content-section">
                    <div class="container">
                        <div class="table-responsive">
                            <div class="table-wrapper">
                                <div class="table-title">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <h2>Manage <b>Hotel</b></h2>
                                        </div>
                                        <div class="col-xs-6">
                                            <a id="addHotel" class="btn btn-success" data-bs-toggle="modal"
                                               data-bs-target="#addHotelModel"><i class="material-icons">&#xE147;</i>
                                                <span>Add
                                                    New Hotel</span></a>
                                        </div>
                                    </div>
                                </div>           
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>Hotel ID</th>
                                            <th>Hotel Name</th>
                                            <th>Description</th>
                                            <th>Image Location</th>
                                            <th>Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listOfHotel}" var="hotel">
                                            <tr>
                                                <td>#${hotel.hotelId}</td>
                                                <td>${hotel.hotelName}</td>
                                                <td>${hotel.hotelDescription}</td>
                                                <td>${hotel.hotelImageLoc}</td>
                                                <td>
                                                    <a href="#" class="edit" data-bs-toggle="modal" data-action="hotel" data-bs-target="#editHotelModal">
                                                        <i class="material-icons" title="Edit">&#xE254;</i>
                                                    </a>
                                                    <a href="#" class="delete" data-bs-toggle="modal" data-action="hotel" data-bs-target="#deleteHotelModal">
                                                        <i class="material-icons" title="Delete">&#xE872;</i>
                                                    </a>
                                                </td>
                                            </tr> 
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <!--                 Hotel Add Modal Start-->

                <div class="modal fade" id="addHotelModel" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="Add" method="post" enctype="multipart/form-data">
                                <div class="modal-header">
                                    <h4 class="modal-title">Add Hotel</h4>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-hidden="true"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="my-3">Hotel ID</label>
                                        <input type="text" class="form-control" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label class="my-3">Hotel Name</label>
                                        <input type="text" name="hotelName" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label class="my-3">Image Location</label>
                                        <input type="file" name="hotelImage" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label class="my-3">Description</label>
                                        <textarea class="form-control" name="hotelDescription" style="height: 200px;"></textarea>
                                    </div>
                                    <input type="hidden" name="action" value="addHotel">
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-success" value="Add">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <!--                 Hotel Add Modal End-->


                <!--                 Hotel Edit Modal Start-->

                <div class="modal fade" id="editHotelModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="Update" method="post">
                                <div class="modal-header">
                                    <h4 class="modal-title">Add Hotel</h4>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-hidden="true"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="my-3">Hotel ID</label>
                                        <input type="text" name="hotelID" class="form-control" readonly id="hotelIDInput">
                                    </div>
                                    <div class="form-group">
                                        <label class="my-3">Hotel Name</label>
                                        <input type="text" name="hotelName" class="form-control" id="hotelNameInput">
                                    </div>
                                    <div class="form-group">
                                        <label class="my-3">Image Location</label>
                                        <input type="text" name="hotelImage" class="form-control" readonly id="hotelimageLocationInput">
                                    </div>
                                    <div class="form-group">
                                        <label class="my-3">Description</label>
                                        <textarea class="form-control" name="hotelDescription" id="hoteldescriptionInput"
                                                  style="height: 200px;"></textarea>
                                    </div>
                                    <input type="hidden" name="action" value="hotelUpdate">
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-success" value="Add">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <!--                 Hotel Edit Modal End-->


                <!--                 Hotel Delete Modal Start-->

                <div class="modal fade" id="deleteHotelModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="Delete" method="post">
                                <div class="modal-header">
                                    <h4 class="modal-title">Delete Hotel</h4>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-hidden="true"></button>
                                </div>
                                <div class="modal-body">
                                    <p>Are you sure you want to delete these Records?</p>
                                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                                    <input type="text" name="hotelID" id="hotelIdDelete" hidden>
                                    <input type="text" name="imageLocation" id="hotelImageLoc" hidden>
                                    <input type="hidden" name="action" value="hotelDelete">
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-danger" value="Delete">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <!--    Hotel Delet Modal End-->

            </div>
            <!-- End of Hotel section -->

























            <!-- start of Cab Section -->

            <div id="cabs" class="content-section">
                <div class="container">
                    <div class="table-responsive">
                        <div class="table-wrapper">
                            <div class="table-title" style="background: #1679AB;">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <h2>Manage <b>Cab</b></h2>
                                    </div>
                                    <div class="col-xs-6">
                                        <a id="addCab" class="btn btn-success" data-bs-toggle="modal"
                                           data-bs-target="#addCabModel"><i class="material-icons">&#xE147;</i>
                                            <span>Add
                                                New Cab</span></a>
                                    </div>
                                </div>
                            </div>
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>Cab ID</th>
                                        <th>Cab Name</th>
                                        <th>Image Location</th>
                                        <th>Description</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${listOfCab}" var="cab">
                                    <tr>
                                        <td>#${cab.cabId}</td>
                                        <td>${cab.cabName}</td>
                                        <td>${cab.cabDescription}</td>
                                        <td>${cab.cabImageLoc}</td>
                                        <td>
                                            <a href="#" class="edit" data-bs-toggle="modal" data-action="cab" data-bs-target="#editCabModal">
                                                <i class="material-icons" title="Edit">&#xE254;</i>
                                            </a>
                                            <a href="#" class="delete" data-bs-toggle="modal" data-action="cab" data-bs-target="#deleteCabModal">
                                                <i class="material-icons" title="Delete">&#xE872;</i>
                                            </a>
                                        </td>
                                    </tr> 
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Cab Add Modal Start-->

            <div class="modal fade" id="addCabModel" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="Add" method="post" enctype="multipart/form-data">
                            <div class="modal-header">
                                <h4 class="modal-title">Add Cab</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label class="my-3">Cab ID</label>
                                    <input type="text" class="form-control" readonly>
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Cab Name</label>
                                    <input type="text" name="cabName" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Image Location</label>
                                    <input type="file" name="cabImage" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Description</label>
                                    <textarea class="form-control" name="cabDescription" style="height: 200px;"></textarea>
                                </div>
                                <input type="hidden" name="action" value="addCab">
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Cab Add Modal End-->


            <!-- Cab Edit Modal Start-->

            <div class="modal fade" id="editCabModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="Update" method="post">
                            <div class="modal-header">
                                <h4 class="modal-title">Add Cab</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label class="my-3">Cab ID</label>
                                    <input type="text" class="form-control" name="cabId" readonly id="cabIDInput">
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Cab Name</label>
                                    <input type="text" class="form-control" name="cabName" id="cabNameInput">
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Image Location</label>
                                    <input type="text" class="form-control" readonly id="cabimageLocationInput">
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Description</label>
                                    <textarea class="form-control" name="cabDescr" id="cabdescriptionInput"
                                              style="height: 200px;"></textarea>
                                </div>
                                <input type="hidden" name="action" value="cabUpdate">
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Cab Edit Modal End-->


            <!-- Cab Delete Modal Start-->

            <div class="modal fade" id="deleteCabModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="Delete" method="post">
                            <div class="modal-header">
                                <h4 class="modal-title">Delete Cab</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                            </div>
                            <div class="modal-body">
                                <p>Are you sure you want to delete these Records?</p>
                                <p class="text-warning"><small>This action cannot be undone.</small></p>
                                <input type="text" name="cabId" id="cabIdDelete" hidden>
                                <input type="text" name="imageLocation" id="cabImageLoc" hidden>
                                <input type="hidden" name="action" value="cabDelete">
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-danger" value="Delete">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Cab Delet Modal End-->

            <!-- End of Cab Section -->


            <!-- start of Destination Section -->

            <div id="destination" class="content-section">
                <div class="container">
                    <div class="table-responsive">
                        <div class="table-wrapper">
                            <div class="table-title" style="background: #401F71;">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <h2>Manage <b>Destination</b></h2>
                                    </div>
                                    <div class="col-xs-6">
                                        <a id="addCab" class="btn btn-success" data-bs-toggle="modal"
                                           data-bs-target="#addDestinationModel"><i class="material-icons">&#xE147;</i>
                                            <span>Add
                                                New Destination</span></a>
                                    </div>
                                </div>
                            </div>
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>Destination ID</th>
                                        <th>Destination Name</th>
                                        <th>Image Location</th>
                                        <th>Description</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listOfDest}" var="dest">
                                        <tr>
                                            <td>#${dest.destId}</td>
                                            <td>${dest.destName}</td>
                                            <td>${dest.destDescription}</td>
                                            <td>${dest.destImageLoc}</td>
                                            <td>
                                                <a href="#" class="edit" data-bs-toggle="modal" data-action="destination" data-bs-target="#editDestinationModal">
                                                    <i class="material-icons" title="Edit">&#xE254;</i>
                                                </a>
                                                <a href="#" class="delete" data-bs-toggle="modal" data-action="destination" data-bs-target="#deleteDestinationModal">
                                                    <i class="material-icons" title="Delete">&#xE872;</i>
                                                </a>
                                            </td>
                                        </tr> 
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Destination Add Modal Start-->

            <div class="modal fade" id="addDestinationModel" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="Add" method="post" enctype="multipart/form-data">
                            <div class="modal-header">
                                <h4 class="modal-title">Add Destination</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label class="my-3">Destination ID</label>
                                    <input type="text" class="form-control" readonly>
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Destination Name</label>
                                    <input type="text" name="destName" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Image Location</label>
                                    <input type="file" name="destImage" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Description</label>
                                    <textarea class="form-control" name="destDiscr" style="height: 200px;"></textarea>
                                </div>
                                <input type="hidden" name="action" value="addDestination">
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Destination Add Modal End-->


            <!-- Destination Edit Modal Start-->

            <div class="modal fade" id="editDestinationModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="Update" method="post">
                            <div class="modal-header">
                                <h4 class="modal-title">Update Destination</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label class="my-3">Destination ID</label>
                                    <input type="text" class="form-control" name="destId" readonly id="destinationIDInput">
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Destination Name</label>
                                    <input type="text" class="form-control" name="destName" id="destinationNameInput">
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Image Location</label>
                                    <input type="text" class="form-control" readonly id="destinationimageLocationInput">
                                </div>
                                <div class="form-group">
                                    <label class="my-3">Description</label>
                                    <textarea class="form-control" name="destDescr" id="destinationdescriptionInput"
                                              style="height: 200px;"></textarea>
                                </div>
                                <input type="hidden" name="action" value="destUpdate">
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Destination Edit Modal End-->


            <!-- Destination Delete Modal Start-->

            <div class="modal fade" id="deleteDestinationModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="Delete" method="post">
                            <div class="modal-header">
                                <h4 class="modal-title">Delete Cab</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                            </div>
                            <div class="modal-body">
                                <p>Are you sure you want to delete these Records?</p>
                                <p class="text-warning"><small>This action cannot be undone.</small></p>
                                <input type="text" name="destId" id="destinationIdDelete" hidden>
                                <input type="text" name="imageLocation" id="destinationImageLoc" hidden>
                                <input type="hidden" name="action" value="destinationDelete">
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-danger" value="Delete">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Destination Delete Modal End-->



            <div id="booking" class="content-section">
                <div class="container" style="margin-top: 50px;">

                    <!-- Hotel Booking Table -->
                    <c:if test="${not empty bookedHotel}">
                        <div class="row">
                            <h3 class="book-table-head">Hotel Booking</h3>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col"  style="width: 120px;" >Booking ID</th>
                                        <th scope="col" style="width: 200px;">City</th>
                                        <th scope="col" style="width: 200px;">Check-in</th>
                                        <th scope="col" style="width: 200px;">Check-out</th>
                                        <th scope="col" style="width: 200px;">Number Of Room</th>
                                        <th scope="col" style="width: 200px;">Booking Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="hotel" items="${bookedHotel}">
                                        <tr>
                                            <th scope="row">#${hotel.hBookId}</td>
                                            <td>${hotel.hotelName}</td>
                                            <td>${hotel.checkInDate}</td>
                                            <td>${hotel.checkOutDate}</td>
                                            <td>${hotel.noOfRooms}</td>
                                            <td>${hotel.hBookingDate}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>

                    <!-- Cab Booking Table -->
                    <c:if test="${not empty bookedCab}">
                        <div class="row">
                            <h3 class="book-table-head">Cab Booking</h3>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col" style="width: 120px;">Booking ID</th>
                                        <th scope="col" style="width: 200px;">Location</th>
                                        <th scope="col" style="width: 200px;">Name</th>
                                        <th scope="col" style="width: 200px;">Email</th>
                                        <th scope="col" style="width: 200px;">Mobile</th>
                                        <th scope="col" style="width: 200px;">Booking Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="cab" items="${bookedCab}">
                                        <tr>
                                            <th scope="row">#${cab.bookId}</td>
                                            <td>${cab.location}</td>
                                            <td>${cab.name}</td>
                                            <td>${cab.emailId}</td>
                                            <td>${cab.mobile}</td>
                                            <td>${cab.bookingTime}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>

                    <!-- Destination Enquiry Table -->
                    <c:if test="${not empty bookedDest}">
                        <div class="row">
                            <h3 class="book-table-head">Destination Enquiry</h3>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col" style="width: 150px;">Enquiry ID</th>
                                        <th scope="col" style="width: 150px;">Full Name</th>
                                        <th scope="col" style="width: 200px;">Email</th>
                                        <th scope="col" style="width: 200px;">Mobile</th>
                                        <th scope="col" style="width: 200px;">Travel Date</th>
                                        <th scope="col" style="width: 200px;">Traveller Count</th>
                                        <th scope="col" style="width: 200px;">Message</th>
                                        <th scope="col" style="width: 250px;">Enquiry Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="dest" items="${bookedDest}">
                                        <tr>
                                            <th scope="row">#${dest.bookId}</td>
                                            <td>${dest.name}</td>
                                            <td>${dest.email}</td>
                                            <td>${dest.mobile}</td>
                                            <td>${dest.travelDate}</td>
                                            <td>${dest.travellerCount}</td>
                                            <td>${dest.message}</td>
                                            <td>${dest.bookDate}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div>
            </div>





            <div id="newsLetter" class="content-section">
                <div class="container" style="margin-top: 100px;">
                    <h3 style="margin-top: 30px; margin-bottom: 30px;">News Letter</h3>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">S-ID</th>
                                <th scope="col">Email</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="newsletter" items="${listOfSub}">
                                <tr>
                                    <th scope="row">#${newsletter.id}</td>
                                    <td>${newsletter.email}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>


        </div>


        <!--Container Main end-->


        <script src="js/admin-home.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <script>

            //Edit modal jquery for populate data

            $(document).ready(function () {
                // Adding click event listener to the edit buttons
                $('.edit').on('click', function () {

                    var action = $(this).data('action');
                    var row = $(this).closest('tr');
                    if (action === 'hotel') {

                        var id = row.find('td:eq(0)').text().replace('#', '');
                        var name = row.find('td:eq(1)').text();
                        var description = row.find('td:eq(2)').text();
                        var imageLocation = row.find('td:eq(3)').text();
                        $('#editHotelModal #hotelIDInput').val(id);
                        $('#editHotelModal #hotelNameInput').val(name);
                        $('#editHotelModal #hotelimageLocationInput').val(imageLocation);
                        $('#editHotelModal #hoteldescriptionInput').val(description);
                    } else if (action === 'cab') {

                        var id = row.find('td:eq(0)').text().replace('#', '');
                        var name = row.find('td:eq(1)').text();
                        var description = row.find('td:eq(3)').text();
                        var imageLocation = row.find('td:eq(2)').text();
                        $('#editCabModal #cabIDInput').val(id);
                        $('#editCabModal #cabNameInput').val(name);
                        $('#editCabModal #cabimageLocationInput').val(imageLocation);
                        $('#editCabModal #cabdescriptionInput').val(description);
                    } else if (action === 'destination') {

                        var id = row.find('td:eq(0)').text().replace('#', '');
                        var name = row.find('td:eq(1)').text();
                        var description = row.find('td:eq(4)').text();
                        var imageLocation = row.find('td:eq(3)').text();
                        $('#editDestinationModal #destinationIDInput').val(id);
                        $('#editDestinationModal #destinationNameInput').val(name);
                        $('#editDestinationModal #destinationimageLocationInput').val(imageLocation);
                        $('#editDestinationModal #destinationdescriptionInput').val(description);
                    }
                });
            });








            //Delete modal JQuery to send the data

            $(document).ready(function () {
                $('.delete').click(function (event) {
                    event.preventDefault();
                    var row = $(this).closest('tr');
                    var action = $(this).data('action');
                    if (action === 'hotel') {
                        var hotelID = row.find('td:nth-child(1)').text().replace('#', '');
                        var imageLocation = row.find('td:nth-child(4)').text().trim();
                        $('#hotelIdDelete').val(hotelID);
                        $('#hotelImageLoc').val(imageLocation);
                    } else if (action === 'cab')

                    {
                        var cabID = row.find('td:nth-child(1)').text().replace('#', '');
                        var imageLocation = row.find('td:nth-child(3)').text().trim();
                        $('#cabIdDelete').val(cabID);
                        $('#cabImageLoc').val(imageLocation);
                    } else if (action === 'destination') {
                        var destinationID = row.find('td:nth-child(1)').text().replace('#', '');
                        var imageLocation = row.find('td:nth-child(4)').text().trim();
                        
                        console.log(destinationID);
                        console.log(imageLocation);
                        
                        $('#destinationIdDelete').val(destinationID);
                        $('#destinationImageLoc').val(imageLocation);
                    }
                });
            });




            var dataTarget = "${dataTarget}";



            $(document).ready(function () {

                $('.content-section.active').show();


                var target = dataTarget
                $('.content-section').hide();
                $('#' + target).show();
                $('.nav_link').removeClass('active');
                $(this).addClass('active');



//                $('.nav_link.active').trigger('click');
            });





        </script>


    </body>

</html>
