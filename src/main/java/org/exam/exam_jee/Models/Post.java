package org.exam.exam_jee.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


public enum Post {


    JUNIOR(1), SENIOR(2), MANAGER(3);

    private final int value;

    private Post(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Post fromValue(int value) {
        for (Post post : Post.values()) {
            if (post.getValue() == value) {
                return post;
            }
        }
        return null;
    }
}
