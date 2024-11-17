# Dog Breeds App

## Overview
The Dog Breeds App is an Android application that fetches and displays a list of dog breeds from the [Dog CEO API](https://dog.ceo/dog-api/). Users can search for breeds, view details of a specific breed, and see a random image of the breed. The app is built using **Jetpack Compose** and follows the **MVVM (Model-View-ViewModel)** architectural pattern.

---

## Features
- Fetch and display a list of dog breeds.
- Search functionality to filter breeds locally.
- View details of a selected breed, including its name and a random image.
- UI design using Jetpack Compose.

---

## Architecture
The app is designed using the **MVVM (Model-View-ViewModel)** architecture for better separation of concerns, maintainability, and testability.

### **1. Model**
The `Model` layer handles the data operations of the app. This includes network requests and data processing.

- **Files:**
  - `DogBreedRepository`: The repository that serves as the single source of truth for fetching data from the network.
  - `DogRestAPI` (Interface): Defines the API endpoints and response models.
  - `DogAPIServiceGenerator`: Configures the Retrofit instance to interact with the Dog CEO API.

- **Responsibilities:**
  - Fetching the list of dog breeds.
  - Fetching a random image for a breed.
  - Handling API communication using Retrofit.

---

### **2. ViewModel**
The `ViewModel` layer mediates between the `Model` and `View` layers. It exposes data to the UI and handles business logic.

- **Files:**
  - `DogBreedsViewModel`: Manages the state of the dog breeds and images. It uses Kotlin `StateFlow` to provide reactive streams of data to the UI.
  - `DogBreedsViewModelFactory`: A factory for creating `DogBreedsViewModel` instances with the necessary repository.

- **Responsibilities:**
  - Fetching and caching the list of dog breeds using `fetchBreeds`.
  - Fetching a random image for a selected breed using `fetchRandomImage`.
  - Detecting errors.
  - Maintaining loading states and user-friendly responses.

---

### **3. View**
The `View` layer consists of the UI components built with Jetpack Compose.

- **Files:**
  - **Main Activity:**
    - `MainActivity`: The entry point of the app, responsible for initializing the `ViewModel` and setting up the navigation.
  - **UI Components:**
    - `DogBreedsMainScreen`: Displays the list of dog breeds with search functionality. Navigates to the details screen when a breed is selected.
    - `DogBreedDetails`: Shows the details of a specific breed, including its name and a random image, in a modal bottom sheet.
  - **Navigation:**
    - `Navigation`: Manages navigation and transitions between the main screen and the details modal.

- **Responsibilities:**
  - Displaying the data provided by the `ViewModel`.
  - Implementing user interactions like searching and navigating to the details screen.
  - Showing loading indicators and error messages.

