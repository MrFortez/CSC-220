Author: Brandon Fortes
Description: This program will take in any number of students (more than 1) in the format shown in the example csv file
    and organize them into groups with high average compatability score. This algorithm first puts students into 
    random groups, then it employs a strategy known as hill climbing where it makes random swaps that slowly
    increase the average group score until it reaches an optima. It will then print out the groups for the teacher.

Running Intructions: Navigate to the /src folder, then compile and run GroupTest.java. The terminal will prompt you 
    to give a group size. This value can be an integer between 2 and half of the total number of students rounded up.
    The code will then generate random groups, print out their scores, then prerform the hill climbing algorithm and 
    print those groups and scores.

Resources Used:
https://www.w3schools.com/java
https://www.tutorialspoint.com/how-to-read-the-data-from-a-csv-file-in-java
https://www.geeksforgeeks.org/generics-in-java/
https://en.wikipedia.org/wiki/Hill_climbing

chatgpt was used exclusively for help in determining the algorithm I would use to organize students optimally. 
Link to the chatgpt conversation: https://chatgpt.com/share/670c27e1-7da4-800b-b6f5-79fa9808b56c