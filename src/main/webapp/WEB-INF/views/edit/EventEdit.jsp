<%@ page import="java.util.List" %>
<%@ page import="com.sun.org.apache.bcel.internal.generic.LDIV" %>
<div class="eventDetails">
  <div class="eventDetails_box">
    <div class="eventDetails_btnCloseBox">
      <button class="eventDetails_closeBtn CloseBtn">X</button>
    </div>
    <h2 class="eventDetails_title"> EDIT EVENT</h2>
    <div class="eventDetails_nameBox">
      <h3 class="eventDetails_nameText">name</h3>
<%--      <h3 class="eventDetails_nameOutput"><% String name = (String) request.getAttribute("name");--%>
<%--        out.print(name);%></h3>--%>
            <input type="text" class="eventDetails_nameEdit" value="<% String name = (String) request.getAttribute("name");
              out.print(name);%>">
    </div>
    <div class="eventDetails_TimeBox">
      <div class="eventDetails_StartTimeBox">
        <h3 class="eventDetails_StartTimeText">start time</h3>
<%--        <h3 class="eventDetails_StartTimeTextOutput"><% String startTime = (String) request.getAttribute("startDate");--%>
<%--          out.print(startTime);%></h3>--%>
                <input type="datetime-local" class="eventDetails_StartTimeEdit" value="<% String startTime = (String) request.getAttribute("startDate");
                  out.print(startTime);%>">
      </div>
    </div>
    <div class="eventDetails_EndTimeBox">
      <h3 class="eventDetails_EndTimeText">end time</h3>
<%--      <h3 class="eventDetails_EndTimeTextOutput"><% String EndTime = (String) request.getAttribute("endDate");--%>
<%--        out.print(EndTime);%></h3>--%>
            <input type="datetime-local" class="eventDetails_EndTimeEdit" value="<% String endTime = (String) request.getAttribute("endDate");
                out.print(endTime);%>">
    </div>
    <div class="eventDetails_location">
      <h3 class="eventDetails_locationText">place</h3>
<%--      <h3 class="eventDetails_locationOutput"><% String location = (String) request.getAttribute("location");--%>
<%--        out.print(location);%></h3>--%>
            <input type="text" class="eventDetails_locationEdit" value="<% String location = (String) request.getAttribute("location");
              out.print(location);%>">

    </div>
    <div class="eventDetails_msgTitleBox">
      <h3 class="eventDetails_msgTitle">msg Title</h3>
<%--      <h3 class="eventDetails_msgTitleOutput"><% String msgTitle = (String) request.getAttribute("msgTitle");--%>
<%--        out.print(msgTitle);%></h3>--%>
            <input type="text" class="eventDetails_msgTitleEdit" value="<% String msgTitle = (String) request.getAttribute("msgTitle");
              out.print(msgTitle);%>">
    </div>
    <div class="eventDetails_msgDescBox">
      <h3 class="eventDetails_msgDesc">msg description</h3>
<%--      <h3 class="eventDetails_msgDescOutput"><% String msgDesc = (String) request.getAttribute("msgDesc");--%>
<%--        out.print(msgDesc);%></h3>--%>
            <textarea rows = "5" class="eventDetails_msgDescEdit" value="<% String msgDesc = (String) request.getAttribute("msgDesc");
                out.print(msgDesc);%>"></textarea>
    </div>
    <div class="eventDetails_emailBox">
      <%
        List<String> emails = (List<String>) request.getAttribute("emails");
        List<Boolean> confirmation = (List<Boolean>) request.getAttribute("confirmationEmail");
        if (emails.size() > 0) {
          System.out.println("wchodzi w ifaaa" + emails.size());
          out.print("<h3 class=\"eventDetails_emailTitle\">emails</h3>");
          for (int i = 0; i < emails.size(); i++) {
            out.print("<div class=\"eventDetails_singleEmail\">");
            System.out.println(i);
//            out.print("<h3 class=\"eventDetails_singleEmailText\">" + emails.get(i) + "</h3>");
           out.print("<input type=\"text\" class=\"eventDetails_singleEmailTextEdit\" value=\"");
           out.print(emails.get(i));
           out.print("\">");
            if (confirmation.get(i)) {
              out.print("<div class=\"eventDetails_confirmation\">");
              out.print("<span class=\"material-symbols-outlined\">\n" +
                "check_circle\n" +
                "</span>");
              out.print("</div>");
            } else {
              out.print("<div class=\"eventDetails_notConfirmation\">");
              out.print("<span class=\"material-symbols-outlined\">\n" +
                "close\n" +
                "</span>");
              out.print("</div>");
            }
            out.print("</div>");
          }
        }

      %>
    </div>
    <div class="eventDetails_btns">

        <%@ include file="../elements/btns_eventEdit.jsp" %>



    </div>

  </div>
</div>
<script>
    document.querySelector(".eventDetails_closeBtn").addEventListener('click', () => {
        const div = document.querySelector(".eventDetails");
        div.innerHTML = "";
        // $('.emailSender,.header,.footer').css('filter', 'blur(0px)');
    });

</script>

