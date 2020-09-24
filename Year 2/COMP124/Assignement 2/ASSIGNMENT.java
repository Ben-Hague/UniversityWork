/************************\
April 2018
Potter and Packer problem
Assignment 2 - COMP124
Benjamin Hague
sgbhague@liv.ac.uk
Student ID 201146260
\************************/

/*
This program executes a Producer consumer problem with 2 Producers, the Potters
(Harry and Beatrix) and 1 consumer, the Packer (Macca).
Harry takes 500ms to produce a pot, Beatrix takes 600ms and Macca takes 400ms
to pack a pot.
*/

/********************************* Shelf ***********************************/

/*
This is the Shelf Class, it can be used to create a shelf object
To access the shelf object you must use the declared functions
Using the Declared functions to manage from the shelf prevents deadlock
as these methods are syncronized only one instance of any of them can run
*/
class Shelf
{
  // Variables are Created for the shelf size (Capacity)
  // and keeping track of what is in the shelf
  // these are both private to prevent illegal access
  private static int Capacity;
  private volatile int Objects = 0;

  // Set the Value of Capacity when the Shelf object is created
  public Shelf(int C)
  {
    Capacity = C;
  }

  // isFull function takes no input arguments
  // Returns Boolean value true if shelf is full and false if shelf is not
  public synchronized boolean isFull()
  {
    return (Objects >= Capacity);
  }

  // isEmpty function takes no input arguments
  // Returns Boolean value true if shelf is Empty and false if shelf is not
  public synchronized boolean isEmpty()
  {
    return (Objects == 0);
  }

  // addObject ensures that the shelf can only be accessed by one actor at any Time
  // addObject takes a string input which is used to produce a Named output
  // The function increments the number of items in the Shelf by one and produces output to inform us of this
  public synchronized void addObject(String Name)
  {
    Objects++;
    System.out.println(Name + " has placed their pot on the shelf");
    System.out.println("There are now "+ Objects + " pots on the shelf");
  }

  // removeObject ensures that the shelf can only be accessed by one actor at any Time
  // removeObject takes a string input which is used to produce a Named output
  // The function increments the number of items in the Shelf by negative one
  // (removes item from Shelf) and produces output to inform us of this
  public synchronized void removeObject(String Name)
  {
    Objects--;
    System.out.println(Name + " has removed a pot from the shelf");
    System.out.println("There are now "+ Objects + " pots on the shelf");
  }
}

/******************************** Potter ***********************************/

/*
This is the Potter class. it is used to create a potter object
The Potter class has 2 methods, an initialize method and a run method
The Potter class is designed to create an object to be run as a thread
*/
class Potter extends Thread
{
  // Variables are created for Name of Potter (Name), the Shelf being used (workingShelf),
  // the number of Pots (Pots) that have been produced and the time taken to create a Pot (Time)
  private String Name;
  private Shelf workingShelf;
  private int Pots = 0;
  private int Time;

  // Set the Name, Shelf and Time taken to create a pot when the Potter Object is created
  public Potter(String n, Shelf shelf, int T)
  {
      Name = n;
      workingShelf = shelf;
      Time = T;
  }

  // the run function is created in its own thread
  // the run function contains all the code needed to execute the Potter and create pots
  public synchronized void run()
  {
    // This lets us know by name that the potter has begun work
    System.out.println(Name + " (Potter) has started");

    // This limits the number of pots to be created to 10
    while (Pots < 10)
    {
      // if the shelf is full, Tell us
      if(workingShelf.isFull())
      {
        System.out.println("The shelf is full");
        // while the shelf is full, Loop doing nothing
        // (Wait untill shelf is no longer full)
        while (workingShelf.isFull())
        {}
      }

      // increment the Number of pots created
      Pots++;

      // Tell us that it has begun to start making the next pot
      System.out.println(Name + " has begun to produce pot number " + Pots);

      // Sleep the thread for the ammount of time it takes to create the pot
      // (Create the pot)
      try
      {
        Thread.sleep(Time);
      }
        catch (InterruptedException e) {}

      // Tell us that the pot has been created
      System.out.println(Name + " has produced pot number " + Pots);

      // Add the pot to the shelf using the addObject function
      workingShelf.addObject(Name);
    }

    // Tell us how many pots the potter has created
    System.out.println(Name + " Has Made " + Pots +" Pots");
  }
}

/******************************** Packer ***********************************/

/*
This is the Packer Class. it is used to create a Packer object
The Packer class has 2 methods, an initialize method and a run method
The Packer class is designed to create an object to be run as a thread
*/
class Packer extends Thread
{
  // Variables are created for Name of Packer (Name), the Shelf being used (workingShelf),
  // the number of Pots (Pots) that have been packed and the time taken to pack a Pot (Time)
  private String Name;
  private Shelf workingShelf;
  private int Pots = 0;
  private int Time;

  // Set the Name, Shelf and Time taken to pack a pot when the Packer Object is created
  public Packer(String n, Shelf shelf, int T)
  {
      Name = n;
      workingShelf = shelf;
      Time = T;
  }

  // the run function is created in its own thread
  // the run function contains all the code needed to execute the Packer and pack pots
  public void run(){

    // This lets us know by name that the Packer has begun work
    System.out.println(Name + " (Packer) has started");

    // This insures that the packer will only pack 20 pots (each Potter Creates 10)
    while(Pots < 20)
    {
      // Check if the shelf is empty using isEmpty, if it is, tell us
      if (workingShelf.isEmpty())
      {
        System.out.println("The shelf is Empty");

        // While the shelf remains empty, Loop doing nothing
        // (Wait untill shelf is no longer empty)
        while (workingShelf.isEmpty())
        {}
      }

      // Remove the pot from the shelf
      workingShelf.removeObject(Name);

      // Begin Packing the pot for the specified ammount of time
      try
      {
        Thread.sleep(Time);
      }
        catch (InterruptedException e) {}

        // increment the number of pots packaged
        Pots++;

        // tell us that the pot has been packed
        System.out.println(Name + " has Packaged the Pot");
    }
    // When all the pots have been packed, Tell us they have all been packed
    System.out.println(Name + " Has Packaged " + Pots +" Pots");
  }
}

/********************************* Main ************************************/

/*
This is the Main class in the program,
It is used to create the objects and execute the threads
The main function within this class is executed when the program is started
*/
public class ASSIGNMENT
{
  public static void main(String[] args)
  {
    // Create the Shelf Object Called workingShelf with a Capacity of 5
    Shelf workingShelf = new Shelf(5);

    // Create the Potter Object Called Harry, with the shelf workingShelf
    // and the time to create a pot being 500ms
    Potter Harry = new Potter("Harry", workingShelf, 500);

    // Create the Potter Object Called Beatrix, with the shelf workingShelf
    // and the time to create a pot being 600ms
    Potter Beatrix = new Potter("Beatrix", workingShelf, 600);

    // Create the Packer Object Called Beatrix, with the shelf workingShelf
    // and the time to pack a pot being 400ms
    Packer Macca = new Packer("Macca", workingShelf, 400);

    // Start Harry, Beatrix and Macca in different threads
    Harry.start();
    Beatrix.start();
    Macca.start();
  }
  
}
