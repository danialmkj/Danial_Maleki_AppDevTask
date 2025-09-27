# Danial_Maleki_AppDevTask

Simple Jetpack Compose prototype for Collabity — a single screen "Task List" UI.

## What I built
- One screen titled **My Tasks**
- Vertical list of three static tasks
- Checkboxes toggle state and apply a strike-through + subtle animation

## Tech
- Kotlin
- Jetpack Compose (Material3)
- Minimal project built from Android Studio "Empty Compose Activity" template

## Notes
- State is kept local via `mutableStateListOf` and `MutableState` for each `TaskItem`.
- This is intentionally a prototype; for production I'd use ViewModel + immutable models and DataStore for persistence.
- Small visual polish: Card container for rows + alpha animation on checked tasks.

## How to run
1. Open the project in Android Studio.
2. Build & run on an emulator or device.

Made by Danial Maleki
