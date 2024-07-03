<!DOCTYPE html>
<html>
<head>
  <title>Google Calendar API Quickstart</title>
  <meta charset="utf-8"/>
</head>
<body>
<p>Google Calendar API Quickstart</p>

<!--Add buttons to initiate auth sequence and sign out-->
<button id="authorize_button" onclick="handleAuthClick()">Authorize</button>
<button id="signout_button" onclick="handleSignoutClick()">Sign Out</button>

<pre id="content" style="white-space: pre-wrap;"></pre>
<script src="https://apis.google.com/js/api.js" async defer></script>
<%--<script async defer src="https://apis.google.com/js/api.js" onload="gapiLoaded()"></script>--%>
<script src="https://accounts.google.com/gsi/client"  async defer></script>
<script>
    function handleClientLoad() {
        gapi.load('client:auth2', initClient);
    }
        const evente = {
            'summary': 'Google I/O 2015',
            'location': '800 Howard St., San Francisco, CA 94103',
            'description': 'A chance to hear more about Google\'s developer products.',
            'start': {
                'dateTime': '2024-07-28T09:00:00-07:00',
                'timeZone': 'America/Los_Angeles'
            },
            'end': {
                'dateTime': '2024-07-28T17:00:00-09:00',
                'timeZone': 'America/Los_Angeles'
            },
            'recurrence': [
                'RRULE:FREQ=DAILY;COUNT=2'
            ],
            'attendees': [
                {'email': 'lpage@example.com'},
                {'email': 'sbrin@example.com'}
            ],
            'reminders': {
                'useDefault': false,
                'overrides': [
                    {'method': 'email', 'minutes': 24 * 60},
                    {'method': 'popup', 'minutes': 10}
                ]
            }
        };

        const request = gapi.client.calendar.events.insert({
            'calendarId': 'primary',
            'resource': event
        });

        request.execute(function (event) {
            appendPre('Event created: ' + event.htmlLink);
        });



</script>

</body>
</html>