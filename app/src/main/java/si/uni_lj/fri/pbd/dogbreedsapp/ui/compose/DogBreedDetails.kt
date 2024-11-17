package si.uni_lj.fri.pbd.dogbreedsapp.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import si.uni_lj.fri.pbd.dogbreedsapp.viewmodel.DogBreedsViewModel

class DogBreedDetails {
    @Composable
    fun DogBreedDetailsModal(viewModel: DogBreedsViewModel, breed: String) {
        val randomImage by viewModel.randomImage.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.fetchRandomImage()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            if (randomImage == null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                Image(
                    painter = rememberAsyncImagePainter(randomImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = breed,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Lorem ipsum odor amet, consectetuer adipiscing elit. Mus metus tellus dolor auctor sed litora. Conubia proin turpis ultricies maecenas sodales magna nostra phasellus euismod. Tristique interdum netus augue urna curabitur eros. Fames molestie tempus lacus turpis hac.",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
