## Build tools & versions used
Gradle with Groovy DSL

## Steps to run the app
Build it and run it via Android Studio!

## What areas of the app did you focus on?
I wanted the error checking, at both the repository layer, and the viewModel layer, 
to handle many potential cases, especially the unhappy ones.

I enjoy setting up theming, even for a simple app. The bit of work to force consistent styling has served me well.

I also needed to spend some time learning about the implementation details of coroutines, 
to ensure data was returned in a reliable way to the frontend, as well as test the implementation.

## What was the reason for your focus? What problems were you trying to solve?
Coroutines are both a tool I use a lot, and an area I wanted to work hard to get better in. 

## How long did you spend on this project?
About 6 hours, a large amount of which was on debugging a coroutines bug.

## Did you make any trade-offs for this project? What would you have done differently with more time?
(a) I would've styled the directory more, including the Error/Empty screens
(b) I would've written more unit tests for unhappy paths
(c) I _really_ want to go deep into dependency management. My deps/testDeps keys should be named better, 
any unused dependencies should be removed, and dependency imports in the app/build.gradle should be organized better

## What do you think is the weakest part of your project?
Coroutines. It works, but a lot is still magic to me. A quote by one of your employees that I think about all the time is:
“If I can write good coroutines code that I can predict what it does, then I can write good coroutines test code"

I need to learn more about writing awesome coroutines code where I know exactly what to expect. 

## Did you copy any code or dependencies? Please make sure to attribute them here!
I copied from a past take home project, largely the gradle files. 

I copied in the `MainDispatcherRule` code from here: https://www.google.com/search?client=firefox-b-1-d&q=clear+image

I needed to write most of the rest of the code from scratch.

## Is there any other information you’d like us to know?
I've greatly enjoyed focusing on Android development for over three years now. I love the increasingly complex problems I get to solve.

I excel at learning new concepts, and communicating (whether it's when giving code review, pairing, asking questions of someone more senior, and more).

There are pockets of Android development that I have gaps in -- I'm eager to fill those gaps and push myself to solve problems that are new to me. 
