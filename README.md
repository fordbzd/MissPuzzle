# MissPuzzle

Simple runner and organizer for coding puzzles.

## Feature
Nothing good but simple. No dependency. You can run from CLI or IDE.

## Usage
Put your puzzle in one of the folder under org.misspuzzle.puzzle.

Implement org.misspuzzle.puzzle.Puzzle with a execute() method.

You can write your algorithm in a method, and your test in execute().

From CLI, complie and run: java Run

From IDE, click Debug or F5 (for most IDEs). Breakpoint also works.

To exclude file/folder, add them at the begining of Run.java.

To only execute a file, add them at the begining Run.java. (exclude has higher priority than only)
