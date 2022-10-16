package com.github.nanoflakes

/**
 * A generator of [nanoflakes][Nanoflake] that retains its epoch information.
 */
public interface NanoflakeWithEpochGenerator : NanoflakeGenerator {
    override fun next(): NanoflakeWithEpoch
}