# Collegue Clock In Application 
## An application where users can be added & deleted from the database. Users also have the ability to sign in to indicate they are at work, and are finishing their shift at work. 

I embarked on my Android journey around the same time I began working in retail. It struck me that the Clock in application I used daily was on an Android device, and I realized I could recreate it myself. However, I didn't just want to replicate the application; I aimed to enhance it. One issue my colleagues and I encountered was the uncertainty of whether we had clocked into work or not, as there was no indication of who exactly was clocked in. This ambiguity could lead to problems with getting paid for our work hours. To address this, I implemented a solution using Jetpack Compose's LazyColumn to display a dedicated screen with checkboxes indicating who was clocked in.

In this project, I expanded my knowledge of architectural patterns by incorporating clean architecture alongside the MVVM pattern. I also utilized design patterns such as dependency injection with the Koin library. Understanding these core Android development practices is crucial for creating high-quality applications, especially when working in a team. I adopted a modern approach to Android development, leveraging Jetpack Compose for the UI and Kotlin as my programming language. Additionally, I integrated the SQLDelight database to store user information.

Following Jetpack Compose standards, I employed the Scaffold feature to ensure a consistent and professional look for the application. Implementing clean architecture with use cases was a significant advancement in my coding abilities, as it helped decouple the business logic from the view models. I also went the extra mile by incorporating error handling. For example, users who input a pin longer than 5 digits or attempt to log in with a nonexistent pin receive appropriate error messages.

Below is a brief demonstration video on my YouTube channel, providing an overview of how the application functions.

[![collegueClockInApp](https://img.youtube.com/vi/L9_DNSihm3U/0.jpg)](https://www.youtube.com/shorts/L9_DNSihm3U)

