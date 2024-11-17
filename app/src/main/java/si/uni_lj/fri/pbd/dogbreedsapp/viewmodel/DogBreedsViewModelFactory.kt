package si.uni_lj.fri.pbd.dogbreedsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import si.uni_lj.fri.pbd.dogbreedsapp.repository.DogBreedRepository

class DogBreedsViewModelFactory(
    private val repository: DogBreedRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DogBreedsViewModel::class.java)) {
            return DogBreedsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
