package com.movie.recommendation.dao;

import com.movie.recommendation.dto.DatabaseConfiguration;
import com.movie.recommendation.mappers.MovieMapper;
import com.movie.recommendation.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class MovieDAOImpl implements MovieDAO{

    private final DatabaseConfiguration databaseConfiguration;

    public MovieDAOImpl(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }


    @Override
    public List<Movie> getAllMovies() {
        String sql="SELECT * FROM public.movies";
        try {
            return databaseConfiguration.getJdbcTemplate().query(sql, (resultSet, rowNum)
                    -> MovieMapper.buildMovie(resultSet));
        } catch (DataAccessException ex) {
            log.error(ex.getMessage(), ex);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Movie> getLongestDurationMovies() {
        String sql = "SELECT tconst, primaryTitle, runtimeMinutes, genres FROM movies ORDER BY runtimeMinutes DESC LIMIT 10";

        return databaseConfiguration.getJdbcTemplate().query(sql, (rs, rowNum) -> {
            String tconst = rs.getString("tconst");
            String primaryTitle = rs.getString("primaryTitle");
            int runtimeMinutes = rs.getInt("runtimeMinutes");
            String genres = rs.getString("genres");

            return new Movie(tconst, primaryTitle, runtimeMinutes, genres);
        });
    }

    @Override
    public String addNewMovie(Movie movies) {
        return null;
    }

    @Override
    public List<Movie> getTopRatedMovies() {
        return null;
    }
}
