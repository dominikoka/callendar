<%@ page import="models.Event" %>
<div class="btns_details">
  <button class="btn_remove"> remove</button>
  <button class="btn_edit">edit</button>
  <%--  <%--%>
  <%--    String --%>
  <%--  %>--%>
</div>
<script>
$(".btn_remove").click(function () {
  var adressURL = "http://localhost:8088/remove";
  $.ajax({
    type: "GET",
    url: adressURL,
    data: {
      ide: eid.substring(12, eid.length),
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
$(".btn_edit").click(function () {
  var adressURL = "http://localhost:8088/eventEdit";
  $.ajax({
    type: "GET",
    url: adressURL,
    data: {
      eventID: eid.substring(12, eid.length),
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