package com.github.nanoflakes

/**
 * A [Nanoflake](https://github.com/nanoflakes/nanoflakes).
 */
class Nanoflake {
    /**
     * The base epoch of the nanoflake.
     */
    private val epoch: Long

    /**
     * The value of the nanoflake.
     */
    private val value: Long

    /**
     * Creates a new nanoflake.
     *
     * @param epoch the nanoflake's epoch.
     * @param value the nanoflake's value.
     */
    constructor(epoch: Long, value: Long) {
        this.epoch = epoch
        this.value = value
    }

    /**
     * Creates a new nanoflake, parsing the value from a string.
     *
     * @param epoch the nanoflake's epoch.
     * @param value the nanoflake's value.
     */
    constructor(epoch: Long, value: String) {
        this.epoch = epoch
        this.value = value.toLong()
    }

    /**
     * Creates a new nanoflake, parsing the value from a string with a radix.
     *
     * @param epoch the nanoflake's epoch.
     * @param value the nanoflake's value.
     * @param radix the radix of the nanoflake.
     */
    constructor(epoch: Long, value: String, radix: Int) {
        this.epoch = epoch
        this.value = value.toLong(radix)
    }

    /**
     * Gets the nanoflake value as a Long.
     *
     * @return the value as a long.
     */
    fun asLong(): Long {
        return value
    }

    /**
     * Gets the nanoflake value as a string.
     *
     * @return the value as a String.
     */
    fun asString(): String {
        return value.toString()
    }

    /**
     * Gets the nanoflake value as a string, using a specified radix.
     *
     * @param radix the radix.
     * @return the value as a String.
     */
    fun withRadix(radix: Int): String {
        return value.toString(radix)
    }

    /**
     * Gets the creation time as an [OffsetDateTime].
     *
     * @return a [OffsetDateTime] set to the creation time.
     */
    fun creationTime(): DateTime {
        return creationTimeMillis().toDateTime()
    }

    /**
     * Gets the creation time.
     *
     * @return the creation time in milliseconds.
     */
    fun creationTimeMillis(): Long {
        return epoch + Nanoflakes.timestampValue(value)
    }

    /**
     * Gets this nanoflake's epoch.
     *
     * @return the epoch in milliseconds.
     */
    fun epochMillis(): Long {
        return epoch
    }

    /**
     * Gets this nanoflake's epoch as an [OffsetDateTime].
     *
     * @return a [OffsetDateTime] set to the epoch time.
     */
    fun epoch(): DateTime {
        return epochMillis().toDateTime()
    }

    /**
     * {@inheritDoc}
     */
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || o !is Nanoflake) return false
        return epoch == o.epoch && value == o.value
    }

    /**
     * {@inheritDoc}
     */
    override fun hashCode(): Int {
        return arrayOf<Any?>(epoch, value).contentHashCode()
    }

    /**
     * {@inheritDoc}
     */
    override fun toString(): String {
        return "Nanoflake{epoch=$epoch, value=$value}"
    }
}