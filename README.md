# Ranked Choice Voting Kata
Presented at Ingage's C3 Meetup on September 18th, 2024

## What is Ranked Choice Voting?

Ranked choice voting (RCV) is a voting system where voters rank candidates in order of preference, instead of choosing just one. For example, instead of only picking one candidate, you would list them like this:

1. Candidate A (Your first choice)
2. Candidate B (Your second choice)
3. Candidate C (Your third choice)

> It's important to note that _Ranked Choice Voting_ is a broad term. It can refer to several different voting methods that use ranked ballots. Different versions of ranked voting systems exist, and today, we will focus on a specific method called _instant-runoff voting (IRV)_.

### Why Use Ranked Choice Voting (RCV)?

Ranked choice voting helps to address common problems in elections. For example, in some systems, similar candidates can split votes between them, which allows another candidate to win with less overall support. With RCV, even if your favorite candidate doesn’t win, your vote can still help determine the outcome through your next preferences.

## How Does Instant-Runoff Voting (IRV) Work?

Instant-runoff voting is a method of ranked choice voting designed for single-winner elections. Here's a general overview of how it works (note that this explanation doesn't cover all edge cases):

1. **First, count all the first-choice votes**. If any candidate gets more than 50% of the votes, they win.
2. **If no candidate gets over 50%**, the candidate with the fewest votes is eliminated.
3. **Redistribute the votes** from the eliminated candidate to the voters' next choice.
4. **Repeat the process** of eliminating candidates and redistributing votes until one candidate gets more than 50% and wins.

### Why Use Instant Runoff Voting?

Instant Runoff Voting helps ensure that the winner has broader support by considering voters' next most-preferred candidate if their top candidate is eliminated. This prevents a candidate from winning with just a small percentage of the vote in a crowded race.

## What is a Cast Vote Record (CVR)?

A **Cast Vote Record (CVR)** is a data representation how each voter ranked the candidates. Different voting system vendors may have different formats for CVRs, but for this kata, we are using a simple CSV format. Here’s an example of a CVR file using our generic CSV format:

```
BallotID,Alice,Bob,Carlos,David,Erin,Frank
000,4,1,6,3,5,2
001,2,5,4,1,3,6
002,3,6,2,5,4,1
003,1,2,5,4,6,3
004,6,3,1,2,4,5
005,5,4,2,6,1,3
006,2,3,6,1,5,4
007,4,6,3,2,1,5
008,1,5,4,6,2,3
009,3,2,6,5,1,4
```

In this example:
- Each row represents a single voter’s ranking of the candidates.
- The columns after **BallotID** represent the candidates: **Alice, Bob, Carlos, David, Erin, and Frank**.
- The numbers in each row indicate the ranking a voter gave to each candidate. For example, in the first row (BallotID `000`), the voter ranked **Bob** as their first choice (`1`), **Frank** as their second choice (`2`), **David** as their third choice (`3`), and so on.

## Your Challenge

For this kata, you’ll implement the **Instant Runoff Voting (IRV)** algorithm. Here's what you need to do for each test election:

1. **Read the CVR** election data from the CSV file which contains ranked ballots from voters.
2. **Process the election** by running rounds of counting, eliminating candidates with the fewest votes, and redistributing those votes.
3. **Output the winner** after all rounds are complete (i.e. once a candidate has received 50% of the remaining votes).

You will be given some mock test elections (formatted as CSV files) and the expected results (provided in either JSON or CSV format). Your goal is to write code that reads the election data, runs the IRV process, and produces the correct winner.

### Edge Cases

If you have extra time, you can explore handling some edge cases.

## How to Get Started

1. Pick the programming language you’re most comfortable with.
2. Open the "Templates" directory to find starter code and unit tests.
3. Follow the principles of **Test-Driven Development (TDD)** by writing tests first and building your solution step by step.

## Test Elections Directory Structure

Each test election will be stored in its own folder. Inside each folder, you'll find:

- **README.md**: A brief explanation of the test election.
- **cvr.csv**: The Cast Vote Record for the test election, which you'll process.
- **expect_results_summary.json** or **expect_results_summary.csv**: These files contain the expected election outcome. You can use either format.
- **config.json**: This file is optional and is provided for debugging or facilitator support.

## Additional Notes

See solutions in different languages in the "Templates" directory. Once you decide which language you'd like to use, simply open that directory in your favorite IDE, and you should be able to run the included unit tests "out of the box".

The recommended IDEs are as follows, but feel free to use whatever IDE you are comfortable with.

-   [C#](Templates/C%23) - [Microsoft Visual Studio](https://visualstudio.microsoft.com/vs/community/)
-   [Java](Templates/Java) - [IntelliJ Idea](https://www.jetbrains.com/idea/download) (Community Edition is fine)
-   [JavaScript](Templates/JavaScript) - [Microsoft Visual Studio Code](https://code.visualstudio.com/)
-   [Kotlin](Templates/Kotlin) - [IntelliJ Idea](https://www.jetbrains.com/idea/download) (Community Edition is fine)
-   [Python](Templates/Python) - [Pycharm](https://www.jetbrains.com/pycharm/download/?section=windows) (Community Edition is fine)
-   [TypeScript](Templates/TypeScript) - [Microsoft Visual Studio Code](https://code.visualstudio.com/)

## Further Reading and Resources

- **[Wikipedia article on Ranked Voting](https://en.wikipedia.org/wiki/Ranked_voting):** provides a broad overview on various ranked choice voting systems.
- **[Wikipedia article on Instant-Runoff Voting](https://en.wikipedia.org/wiki/Instant-runoff_voting)**: discusses IRV (a type of single-winner ranked choice voting; the type of RCV that we implemented in this kata).
- **[Wikipedia article on Single Transferable Vote](https://en.wikipedia.org/wiki/Single_transferable_vote)**: discusses STV (a type of proportional, multi-winner ranked choice voting).
- **[Wikipedia article on Comparison of Voting Rules](https://en.wikipedia.org/wiki/Comparison_of_voting_rules)**: compares various voting systems (including various ranked choice systems) against various formal criteria that are used to evaluate voting systems. This article is useful for understanding the pros and cons of various voting systems, and what problems each voting system might be effective at solving.
- **[Fairvote article on How Ranked Choice Voting Works](https://fairvote.org/our-reforms/ranked-choice-voting-information/#how-ranked-choice-voting-works)**: an in-depth discussion of ranked choice voting, its history, problems it attempts to address, and RCV implementation status and efforts in the United States. (Note: Fairvote is a US-based advocacy group promoting ranked choice voting.)
- **[Ranked Choice Voting Resource Center's article on What is RCV](https://www.rcvresources.org/what-is-rcv):** The Ranked Choice Voting Resource Center (RCVRC) is a US-based nonprofit that provides information, research and tools to teach the public about ranked choice voting. (Disclosure: the presenter is currently employed by the RCVRC).
- **[RCTab](https://www.rcvresources.org/what-is-rcv):** An open source RCV tabulator that can handle both single-winner and multi-winner elections.
