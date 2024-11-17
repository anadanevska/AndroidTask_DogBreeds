package si.uni_lj.fri.pbd.dogbreedsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import si.uni_lj.fri.pbd.dogbreedsapp.ui.theme.DogBreedsAppTheme
import si.uni_lj.fri.pbd.dogbreedsapp.viewmodel.DogBreedsViewModel
import si.uni_lj.fri.pbd.dogbreedsapp.repository.DogBreedRepository
import si.uni_lj.fri.pbd.dogbreedsapp.viewmodel.DogBreedsViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = DogBreedRepository()
        val viewModel = ViewModelProvider(this, DogBreedsViewModelFactory(repository))[DogBreedsViewModel::class.java]

        setContent {
            DogBreedsAppTheme {
                val navigation = Navigation()
                navigation.App(viewModel = viewModel)
            }
        }
    }
}
