/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package game

// Understands scoring of bowling, a game where pins are knocked down
class BowlingGame {
    private val frames = List(10) { Frame() }

    fun score() = frames.sumBy { it.score() }

    infix fun roll(bowls: List<Bowl>) {}
}