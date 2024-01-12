# Classical Music Companion

## Description

Classical Music Companion is an Android app that guides users through a 30-day journey of classical music discovery. Each day, users are presented with a new piece from the classical repertoire, complete with details about the composition, the composer, and a link to listen to the piece.

## Features

- **Daily Music Cards**: Users receive a new card each day featuring a classical music piece.
- **Music Details**: Each card displays the title, composer, performer(s), and duration of the piece.
- **Note Taking**: Users can jot down their thoughts and notes for each piece, making the experience interactive and personal.
- **Navigation**: Users can navigate between the main screen, a list view of all pieces, and detailed views for more information.
- **Material Design**: The app features a simple and elegant design that adheres to Material Design principles, ensuring a smooth user experience.

## How to Use the App

1. **Main Screen**: Upon launching the app, you will be greeted with today's featured classical music piece.
2. **View All**: Click the "View All" button to see a list of all 30 pieces of music.
3. **View Detail**: Click the "View Detail" button on the main screen to see more information about today's featured piece.
4. **Taking Notes**: When in the detail view, you can take notes by clicking the edit icon; this is a space to write your personal reflections on the piece.
5. **Navigation**: Use the "< Previous" and "Next >" buttons in the detail view to navigate between different pieces.

## Project Structure

The project includes several key components:

- `MainActivity.kt`: The entry point of the app, which sets up the navigation and hosts the main screens.
- `MusicCard.kt`: A composable that defines the layout for each music card.
- `MainScreen.kt`: The composable that is shown when the app starts, featuring the music card for the current day and navigation buttons.
- `ListScreen.kt`: A composable that displays a scrollable list of all music cards.
- `DetailScreen.kt`: A composable that shows detailed information for each music piece and allows note-taking.
- `Data.kt`: A list of `ClassicalMusicPiece` instances representing the app's "database" of classical music.

## Installation

To run this app:

1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Run the app on an emulator or a physical device.


## Contact

[Mehmet Furkan Geçkil] - [mgeckil18@ku.edu.tr]

