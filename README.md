# HeadField
From Advent Of Code - day 9

Solution for riddle from Advent Of Code 2022: https://adventofcode.com/2022/day/9

Text of riddle made by Eric Wastl:

This rope bridge creaks as you walk along it. You aren't sure how old it is, or whether it can even support your weight.
It seems to support the Elves just fine, though. The bridge spans a gorge which was carved out by the massive river far below you.
You step carefully; as you do, the ropes stretch and twist. You decide to distract yourself by modeling rope physics; maybe you can even figure out where not to step.
Consider a rope with a knot at each end; these knots mark the head and the tail of the rope. If the head moves far enough away from the tail, the tail is pulled toward the head.
Due to nebulous reasoning involving Planck lengths, you should be able to model the positions of the knots on a two-dimensional grid. Then, by following a hypothetical series of motions (your puzzle input) for the head, you can determine how the tail will move.
Due to the aforementioned Planck lengths, the rope must be quite short; in fact, the head (H) and tail (T) must always be touching. [...]
If the head is ever two steps directly up, down, left, or right from the tail, the tail must also move one step in that direction so it remains close enough. [...]
Otherwise, if the head and tail aren't touching and aren't in the same row or column, the tail always moves one step diagonally to keep up. [...]
You just need to work out where the tail goes as the head follows a series of motions. Assume the head and the tail both start at the same position, overlapping. [...]
Simulate your complete hypothetical series of motions. How many positions does the tail of the rope visit at least once?

A rope snaps! Suddenly, the river is getting a lot closer than you remember. The bridge is still there, but some of the ropes that broke are now whipping toward you as you fall through the air!
The ropes are moving too quickly to grab; you only have a few seconds to choose how to arch your body to avoid being hit. Fortunately, your simulation can be extended to support longer ropes.
Rather than two knots, you now must simulate a rope consisting of ten knots. One knot is still the head of the rope and moves according to the series of motions. Each knot further down the rope follows the knot in front of it using the same rules as before.
Using the same series of motions as the above example, but with the knots marked H, 1, 2, ..., 9, the motions now occur as follows. [...]
Now, you need to keep track of the positions the new tail, 9, visits. In this example, the tail never moves, and so it only visits 1 position. However, be careful: more types of motion are possible than before, so you might want to visually compare your simulated rope to the one above. [...]
Simulate your complete series of motions on a larger rope with ten knots. How many positions does the tail of the rope visit at least once?
