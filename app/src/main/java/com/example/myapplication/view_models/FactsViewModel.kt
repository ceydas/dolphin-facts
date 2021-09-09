package com.example.myapplication.view_models

import android.app.Application
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.content.res.loader.AssetsProvider
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.example.myapplication.R


class FactsViewModel ()
    : ViewModel() {

    var fact = ""

    var dolphinName = ""

    var image = R.drawable.ic_info
    
    var colorName = R.color.shadow_grey

    var colorFact = R.color.shadow_grey


    lateinit var listOfFacts : MutableList<String>

    lateinit var listOfNames : MutableList<String>

    lateinit var listOfImages : MutableList<Int>

    lateinit var listOfColors : MutableList<Int>

    init {
        Log.i("ViewModel", "ViewModel created!")
        resetAll()
        next()

    }

    override fun onCleared() {
        super.onCleared()
        Log.i("onCleared ViewModel", "ViewModel cleared!")
    }


    private fun resetNamesList(){
        listOfNames = mutableListOf(
            "Anabia","Guthrie","Rita","Weir","Ollie","Alcock","Abi",
            "Griffiths","Bob","Moyer","Rosemarie","Clarkson","Stephan",
            "Hill","Sierra","Crosby","Francisco","Wells","Ewan","Bevan", "Jesus","Marks","Anabel","Mcarthur","Eshaal","Byrd","Mccauley", "Martin","Mark","Butler","Sadia","Paul","Sherry","Carey","Gail", "Burns","Shamas","Beil","Josephine","Mcmahon","Haya","Brett","Jensen", "Murphy","Lola-Rose","Samuels","Bluebell","Dawson","Tom","Mccormick", "Flynn","Shannon","Milly","Mckeown","Marlene","Bassett","Addison", "Peters","Ayisha","Quintana","Pollyanna","O'Connor","Shelbie","Greer", "Roy","Schroeder","Lynda","Villa","Keelan","Gay","Subhaan","Watson", "Aairah","Cuevas","Brielle","Ferry","Carlton","Logan","Sonya","Lynn", "Mina","Hogan","Ada","Richardson","Miya","Fry","Anjali","Healy", "Martyna","Freeman","Jazmyn","Rojas","Myrtle","Brewer","Asad","Knight","Elle","Mcdonnell","Caris","Williams","Clark","Mcintyre","Mari","Rivers","Adelaide","Rosario","Amani","Avalos","Anabella","Cohen","Jeanette","Castro","Yazmin","Short","Siya","Davies","Klay","Colley","Daryl","Mcmanus","Esmae","Riley","Krystal","Britt","Ursula","Pollard","Amirah","Cervantes","Tamzin","Hoffman","Riaz","Mendez","Brandy","Powell","Blossom","Tang","Jules","Sheppard","Lewys","Jeffery","Georgiana","Callahan","Patsy","Kennedy","Danielius","Emerson","Mert","Moss","Abubakar","Hubbard","Tianna","Marsh","Jo","Carroll","Amy","Duke","Lyra","Drummond","Areebah","Hirst","Morris","Collier","Kaan","Villanueva","Nuha","Huffman","Hayden","Portillo","Yasser","Padilla","Lily-Mae","Mac","Lily-Grace","Bob","Avani","Keeling","Lily-Mai","Conner","Colton","Schneider","Priyanka","Greenwood","Amrita","Guy","Oakley","Bernard","Sameer","Brandt","Iwan","Tucker","Cheryl","Lucas","Gemma","Burris","Martine","Hutchinson","Briony","Fields","Aaryan","Carpenter"
        )
        listOfNames.shuffle()
    }

    private fun resetFactsList(){
        listOfFacts = mutableListOf("There are currently 42 species of dolphins and seven species of porpoises.","Dolphins are marine mammals. They must surface to breathe air and give birth to live young.","A dolphin pregnancy last between nine and 16 months. The mother feeds her offspring on milk. The sons and daughters of resident orcas stay with their maternal family for life.","Dolphins eat fish, squid and crustaceans. They do not chew they food but may break it into smaller pieces before swallowing.","All dolphins have conical-shaped teeth. A Risso's dolphin has 14 while a spinner dolphin can have 240.","The orca (killer whale) is the largest dolphin. Hector's dolphin and Franciscana are two of the smallest.","The four river dolphin species inhabit the large waterways of Asia and South America.","Dolphins have an array of vocalisations such as clicks, whistles and squeals which they use for their well-developed communication and echolocation skills.","Lifespan varies from around 20 years in the smaller dolphin species to 80 years or more for larger dolphins such as orcas.","Maui's dolphin (a sub-species of the New Zealand dolphin) is the most endangered dolphin. There are less than 50 individuals remaining. Fewer than 10 vaquitas (a species of porpoise) survive.","The Amazon river is home to four species of river dolphin that are found nowhere else on Earth.","Bottlenose dolphins are usually fairly slow swimmers, travelling at about 2 mph. However they can reach speeds of over 30 mph for brief periods!","Bottlenose dolphins swallow a fish head first so the fish's spines don't catch in their throat.","When hunting, dolphins produce bubbles to herd their prey to the surface. They sometimes also use a hunting technique called 'fish-whacking', where they use their tail to hit fish and so stun them - making them easier to catch.","Dolphins have some of the most elaborate acoustic abilities in the animal kingdom. They make a variety of sounds including whistles, clicks, squawks, squeaks, moans, barks, groans and yelps.","Bottlenose dolphins are one of the few species, along with apes and humans, that have the ability to recognise themselves in a mirror.","Dolphins are among the few animals that have been documented using tools. In Shark Bay in Western Australia, dolphins fit marine sponges over their beaks to protect them from sharp, harmful rocks as they forage for fish.","Bottlenose dolphins sleep with one half of their brain at a time, and keep one eye open. It's believed they do this to keep an eye out for their group - to make sure they stick together - and to look out for predators like sharks.","Dolphins may swim through the water as gracefully as any fish, but they are not fish. Dolphins are mammals. They are warm-blooded, breathe through lungs, not gills, give birth to live young, produce milk for their young, have body hair (doesn’t look like it, but they do!)","Even though the average lifespan of dolphins is about 17 years, some can even live up to 50 years!","Dolphins help the sick or injured members: These caring creatures are often seen tending to the sick, the old and the injured in their group, which is known as ‘pod’.","It has been proved by scientists that dolphins give themselves names. They develop their own individual whistles and they recognize theirs and other dolphins’ names.","Killer whales are the biggest kind of dolphin.","Dolphins have very delicate skin, getting injured at the slightest touch of hard surface. However, due to their fast healing attribute, even the deepest of wounds can be healed within a short time.",
            "Scientific name of the Dolphin family is Odontoceti"
        )
        listOfFacts.shuffle()
    }

    private fun resetColorsList(){
        listOfColors = mutableListOf(R.color.color_palette_3, R.color.color_palette_12, R.color.color_palette_11)
            //(R.color.color_palette_1, R.color.color_palette_2, R.color.color_palette_3, R.color.color_palette_4, R.color.color_palette_5, R.color.color_palette_6, R.color.color_palette_7, R.color.color_palette_8, R.color.color_palette_9, R.color.color_palette_10, R.color.color_palette_11, R.color.color_palette_12, R.color.color_palette_13, R.color.color_palette_14, R.color.color_palette_15, R.color.color_palette_16, R.color.color_palette_17, R.color.color_palette_18, R.color.color_palette_19, R.color.color_palette_20, R.color.color_palette_21, R.color.color_palette_22, R.color.color_palette_23, R.color.color_palette_24, R.color.color_palette_25
        //)
        listOfColors.shuffle()
    }

    private fun resetImagesList(){
        listOfImages = mutableListOf(R.drawable.d1, R.drawable.d2, R.drawable.d3)
        listOfImages.shuffle()
    }

    private fun nextFact(){
        if (!listOfFacts.isEmpty()){
            fact = listOfFacts.removeAt(0)
        }
        else
            resetFactsList()
    }

    private fun nextColor(){
        if (!listOfColors.isEmpty()){
            colorName = listOfColors.removeAt(0)
            colorFact = listOfColors.removeAt(0)
        }
        else
            resetColorsList()
    }

    private fun nextImage(){
        if (!listOfImages.isEmpty()){
            image = listOfImages.removeAt(0)
        }
        else
            resetImagesList()
    }

    private fun nextName(){
        if (!listOfNames.isEmpty()){
            dolphinName = listOfNames.removeAt(0)
        }
        else
            resetNamesList()
    }

    private fun next(){
        nextImage()
        nextFact()
        nextName()
        nextColor()
    }

    private fun resetAll(){
        resetFactsList()
        resetImagesList()
        resetNamesList()
        resetColorsList()
    }




}



