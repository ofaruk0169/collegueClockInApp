# Collegue Clock In Application 
## An application where users can be added & deleted from the database. Users also have the ability to sign in to indicate they are at work, and are finishing their shift at work. 

I embarked on my Android journey around the same time I began working in retail. It struck me that the Clock in application I used daily was on an Android device, and I realized I could recreate it myself. However, I didn't just want to replicate the application; I aimed to enhance it. One issue my colleagues and I encountered was the uncertainty of whether we had clocked into work or not, as there was no indication of who exactly was clocked in. This ambiguity could lead to problems with getting paid for our work hours. To address this, I implemented a solution using Jetpack Compose's LazyColumn to display a dedicated screen with checkboxes indicating who was clocked in.

In this project, I expanded my knowledge of architectural patterns by incorporating clean architecture alongside the MVVM pattern. I also utilized design patterns such as dependency injection with the Koin library. Understanding these core Android development practices is crucial for creating high-quality applications, especially when working in a team. I adopted a modern approach to Android development, leveraging Jetpack Compose for the UI and Kotlin as my programming language. Additionally, I integrated the SQLDelight database to store user information.

Following Jetpack Compose standards, I employed the Scaffold feature to ensure a consistent and professional look for the application. Implementing clean architecture with use cases was a significant advancement in my coding abilities, as it helped decouple the business logic from the view models. I also went the extra mile by incorporating error handling. For example, users who input a pin longer than 5 digits or attempt to log in with a nonexistent pin receive appropriate error messages.

Below is a brief demonstration video on my YouTube channel, providing an overview of how the application functions.

[![collegueClockInApp](https://img.youtube.com/vi/L9_DNSihm3U/0.jpg)](https://www.youtube.com/shorts/L9_DNSihm3U)

## Installation Guide

If you are interested in installing this application onto your local computer for a personalised demo, follow these instructions. 

1. Clone the repository using the following command on your terminal - `git clone https://github.com/ofaruk0169/collegueClockInApp.git`
2. Open Android Studio on your computer
3. In Android Studio select "File" > "Open" and navigate to the directory where you cloned the repository. Select the "collegueClockInApp" directory and click "OK" to import the project into Android Studio.
4. Once the project is imported, Android Studio may automatically start syncing the project with Gradle. If not, you can manually trigger the sync process by clicking on the "Sync Project with Gradle Files" icon in the toolbar.
5. Set up the emulator, if you haven't set up an emulator yet, you can do so by going to "Tools" > "AVD Manager" in Android Studio. Create a new virtual device according to your preferences and specifications.
6. Once the project is successfully imported and synced, you can run the application by clicking the "Run" button in the toolbar. Choose the emulator you created in the previous step, and Android Studio will build the app and install it on the emulator. After installation, the app should automatically start running on the emulator.

Now you can explore the collegueClockInApp app running in the emulator. You can interact with it as you would with any other Android app, testing its features and functionality.
