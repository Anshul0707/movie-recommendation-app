package com.movie.recommendation.dao;

import com.movie.recommendation.dto.DatabaseConfiguration;
import com.movie.recommendation.mappers.MovieMapper;
import com.movie.recommendation.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MovieDAOImpl implements MovieDAO {

    private final DatabaseConfiguration databaseConfiguration;


    public MovieDAOImpl(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }


    @Override
    public List<Movie> getLongestDurationMovies(int limit, String sortType) {
        String sql = "SELECT tconst, primaryTitle, runtimeMinutes, genres " +
                "FROM movies ORDER BY runtimeMinutes " + sortType + " LIMIT " + limit;
        try {

            return databaseConfiguration.getJdbcTemplate().query(sql, (resultSet, rowNum)
                    -> MovieMapper.buildMovie(resultSet));
        } catch (DataAccessException ex) {
            log.error(ex.getMessage(), ex);

        }
        return new ArrayList<>();
    }


    @Override
    public List<Movie> getTopRatedMovies(double limit, String sortType) {
        String sql = "SELECT movies.tconst, movies.primaryTitle, movies.genres, AVG(ratings.averageRating) AS averageRating\n" +
                "FROM ratings\n" +
                "INNER JOIN movies ON ratings.tconst = movies.tconst\n" +
                "GROUP BY movies.tconst, movies.primaryTitle, movies.genres\n" +
                "HAVING AVG(ratings.averageRating) > " + limit + " " +
                "ORDER BY AVG(ratings.averageRating) " + sortType + " ";
        try {
            return databaseConfiguration.getJdbcTemplate().query(sql, (resultSet, rowNum)
                    -> MovieMapper.buildMovieByRating(resultSet));
        } catch (DataAccessException ex) {
            log.error(ex.getMessage(), ex);

        }
        return new ArrayList<>();
    }

    @Override
    public boolean saveMovie(Movie movie) {
        String sql = "INSERT INTO movies (tconst, titletype, primaryTitle, runtimeMinutes, genres) VALUES (?, ?, ?, ?, ?)";

        try {
            int rowsAffected = databaseConfiguration.getJdbcTemplate().update(
                    sql,
                    movie.getTconst(),
                    movie.getTitleType(),
                    movie.getPrimaryTitle(),
                    movie.getRuntimeMinutes(),
                    movie.getGenres()
            );
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Movie> getGenreMoviesWithSubtotals() {
        String sql = "SELECT movies.genres ,movies.primarytitle, SUM(ratings.numVotes) AS numVotes\n" +
                "FROM movies\n" +
                "JOIN ratings ON movies.tconst  = ratings.tconst\n" +
                "GROUP by movies.genres , movies.primarytitle\n" +
                "ORDER BY movies.genres desc";
        try {
            return databaseConfiguration.getJdbcTemplate().query(sql, (resultSet, rowNum)
                    -> MovieMapper.buildMovieBySubTotal(resultSet));
        } catch (DataAccessException ex) {
            log.error(ex.getMessage(), ex);

        }
        return new ArrayList<>();
    }

    @Override
    public void updateRuntimeMinutes() {

        String sql = "UPDATE movies " +
                "SET runtimeMinutes = CASE " +
                "   WHEN genres = 'Documentary' THEN runtimeMinutes + 15 " +
                "   WHEN genres = 'Animation' THEN runtimeMinutes + 30 " +
                "   ELSE runtimeMinutes + 45 " +
                "   END";
        try {
            databaseConfiguration.getJdbcTemplate().update(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
