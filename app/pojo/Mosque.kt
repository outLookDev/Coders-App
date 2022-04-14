package com.hudazamov.myquran.pojo

data class Mosque(
    val html_attributions: List<Any>,
    val next_page_token: String,
    val results: List<Result>,
    val status: String
)