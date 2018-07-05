package com.dulal.many_to_many;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
  @Autowired
  ActorRepo actorRepo;

  @RequestMapping("/")
  public String index(Model model){

    //Create an actor
    Actor actor=new Actor();
    actor.setName("Bivechan gautam");
    actor.setRealname("blah blah");

    //Create a movie
    Movie movie=new Movie();
    movie.setTitle(" No movie done yet");
    movie.setYear(2017);
    movie.setDesc(" This is all about palying game");


    //Adding movie to an Empty List
    Set<Movie>movies=new HashSet<Movie>();
    movies.add(movie);

    //Add the list of movies to the actor's movie list
    actor.setMovies(movies);

    //Save the actor to the database
    actorRepo.save(actor);

    //Grab all the actors from the database and sent them to the templates
    model.addAttribute("actors", actorRepo.findAll());
    return "index";
  }
}
