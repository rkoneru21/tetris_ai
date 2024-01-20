# Tetris AI
A minimalistic java implementation of Tetris that comes with a toggleable Tetris Bot to play the game for you.

## Description
This Tetris implementation is object-oriented with the tetris pieces as objects and the Tetris Manager object as the container where the Tetris pieces fall. The Piece class has 7 classes that extend it, representing the 7 different Tetris pieces in the game. Each seperate piece class has its own rotation methods. When a row on the board is full, the line clears and everything moves down. The scoring is as follows:

- 1 line: 40 points
- 2 lines: 100 points
- 3 lines: 300 points
- Tetris: 1200 points

When the player hits the button at the top of the screen that says "Enable Tetris AI", the AI starts playing on its own using the TetrisAI class. The AI works by taking the current piece and simulates dropping it in every possible orientation on the board. Then the AI assignes a score to each board based on how many holes are present, how many pillars are present, the maximum height of the board, the bumpiness of the board, and if a tetris was cleared. Whichever board scores the lowest is the move that the AI will play. 

## Getting Started
There are no dependencies necessary for this repository, all you need to do is clone the repository and run the file "Tetris.java".

## Controls
- Left Arrow: Move Left
- Right Arrow: Move Right
- Down Arrow: Move Down
- Up Arrow: Rotate Clockwise
- Z: Rotate Counter-Clockwise
- Space: Hard Drop(Instant Drop)

## Authors
Rohith Koneru
rkoneru21@gmail.com

