# TennisScoreBoard

Created this application to demonstrate tennis score board.

Java 17 is used to write and compile the program.
Used Maven for dependency management.
An executable jar file will be created using maven jar plugin.
Junits are written for unit testing.

# Usage: 
To run the program as a single java file, Please use the file ScoreBoard.java at the root of repository with command line arguments. Ex. java ScoreBoard.java Input.txt Output.txt
 
For executable jar, use tennisScoreBoard-1.0.0.jar at the root of the repository with command line arguments. Ex. java -jar tennisScoreBoard-1.0.0.jar Input.txt Output.txt  

# Problem description:

Write a program which reads in descriptions
of tennis matches and displays the current score in each match.	

The program should take two arguments on the command line:
respectively the name of an input file and the name of an output
file.

Each line of the input file is a description of a tennis match
between two players named 'A' and 'B', and comprises a sequence
of 'A's and 'B's which indicates the winner of each point in the
match in the order that they are played.

For each line in the input, the program should write a line to
the output in the format:

[completed set scores] [score in current set] [score in current game]

For example: 3-6 6-4 0-2 0-15
                         ^^^^ score in current game
                     ^^^ score in current set
             ^^^^^^^ scores in completed sets

Each score is shown in the form 'n-m' where 'n' is the current
server's score and 'm' is the current receiver's score. The server
changes at the end of each game, and player A serves first.

The score in points in the current game is omitted if it is 0-0.

The score in games in the current set is shown even if it is 0-0.

An advantage score is shown 40-A or A-40.

There is no tiebreak in any set.

The match begins with player A serving.

The match is best of 3 sets.

An example input file, and the corresponding output file, is
included. The submitted program is expected to produce a
character-for-character copy of this output file from this input
file, so careful attention must be paid to whitespace characters.

The input file can be assumed to only comprise lines of sequences
of 'A's and 'B's which form matches which have not been won by
either player. It is not required to handle gracefully any other
format of input.

The rules of tennis scoring may be found online at [1]. For this
exercise, the match is won by the best of three sets and each set
is won by two clear games. There is no tiebreak in any set.

Candidates unfamiliar with the rules of tennis may request an
alternative exercise.

[1] http://en.wikipedia.org/wiki/Tennis_score
