package si.uni_lj.fri.pbd.dogbreedsapp.repository

import si.uni_lj.fri.pbd.dogbreedsapp.api.DogAPIServiceGenerator

class DogBreedRepository {

    private val api = DogAPIServiceGenerator.api

    suspend fun getBreeds(): List<String> {
        val response = api.getBreeds()
        return response.message.keys.toList()
    }

    suspend fun getBreedImage(): String {
        val response = api.getImage()
        return response.message
    }

}