package si.uni_lj.fri.pbd.dogbreedsapp

import androidx.compose.material3.*
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import si.uni_lj.fri.pbd.dogbreedsapp.ui.compose.DogBreedsMainScreen
import si.uni_lj.fri.pbd.dogbreedsapp.ui.compose.DogBreedDetails
import si.uni_lj.fri.pbd.dogbreedsapp.viewmodel.DogBreedsViewModel

class Navigation {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun App(viewModel: DogBreedsViewModel) {
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        val coroutineScope = rememberCoroutineScope()
        val selectedBreed = remember { mutableStateOf("") }
        var isSheetVisible by remember { mutableStateOf(false) } // remembers whether the modal is visible

        if (isSheetVisible) {
            ModalBottomSheet(
                onDismissRequest = {
                    coroutineScope.launch {
                        sheetState.hide()
                        isSheetVisible = false
                    }
                },
                sheetState = sheetState,
            ) {
                DogBreedDetails().DogBreedDetailsModal(
                    viewModel = viewModel,
                    breed = selectedBreed.value
                )
            }
        }

        DogBreedsMainScreen().DogBreedsScreen(viewModel = viewModel) { breed ->
            selectedBreed.value = breed.toString()
            coroutineScope.launch {
                sheetState.show()
                isSheetVisible = true
            }
        }
    }
}
