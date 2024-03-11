package io

fun scan(delimiter: String): List<String> {
    return scan().split(delimiter)
}

fun scan(): String {
    return readLine()!!
}