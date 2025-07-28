# NativeStarter Project

This is a starter project for an Android native application, built with Kotlin and following the Clean Architecture principles.

## Project Structure

The project is structured into the following modules:

*   **app**: The main application module.
    *   **src**: Source code for the application.
        *   **main**: Main source set.
            *   **java/com/andikas/nativestarter**: Root package for the application.
                *   **core**: Core module, containing the data and domain layers.
                    *   **data**: Data layer, responsible for fetching data from local and remote sources.
                        *   **source**: Data source interfaces and implementations.
                            *   **local**: Local data source, using Room for database and Jetpack DataStore for preferences.
                            *   **remote**: Remote data source, using Retrofit for network requests.
                        *   **di**: Dagger Hilt module for providing data layer dependencies.
                    *   **domain**: Domain layer, containing business logic and use cases.
                        *   **model**: Domain models.
                        *   **repository**: Repository interfaces.
                *   **presentation**: Presentation layer, containing UI-related classes.
                    *   **adapter**: RecyclerView adapters.
                    *   **screen**: Activities and fragments.
                    *   **utils**: UI-related utility classes.
                *   **utils**: Application-wide utility classes.
        *   **androidTest**: Instrumented tests.
        *   **test**: Unit tests.
*   **gradle**: Gradle-related files.

## Dependencies

The project uses the following dependencies:

*   **Kotlin**: The programming language used for the project.
*   **AndroidX**: A collection of libraries that are part of the Android Jetpack.
*   **Dagger Hilt**: A dependency injection library for Android.
*   **Room**: A persistence library that provides an abstraction layer over SQLite.
*   **Jetpack DataStore**: A data storage solution that allows you to store key-value pairs or typed objects with protocol buffers.
*   **Retrofit**: A type-safe HTTP client for Android and Java.
*   **OkHttp**: An HTTP client for Android and Java.
*   **Gson**: A Java library that can be used to convert Java Objects into their JSON representation.
*   **Coil**: An image loading library for Android backed by Kotlin Coroutines.
*   **Mockito**: A mocking framework for Java.
*   **JUnit**: A unit testing framework for Java.

## How to Build

To build the project, you will need to have Android Studio installed. Once you have opened the project in Android Studio, you can build it by clicking on the "Build" menu and selecting "Make Project".

## How to Run

To run the project, you will need to have an Android device or emulator connected to your computer. Once you have connected a device, you can run the project by clicking on the "Run" menu and selecting "Run 'app'".

## How to Test

To run the unit tests, you can right-click on the "test" directory and select "Run 'Tests in 'test''". To run the instrumented tests, you can right-click on the "androidTest" directory and select "Run 'All Tests'".
