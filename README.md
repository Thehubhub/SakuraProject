# SakuraProject
This project uses the Card Captor Sakura Card Collection API:
https://github.com/JessVel/sakura-card-captor-api

Project Ideas:
The project consists of one main Activity and 5 fragments. First fragment is the Home Fragment, where the title of the app is displayed and 3 different
buttons. First button is "Show list"; the second fragment contains RecyclerView of all card items wil be shown after the button click, with several 
different fields about the each card and its own image. Second button is "Search card"; the third fragment that let user input a card name and search 
for the card's details, which is displayed on the fourt fragment. Third button is "Flip it"; once button is clicked, it will show the front of a Sakura 
Card and allows user to click on the card itself to flip to the back of the card.

What's working and what's not:
All fragments are created and show up. Buttons on Home Fragment are working as intended. Recycler View list shows up 
but for some reason the images from API won't load with neither Picasso nor Glide (yes, i've tried both). Input field 
returns one item like expected but the data doesn't come through, so all fields are empty. Flip card function is a bust;
the front doesn't even show after button is clicked.

Technologies used:
* Kotlin programming language
* Fragments and activity for functionalities/UI
* RecyclerView to retrieve list of data from API
* Koin DI
* MVVM architectural design
* ViewModel and LiveData
* Asynchronous Operations such as Coroutines
* Both Picasso and Glide, but Glide is the one in the code
* Navigation Component

Hopes for the future:
Keep working on the app's original ideas an pretty up the UI.
