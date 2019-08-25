/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package game

// Understands a single roll in bowling
class Bowl internal constructor(private val pinCount: Int) {
    companion object {
        internal fun totalScore(rolls: List<Bowl>) = rolls.sumBy { it.pinCount }
    }

    operator fun times(count: Int) = List(count) { this }
}

operator fun Int.times(b: Bowl) = b * this

val Int.pins get() = Bowl(this)

internal fun List<Bowl>.totalScore() = Bowl.totalScore(this)