# Android Blog Reading App [MVVM Architecture]

Welcome to the Android MVVM Blog Reading App repository! This project is a hands-on example of building a Blog Reading App using the Model-View-ViewModel (MVVM) architectural pattern. Dive into this practical project to enhance your Android development skills and get a taste of what you'll learn in the [Android MVVM Architecture Course (Bengali)](http://learning.megaminds.technology/courses/android-mvvm-architecture/details). You can watch the course [introduction and outline from here](https://youtu.be/2oSJi-pwY2s?si=wVsXq2RkMqykL-Vd).


https://github.com/hasancse91/android-mvvm-blog-app/assets/3769029/e5817744-cf8d-4310-8efc-8bf01df55c27


## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Naive Approach](#naive-approach)
- [MVP Architecture](#mvp-architecture)
- [MVVM Architecture](#mvvm-architecture)

## Project Overview

The Android MVP Blog Reading App showcases how to structure and build an Android app using MVVM architecture. As you explore this repository, you'll gain practical insights into clean code, separation of concerns, and best practices in Android app development.

## Features

This app showcases various features related to reading blogs, including:

- [x] Viewing a list of blog posts
- [x] Displaying blog post details
- [x] Fetching blog posts from a remote server
- [x] Naive implementation in [this branch](https://github.com/hasancse91/android-mvp-blog-app/tree/naive-approach)
- [x] Refactored using MVP architecture (master branch)

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository to your local machine:
   ```shell
   git clone git@github.com:hasancse91/android-mvvm-blog-app.git
   ```

2. Open the project in Android Studio.

3. Build and run the app on an emulator or physical device.

## Naive Approach

The initial version of this app was developed using a naive approach ([checkout here](https://github.com/hasancse91/android-mvvm-blog-app/tree/naive-approach)), where the code was less structured and did not follow a specific architecture. This approach served as the starting point for refactoring.

## MVP Architecture

The project was then refactored using the Model-View-Presenter (MVP) architectural pattern in [this repository](https://github.com/hasancse91/android-mvp-blog-app). The key components of the MVP architecture include:

- Model: Represents the data and business logic of the app.
- View: Displays the UI and handles user input.
- Presenter: Acts as an intermediary between the Model and View, handling business logic and updating the UI.

The MVP architecture brings several benefits, including improved code maintainability, separation of concerns, and testability.

## MVVM Architecture (The final goal!)

From naive approach we have refactored and adopted it to MVVM architecture. The key components of the MVVM architecture include:

- Model: Represents the data and business logic of the app.
- View: Displays the UI and handles user input.
- ViewModel: Acts as an intermediary between the Model and View, handling business logic and updating the observable field. Which observable field is being observed by View.

The MVVM architecture brings several benefits, including improved code maintainability, separation of concerns, and testability. Specially it overcomed the limitations of MVP architecture like: ViewModel reusability issue, lifecycle handle issue etc.

---

Thank you for exploring the Android Blog Reading App project! If you have any questions or suggestions, please feel free to reach out.

**Happy coding!**
