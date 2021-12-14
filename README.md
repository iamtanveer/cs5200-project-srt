Problem Statement:

Provide a database centric application that allows bloggers and readers to interact with articles posted and created by authors. Users can interact with the application by posting comments and liking articles. Users can also follow their favourite authors and other users.

Solution Statement:
The solution is to start by thinking of the main domain objects and the users our model would consist of. We started by making a UML model consisting of classes that would be included as part of our data model. We then applied reification of the necessary classes so that it could be directly translated into a data model. We then created all the necessary tables and enums in our database using MySql. Once we had the database set up, we wrote services to perform CRUD operations over the web on our data model using Java Springboot. We finally implemented a React front end where the user can visually see the data that is being stored in the db and also see the results of their CRUD operations.


Users Objects:
Users : Users are the actors in the application who can read Articles posted by Authors. They can also like,  comment on articles and follow other users.

Authors : Authors are inherently users with extra privileges to create articles. Authors have a specific interest area in which they write articles.

Domain Objects:
Articles : Articles are blog posts that are written by authors. They can be created, edited or deleted by authors. They can be read by all users. Articles have a ManyToOne relationship with the Authors. If the author of the article is deleted, the article will also be deleted because of the Cascading effect defined while creating the foreign key relation.

Comments : Comments are a way for the users to share their views on an article. We support regular text. Each comment is associated with a user and an article. Comments share a ManyToOne relation with the Article and a OneToMany relation with the User. . One user can post many comments and one article can have many comments as well. If the user or article is deleted, we delete the comment because of the Cascading effect defined while creating the foreign key relation.

Likes : Likes, like comments, are a way to leave an impression on a post. Likes share a onetomany multiplicity with articles and users. Each Like has a foreign key references to both users and articles.. One article can have many likes and users can like as many articles as they want. If the user who liked the article or the article itself is deleted, we delete the Like record because of the Cascading effect defined while creating the foreign key relation.

Follows : Follows is a ManyToMany relationship between Users. Follows is a feature to increase their network. Each link is a unidirectional link from one user to the other. If one of the users in the link is deleted, we delete the record in the Follows table because of the Cascading effect defined while defining the Foreign Key Reference.

Categories: Categories is an enum created from our Springboot application. Articles created by Authors fall into one of the Categories stored in the Categories enum in the database. While creating an Author, there is a field to select a category that they prefer. This refers back to the Categories enum.
