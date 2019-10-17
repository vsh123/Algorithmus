package kakao;

import java.util.*;

public class Muzi {
    public int solution(int[][] board) {
        Set<Position> log = new HashSet<>();
        Position first = new Position(0, 0, 0, 1, 0);
        log.add(first);
        Queue<Position> q = new LinkedList<>();
        q.add(first);

        while (!q.isEmpty()) {
            Position position = q.poll();
            for (MovingPoint movingPoint : MovingPoint.values()) {
                Optional<Position> maybePosition = Optional.ofNullable(position.move(board, movingPoint));
                if (maybePosition.isPresent()) {
                    Position movedPosition = maybePosition.get();
                    if (movedPosition.checkFinish(board)) {
                        return movedPosition.count;
                    }
                    if (!log.contains(movedPosition)) {
                        System.out.println(position + ", position: " + movingPoint);
                        System.out.println(movedPosition + ", movedposition: " + movingPoint);
                        q.offer(movedPosition);
                        log.add(movedPosition);
                    }
                }
            }
        }

        return 0;
    }
}

class Position {
    int count;
    int first_x;
    int first_y;
    int second_x;
    int second_y;

    public Position(int count, int first_x, int first_y, int second_x, int second_y) {
        this.count = count;
        this.first_x = first_x;
        this.first_y = first_y;
        this.second_x = second_x;
        this.second_y = second_y;
    }

    public Position move(int[][] board, MovingPoint point) {
        switch (point) {
            case UP:
                if (first_y > 0 && second_y > 0) {
                    Position movedPosition = movePosition(MovingPoint.UP);
                    return checkWall(board, movedPosition);
                }
                break;
            case DOWN:
                if (first_y < board.length - 1 && second_y < board.length - 1) {
                    Position movedPosition = movePosition(MovingPoint.DOWN);
                    return checkWall(board, movedPosition);
                }
                break;
            case LEFT:
                if (first_x > 0 && second_x > 0) {
                    Position movedPosition = movePosition(MovingPoint.LEFT);
                    return checkWall(board, movedPosition);
                }
                break;
            case RIGHT:
                if (second_x < board[0].length - 1 && first_x < board[0].length - 1) {
                    Position movedPosition = movePosition(MovingPoint.RIGHT);
                    return checkWall(board, movedPosition);
                }
                break;
            case FIRST_ROTATE_RIGHT:
                if (first_x == second_x) {
                    if (second_y > first_y) {
                        if (first_x < board[0].length - 1) {
                            Position movedPosition = movePosition(MovingPoint.FIRST_RIGHT);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.FIRST_DOWN);
                                return rotated(movedPosition, board);


                            }
                        }
                    } else {
                        if (first_x > 0) {
                            Position movedPosition = movePosition(MovingPoint.FIRST_LEFT);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.FIRST_UP);
                                return rotated(movedPosition, board);

                            }
                        }
                    }
                } else {
                    if (second_x > first_x) {
                        if (first_y > 0) {
                            Position movedPosition = movePosition(MovingPoint.FIRST_UP);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.FIRST_RIGHT);
                                return rotated(movedPosition, board);

                            }
                        }
                    } else {
                        if (first_y < board.length - 1) {
                            Position movedPosition = movePosition(MovingPoint.FIRST_DOWN);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.FIRST_LEFT);
                                return rotated(movedPosition, board);

                            }
                        }
                    }
                }
                break;
            case FIRST_ROTATE_LEFT:
                if (first_x == second_x) {
                    if (second_y > first_y) {
                        if (first_x > 0) {
                            Position movedPosition = movePosition(MovingPoint.FIRST_LEFT);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.FIRST_DOWN);
                                return rotated(movedPosition, board);
                            }
                        }
                    } else {
                        if (first_x < board[0].length - 1) {
                            Position movedPosition = movePosition(MovingPoint.FIRST_RIGHT);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.FIRST_UP);
                                return rotated(movedPosition, board);

                            }
                        }
                    }
                } else {
                    if (second_x > first_x) {
                        if (first_y < board.length - 1) {
                            Position movedPosition = movePosition(MovingPoint.FIRST_DOWN);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.FIRST_RIGHT);
                                return rotated(movedPosition, board);

                            }
                        }
                    } else {
                        if (first_y > 0) {
                            Position movedPosition = movePosition(MovingPoint.FIRST_UP);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.FIRST_LEFT);
                                return rotated(movedPosition, board);

                            }
                        }
                    }
                }
                break;
            case SECOND_ROTATE_RIGHT:
                if (first_x == second_x) {
                    if (second_y > first_y) {
                        if (second_x > 0) {
                            Position movedPosition = movePosition(MovingPoint.SECOND_LEFT);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.SECOND_UP);
                                return rotated(movedPosition, board);

                            }
                        }
                    } else {
                        if (second_x < board[0].length - 1) {
                            Position movedPosition = movePosition(MovingPoint.SECOND_RIGHT);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.SECOND_DOWN);
                                return rotated(movedPosition, board);

                            }
                        }
                    }
                } else {
                    if (second_x > first_x) {
                        if (second_y < board.length - 1) {
                            Position movedPosition = movePosition(MovingPoint.SECOND_DOWN);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.SECOND_LEFT);
                                return rotated(movedPosition, board);

                            }
                        }
                    } else {
                        if (second_y > 0) {
                            Position movedPosition = movePosition(MovingPoint.SECOND_UP);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.SECOND_RIGHT);
                                return rotated(movedPosition, board);

                            }
                        }
                    }
                }
                break;
            case SECOND_ROTATE_LEFT:
                if (first_x == second_x) {
                    if (second_y > first_y) {
                        if (second_x < board[0].length - 1) {
                            Position movedPosition = movePosition(MovingPoint.SECOND_RIGHT);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.SECOND_UP);
                                return rotated(movedPosition, board);

                            }
                        }
                    } else {
                        if (second_x > 0) {
                            Position movedPosition = movePosition(MovingPoint.SECOND_LEFT);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.SECOND_DOWN);
                                return rotated(movedPosition, board);

                            }
                        }
                    }
                } else {
                    if (second_x > first_x) {
                        if (second_y > 0) {
                            Position movedPosition = movePosition(MovingPoint.SECOND_UP);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.SECOND_LEFT);
                                return rotated(movedPosition, board);

                            }
                        }
                    } else {
                        if (second_y < board.length - 1) {
                            Position movedPosition = movePosition(MovingPoint.SECOND_DOWN);
                            Optional<Position> po = Optional.ofNullable(checkWall(board, movedPosition));
                            if (po.isPresent()) {
                                movedPosition = movedPosition.movePosition(MovingPoint.SECOND_RIGHT);
                                return rotated(movedPosition, board);

                            }
                        }
                    }
                }
                break;
            default:
                return null;
        }
        return null;
    }

    private Position checkWall(int[][] board, Position movedPosition) {
        if (board[movedPosition.first_y][movedPosition.first_x] == 1 || board[movedPosition.second_y][movedPosition.second_x] == 1) {
            return null;
        }
        return movedPosition;
    }

    private Position movePosition(MovingPoint point) {
        int x1 = first_x + point.first_x;
        int y1 = first_y + point.first_y;
        int x2 = second_x + point.second_x;
        int y2 = second_y + point.second_y;
        int count1 = count + 1;
        return new Position(count1, x1, y1, x2, y2);
    }

    private Position rotated(Position movedPosition, int[][] board){
        if (movedPosition != null) {
            movedPosition.count--;
            return checkWall(board, movedPosition);
        }
        return null;
    }

    public boolean checkFinish(int[][] board) {
        if (first_x == board[0].length - 1 && first_y == board.length - 1) {
            return true;
        }
        if (second_x == board[0].length - 1 && second_y == board.length - 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return first_x == position.first_x &&
                first_y == position.first_y &&
                second_x == position.second_x &&
                second_y == position.second_y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_x, first_y, second_x, second_y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "count=" + count +
                ", first_x=" + first_x +
                ", first_y=" + first_y +
                ", second_x=" + second_x +
                ", second_y=" + second_y +
                '}';
    }
}

enum MovingPoint {
    LEFT(-1, 0, -1, 0),
    RIGHT(1, 0, 1, 0),
    UP(0, -1, 0, -1),
    DOWN(0, 1, 0, 1),
    FIRST_ROTATE_RIGHT(0, -1, 0, 0),
    FIRST_ROTATE_LEFT(0, 1, 0, 0),
    SECOND_ROTATE_RIGHT(0, 0, 0, -1),
    SECOND_ROTATE_LEFT(0, 0, -1, 0),
    FIRST_RIGHT(1, 0, 0, 0),
    FIRST_LEFT(-1, 0, 0, 0),
    FIRST_UP(0, -1, 0, 0),
    FIRST_DOWN(0, 1, 0, 0),
    SECOND_RIGHT(0, 0, 1, 0),
    SECOND_LEFT(0, 0, -1, 0),
    SECOND_UP(0, 0, 0, -1),
    SECOND_DOWN(0, 0, 0, 1);

    public int first_x;
    public int first_y;
    public int second_x;
    public int second_y;

    MovingPoint(int first_x, int first_y, int second_x, int second_y) {
        this.first_x = first_x;
        this.first_y = first_y;
        this.second_x = second_x;
        this.second_y = second_y;
    }
}
