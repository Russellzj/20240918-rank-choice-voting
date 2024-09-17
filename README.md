# Ranked Choice Voting Kata
Presented at Ingage's C3 Meetup on September 18th, 2024

## What is Ranked Choice Voting?

Ranked Choice Voting (RCV) is a voting system where voters rank candidates in order of preference, instead of choosing just one. For example, instead of only picking one candidate, you would list them like this:

1. Candidate A (Your first choice)
2. Candidate B (Your second choice)
3. Candidate C (Your third choice)

This helps ensure that the winner of an election has the support of the majority of voters, even if their first-choice candidate doesn’t win.

### Why Use Ranked Choice Voting?

Ranked Choice Voting solves a common problem in elections called "vote splitting." Sometimes, two similar candidates can split the votes between them, allowing a third, less popular candidate to win. RCV ensures that even if your favorite candidate is eliminated, your vote can still count for your next choice, helping to find a candidate with broader support.

## How Does Instant Runoff Voting (IRV) Work?

Instant Runoff Voting (IRV) is a type of Ranked Choice Voting. Here’s how it works:

1. **First, count all the first-choice votes**. If any candidate gets more than 50% of the votes, they win.
2. **If no candidate gets over 50%**, the candidate with the fewest votes is eliminated.
3. **Redistribute the votes** from the eliminated candidate to the voters' next choice.
4. **Repeat the process** of eliminating candidates and redistributing votes until one candidate gets more than 50% and wins.

### Why Use Instant Runoff Voting?

IRV ensures that the winning candidate has majority support, even if there are many candidates. It helps avoid situations where someone wins with a small percentage of the vote, which can happen in systems where voters only pick one candidate.

## Your Challenge

For this kata, you’ll implement the Instant Runoff Voting (IRV) algorithm. Here’s what you’ll do:

1. **Read an election file** (provided in CSV format) that contains ranked ballots from voters.
2. **Process the election** by running rounds of counting, eliminating candidates with the fewest votes, and redistributing those votes.
3. **Output the winner** after all rounds are complete.

You’ll be given some mock test elections (formatted as CSV files) and the expected results (formatted as either CSV or JSON). Your goal is to write code that reads the election data, runs the IRV process, and produces the correct winner.

## How to Get Started

1. Pick the programming language you’re most comfortable with.
2. Open the "Templates" directory to find starter code and unit tests.
3. Follow the principles of Test-Driven Development (TDD) by writing tests first and building your solution step by step.

## Additional Notes

See solutions in different languages in the "Templates" directory. Once you decide which language you'd like to use, simply open that directory in your favorite IDE, and you should be able to run the included unit tests "out of the box".

The recommended IDEs are as follows, but feel free to use whatever IDE you are comfortable with.

-   [C#](Templates/C%23) - [Microsoft Visual Studio](https://visualstudio.microsoft.com/vs/community/)
-   [Java](Templates/Java) - [IntelliJ Idea](https://www.jetbrains.com/idea/download) (Community Edition is fine)
-   [JavaScript](Templates/JavaScript) - [Microsoft Visual Studio Code](https://code.visualstudio.com/)
-   [Kotlin](Templates/Kotlin) - [IntelliJ Idea](https://www.jetbrains.com/idea/download) (Community Edition is fine)
-   [Python](Templates/Python) - [Pycharm](https://www.jetbrains.com/pycharm/download/?section=windows) (Community Edition is fine)
-   [TypeScript](Templates/TypeScript) - [Microsoft Visual Studio Code](https://code.visualstudio.com/)
