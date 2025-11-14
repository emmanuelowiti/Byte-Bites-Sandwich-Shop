# Byte-Bites-Sandwich-Shop
Where every byte builds a better bite 
## 📚 Table of Contents

**Project Overview**

This is a program used to test and demonstrate key aspects of Object Oriented Programming encompassed in creating a custom sandwich shop to make custom sandwiches, orders then proceed to checkout, and finally generates a receipt file showing all transactions.

This project utilized OOP principles such as:

**Inheritance

**Interfaces

**Polymorphism



**Features**

HomeScreen()

<img width="682" height="232" alt="Screenshot 2025-11-13 231056" src="https://github.com/user-attachments/assets/d1960663-dd08-46ec-b1d0-a673ff7ed33d" />


This serves as the entry point into running the code.


Order Menu()

This offers the customer a selection of choices to proceed to make the order or cancel.

Depending on the choice made, it takes the customer to either the drink mini menu, or the sandwich or the chips or exit.

<img width="550" height="299" alt="Screenshot 2025-11-13 231400" src="https://github.com/user-attachments/assets/662a4c9a-221a-4c7c-9252-441fa8e82bdd" />

Sandwich Mini-Menu

Gives the liberty to create a custom sandwich or have the shop's signature sandwiches

<img width="499" height="500" alt="Screenshot 2025-11-13 234619" src="https://github.com/user-attachments/assets/ce7791cd-f5ab-449e-8371-a4eca8805d90" />

Drinks Mini Menu

The customer has to choose a drink from the given options, and choose the size of drink they want.

<img width="464" height="488" alt="Screenshot 2025-11-13 234940" src="https://github.com/user-attachments/assets/23c55bc2-9642-464d-9c02-e9db21f0eb02" />


Chips Mini Menu

If the customer chooses to proceed to buy another item(Chips) they do so from this menu

<img width="499" height="581" alt="Screenshot 2025-11-13 235202" src="https://github.com/user-attachments/assets/6c0444b5-72e8-488c-9233-f7b5388cd19e" />








**UML Diagram**

This shows how the classes and interfaces interact to make the code run.

<img width="1689" height="1021" alt="hLTTRzem57r7uZ_uRR0frPwh3XLIgY9HoWZz0IQv0uiapcnd7Mltt-Vu8mb9ID9jF81oxpdskH--3hTSO2RIA1mE114XeDb9m8m8uCZ3SV12_0DQFtd8GMw8EKTt1EyPZeQ3uO0VIPnW-O3yp3KLWf5TAc3XqzWZlm1zpb0Vq9VcJ-QQphpjPkfkaRkSUjurMWY8U2i7xxXWs1TwJqr0hyC1a" src="https://github.com/user-attachments/assets/7a7ebcca-7883-4969-8c91-ec765f8653ce" />


**UML diagram explanation**

The Item class is the parent class which I declared as abstract while the child classes (Sandwich , Chips and Drinks) extend the parent class since they are all Items. 

This demonstrates "Is-A" relationship which allows them to share common fields such as name and quantity while implementing
their own calculatePrice() .

The interphase calculatePrice() is implemented by the sandwich, drinks, chips and order classes.

Encapsulation is also used where fields are only accessible through getters and setters.

**Technologies Used**

-Java 17

-ANSI Console Colors

-Text-based UI

-File I/O for generating receipts




**Example Output**






https://github.com/user-attachments/assets/1d539385-5a8a-47be-b4b3-3cebb65ac7d1

**Receipt Output Example**





<img width="507" height="513" alt="Screenshot 2025-11-13 232417" src="https://github.com/user-attachments/assets/758ee32e-bb08-4a3d-85c0-2b96358818b0" />


**Future Improvements**
1. Handling the inventory to keep track and to know when low on items
2. Retrievable list of all transactions sortable by date and/or time


**Project Board link**

https://trello.com/invite/b/691265d17d3f2723d47c23de/ATTIcc3afd160d753694e2b72364110cb3b83B40D101/byte-bite





**👤 Author**

Owiti Emmanuel
