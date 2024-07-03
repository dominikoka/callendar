<%@ page import="java.util.List" %>
<%@ page import="models.Event" %>
<%--
  Created by IntelliJ IDEA.
  User: lenda
  Date: 07.06.2024
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%--<style>--%>
<%--  <%@include file="/WEB-INF/css/style.css" %>--%>
<%--</style>--%>
<%--<div class="callendarBig">--%>
<div class="callendarBig_date">
  <div class="callendarBig_month"> Month: <% Integer month = (Integer) request.getAttribute("month");
    out.print(month);
  %></div>
  <div class="callendarBig_year">Year:  <% Integer year = (Integer) request.getAttribute("year");
    out.print(year);
  %></div>
  <div class="callendarBig_year"></div>
</div>
<div class="callenarBig_box">

  <div class="callendarBig_el time">
    <div class="callendar_times">
      <div class="callenarBig_day callendarBig_titleTime">TIME</div>
      <div class="callendarBig_time time_7">7:00</div>
      <div class="callendarBig_time time_8">8:00</div>
      <div class="callendarBig_time time_9">9:00</div>
      <div class="callendarBig_time time_10">10:00</div>
      <div class="callendarBig_time time_11">11:00</div>
      <div class="callendarBig_time time_12">12:00</div>
      <div class="callendarBig_time time_13">13:00</div>
      <div class="callendarBig_time time_14">14:00</div>
      <div class="callendarBig_time time_15">15:00</div>
      <div class="callendarBig_time time_16">16:00</div>
      <div class="callendarBig_time time_17">17:00</div>
    </div>
  </div>
  <%--    <div class="callendarBig_el">Monday</div>--%>
  <%--    <div class="callendarBig_el">Tuesday</div>--%>
  <%--    <div class="callendarBig_el">Wendsday</div>--%>
  <%--    <div class="callendarBig_el">Thursday</div>--%>
  <%--    <div class="callendarBig_el">Friday</div>--%>
  <%--    <div class="callendarBig_el">Saturday</div>--%>
  <%--    <div class="callendarBig_el">Sunday</div>--%>
  <div class="callenarBig_day"></div>
  <%
    int clickedDayInWeek = (int) request.getAttribute("clickedDayNumber");
    List<String> days = (List<String>) request.getAttribute("days");
    List<String> nbOfDays = (List<String>) request.getAttribute("nbOfDays");
    List<Event> events = (List<Event>) request.getAttribute("events");
    List<List<Integer>> hoursAndEvents = (List<List<Integer>>) request.getAttribute("hoursAndEvents");
    Integer eventID = 0;
    Integer type = -1;
    //TODO poprawic optymalizacje
    for (int i = 0; i < days.size(); i++) {

      System.out.println(eventID);

      if (clickedDayInWeek == i) {
        out.print("<div class=\"callendarBig_el callendar_clickedDay\">");
        out.print("<div class=\"callenarBig_day\">" + days.get(i) + nbOfDays.get(i) + "</div>");
        int counter = 0;
        int number = -1;
        for (int k = 0; k < hoursAndEvents.get(i).size(); k++) {
          if (number != hoursAndEvents.get(i).get(k)) {
            counter = 0;
          }

          if (hoursAndEvents.get(i).get(k) >= 0) {
            String chapter = "";
            if (counter == 0) {
              chapter = events.get(hoursAndEvents.get(i).get(k)).getName();
              type = events.get(hoursAndEvents.get(i).get(k)).getType();
              eventID = events.get(hoursAndEvents.get(i).get(k)).getID();
            } else {
              chapter = "";
            }

            out.print("<div class=\"activeEvent " + eventID + "\">");

            System.out.println(type + "typeEvent");
            if (type == 0) {
              out.print("<div class=\"halfHour halfHour_activeEvent type0\">" + chapter + " </div>");
            } else {
              out.print("<div class=\"halfHour halfHour_activeEvent type1\">" + chapter + " </div>");
            }
            out.print("</div>");
            counter++;
          } else {
            out.print("<div class=\"halfHour\"> </div>");
          }
          number = hoursAndEvents.get(i).get(k);
        }

        out.print("</div>");
      } else {
        out.print("<div class=\"callendarBig_el callendar_day\">");
        out.print("<div class=\"callenarBig_day\">" + days.get(i) + nbOfDays.get(i) + "</div>");
        int counter = 0;
        int number = -1;
        for (int k = 0; k < hoursAndEvents.get(i).size(); k++) {
          if (number != hoursAndEvents.get(i).get(k)) {
            counter = 0;
          }

          if (hoursAndEvents.get(i).get(k) >= 0) {
            String chapter = "";
            if (counter == 0) {
              chapter = events.get(hoursAndEvents.get(i).get(k)).getName();
              eventID = events.get(hoursAndEvents.get(i).get(k)).getID();
              type = events.get(hoursAndEvents.get(i).get(k)).getType();
            } else {
              chapter = "";
            }
            out.print("<div class=\"activeEvent " + eventID + "\">");

            System.out.println(type + "tyawe" + "zmiennne " + i + "" + k);
            if (type == 0) {
              out.print("<div class=\"halfHour halfHour_activeEvent type0\">" + chapter + " </div>");
            } else {
              out.print("<div class=\"halfHour halfHour_activeEvent type1\">" + chapter + " </div>");
            }
            out.print("</div>");
            counter++;
          } else {
            out.print("<div class=\"halfHour\"> </div>");
          }
          number = hoursAndEvents.get(i).get(k);
        }

        out.print("</div>");
      }

    }


  %>
</div>


<%--</div>--%>

<script>
    var eid = "";
    document.querySelectorAll('.activeEvent').forEach(function (element) {
        element.addEventListener('click', function () {
            eid = this.className;
        });
    });

    $(".activeEvent").click(function () {
        var adressURL = "http://localhost:8088/eventDetails";
        //
        // const eventName = document.querySelector('.eventWindow_nameInput').value;
        // const location = document.querySelector('.eventWindow_locationInput').value;
        // const messageTitle = document.querySelector('.eventWindow_MessageTitle').value;
        // const messageDesc = document.querySelector('.eventWindow_MessageDescription').value;
        // const dateStart = document.querySelector('.eventWindow_startDateInput').value;
        // const dateEnd = document.querySelector('.eventWindow_endDateInput').value;
        // console.log(dateStart);
        // var listOrder = JSON.stringify(itemsList);

        //var eventID = eid.substring(12,eid.length);

        //console.log(eventID);

        $.ajax({
            type: "GET",
            url: adressURL,
            data: {
                eventID: eid.substring(12, eid.length),
            },
            success: function (result) {
                $(".event_window").html(result);
                console.log(eid.substring(12, eid.length));
                // delete eid;
            },
            error: function (error) {
                console.error("Ajax request failed: " + error);
            }
        });
    });


</script>
