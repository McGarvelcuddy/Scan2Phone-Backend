# Scan2Phone-Backend

  The Revengers team is a group of students in the school of Information Science and Technology out of Penn State University, University Park. As part of our final project, we are tasked with choosing some kind of issue in the world that we would like to see fixed or improved upon. From this, we are tasked with figuring out which issue we would like to address and then design a project that would address this issue. Throughout the semester, we are tasked with making plans, documents, designs and various briefings in order to make our projects come to life. Throughout the entirety of our single semester, we are also tasked with making brief presentations in which to enlighten the rest of our class, as well as our professor on what our project is all about as well as to make progress reports to let everyone know how we are doing.

  With that being said, our project is called Scan2Phone. When we started our project, we all came to the conclusion that with the evolution of technology, money and credit cards are slowly moving to virtual interfaces on phones and other technology. What we mean by this is that things like online banking and applications like Venmo allow users to withdraw/deposit/send money between themselves or with their friends. Apple has already created an app on their Iphone IOS that allows users to load credit/debit cards onto their phone to be used wirelessly - virtually eliminating the need for the person to carry around those credit/debit cards or even their entire wallet for that matter. From this though, we realized that only credit/debit cards can be loaded onto this app. What if we expanded this environment to include any card that has a magnetic strip?

  Our vision for this project includes an app component on the phone which will store all of the cards the user would like as well as a separate Raspberry Pi Scanner system that can scan any magnetic stripe card and automatically load them into your phone app for the user to use! From this, the user can expand their virtual wallet from just credit/debit cards to other cards including library cards, student IDs and even hotel room card keys. We believe this will virtually eliminate the need for 15 cards in a wallet and allow the use of cards you may use everyday, to all be in one place on your phone. While we still recommend having some kind of access to the cards just in case, we believe this will make the user experience with cards of many kinds and wallets to be much simpler.

### NOTE: Current application built using Netbeans IDE 8.2, Built using Maven, using JDK 1.8


## Class List
### Controllers
LoginController.java

AddCardController.java

### Views
LoginView.java(controlled by LoginController)

AddCardView.java(controlled by AddCardController)

## Function List: Backend

#### getAccountName() - LoginView.java
Takes in account name user types in and passes it to LoginController for database querying.
#### accountSelect() - LoginController.java
Takes in the account name and accesses the database to get an account with that name for uploading to.
#### beginAddCard() - LoginController.java
Passes control to the AddCardController controller class when an account is accessed successfully.  
#### getCardInfo() - AddCardView.java
Takes in card information from input fields displayed in the view, including card magnetic strip readout.  Sends values as Strings in an Array object to the AddCardController class.
#### convertInfoJSON() - AddCardController.java
Converts the Array of Strings into a JSON object if all the required information is present.
#### addCardJSON() - AddCardController.java
Adds the newly created card JSON information to the larger JSON account object.
#### updateAccount() - AddCardController.java
Sends the updated account JSON object back to the database to update the entry.  Checks if the sending succeeds or not and displays the success status using warning() in the AddCardController class.


###Application installers for Windows and Mac can be found int the /Installers folder
