<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="headeradmin.jsp" %>
<script type="text/javascript" src="<c:url value="/script/ui.datepicker-fi.js" />"></script>
<script>
    $(function() {
        $( "#start" ).datepicker();
        $( "#end" ).datepicker();
        $( "#start2" ).datepicker();
        $( "#end2" ).datepicker();
    });
    
    
    
</script>
<div id="contents">
    <h2>Raportit</h2>
    <p>
    <form action="${pageContext.servletContext.contextPath}/seek">
        <table class="noborder">
            <tr>
                <td>Alkupvm</td>

                <td><input id="start" name="start" type="text" value="" required="required" pattern="^(0[1-9]|[1-2][0-9]|3[0-1])\.(0[1-9]|1[0-2])\.[0-9]{4}$"/></td>
            </tr>
            <tr>
                <td>Loppupvm</td>
                <td><input id="end" name="end" type="text" value="" required="required" pattern="^(0[1-9]|[1-2][0-9]|3[0-1])\.(0[1-9]|1[0-2])\.[0-9]{4}$"/></td>
            </tr>
        </table>
        </br>


        <input type="checkbox" name="reports" value="arrived" /> Saapuneet radiolääkkeet <br />
        <input type="checkbox" name="reports" value="removed" /> Poistuneet radiolääkkeet <br />
        <input type="checkbox" name="reports" value="RadioMedQuantity" /> Käyttökuntoon saatetut radiolääkkeet / lkm <br />
        <input type="checkbox" name="reports" value="RadioMedDetails" /> Käyttökuntoon saatetut radiolääkkeet / tarkat tiedot <br />
        <br/>
        <input type="submit" value="Luo raportti">
    </form>
    </p>
    
</br>
</br>

<h2>Tapahtumien haku</h2>
</br>
<form action="${pageContext.servletContext.contextPath}/getAllEvents">Hae kaikki tapahtumat aikaväliltä <input id="start2" name="start" type="text" value="" required="required" pattern="^(0[1-9]|[1-2][0-9]|3[0-1])\.(0[1-9]|1[0-2])\.[0-9]{4}$"/> - <input id="end2" name="end" type="text" value="" required="required" pattern="^(0[1-9]|[1-2][0-9]|3[0-1])\.(0[1-9]|1[0-2])\.[0-9]{4}$"/> <input type="submit" value="Hae"></form>

</div>
<%@include file="footer.jsp" %>
