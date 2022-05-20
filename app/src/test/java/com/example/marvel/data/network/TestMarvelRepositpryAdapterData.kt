package com.example.marvel.data.network

import androidx.lifecycle.MutableLiveData
import com.example.marvel.data.database.entity.MovieCharacterEntity
import com.example.marvel.data.network.dto.*
import com.example.marvel.util.common.Thumbnail

object TestMarvelRepositpryAdapterData {
    fun getDataFromApi(): List<MovieCharacterDTO> {
        val responseDTOMock = MovieCharacterDTO(
            comics = comicMock,
            description = desc,
            events = eventMock,
            id = 1,
            modified = "StringModified",
            name = "Iron Man",
            resourceURI = "StringURL",
            series = serieMock,
            stories = storiesMock,
            thumbnail = thumbailMock,
            urls = listOf(urlsMock)
        )
        return listOf(responseDTOMock)
    }

    fun getDataFromRoom(): MutableLiveData<List<MovieCharacterEntity>>{
        val responseEntityMock = MovieCharacterEntity(
            id = 1,
            name = "Iron Man",
            description = desc,
            thumbnail = thumbailMock
        )
        return MutableLiveData(listOf(responseEntityMock))
    }

    private val desc = """Tony Stark es un inventor de armamento brillante 
        |que es secuestrado en el extranjero. 
        |Sus captores son unos terroristas que le obligan a construir 
        |una máquina destructiva pero Tony se construirá una armadura 
        |para poder enfrentarse a ellos y escapar."""

    private val itemComicMock = Item(
        name = "StringItemComic1",
        resourceURI = "StringItemComic2"
    )

    private val comicMock = Comic(
        available = 1,
        collectionURI = "",
        items = listOf(itemComicMock),
        returned = 1
    )

    private val itemXMock = ItemX(
        name = "StringItemXName1",
        resourceURI = "StringURL"
    )

    private val eventMock = Events(
        available = 1,
        collectionURI = "CollectionURIEvent",
        items = listOf(itemXMock),
        returned = 1
    )

    private val itemXXMock = ItemXX(
        name = "StringNameItemXX",
        resourceURI = "StringURLItemXX"
    )

    private val serieMock = Series(1,
        collectionURI = "StringURLSerie",
        items = listOf(element = itemXXMock),
        returned = 1
    )

    private val itemXXXMock = ItemXXX(
        name = "StrinNameItemXXX",
        resourceURI = "StringURL",
        type = "StringType"
    )

    private val storiesMock = Stories(
        available = 1,
        collectionURI = "StringCollectionURLStories",
        items = listOf(itemXXXMock),
        returned = 1
    )

    private val thumbailMock = Thumbnail(
        extension = "png",
        path = "https://disney.fandom.com/es/wiki/Iron_Man?file=Iron-Man-AOU-Render."
    )

    private val urlsMock = Url(
        type = "StringType",
        url = "StringURL"
    )

}