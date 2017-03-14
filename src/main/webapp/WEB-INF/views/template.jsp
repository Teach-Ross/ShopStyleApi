
<%--
  Created by IntelliJ IDEA.
  User: rteach
  Date: 3/13/2017
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* Dropdown Button */
        .dropbtn {
            background-color: #4CAF50;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }

        /* Dropdown button on hover & focus */
        .dropbtn:hover, .dropbtn:focus {
            background-color: #3e8e41;
        }

        /* The container <div> - needed to position the dropdown content */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        /* Dropdown Content (Hidden by Default) */
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        /* Links inside the dropdown */
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        /* Change color of dropdown links on hover */
        .dropdown-content a:hover {background-color: #f1f1f1}

        /* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
        .show {display:block;}
    </style>

</head>
<body>

<form action="gather" method="post">
<select name="waistsize" id="select1">
    <option>Select Waist Size</option>
</select>
<select name="inseamsize" id="select2">
    <option>Select Inseam Size</option>
</select>

<select name="style" id="styleList">
    <option selected="${style}" value="">Select Jean Style</option>
    <c:set var="test1" value="${style}"/>
    <c:forEach items="${list}" var="option">
        <c:set var="test2" value="${option}"/>
        <c:if test="test1 == test2">
        <option selected="${option}" value="${option}">
            <c:out value="${option}"></c:out>
        </option>
        </c:if>
        <option value="${option}">
            <c:out value="${option}"></c:out>
        </option>
    </c:forEach>
</select>
    <input type="submit" value="Submit">
</form>

${style}

${name}
<br>
${description}
<br>
${color}
<br>
${colorName0}
<br>
${categoryName0}














</body>
<script>

    var e = document.getElementById("styleList");
    //e.options[e.selectedIndex].value = "T"; // does not work
    e.value="${style}";

    function dropDown(id, min, max){
        var select = document.getElementById(id);
        for(var i = min; i <= max; i++) {
            var opt = i;
            var el = document.createElement("option");
            el.textContent = opt;
            el.value = opt;
            select.appendChild(el);
        }
    }

    dropDown("select1", 20, 40);
    dropDown("select2", 20, 40);



 /*   var select = document.getElementById("select1");

    for(var i = 20; i <= 40; i += 2) {
        var opt = i;
        var el = document.createElement("option");
        el.textContent = opt;
        el.value = opt;
        el.name = "waistsize";
        select.appendChild(el);
    }

    var select = document.getElementById("select2");

    for(var i = 20; i <= 40; i += 2) {
        var opt = i;
        var el = document.createElement("option");
        el.textContent = opt;
        el.value = opt;
        el.name = "inseamsize";
        select.appendChild(el);
    }*/
</script>

</html>

