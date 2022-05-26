package com.example.penide_estefania_examen3t

import android.app.Application
import android.content.res.Resources
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ListasViewModel(application: Application) : AndroidViewModel(application) {
    private val resources = application.resources

    public val listadoRock: MutableList<Album> = ArrayList()
    public val listadoBlues:MutableList<Album> = ArrayList()
    public val listadoJazz:MutableList<Album> = ArrayList()

    public var listadoDiscos: MutableLiveData<MutableList<Album>> = MutableLiveData(ArrayList())

    init {
        listaRock()
        listaBlues()
        listaJazz()
    }

    public fun listaRock() {
        listadoRock.add(
            Album(
                "Abbey Road",
                "The Beatles",
                R.drawable.abbeyroad, resources.getString(R.string.abbeyroad)
            )
            )

        listadoRock.add(
            Album(
                "Exile on Main Street",
                "The Rolling Stones",
                R.drawable.exileonmainst,
                resources.getString(R.string.exilesonmainstreet)
            )
        )
        listadoRock.add(
            Album(
                "The Velvet Underground",
                "The Velvet Underground and Nico",
                R.drawable.velvetunderground,
                resources.getString(R.string.velvetunderground)
            )
        )
        listadoRock.add(
            Album(
                "Are You Experienced",
                "Jimi Hendrix",
                R.drawable.areyouexperienced,
                resources.getString(R.string.areyouexperienced)
            )
        )
        listadoRock.add(
            Album(
                "Back in Black",
                "AC/DC",
                R.drawable.backinblack,
                resources.getString(R.string.backinblack)
            )
        )
        listadoRock.add(
            Album(
                "Appetite for Destruction",
                "Guns N’ Roses",
                R.drawable.appetitefordestruction,
                resources.getString(R.string.appetitefordestruction)
            )
        )
        listadoRock.add(
            Album(
                "Led Zeppelin IV",
                "Led Zeppelin",
                R.drawable.ledzeppeliniv,
                resources.getString(R.string.ledzeppeliniv)
            )
        )

    }

    public fun listaBlues() {
        listadoBlues.add(
            Album(
                "Lady Soul",
                "Aretha Franklin",
                R.drawable.ladysoul,
                resources.getString(R.string.ladysoul)
            )
        )
        listadoBlues.add(
            Album(
                "I Never Loved a Man the Way I Love You",
                "Aretha Franklin",
                R.drawable.neverloved,
                resources.getString(R.string.ineverloveda)
            )
        )
        listadoBlues.add(
            Album(
                "What's Going On",
                "Marvin Gaye",
                R.drawable.whatsgoingon,
                resources.getString(R.string.whatsgoingon)
            )
        )
    }

    public fun listaJazz() {
        listadoJazz.add(
            Album(
                "Kind of Blue",
                "Miles Davis",
                R.drawable.kindofblue,
                resources.getString(R.string.kindofblue)
            )
        )
        listadoJazz.add(
            Album(
                "Bitches Brew",
                "Miles Davis",
                R.drawable.bitchesbrew,
                resources.getString(R.string.bitchesbrew)
            )
        )
        listadoJazz.add(
            Album(
                "A Love Supreme",
                "John Coltrane",
                R.drawable.alovesupreme,
                resources.getString(R.string.alovesupreme)
            )
        )

    }
}