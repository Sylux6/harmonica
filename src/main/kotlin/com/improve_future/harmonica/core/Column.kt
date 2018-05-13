package com.improve_future.harmonica.core

import java.sql.Types

class Column(val name: String, val type: Type) {
    val sqlType: String
        get() {
            return when (type) {
                Types.BIT -> "BIT"
                Types.BOOLEAN -> "BOOL"

                // NUMBER
                Types.BIGINT -> "BIGINT" // BITSERIAL
                Types.SMALLINT -> "SMALLINT"
                Types.INTEGER -> "INTEGER" // SERIAL
                Types.NUMERIC -> "NUMERIC"
                Types.DOUBLE -> "DOUBLE PRECISION"
                Types.REAL -> "REAL"

                // LETTER
                Types.CHAR -> "CHARACTER"
                Types.VARCHAR -> "VARCHAR"
                Types.LONGNVARCHAR -> "TEXT"

                // BINARY
                Types.LONGVARBINARY -> "BYTEA"
                Types.BINARY -> "BIT VARYING"
                Types.BLOB -> "BLOB"

                // DATE AND TIME
                Types.DATE -> "DATE"
                Types.TIMESTAMP -> "TIMESTAMP" // TIME WITH TIMEZONE, TIMESTAMP WITH TIMEZONE

                Types.SQLXML -> "XML"
                else -> throw Exception()
            }
        }
}