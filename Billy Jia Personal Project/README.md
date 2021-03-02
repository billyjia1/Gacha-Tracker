# My Personal Project

## A Gacha Game Farming Planner

<p> Mobile games are some of the most popular games in the world. While some games are just ported onto mobile devices,
like Minecraft or Hearthstone, gacha games are nearly exclusive to mobile. What gacha game players know as grinding is just doing
the same level over and over again, potentially obtaining items along the way which help the player. Currently at the moment, there's only one way to know what level to repeat and what
you obtain from that level, and that is by Googling everything. The application I hope to make allows for the process to be simplified greatly. It will have everything a person would want
to know about what to grind by showing item drop rates and locations, and hopefully people who enjoy games like this will also
utilize what I'm making. I personally love games like this due to the passionate community that comes with it. The community does a lot 
for the game and hopefully I can do something as well.<p>

What I want to implement:
- Percentages regarding which area for items is most efficient.
- Being able to calculate expected value for items.
- Being able to implement your own drops per level run into the community compiled average.

### User Stories

- As a user, I want to pick an item and add my own percentage.
- As a user, I want to be able to choose an item and alter the entire percentage due to special events.
- As a user, I want to be able to be able to see all items.
- As a user, I want to be able to know how long it takes to acquire X number of items based on expected values.
- As a user, I want to be able to save what I have added to the material list.
- As a user, I want to be able to load in what I have saved previously
- As a user, I want to be able to add materials to a list with a button press.
- As a user, I want to be able to load and save the state of the application.
- As a user, I want to be able to play a random sound on button press.

###### Elaboration(Since this is hard to understand without prior knowledge)
What I hope to achieve is an application that is very similar to an inventory/stock manager.
When someone were to input an item, results would come out such as price, stock, things of that nature. Instead of 
items, I call it "Materials" which is the terminology the game uses, and instead of price and stock, I have location and 
drop rate. Very similarly, I want to be able to add multiple items/materials into a list at once, similar to a shopping 
cart, displaying the individual aspects of each item and calculating potential totals for what the user 
wants to know.

##### Phase 4: Task 2
I have decided to make a method in ListOfMaterial throw an exception. Since it is a very basic
method, it only exists in the class itself.

##### Phase 4: Task 3
The UML diagram has nearly everything that I would want, except for the fact that I basically
recoded the save/load feature since I referenced code online that made more sense for my GUI and
was also easier to understand.
If I had more time, I would

- Make the GUI implement the previous code I had, notably save and load
- Make the UI easier to code
- Created easier to read code

