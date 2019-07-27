package com.hadyandev.moviecatalogue;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hadyandev.moviecatalogue.adapter.MovieAdapter;
import com.hadyandev.moviecatalogue.adapter.MovieClickListener;
import com.hadyandev.moviecatalogue.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieClickListener {

    private List<Movie> movies;
    private MovieAdapter adapter;

    public RecyclerView lstMovie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstMovie = findViewById(R.id.lstMovie);

        //1. menyiapkan data yang akan ditampilkan kedalam recyclerview
        movieExampleData();

        //2. layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstMovie.setLayoutManager(linearLayoutManager);

        //3. mendefinisikan adapter
        adapter = new MovieAdapter(movies, this);

        //4. tampilkan data
        lstMovie.setAdapter(adapter);
    }

    private void movieExampleData() {
        movies = new ArrayList<>();
        movies.add(new Movie("Aquaman", R.drawable.poster_aquaman, 6.8f, "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."));
        movies.add(new Movie("Avengers: End Game", R.drawable.poster_avengerendgame, 8.4f, "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store."));
        movies.add(new Movie("Avengers: Infinity War", R.drawable.poster_avengerinfinity, 8.3f, "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."));
        movies.add(new Movie("Bumblebee", R.drawable.poster_bumblebee, 6.5f, "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug."));
        movies.add(new Movie("Creed II", R.drawable.poster_creed, 6.7f, "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."));
        movies.add(new Movie("How to Train Your Dragon: The Hidden World", R.drawable.poster_dragon, 7.6f, "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."));
        movies.add(new Movie("Dragon Ball Super: Broly", R.drawable.poster_dragonball, 7.4f, "Earth is peaceful following the Tournament of Power. Realizing that the universes still hold many more strong people yet to see, Goku spends all his days training to reach even greater heights. Then one day, Goku and Vegeta are faced by a Saiyan called 'Broly' who they've never seen before. The Saiyans were supposed to have been almost completely wiped out in the destruction of Planet Vegeta, so what's this one doing on Earth? This encounter between the three Saiyans who have followed completely different destinies turns into a stupendous battle, with even Frieza (back from Hell) getting caught up in the mix."));
        movies.add(new Movie("The Lion King", R.drawable.poster_lionking, 6.7f, "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his."));
        movies.add(new Movie("Robin Hood", R.drawable.poster_robinhood, 5.8f, "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."));
        movies.add(new Movie("Shazam!", R.drawable.poster_shazam, 7.1f, "A boy is given the ability to become an adult superhero in times of need with a single magic word."));
        movies.add(new Movie("Spider-Man: Into the Spider-Verse", R.drawable.poster_spiderman, 8.4f, "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."));
        movies.add(new Movie("Spider-Man: Far from Home", R.drawable.poster_spidermanfarfromhome, 7.8f, "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent."));
        movies.add(new Movie("Toy Story 4", R.drawable.poster_toystory, 7.7f, "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy."));
        movies.add(new Movie("Venom", R.drawable.poster_venom, 6.6f, "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own."));

    }

    @Override
    public void onMovieClicked(Movie movie) {
        Toast.makeText(this, movie.getName(), Toast.LENGTH_LONG).show();

        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("MOVIE_DETAIL", movie);
        startActivity(detailIntent);
    }
}
