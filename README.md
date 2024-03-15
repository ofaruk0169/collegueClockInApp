﻿# Collegue Clock In Application 
## An application where users can be added & deleted from the database. Users also have the ability to sign in to indicate they are at work, and are finishing their shift at work. 

I started my Android journey around the same time I started working a retail job. I could not help but notice the Clock in application I used daily was on an Android device and how easy it would have been for me to recreate the application myself. So that is exactly what I did. I did not just want to recreate the application however, I wanted to improve upon it. One thing me and my colleagues noticed is sometimes we did not know if we had clocked into work or not, and there was no indication of who exactly was clocked into work. Of course this would cause problems with knowing if you were at work and getting paid for the time you were working. My solution to this was to display a LazyColumn with Jetpack Compose and have a dedicated screen to showcase via a checkbox who was clocked in. 

I expanded my knowledge of architectural patterns with this project and implemented clean architecture alongside my established knowledge of the MVVM pattern. Other design patterns I had implemented is dependency injection with the Koin library. I wanted a understanding of these core Android development practices as they are industry standards in creating high quality applications with a team. I of course used a modern approach to Android utilising Jetpack Compose for the UI and Kotlin being my programming language of choice. I also implemented the SQLDelight database to store the user's information. 

I also followed Jetpack Compose standards by using the Scaffold feature to bring a standard look that users come to expect from a professional and trusted Android application. 

The use of clean architecture with use cases was a huge step up in my coding abilities as the introduction of Use Cases in my application helped me decouple the business logic with the state of data in the view models. This application also made me go over and beyond with the introduction of error handling, users who incorrectly add a pin login longer than 5, or try to log in with a pin that does not exist would recieve an error. 

Below is a short demonstration on my YouTube channel to give you a feel for how the application operates. 

[![collegueClockInApp](https://img.youtube.com/vi/L9_DNSihm3U/0.jpg)](https://www.youtube.com/shorts/L9_DNSihm3U)

