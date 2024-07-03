<html>
<head>
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
  <style>
    <%@include file="css/style.css" %>


  </style>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>

</head>
<body class="body">
<div class="main">
  <div class="main_box">
    <%--  <img src="https://cdn0.iconfinder.com/data/icons/multimedia-line-30px/30/moon_dark_mode_night-512.png" alt="" class="main_switch">--%>
    <i class="bi bi-brightness-high-fill main_switch" id="toggleDark"></i>
    <h1 class="main_title">Callendar</h1>
    <div class="event">
      <div class="event_box">
        <div class="event_btnBox">
          <button class="event_btn btn draw-border"> create event</button>
        </div>
        <div class="event_window"></div>

      </div>
    </div>
    <div class="callendarMini">
      <div class="calendar-month-arrow-container">
        <div class="calendar-month-year-container">
          <select class="calendar-years"></select>
          <select class="calendar-months">
          </select>
        </div>
        <div class="calendar-month-year">
        </div>
        <div class="calendar-arrow-container">
          <button class="calendar-today-button"></button>
          <button class="calendar-left-arrow">
            <
          </button>
          <button class="calendar-right-arrow"> ></button>
        </div>
      </div>

      <div class="callendar-box">
        <div class="calendar-container">

          <ul class="calendar-week">
          </ul>
          <ul class="calendar-days">
          </ul>
        </div>
        <div class="calendar-big"></div>
      </div>
    </div>

  </div>
</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/moment.min.js"></script>


</body>
<script src="js/maine.js"></script>
</html>
