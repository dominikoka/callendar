

<div class="eventWindow">
  <div class="eventWindow_box">
    <div class="eventDetails_btnCloseBox">
    <button class="eventWindow_closeBtn CloseBtn">X</button></div>
    <div class="eventWindow_title">create a calendar event</div>
    <div class="eventWindow_switch">
      <h3 class="eventWindow_switchBtn" data-target="tab1">
        Event
      </h3>
      <h3 class="eventWindow_switchBtn" data-target="tab2">
        Task
      </h3>
    </div>
    <div class="eventWindow_page tab1">
      <div class="eventWindow_nameBox">
        <div class="eventWindow_nameTitle"> event name</div>
        <input type="text" id="eventWindow_nameInput" class="eventWindow_nameInput">
      </div>
      <div class="eventWindow_data">
        <div class="eventWindow_startDate">
          <input
            class="eventWindow_startDateInput"
            type="datetime-local"
            id="meeting-time"
            name="meeting-time"
            <%
              Integer year = (Integer) request.getAttribute("year");
              Integer month = (Integer) request.getAttribute("month");
              Integer day = (Integer) request.getAttribute("day");
              String monthString = "";
              String dayString = "";
              if (month < 10) {
                monthString = "0" + month;
              } else {
                monthString = "" + month;
              }
              if (day < 10) {
                dayString = "0" + day;
              } else {
                dayString = "" + day;
              }
              String date = year + "-" + monthString + "-" + dayString;
              System.out.println("z mojego pliku jsp" + date);
              out.print("value=\"" + date + "T07:00\"");
            %>

            min="2024-06-08T07:00"
            max="2030-06-14T17:00"/>
        </div>
        <div class="eventWindow_endDate">
          <input
            class="eventWindow_endDateInput"
            type="datetime-local"
            id="meeting-time"
            name="meeting-time"
            <%
              out.print("value=\"" + date + "T07:30\"");
            %>

            min="2024-06-08T07:00"
            max="2030-06-14T17:00"/>
        </div>

      </div>
      <div class="eventWindow_locationBox">
        <div class="eventWindow_locationTitle"> location</div>
        <input type="text" id="eventWindow_locationInput" class="eventWindow_locationInput">
      </div>
      <div class="eventWindow_MessageBox">
        <div class="eventWindow_Message"> Message</div>
        <input type="text" id="eventWindow_MessageTitle" class="eventWindow_MessageTitle" placeholder="title">
        <input type="text" id="eventWindow_MessageDescription" class="eventWindow_MessageDescription"
               placeholder="description">
      </div>
      <div class="eventWindow_notificationBox">
        <input type="checkbox" class="eventWindow_notificationCheckBox">
        <h3 class="eventWindow_notificationText">6h before sms</h3>

      </div>
      <div class="eventWindow_emailBox">
        <div class="eventWindow_emailTitle"> enter the email addresses to which the invitation should be sent</div>
        <ul id="eventWindow_emailList" class="eventWindow_emailList">
        </ul>
        <input type="email" id="eventWindow_emailInput" class="eventWindow_emailInput" placeholder="enter email">
        <button id="eventWindow_addBtn" class="eventWindow_addBtn">add</button>
        <button id="eventWindow_removeBtn" class="eventWindow_removeBtn">remove</button>
      </div>

      <div class="eventWindow_sendBtnBox">
        <button class="eventWindow_sendBtn">SEND</button>
      </div>
    </div>


    <div class="eventWindow_page tab2">
      <div class="eventWindow_nameBox">
        <div class="eventWindow_nameTitle"> event name</div>
        <input type="text" id="eventWindow_nameInput" class="eventWindow_nameInput">
      </div>
      <div class="eventWindow_data">
        <div class="eventWindow_startDate">
          <input
            class="eventWindow_startDateInput"
            type="datetime-local"
            id="meeting-time"
            name="meeting-time"
            <%

              if (month < 10) {
                monthString = "0" + month;
              } else {
                monthString = "" + month;
              }
              if (day < 10) {
                dayString = "0" + day;
              } else {
                dayString = "" + day;
              }

              System.out.println("z mojego pliku jsp" + date);
              out.print("value=\"" + date + "T07:00\"");
            %>

            min="2024-06-08T07:00"
            max="2030-06-14T17:00"/>
        </div>
        <div class="eventWindow_endDate">
          <input
            class="eventWindow_endDateInput"
            type="datetime-local"
            id="meeting-time"
            name="meeting-time"
            <%
              out.print("value=\"" + date + "T07:30\"");
            %>

            min="2024-06-08T07:00"
            max="2030-06-14T17:00"/>
        </div>

      </div>
      <%--      <div class="eventWindow_locationBox">--%>
      <%--        <div class="eventWindow_locationTitle"> location</div>--%>
      <%--        <input type="text" id="eventWindow_locationInput" class="eventWindow_locationInput">--%>
      <%--      </div>--%>
      <div class="eventWindow_notificationBox">
        <input type="checkbox" class="eventWindow_notificationCheckBox">
        <h3 class="eventWindow_notificationText">6h before sms</h3>

      </div>
      <div class="eventWindow_MessageBox">
        <div class="eventWindow_Message"> Message</div>

        <input type="text" id="eventWindow_MessageDescription" class="eventWindow_MessageDescription"
               placeholder="description">
      </div>
      <div class="eventWindow_sendBtnBox">
        <button class="eventWindow_sendBtn">SEND</button>
      </div>
    </div>
  </div>
</div>

<script>


</script>
<script>

    if ((buttonsSwitch = document.querySelectorAll(".eventWindow_switchBtn")[0].style.color = 'white') && (buttonsSwitch = document.querySelectorAll(".eventWindow_switchBtn")[1].style.color = 'white')) {
        const buttonsSwitch = document.querySelectorAll(".eventWindow_switchBtn")[0].style.color = 'red';
    }

    // Change button to active when clicked
    $(".eventWindow_switchBtn").click(function () {
        buttonsSwitch = document.querySelectorAll(".eventWindow_switchBtn")[0].style.color = 'white';

        $(".eventWindow_switchBtn").removeClass("active");


        $(this).addClass("active");

    });


    // Makes variables for button and page content
    var $categoryButton = $(".eventWindow_switchBtn");
    var $pageContent = $(".eventWindow_page");


    // Hide all page content shows first one
    $(".eventWindow_page")
        .hide()
        .first()
        .show();
    var $category;
    // When button is clicked, show content
    $categoryButton.on("click", function (e) {
        $category = $(this).data("target");
        $pageContent
            .hide()
            .find('img').hide()
            .end()
            .filter("." + $category)
            .show()
            .find('img').fadeIn();
        console.log($category + "aasd")
    });


    // let itemsList;
    if (!window.emailAddBtn) {
        let itemsList = [];
        const emailAddBtn = document.getElementById('eventWindow_addBtn');
        const emailInput = document.getElementById('eventWindow_emailInput');
        const emailRemoveBtn = document.getElementById('eventWindow_removeBtn');
        const emailList = document.getElementById('eventWindow_emailList');
        emailAddBtn.addEventListener('click', () => {
            if (emailInput.value.includes("@")) {
                const newItem = document.createElement('li');
                newItem.textContent = emailInput.value;
                emailList.appendChild(newItem);
                itemsList.push(emailInput.value);
                emailInput.value = '';
            } else {
                console.log("To nie jest poprawny adres email");
            }
        });

        emailRemoveBtn.addEventListener('click', () => {
            const lastItem = emailList.lastElementChild;
            if (lastItem) {
                emailList.removeChild(lastItem);
                itemsList.pop();
            }
        });

        document.querySelector(".eventWindow_closeBtn").addEventListener('click', () => {
            const div = document.querySelector(".eventWindow");
            div.innerHTML = "";
            $('.main_title').css('filter', 'blur(0px)');
        });


        $(".eventWindow_sendBtn").click(function () {
            var adressURL = "http://localhost:8088/saveEvent";
            var type;

            if ($category == undefined) {
                $category = 'tab1';
            }

            if ($category == 'tab1') {
                type = 0;
            } else {
                type = 1;
            }
            console.log(type + "moj typ");

            var eventNameValues = [];
            var eventName = document.querySelectorAll('.eventWindow_nameInput');
            eventName.forEach(function (input) {
                console.log(input);
                eventNameValues.push(input.value);
            })
            console.log(eventNameValues);


            var location = document.querySelector('.eventWindow_locationInput').value;
            var messageTitle = document.querySelector('.eventWindow_MessageTitle').value;
            var messageDesc = document.querySelector('.eventWindow_MessageDescription').value;

            var dateStartValues = [];
            var dateStart = document.querySelectorAll('.eventWindow_startDateInput');
            dateStart.forEach(function (input) {
                console.log(input);
                dateStartValues.push(input.value);
            })

            var dateEndValues = [];
            var dateEnd = document.querySelectorAll('.eventWindow_endDateInput');
            dateEnd.forEach(function (input) {
                console.log(input);
                dateEndValues.push(input.value);
            })

            console.log(dateStart);
            var listOrder = JSON.stringify(itemsList);
            if (type == 1) {
                location = 'null';
                messageTitle = 'null'
                messageDesc = 'null';
            }

            console.log(location + "location")
            $.ajax({
                type: "GET",
                url: adressURL,
                data: {
                    eventName: eventNameValues[type],
                    location: location,
                    messageTitle: messageTitle,
                    messageDesc: messageDesc,
                    dateStart: dateStartValues[type],
                    dateEnd: dateEndValues[type],
                    listOrder: listOrder,
                    
                    type: type
                },
                success: function (result) {
                    $(".event_window").html(result);
                },
                error: function (error) {
                    console.error("Ajax request failed: " + error);
                }
            });
        });

    }


</script>