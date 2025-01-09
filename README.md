# GUI2 Project : SylvaMet Rework

This project aimed to learn how to create an Android app using JetPack compose and follow the Android guidelines.

## Requirements

As this is a basic project, it only needs the basics to dev, build and run an Android app. Follow the instructions below to install Android Studio and its necessary packages.

1. [Android Studio](https://developer.android.com/studio/install)

## Installation

1. Clone this project
2. Open Android Studio
  - On the "Projects" tab, click on "Open" and select the cloned project
3. Let Android Studio import the project. It can take some time until it's ready to go.

## Run

1. Create a virtual device following the instructions below
  - On the right side of your app, click on the third icon (Device Manager)
<img width="275" alt="image" src="https://github.com/user-attachments/assets/cc31c37d-8dfd-4d2e-b2e2-800215bd0094" />
  
  - Click on the "+" button and then click on "Create Virtual Device"
<img width="466" alt="image" src="https://github.com/user-attachments/assets/e1015917-c5ed-49f2-aaac-a0cd712db461" />
  
  - Select "Medium Phone" in the list and click on "Next".
  - Select "VanillaIceCream" (API 35). You will probably need to download the package. Click on next when possible.
  - On this last page, you can let the parameters by default. Click on "Finish".
2. Click on the "Run" button. This will build the app and run it on the virtual device.

## Directory Structure
```
app/
├── manifests
├── kotlin+java/
│   └── com.example.gui2_diogo_sylvamet/
│       ├── components   # App visual components
│       ├── ui.theme
│       ├── Cubages.kt       # View
│       ├── Home.kt          # View
│       ├── InfoMartelage.kt # View
│       ├── MainActivity.kt  
│       └── NewCubage.kt     # View
└── res/
    ├── drawable/
    │   ├── ic_launcher_background.xml
    │   ├── ic_launcher_foreground.xml
    │   ├── type_1.png
    │   └── type_2.png
    ├── mipmap
    ├── values/
    │   ├── colors.xml   # App colors definitions
    │   ├── strings.xml  # App texts definitions
    │   └── themes.xml   # App themes definitions
    └── xml
```

## Features

This app is mainly visual. It doesn't incorporate any filtering, searching, editing, deleting or creating feature (so all buttons to edit, delete, search, filter, etc DO NOT WORK, at least, some of them have animations or title modifying but only this.)

3 pages are available :
- Cubages (accessible via the "place" icon on the navigation bar), lists all the wood cubing.
- Add Cubage (accessible via the FAB on Cubages page), permits to create a new wood cubing.
- List Martelage (accessible via the "list" icon on the navigation bar), lists all the types of trees that have been marked.

The different buttons :
- Search button on Cubages page, it really opens the search view but can't search anything
- Filters on Cubages page, they are animated but they don't filter the items
- FAB on List Martelage page, it is a expandable FAB. It is animated but the buttons to edit and delete have no action defined.
- Buttons under "RESINEUX" and "FEUILLUS" in List Martelage page really shows the "Infos martelage" part.
- Buttons under "Infos martelage" have the animation to show the delete action but if you double click, it will not delete.

## Choices

- Base colors of the projects (based on the real app colors) where all defined in the colors.xml file.
- App is only in French, all texts have been defined directly in the code. Strings.xml is only used for the App title.
- 2 Icons are used : type_1, type_2. Thats the wood type that you can find on Cubages page.
- A folder named "components" contain the visual parts that are mainly used on all pages or that are called more than one time on a page. It allows me to make it easier to modify and apply directly the changes on all views.
- All the views are present in the same folder as MainActivity.kt. A folder named "pages" could have been created but as the project as only a few pages, for me it was not as necessary as it would be if the app was bigger.
- On more complexes components, I used the Previewer to build the components before adding it in the final view.

## Author

Diogo da Silva Fernandes (diogo.dasilva2@eduvaud.ch)
