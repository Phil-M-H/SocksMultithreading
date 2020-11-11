# SocksMultithreading
I wanted to know if, by pulling my a sock from the front and back of my sock pile, I could ensure that regardless of how I add new socks they would be worn approximately evenly.

A quick program that creates a threadpool and 2 worker objects, a Washer and a Wearer. It then adds tasks to the queue - either pull socks from the pile, and increasing their wear count, or running the washing machine. It will then print out information about how often they've been worn.

