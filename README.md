# Navigation Migration

The main goal to this project is to show the migration from an Android project with Jetpack
Navigation to a project with Compose Navigation.

## App Screens

There will be 3 screens:

- **First Fragment**: The main screen where the app will start.
- **Second Fragment**: Another screen used to pass a string argument.
- **Third Fragment**: Another screen used to pass an integer argument.

The first one will be connected to the second and third one.
The second one will be connected to the third one.
This is done this way to show how the navigation handles the back stack.

The second and third screen will receive arguments to show how to pass arguments with the
navigation graph.

## Migration Steps

There will be 5 branches displaying the migration steps from a navigation with views to a navigation
with Compose screens

| Syntax                                                                                          | Description                                                                                                 |
|-------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| [Views](https://github.com/DanP1925/NavigationMigration/tree/views)                             | The base project to migrate using views, jetpack navigation, and safeArgs.                                  |
| [Views with KotlinDSL](https://github.com/DanP1925/NavigationMigration/tree/viewsWithKotlinDSL) | Based on the views branch but replacing the XML graph with KotlinDSL                                        |
| [Compose with ViewNav](https://github.com/DanP1925/NavigationMigration/tree/composablesWithKotlinDSL)                                                                        | The project with the fragments migrated from views to composable Screens but still using jetpack navigation |
| [Compose](https://github.com/DanP1925/NavigationMigration/tree/composables)                            | Based on the compose with views branch but with Compose navigation                                          |
| main                                                                                            | Based on the compose branch but removing the toolbar from the main activity                                 |
