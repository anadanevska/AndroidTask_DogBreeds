package si.uni_lj.fri.pbd.dogbreedsapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogAPIServiceGenerator {

    private const val BASE_URL = "https://dog.ceo/"

    val api: DogRestAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogRestAPI::class.java)
    }

}