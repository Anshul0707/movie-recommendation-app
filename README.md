# Movie Recommendation App

The Movie Recommendation App is a web application that provides users with personalized movie recommendations based on runtime, rating, and genre. It includes the following features:

- Retrieve the top 10 movies with the longest runtime.
- Add new movies to the database.
- Display highly-rated movies.
- Show genre-wise movie lists with numVotes subtotals.

The app utilizes an SQL database and an HTTP server to handle user requests and deliver accurate movie recommendations. It is implemented using [Java-SpringBoot] and follows RESTful API principles.

## Installation

1. Clone the repository.
2. Set up the SQL database and tables.
3. Run the HTTP server.

## Usage

1. Access the Movie Recommendation App through the provided URL.
2. Use the API routes to retrieve movie recommendations and perform database operations.

## API Contracts
### 1.Get Longest Duration Movies
- Method: GET
- Endpoint: `/api/v1/movies/longest-duration-movies`
- Request Parameters:`limit` (optional, default: 10): Specifies the maximum number of movies to retrieve.
`sortType` (optional, default: "DESC"): Specifies the sorting order of movies based on duration ("ASC" for ascending, "DESC" for descending).
- Response:Status: 200 OK
- Body: List of `Movie` objects

### 2.Add New Movie
- Method: POST
- Endpoint: `/api/v1/movies/new-movie`
- Request Body: `Movie` object
- Response:Status: 200 OK if successful, 500 Internal Server Error if failed

### 3.Get Top Rated Movies
- Method: GET
- Endpoint: `/api/v1/movies/top-rated-movies`
- Request Parameters:`limit` (optional, default: 6.0): Specifies the minimum rating for movies to retrieve.
- `sortType` (optional, default: "DESC"): Specifies the sorting order of movies based on rating ("ASC" for ascending, "DESC" for descending).
- Response:Status: 200 OK
- Body: List of `Movie` objects

### 4.Get Genre Movies with Subtotals
- Method: GET
- Endpoint: `/api/v1/movies/genre-movies-with-subtotals`
- Response:Status: 200 OK
- Body: List of `Movie` objects

### 5.Update Runtime Minutes
- Method: POST
- Endpoint: `/api/v1/movies/update-runtime-minutes`
- Response:Status: 200 OK if successful, 500 Internal Server Error if failed

## Contact

For any inquiries or feedback, please contact us at anshul.markwade786@gmail.com.
