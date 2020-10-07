package com.thewithel;


import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private Direction direction = Direction.RIGHT;
    private Point2D head;
    private Point2D previousTail;

    private List<Point2D> body = new ArrayList<>();

    public Snake(Point2D position){
        this.head = position;
        this.previousTail = head;
        body.add(position);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    //when we move we remove last element and add it to the begining
    public void update(){
        head = head.add(direction.vector);

        previousTail = body.remove(body.size() - 1);
        body.add(0, head);
    }

    public Point2D getHead() {
        return head;
    }

    public boolean isCollidingWith(Food food) {
        return head.equals(food.getPosition());
    }

    public int getLength() {
        return body.size();
    }

    public void grow() {
        body.add(previousTail);
    }

    public List<Point2D> getBody() {
        return body;
    }

    public boolean isOutOfBounds(int size) {
        return head.getX() < 0 || head.getY() < 0
                || head.getX() > size || head.getY() > 24;
    }

    //when head is colliding with a body
    public boolean isDead() {
        return body.lastIndexOf(head) > 0;
    }
}
