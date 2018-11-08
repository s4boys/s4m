from enum import Enum
from time import sleep

class Tile(Enum):
    """An enum type representing the characteristic of a tile in the labyrinth."""
    FLOOR = 1
    WALL = 2
    CHEESE = 3
    VISITED = 4
    NONE = 5

# could probably be implemented with numpy arrays for superior speed instead
def labyrinth(rows, columns):
    """Returns a two dimensional array representing a labyrinth with the specified dimensions. All Tiles are initialised with Tile.FLOOR."""
    return [[Tile.FLOOR for _ in  range(columns)] for _ in range(rows)]

def create_wall(labyrinth, row, column):
    labyrinth[row][column] = Tile.WALL
    return labyrinth

def place_cheese(labyrinth, row, column):
    labyrinth[row][column] = Tile.CHEESE
    return labyrinth

def create_walls(labyrinth, rows, columns):
    for r in rows:
        for c in columns:
            labyrinth[r][c] = Tile.WALL
    return labyrinth

def place_cheeses(labyrinth, rows, columns):
    for r in rows:
        for c in columns:
            labyrinth[r][c] = Tile.CHEESE
    return labyrinth

def move(lab, pos, movestack, locked_moves):
    if lab[pos[0]][pos[1]] != Tile.CHEESE:

        right = "right"
        left = "left"
        up = "up"
        down = "down"

        # attempt to move right
        if pos[1] < len(lab[0]) and lab[pos[0]][pos[1]+1] == Tile.FLOOR and right not in locked_moves:
            movestack.append(right)
            locked_moves.clear()
            locked_moves.add(left)
            return [pos[0], pos[1]+1]

        # attempt to move down
        elif pos[0] < len(lab) and lab[pos[0]+1][pos[1]] == Tile.FLOOR and down not in locked_moves:
            movestack.append(down)
            locked_moves.clear()
            locked_moves.add(up)
            return [pos[0]+1, pos[1]]

        # attempt to move left
        elif pos[1] > 0 and lab[pos[0]][pos[1]-1] == Tile.FLOOR and left not in locked_moves:
            movestack.append(left)
            locked_moves.clear()
            locked_moves.add(right)
            return [pos[0], pos[1]-1]

        # attempt to move up
        elif pos[0] > 0 and lab[pos[0]-1][pos[1]] == Tile.FLOOR and up not in locked_moves:
            movestack.append(up)
            locked_moves.clear()
            locked_moves.add(down)
            return [pos[0]-1, pos[1]]

        else:
            # do stuff with the movestack
            moveback()

def moveback():
    print("gotta move back")

def setup():
    # ugly but functional
    # might as well be haskell

    lab = labyrinth(5, 17)
    lab = create_wall(lab, 0, 7)
    lab = create_walls(lab, range(1,2), range(1,5))
    lab = create_walls(lab, range(1,2), range(6,8))
    lab = create_walls(lab, range(1,2), range(9,11))
    lab = create_walls(lab, range(1,2), range(12,16))
    lab = create_wall(lab, 2, 1)
    lab = create_wall(lab, 2, 4)
    lab = create_wall(lab, 2, 9)
    lab = create_wall(lab, 2, 13)
    lab = create_wall(lab, 3, 1)
    lab = create_walls(lab, range(3,4), range(4,16))
    lab = place_cheese(lab, 2 ,10)
    return lab

def main():
    mylab = setup()
    print("setup finished")
    position = [0,0]
    movestack = []
    locked_moves = set()
    print("state initialised")

    while mylab[position[0]][position[1]] != Tile.CHEESE:
        position = move(mylab, position, movestack, locked_moves)
        print(position)
        # print(movestack)
        sleep(0.5)
    
    print("Cheese found at:")
    print(position)

if __name__ == "__main__":
    main()