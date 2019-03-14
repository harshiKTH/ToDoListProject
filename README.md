# ToDoListProject
This is a project written in java to handle project tasks throguh command line interface. The application allow a terminal user to CURD operations of tasks with some aditoanl fucntinalities such as sorting,makring specific task to change the current stasus. The intutive user interface provide simple and flexible methodology for an end user to maange the project tasks with convenince.

Program is consists of following functions as decribed below.

1-Show Menu : 
-------------
Displays the user with a menu items to be chosed to execute a task. Follwong task list is displayed to the user to chose an option.

 (1) Show Menu
 (2) Add List Item
 (3) Remove List Item
 (4) Edit List Item
 (5) Show List Items
 (6) Mark a task completed
 (7) Mark a task not completed
 (8) Save Current List
 (9) Sort task by project
 (0|Q|q) Quit
 

1-Add List Item : 
-----------------
User is able to add a new task to the list of tasks. User is given option to add the necessary details while validating the user input.

Enter your choice : 
2
Enter Project Name
PRO1001
Enter Task
Task 1
Enter date to be completed "dd/MM/yyyy"
1/1/2011
Entered date is already passed, Please enter a valid date !!!  
4/4/2019

2-Remove a Task: 
----------------
User is able to remove a task by providing task number. User is also given a option to enter a valid task number by providing number of tasks and this validates the user input untill user enters a valid task from the task list.

Enter your choice : 
3
Enter the task number between (1-3)
5
Enter the task number between (1-3)
1

*****************************************************************************
TASK# PROJECT NAME    DUE DATE        STATUS     TASK NAME                     
*****************************************************************************

1     Project2        Sep 19, 2019    done       titel2                        
2     Project1        Jun 5, 2019     pending    Project Task 23               
3     Project2        Aug 6, 2019     pending    Task 45    

Task number 1 removed !!!


Program Output :
----------------
*****************************************************************************
TASK# PROJECT NAME    DUE DATE        STATUS     TASK NAME                     
*****************************************************************************

1     project3        Jul 4, 2019     Pending    task3
                        
2     project3        May 5, 2019     Pending    task22
                       
3     project1        Feb 2, 2019     Pending    task1
                        
# Link to Java Document
file:///Users/harshi/IdeaProjects/ToDoListProject/docs/index.html
