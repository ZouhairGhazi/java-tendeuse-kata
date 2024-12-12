# Lawn Mower Kata

This project implements a simulation for controlling mowers within a grid. The mowers are instructed through a series of commands to move or turn in the grid while respecting boundaries. The program processes multiple mowers and their commands as defined in an input file.

## Features
- Simulates movements and turns of multiple mowers on a rectangular grid.
- Processes commands (`G`, `D`, `A`) to turn left, turn right, or move forward.
- Prevents mowers from moving outside the grid boundaries.
- Handles multiple mowers and their respective commands.

## Input Format
The input file specifies the grid size, initial positions and orientations of mowers, and their commands.

### Example Input
```
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
```
- The first line specifies the grid dimensions (`5 5`).
- Each subsequent pair of lines defines:
  - Initial position and orientation of a mower (e.g., `1 2 N`).
  - Commands for that mower (e.g., `GAGAGAGAA`).

## Output
The program outputs the final position and orientation of each mower after executing its commands.

### Example Output
```
1 3 N
5 1 E
```
- Each line corresponds to the final position and orientation of a mower.

## How to Run

1. **Setup the Project**
   - Clone the repository:
     ```bash
     git clone [https://github.com/ZouhairGhazi/java-tendeuse-kata]
     cd LawnMowerKata
     ```
   - Ensure you have Java 17 or higher installed.
   - Build the project using Maven:
     ```bash
     mvn clean install
     ```

2. **Place Input File**
   - Add the input file to the `src/main/resources` directory. Name it `test.txt` or specify a different name in the `main` method.

3. **Run the Program**
   - Execute the `main` method in the `Main` class.

## Project Structure
```
LawnMowerKata
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com/solent/domain       # Domain models (Grid, Mower)
│   │   │   ├── com/solent/dto          # Data Transfer Objects (ParsedInput)
│   │   │   ├── com/solent/io           # File reading utilities
│   │   │   ├── com/solent/parser       # Input parsing logic
│   │   │   ├── com/solent/runner       # Simulation logic
│   │   ├── resources                   # Input files (e.g., test.txt)
│   ├── test                            # Unit tests
```

## Development Workflow
- **Write Tests First**: Follow TDD principles to add test cases before implementing features.
- **Test Framework**: JUnit 5 is used for unit testing.

