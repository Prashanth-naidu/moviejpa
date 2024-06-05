package cm.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.repository.MovieRepository;
import com.example.movie.model.Movie;

@Service
public class MovieJpaService implements MovieRepository {

    @Autowired
    public MovieJpaRepository db;

    @Override
    public ArrayList<Movie> getMovies() {

        return (ArrayList<Movie>) db.findAll();
    }

    @Override
    public Movie getMovieById(int movieId){
        try{
            Movie e = db.findById(movieId).get();
            return e;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie addMovie(Movie movie) {

        Movie e = db.save(movie);

        return e;
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        try {
            Movie newOne = db.findById(movieId).get();
            if (movie.getMovieName() != null) {
                newOne.setMovieName(movie.getMovieName());
            }
            if (movie.getLeadActor() != null) {
                newOne.setLeadActor(movie.getLeadActor());
            }

            db.save(newOne);
            return newOne;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteMovie(int movieId) {
        try {
            db.deleteById(movieId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}