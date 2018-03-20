<%--
  Created by IntelliJ IDEA.
  User: Aladdin
  Date: 3/8/2018
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
    </head>
    <body>
        <form:form method="GET" action="/search" modelAttribute="filterCriteria">
            <form:label path="destinationName">Destination Name</form:label>
            <form:input path="destinationName"/>
            <form:errors path="destinationName"/>
        <br/>
            <form:label path="minTripStartDate">Min Trip Start Date</form:label>
            <form:input path="minTripStartDate" type="date"/>
            <form:errors path="minTripStartDate"/>
        <br/>
            <form:label path="maxTripStartDate">max Trip Start Date</form:label>
            <form:input path="maxTripStartDate" type="date"/>
            <form:errors path="maxTripStartDate"/>
        <br/>
            <form:label path="lengthOfStay">Length Of Stay</form:label>
            <form:input path="lengthOfStay"/>
            <form:errors path="lengthOfStay"/>
        <br/>
            <form:label path="minStarRating">Min Star Rating</form:label>
            <form:input path="minStarRating"/>
            <form:errors path="minStarRating"/>
        <br/>
            <form:label path="maxStarRating">Max Star Rating</form:label>
            <form:input path="maxStarRating"/>
            <form:errors path="maxStarRating"/>
        <br/>
            <form:label path="minGuestRating">Min Guest Rating</form:label>
            <form:input path="minGuestRating"/>
            <form:errors path="minGuestRating"/>
        <br/>
            <form:label path="maxGuestRating">Max Guest Rating</form:label>
            <form:input path="maxGuestRating"/>
            <form:errors path="maxGuestRating"/>
        <br/>
            <input type="submit" value="Filter"/>
        </form:form>
    </body>
</html>

