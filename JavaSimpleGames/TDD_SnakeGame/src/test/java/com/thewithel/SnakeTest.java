package com.thewithel;


import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {

    private Snake snake;

    @BeforeEach
    void init() {
    }

    @Test
    void testSnakeMoves() {
        Snake snake = new Snake(new Point2D(0, 0));
        //@TODO rewrite it to parametrized test
        for (Direction direction : Direction.values()) {
            Point2D oldPosition = snake.getHead();

            snake.setDirection(direction);

            snake.update();

            assertThat(snake.getHead(), is(oldPosition.add(direction.vector)));
        }
    }

    @Test
    void testSnakeFoodCollision() {
        Snake snake = new Snake(new Point2D(10, 5));

        Food food = new Food(new Point2D(10, 5));

        assertTrue(snake.isCollidingWith(food));
    }

    @Test
    void testSnakeGrows() {
        Snake snake = new Snake(new Point2D(0, 0));

        snake.setDirection(Direction.RIGHT);
        snake.update();
        snake.grow();

        assertThat(snake.getLength(), is(2));
        assertThat(snake.getBody(), hasItem(new Point2D(0, 0)));
    }

    @Test
    void testSnakeOutOfBounds() {
        Snake snake = new Snake(new Point2D(25, 0));

        assertTrue(snake.isOutOfBounds(24));
        assertFalse(snake.isOutOfBounds(25));
    }

    @Test
    void testSnakeDies() {
        Snake snake = new Snake(new Point2D(0, 0));

        for (int i = 0; i < 5; i++) {
            snake.setDirection(Direction.RIGHT);
            snake.update();
            snake.grow();
        }

        assertEquals(snake.getLength(), 6);

        snake.setDirection(Direction.UP);
        snake.update();

        snake.setDirection(Direction.LEFT);
        snake.update();

        snake.setDirection(Direction.DOWN);
        snake.update();

        assertTrue(snake.isDead());
    }

    @Test
    void testHeadIsInFront() {
        Snake snake = new Snake(new Point2D(0, 0));

        snake.setDirection(Direction.RIGHT);
        snake.update();
        snake.grow();

        snake.update();

        assertThat(snake.getBody().get(0), is(snake.getHead()));
    }
}
