# SocksMultithreading
I wanted to know if, by pulling my a sock from the front and back of my sock pile, I could ensure that regardless of how I add new socks they would be worn approximately evenly.

A quick program that creates a threadpool and 2 worker objects, a Washer and a Wearer. It then adds tasks to the queue - either pull socks from the pile, and increasing their wear count, or running the washing machine. It will then print out information about how often they've been worn.


## Note
Logically, it is obvious that I can treat the pile as a queue and keep it simple. Also that eventually, pulling from both the front and back would wear everything evenly. However, I wanted to know how imbalanced my socks if I did that, and how long before they were evenly worn.
