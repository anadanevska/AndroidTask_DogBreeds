package si.uni_lj.fri.pbd.dogbreedsapp.api

import retrofit2.http.GET

interface DogRestAPI {

    @GET("api/breeds/list/all")
    suspend fun getBreeds(): DogBreedsResponse

    @GET("api/breeds/image/random")
    suspend fun getImage(): DogBreedImage

    data class DogBreedsResponse(
        val message: Map<String, List<String>>,
        val status: String
    )

    data class DogBreedImage(
        val message: String,
        val status: String
    )

}