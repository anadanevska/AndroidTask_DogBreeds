package si.uni_lj.fri.pbd.dogbreedsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import si.uni_lj.fri.pbd.dogbreedsapp.repository.DogBreedRepository
import android.util.Log

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
            try {
                _breeds.value = repository.getBreeds()
            } catch (e: Exception) {
                Log.e("ViewModel", "Error fetching breeds", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchRandomImage() {
        viewModelScope.launch {
            try {
                _randomImage.value = repository.getBreedImage()
            } catch (e: Exception) {
                Log.e("ViewModel", "Error fetching random image", e)
            }
        }
    }
}
