# JSP contact us project

The entrance page of the project is html project. I Implemented this using the [MVC](https://medium.com/@joespinelli_6190/mvc-model-view-controller-ef878e2fd6f5) which stands for Model, View, Controller. This also provides security we abstract the implementation and logic 

For Exmaple, If we try to use the admin succesful page using ("adminloginsuccesful") at the end of the url it doesn't show any data because that a view that doesn't contain any logic it is used for representation ,MVC provides a lot more flexibilites like this.

## UserRegistation

The user registration is quite simple, select the user option in the main page enter the required details and click on submit you will be redirected to a page it shows whether the registration was succcesful or not and you can go to admin page again.

## AdminLogin

The admin login is different to make it secure I have set different for database and admin credentials even more to that the admin credentials are validated in another server if the credentials doesn't match you will redirected to another page where it shows that the credentials are wrong.

If you try to open the success login page after wrong credentials there will be no data you can only acess the data only if you enter the right details.
The credentials are username : admin , Password : 0000;
