package com.example.simulacro_tp3_ort.ui.views.entities

class DogImpl {
    companion object{
        fun getBreed(image: String?): String {
            var breed = image?.substringAfter("breeds/")?.substringBefore("-")
            breed = breed?.substringBefore("/")

            return breed ?: "No breed"
        }

        fun getSubBreed(image: String?): String {
            val breedSegment = image?.substringAfter("breeds/")?.substringBefore("/")
            val breedParts = breedSegment?.split("-")

            return if (breedParts != null && breedParts.size > 1) {
                breedParts[1]
            } else {
                ""
            }
        }
    }
}