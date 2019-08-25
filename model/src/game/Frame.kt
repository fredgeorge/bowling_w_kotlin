/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package game

// Understands a single scoring element of bowling
internal class Frame {
    private val rolls = mutableListOf<Bowl>()

    internal fun score() = rolls.totalScore()
}