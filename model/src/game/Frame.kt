/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package game

// Understands a single scoring element of bowling
internal class Frame {
    private val rolls = mutableListOf<BowlResult>()
    private var state: FrameState = EmptyFrame()

    internal fun score() = rolls.totalScore()

    internal fun roll(bowlResult: BowlResult?): BowlResult? {
        if (bowlResult == null) return null
        return state.roll(bowlResult)
    }

    internal interface FrameState {
        fun roll(bowlResult: BowlResult): BowlResult?
    }

    internal inner class EmptyFrame : FrameState {
        override fun roll(bowlResult: BowlResult): BowlResult? {
            rolls.add(bowlResult)
            state = InFrameRoll()
            return null
        }
    }

    internal inner class InFrameRoll : FrameState {
        override fun roll(bowlResult: BowlResult): BowlResult? {
            rolls.add(bowlResult)
            state = CompleteFrame()
            return null
        }
    }

    internal inner class CompleteFrame: FrameState {
        override fun roll(bowlResult: BowlResult): BowlResult? {
            return bowlResult
        }

    }
}