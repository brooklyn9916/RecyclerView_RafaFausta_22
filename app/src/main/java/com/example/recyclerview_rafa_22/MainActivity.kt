package com.example.recyclerview_rafa_22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.abomination,
                "Abomination",
                "The Abomination is a fictional character appearing in American comic books published by Marvel Comics.\n"+
                        "The original and most known iteration is Emil Blonsky, who first appeared in Tales to Astonish #90 and was created by writer Stan Lee and artist Gil Kane. \n" +
                        "He is one of the main enemies of the superhero Hulk."
            ),
            Superhero(
                R.drawable.redskull,
                "RedSkull",
                "The Red Skull is an alias used by several fictional supervillains appearing in American comic books published by Marvel Comics. \n" +
                        "The first Red Skull appeared in Captain America Comics #1, created by Joe Simon and Jack Kirby."
            ),
            Superhero(
                R.drawable.thanos,
                "Thanos",
                "Thanos is a supervillain appearing in American comic books published by Marvel Comics. \n" +
                        "He was created by writer-artist Jim Starlin, and made his first appearance in The Invincible Iron Man #55. An Eternal–Deviant warlord from the moon Titan, Thanos is regarded as one of the most powerful beings in the Marvel Universe."
            ),
            Superhero(
                R.drawable.timekeeper,
                "Time Keeper",
                "The Time-Keepers were created by He Who Remains, the very last director of the Time Variance Authority from the previous reality, in the Citadel at the End of Time just prior to the heat death of that universe.\n"

            ),
            Superhero(
                R.drawable.ultron,
                "Ultron",
                "Ultron is a fictional supervillain appearing in American comic books published by Marvel Comics.\n" +
                        "The character was created by writer Roy Thomas and artist John Buscema, and initially made his debut as an unnamed character in The Avengers #54, with his first full appearance in The Avengers #55."
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this, superheroList) {
            val intent = Intent (this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}