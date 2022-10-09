package com.github.nanoflakes

/**
 * A generator of [nanoflakes][Nanoflake] that retains its epoch information.
 */
class DefaultNanoflakeWithEpochGenerator(
    private val generator: NanoflakeGenerator
) : NanoflakeWithEpochGenerator, NanoflakeGenerator by generator {
    override fun next(): NanoflakeWithEpoch {
        return when (val nanoflake = generator.next()) {
            is NanoflakeWithEpoch -> nanoflake
            is PrimitiveNanoflake -> nanoflake.withEpoch(generator.epoch)
        }
    }
}

fun NanoflakeGenerator.withEpoch(): NanoflakeWithEpochGenerator {
    return when (this) {
        is NanoflakeWithEpochGenerator -> this
        else -> DefaultNanoflakeWithEpochGenerator(this)
    }
}