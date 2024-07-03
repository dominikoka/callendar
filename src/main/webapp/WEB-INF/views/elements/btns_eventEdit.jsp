<div class="btns_edit">
  <button class="btn_details"> details</button>
  <button class="btn_accept">accept</button>
  <%--  <%--%>
  <%--    String --%>
  <%--  %>--%>
</div>
<script>
    $(".btn_details").click(function () {
        var adressURL = "http://localhost:8088/eventDetails";
        $.ajax({
            type: "GET",
            url: adressURL,
            data: {
                eventID: eid.substring(12, eid.length),
            },
            success: function (result) {
                $(".event_window").html(result);
                console.log("usunieto");
            },
            error: function (error) {
                console.error("Ajax request failed: " + error);
            }
        });
    });
    $(".btn_accept").click(function () {
        var adressURL = "http://localhost:8088/updateEvent";
        <% Integer typeServlet = (Integer) request.getAttribute("type");%>
        var type = <%=typeServlet%>;

        var eventName = document.querySelector('.eventDetails_nameEdit').value;
        var startTime = document.querySelector('.eventDetails_StartTimeEdit').value;
        var endTime = document.querySelector('.eventDetails_EndTimeEdit').value;
        var location="";
        var msgTitle="";
        var mailList = [];
        var mails = document.querySelectorAll('.eventDetails_singleEmailTextEdit');
        mails.forEach(function (input) {
            console.log(input);
            mailList.push(input.value);
        })

        var mailListToServlet=JSON.stringify(mailList);
        var msgDesc = document.querySelector('.eventDetails_msgDescEdit').value;

        if(type==0)
        {
            location = document.querySelector('.eventDetails_locationEdit').value;
            msgTitle = document.querySelector('.eventDetails_msgTitleEdit').value;
        }

        $.ajax({
            type: "GET",
            url: adressURL,
            data: {
                eventID: eid.substring(12, eid.length),
                eventName: eventName,
                startTime:startTime,
                endTime:endTime,
                location:location,
                msgTitle:msgTitle,
                msgDesc:msgDesc,

                mailList: mailListToServlet,
                type: type
            },
            success: function (result) {
                $(".event_window").html(result);
                console.log("edytujemy");
            },
            error: function (error) {
                console.error("Ajax request failed: " + error);
            }
        });
    });

</script>