## UNDER CONSTRUCTION

# AAD Test Guide
This is my very own personal study guide for the Associate Android Developer certification.

The repo will focus on the following topics:
- Android core
- User interface
- Data management
- Debugging
- Testing

### 1. Android Core
This will focus on the following sections:
- [x] Understand the architecture of the Android system
- [] Be able to describe the basic building blocks of an Android app
        - [x] Activities
        - [x] Services
                    - [x] foreground services
                    - [x] background services
                    - [] bound services
                            - [x] Binder
                            - [] Messenger
                            - [] AIDL
        - [] BroadCast Receivers
        - [] Content Providers
- [x] Know how to build and run an Android app
- [x] Display simple messages in a popup using a Toast or a Snackbar
- [x] Be able to display a message outside your app's UI using Notifications
- [x] Understand how to localize an app
- [x] Be able to schedule a background task using WorkManager

### 2. User Interface
Focusing on:
- [x] Understand the Android activity lifecycle
- [x] Be able to create an Activity that displays a Layout
- [x] Be able to construct a UI with ConstraintLayout
- Understand how to create a custom View class and add it to a Layout
- Know how to implement a custom app theme
- Be able to add accessibility hooks to a custom View
- [x] Know how to apply content descriptions to views for accessibility
- [x] Understand how to display items in a RecyclerView
- Be able to bind local data to a RecyclerView list using the Paging library
- [x] Know how to implement menu-based navigation
    - [x] Option Menu
    - [x] Contextual Menu
    - [x] Popup Menu
- Understand how to implement drawer navigation

### 3. Data Management
Focusing on:
- [x] Understand how to define data using Room entities
- [x] Be able to access Room database with data access object (DAO)
- [x] Know how to observe and respond to changing data using LiveData
- [x] Understand how to use a Repository to mediate data operations
- Be able to read and parse raw resources or asset files
- Be able to create persistent Preference data from user input
    - [x] shared preferences
    - data store
        - Preferences DataStore
        - Proto DataStore
- Understand how to change the behavior of the app based on user preferences

### 4. Debugging
Focusing on:
- [x] Understand the basic debugging techniques available in Android Studio
- [x] Know how to debug and fix issues with an app's functional behavior and usability
- [x] Be able to use the System Log to output debug information
- [x] Understand how to use breakpoints in Android Studio
- [x] Know how to inspect variables using Android Studio

### 5. Testing
Focusing on:
- [x] Thoroughly understand the fundamentals of testing
- [x] Be able to write useful local JUnit tests
- Understand the Espresso UI test framework
- Know how to write useful automated Android tests
