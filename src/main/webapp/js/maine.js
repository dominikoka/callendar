function reload() {
    location.reload();
}

var weekArray = ["Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"];
var monthArray = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
];
var current = new Date();
var todaysDate = current.getDate();
var currentYear = current.getFullYear();
var currentMonth = current.getMonth();

var actuallYear;
var actuallMonth;
var actuallDay;

window.onload = function () {
    var currentDate = new Date();
    generateCalendarDays(currentDate);

    var calendarWeek = document.getElementsByClassName("calendar-week")[0];
    var calendarTodayButton = document.getElementsByClassName(
        "calendar-today-button"
    )[0];
    calendarTodayButton.textContent = `Today ${todaysDate}`;

    calendarTodayButton.addEventListener("click", () => {
        generateCalendarDays(currentDate);
    });

    weekArray.forEach((week) => {
        var li = document.createElement("li");
        li.textContent = week;
        li.classList.add("calendar-week-day");
        calendarWeek.appendChild(li);
    });

    const calendarMonths = document.getElementsByClassName("calendar-months")[0];
    const calendarYears = document.getElementsByClassName("calendar-years")[0];
    const monthYear = document.getElementsByClassName("calendar-month-year")[0];

    const selectedMonth = parseInt(monthYear.getAttribute("data-month") || 0);
    const selectedYear = parseInt(monthYear.getAttribute("data-year") || 0);

    monthArray.forEach((month, index) => {
        var option = document.createElement("option");
        option.textContent = month;
        option.value = index;
        option.selected = index === selectedMonth;
        calendarMonths.appendChild(option);
    });

    const currentYear = new Date().getFullYear();
    const startYear = currentYear - 60;
    const endYear = currentYear + 60;
    var newYear = startYear;
    while (newYear <= endYear) {
        var option = document.createElement("option");
        option.textContent = newYear;
        option.value = newYear;
        option.selected = newYear === selectedYear;
        calendarYears.appendChild(option);
        newYear++;
    }

    const leftArrow = document.getElementsByClassName("calendar-left-arrow")[0];

    leftArrow.addEventListener("click", () => {
        const monthYear = document.getElementsByClassName("calendar-month-year")[0];
        const month = parseInt(monthYear.getAttribute("data-month") || 0);
        const year = parseInt(monthYear.getAttribute("data-year") || 0);

        var newMonth = month === 0 ? 11 : month - 1;
        var newYear = month === 0 ? year - 1 : year;
        var newDate = new Date(newYear, newMonth, 1);
        generateCalendarDays(newDate);
    });

    const rightArrow = document.getElementsByClassName("calendar-right-arrow")[0];

    rightArrow.addEventListener("click", () => {
        const monthYear = document.getElementsByClassName("calendar-month-year")[0];
        const month = parseInt(monthYear.getAttribute("data-month") || 0);
        const year = parseInt(monthYear.getAttribute("data-year") || 0);
        var newMonth = month + 1;
        newMonth = newMonth === 12 ? 0 : newMonth;
        var newYear = newMonth === 0 ? year + 1 : year;
        var newDate = new Date(newYear, newMonth, 1);
        generateCalendarDays(newDate);
    });

    calendarMonths.addEventListener("change", function () {
        var newDate = new Date(calendarYears.value, calendarMonths.value, 1);
        generateCalendarDays(newDate);
    });

    calendarYears.addEventListener("change", function () {
        var newDate = new Date(calendarYears.value, calendarMonths.value, 1);
        generateCalendarDays(newDate);
    });
    document.querySelector('.calendar-day-active').click();
};

function generateCalendarDays(currentDate) {
    const newDate = new Date(currentDate);
    const year = newDate.getFullYear();
    const month = newDate.getMonth();
    const totalDaysInMonth = getTotalDaysInAMonth(year, month);
    const firstDayOfWeek = getFirstDayOfWeek(year, month);
    var calendarDays = document.getElementsByClassName("calendar-days")[0];

    removeAllChildren(calendarDays);

    var firstDay = 1;
    while (firstDay <= firstDayOfWeek) {
        var li = document.createElement("li");
        li.classList.add("calendar-day");
        calendarDays.appendChild(li);
        firstDay++;
    }

    var day = 1;
    while (day <= totalDaysInMonth) {
        var li = document.createElement("li");
        li.textContent = day;
        li.classList.add("calendar-day");
        if (todaysDate === day && currentMonth === month && currentYear === year) {
            li.classList.add("calendar-day-active");
        }
        calendarDays.appendChild(li);
        day++;
    }

    const monthYear = document.getElementsByClassName("calendar-month-year")[0];
    monthYear.setAttribute("data-month", month);
    monthYear.setAttribute("data-year", year);
    const calendarMonths = document.getElementsByClassName("calendar-months")[0];
    const calendarYears = document.getElementsByClassName("calendar-years")[0];
    calendarMonths.value = month;
    calendarYears.value = year;
    //starte
    var months = document.getElementsByClassName("calendar-months");
    var years = document.getElementsByClassName("calendar-years");
    var days = document.getElementsByClassName("calendar-day");


    for (let i = 0; i < days.length; i++) {
        // console.log(days[i]);
        days[i].addEventListener('click', function () {
            console.log("day " + days[i].innerHTML + "month " + months[0].value + "year " + years[0].value);
            actualDayNumber = i;
            let actuallDay = days[i].innerHTML;
            handleDay(actuallDay)
        })
        actuallYear = years[0].value;
        actuallMonth = months[0].value;

    }


}

function handleDay(day) {
    dayII = day;
}

function getTotalDaysInAMonth(year, month) {
    return new Date(year, month + 1, 0).getDate();
}

function getFirstDayOfWeek(year, month) {
    return new Date(year, month, 1).getDay();
}

function removeAllChildren(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}


var dayII = "";
// $(document).ready(function () {
$(".calendar-days").click(function () {
    var adressURL = "http://localhost:8088/LoadBigCallendar";
    let months = document.getElementsByClassName("calendar-months");
    let years = document.getElementsByClassName("calendar-years");
    $.ajax({
        type: "GET",
        url: adressURL,
        data: {
            actuallYear: years[0].value,
            actuallMonth: months[0].value,
            actualDay: dayII

        },
        success: function (result) {
            $(".calendar-big").html(result);
            // reload();
        },
        error: function (error) {
            console.error("Ajax request failed: " + error);
        }
    });


    // const test = "abc";
    // console.log("rok z ajax" + actuallYear);
    // console.log("miesiac z ajax" + actuallMonth);
    // console.log("dzien z ajax" + dayII);

});

$(".event_btn").click(function () {
    var adressURL = "http://localhost:8088/eventWindow";
    let months = document.getElementsByClassName("calendar-months");
    let years = document.getElementsByClassName("calendar-years");

    console.log("to jest moj dzien" + typeof dayII)
    if (dayII == "") {
        dayII = new Date().getDate();
    }
    $.ajax({
        type: "GET",
        url: adressURL,
        data: {
            actuallYear: years[0].value,
            actuallMonth: months[0].value,
            actualDay: dayII

        },
        success: function (result) {
            $(".event_window").html(result);
        },
        error: function (error) {
            console.error("Ajax request failed: " + error);
        }
    });
});
$(".eventWindow_closeBtn").click(function () {
    const div = document.querySelector(".eventWindow");
    div.innerHTML = "";
    // $('.emailSender,.header,.footer').css('filter', 'blur(0px)');
})

var toggleBtn = document.getElementById('toggleDark');
var body = document.querySelector('body');
toggleBtn.addEventListener('click', function () {
    // this.classList.toggle('bi-moon');
    // if (this.classList.toggle('bi-brightness-high-fill')) {
    //     body.style.background = 'white';
    //     body.style.color = 'black';
    //     body.style.transition = '2s';
    // } else {
    //     body.style.background = 'black';
    //     body.style.color = 'white';
    // }
    var element = document.body;
    element.classList.toggle("dark-mode");
    // body.style.transition = '2s';
})

// document.querySelector(".eventDetails_closeBtn").addEventListener('click', () => {
//     const div = document.querySelector(".eventDetails");
//     div.innerHTML = "";
//     // $('.emailSender,.header,.footer').css('filter', 'blur(0px)');
// });
//
// document.querySelector(".eventDetails_closeBtn").addEventListener('click', () => {
//     const div = document.querySelector(".eventDetails");
//     div.innerHTML = "";
//     // $('.emailSender,.header,.footer').css('filter', 'blur(0px)');
// });

// document.querySelector(".eventDetails_closeBtn").addEventListener('click', () => {
//     const div = document.querySelector(".eventDetails");
//     div.innerHTML = "";
//     // $('.emailSender,.header,.footer').css('filter', 'blur(0px)');
// });

