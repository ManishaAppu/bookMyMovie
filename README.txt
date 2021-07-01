Adding New User: http:\\localhost:9090\user\newUser

Request Json: 

{
    "firstName": "Appu",
    "lastName": "Murali",
    "location": "Coimbatore",
    "phoneNumber": "873465435",
    "username":"appu",
    "password":"murali"
}

Get All the Users: http:\\localhost:9090\user\getUsers

User Login  http://localhost:9090/user/login

Request Json:

{
    "username":"appu",
    "password":"murali"
}

Add Cinema Hall to the System: http://localhost:9090/addCinemaHall

Request Json:

{
    "hallName": "Fun Republic Mall",
    "totalNoOfSeats": 60,
    "is_active":1
}

Add New Movie http:\\localhost:9090\movie\add

{
    "movieName" : "Sulthan",
    "movieLanguage": "Tamil",
    "actor": "Karthic",
    "actress" : "Rashmika Mandanna",
    "director": "Bakkiyaraj Kannan",
    "specialCharacters":"Lal"
}


Get All the Movies: http:\\localhost:9090\movie\getMovies

Add Show http:\\localhost:9090\addShow

Request Json:

{
    "movieId" : 2,
    "hallId": 3,
    "showDateTime": "2021-07-01T16:00:00.000"    
}

Get the Show Details: http:\\localhost:9090\getShowDetails\2

Reserve the Movie http:\\localhost:9090\reserveMovie

{
    "movieShowId": 4,
    "userId": 12,
    "noOfSeatsReserving": 4,
    "seatNumbers" : [1,2,3,4]
}

To check the availability of the Show and Seats http:\\localhost:9090\checkSeatAvailability\2

Book the Movie http:\\localhost:9090\bookMovie

{
    "movieReservationId" : 5,
    "paymentStatus" : true
}

Cancel the Reservation http:\\localhost:9090\cancelReservation\4

{
    "movieReservationId" : 2,
    "paymentStatus" : true
}

