package com.github.nanoflakes

/**
 * A generator of [nanoflakes][Nanoflake].
 */
interface NanoflakeGenerator {
    /**
     * This nanoflake generator's epoch.
     */
    val epoch: Long

    /**
     * This nanoflake generator's epoch as a [DateTime].
     */
    val epochDate: DateTime get() = epoch.toDateTime()

    /**
     * Gets the next [nanoflake][Nanoflake].
     *
     * @return a new, generated nanoflake.
     */
    operator fun next(): Nanoflake
}