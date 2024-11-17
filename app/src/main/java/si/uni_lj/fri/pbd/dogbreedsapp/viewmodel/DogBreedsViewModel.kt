package si.uni_lj.fri.pbd.dogbreedsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import si.uni_lj.fri.pbd.dogbreedsapp.repository.DogBreedRepository

class DogBreedsViewModel(private val repository: DogBreedRepository) : ViewModel() {

    private val _breeds = MutableStateFlow<List<String>>(emptyList())
    val breeds: StateFlow<List<String>> get() = _breeds

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _randomImage = MutableStateFlow<String?>(null)
    val randomImage: StateFlow<String?> get() = _randomImage

    init {
        fetchBreeds()
    }

    private fun fetchBreeds() {
        viewModelScope.launch {
            _isLoading.value = true
            _breeds.value = repository.getBreeds()
            _isLoading.value = false
        }
    }

    fun fetchRandomImage() {
        viewModelScope.launch {
            _randomImage.value = repository.getBreedImage()
        }
    }
}
