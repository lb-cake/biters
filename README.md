# Biters
I made this application during the PSU Hackaton in Spring 2017

I had an idea that most rappers claim they "bite" each other's styles. I decided to put this to the test.
I used an implementation of the Jaro-Winkler distance algorithm to measure the similarities between different songs given by the user.

The application is a JavaFX Application that has 4 text fields: Artist Name 1, Song Name 1, Artist Name 2, Song Name 2.

Notes:
Interestingly, after running enough tests, we can see that the distance between songs is around 60%. This is due to the fact that the English
language is limited and song lyrics seem to directly effect that. 

This repo is now depracated and will not be maintained any further.
