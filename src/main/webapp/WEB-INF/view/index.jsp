<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Hotel Offers</title>

        <!-- Bootstrap core CSS -->
        <link href="resources//css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="resources/css/heroic-features.css" rel="stylesheet">
    </head>

    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Hotel Offers</a>
            </div>
        </nav>

        <!-- Page Content -->
        <div class="container">

            <!-- Jumbotron Header -->
            <header class="jumbotron my-4">
                <h1 class="display-3">Welcome to hotel offers</h1>
                <p class="lead">Please use the filters below to get the offers that fit you</p>
            </header>


            <form:form method="GET" action="/search" role="form" modelAttribute="filterCriteria" class="mb-5">
                <div class="form-row">
                    <div class="form-group col-sm-6 row">
                        <form:label path="destinationName"
                                    class="col-sm-4 col-form-label">Destination Name </form:label>
                        <div class="col-sm-4">
                            <form:input path="destinationName" cssClass="form-control"></form:input>
                        </div>
                        <div class="col-sm-4">
                            <form:errors path="destinationName"></form:errors>
                        </div>
                    </div>
                    <div class="form-group col-sm-6 row">
                        <form:label path="lengthOfStay"
                                    class="col-sm-4 col-form-label">Length Of Stay</form:label>
                        <div class="col-sm-4">
                            <form:input type="number" path="lengthOfStay" class="form-control"></form:input>
                        </div>
                        <div class="col-sm-4">
                            <form:errors path="lengthOfStay"></form:errors>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-sm-6 row">
                        <form:label path="minTripStartDate"
                                    class="col-sm-4 col-form-label">Min Trip Start Date</form:label>
                        <div class="col-sm-4">
                            <form:input type="date" path="minTripStartDate" cssClass="form-control"></form:input>
                        </div>
                        <div class="col-sm-4">
                            <form:errors path="minTripStartDate"></form:errors>
                        </div>
                    </div>
                    <div class="form-group col-sm-6 row">
                        <form:label path="maxTripStartDate"
                                    class="col-sm-4 col-form-label">max Trip Start Date</form:label>
                        <div class="col-sm-4">
                            <form:input type="date" path="maxTripStartDate" cssClass="form-control"></form:input>
                        </div>
                        <div class="col-sm-4">
                            <form:errors path="maxTripStartDate"></form:errors>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group row col-sm-6">
                        <form:label path="minStarRating"
                                    class="col-sm-4 col-form-label">Min star Rating</form:label>
                        <div class="col-sm-4">
                            <form:input type="number" path="minStarRating" cssClass="form-control"></form:input>
                        </div>
                        <div class="col-sm-4">
                            <form:errors path="minStarRating"></form:errors>
                        </div>
                    </div>
                    <div class="form-group row col-sm-6">
                        <form:label path="maxStarRating"
                                    class="col-sm-4 col-form-label">Max star Rating</form:label>
                        <div class="col-sm-4">
                            <form:input type="number" path="maxStarRating" cssClass="form-control"></form:input>
                        </div>
                        <div class="col-sm-4">
                            <form:errors path="maxStarRating"></form:errors>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group  col-sm-6 row">
                        <form:label path="minGuestRating"
                                    class="col-sm-4 col-form-label">Min Guest Rating</form:label>
                        <div class="col-sm-4">
                            <form:input type="number" path="minGuestRating" cssClass="form-control"></form:input>
                        </div>
                        <div class="col-sm-4">
                            <form:errors path="minGuestRating"></form:errors>
                        </div>
                    </div>
                    <div class="form-group  col-sm-6 row">
                        <form:label path="maxGuestRating"
                                    class="col-sm-4 col-form-label">Max Guest Rating</form:label>
                        <div class="col-sm-4">
                            <form:input type="number" path="maxGuestRating" cssClass="form-control"></form:input>
                        </div>
                        <div class="col-sm-4">
                            <form:errors path="maxGuestRating"></form:errors>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <input class="btn btn-primary col-sm-2" type="submit" value="Filter"/>
                </div>
            </form:form>


            <!-- Page Features -->
            <div class="row text-center">
                <c:forEach items="${offersObj.offers.hotel}" var="hotel">

                    <div class="col-lg-3 col-md-6 mb-4">
                        <div class="card">
                            <img class="card-img-top" src="${hotel.hotelInfo.hotelImageUrl}" alt="">
                            <div class="card-body">
                                <h4 class="card-title">${hotel.hotelInfo.hotelName}</h4>
                                <p class="card-text">
                                    <fmt:formatDate value="${hotel.offerDateRange.travelStartDate}" var="travelStartDate"
                                                    type="date" pattern="MM-dd-yyyy" />
                                    Travel Start Date: ${travelStartDate}
                                <br/>
                                    <fmt:formatDate value="${hotel.offerDateRange.travelEndDate}" var="travelEndDate"
                                                    type="date" pattern="MM-dd-yyyy" />
                                    Travel End Date: ${travelEndDate}<br/>
                                    Country: ${hotel.destination.country}<br/>
                                    City: ${hotel.destination.city}<br/>
                                    Hotel Review: ${hotel.hotelInfo.hotelStarRating}<br/>
                                    Hotel Total Review: ${hotel.hotelInfo.hotelReviewTotal}<br/>
                                    Average Hotel Price: ${hotel.hotelPricingInfo.averagePriceValue}<br/>
                                    Total Hotel Price: ${hotel.hotelPricingInfo.totalPriceValue}<br/>
                                    Currency: ${hotel.hotelPricingInfo.currency}
                                </p>
                            </div>
                            <div class="card-footer">
                                <a href="#" class="btn btn-primary">Find Out More!</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->

        <script src="resources/jquery/jquery-3.3.1.min.js"></script>
        <script src="resources/js/bootstrap.bundle.min.js"></script>

    </body>

</html>
