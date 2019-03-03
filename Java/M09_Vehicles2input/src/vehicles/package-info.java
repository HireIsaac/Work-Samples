package vehicles;

/**
 *  acronym: 		Concept: 				My application:
 * 	SRP				Single Responsibility	From what I understand about the research I've done,
 * 					Principle				this idea is basically that each component of my
 * 											software should only be responsible for one single
 * 											bit of functionality. I think a good example of this
 * 											is my move() method in SAM.java, which ONLY checks
 * 											if it is still in play, and then moves it. 
 * 									
 * 											Compared to the move() methods for some other vehicles,
 * 											I think SAM.java is a good example compared to say,
 * 											landVehicle.java, which sets gas, sets speed, checks
 * 											and changes directions, and registers turns all inside
 * 											my move() method. Which is bad. But now I understand SRP
 * 											better, I will work on improving that for future code rewrites.
 * 
 * 	OCP				Open/Closed Principle	A good example of this is vehicles and the classes that
 * 											extend vehicle.java. We could have vehicle be this one
 * 											awful long messy code that checks if itself is a SAM,
 * 											or a motorbike, or what have you. Instead, our code
 * 											is extensible to a variety of vehicles, and easy to maintain.
 * 
 * 	LSP				Liskov substitution 	Substitutability sure is confusing. From what I understand
 * 					principle				of the concept, essentially everywhere I create a vehicle,
 * 											if my code is SOLID (no pun intended), I can always replace
 * 											that vehicle with a subclass of my vehicle. EG, anywhere I
 * 											wanted to make an array of vehicles, I could simply make an 	
 * 											array of air vehicles and the resulting code would not break,
 * 											it would simply have all of the original methods/variables
 * 											that vehicle has, as well as the additional methods/variables
 * 											the airplane has. As far as I have tested, all of my vehicle 
 * 											subclasses can at any point replace vehicle, with no issues/less
 * 											functionality then the original vehicle had.
 * 
 * 	ISP				Interface Segregation	I read some fun articles about this. It's a bit foggy to understand,
 * 					Principle				and I think to really show a good example of where the rest
 * 											of my code does this, I need to show an example of where my code
 * 											does not do this. On line 46 of landVehicle.java, my move method
 * 											REQUIRES that setgas() is called, because otherwise the vehicle
 * 											will not move. My other sub vehicles avoid this, and their interfaces
 * 											are seperate, but I wrote landVehicle() very early in the year, and
 * 											wasn't exactly "warmed up" then. I will correct that after this assignment,
 * 											but I figured I'd leave it for now to show you I have an understanding of
 * 											the concept, as my other vehicles don't require any setters called to move,
 * 											I simply was not quite sure what I was doing at the start of the year.
 * 
 * 	DIP				Dependency inversion	This is the foggiest point for me. From what I read, this works by	
 * 					principle				having methods not have any hard dependancies on other objects to work,
 * 											and they should instead rely on abstraction. As well, high level modules
 * 											should not rely on low level modules, and vice versa. EG, having a new object
 * 											created and then call on that object in a method declared below. My test.java
 * 											does this by making a new DrawHere() named d, and then attaching listeners to
 * 											d inside its main() method. Because of this, main is dependant on drawhere,
 * 											and violates this rule. I would have to fix this with abstraction.
 * 
 * 
 */