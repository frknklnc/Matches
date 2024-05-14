package com.example.matches.data.model


import com.google.gson.annotations.SerializedName

data class MatchesResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("at")
        val at: At,
        @SerializedName("br")
        val br: Br,
        @SerializedName("bri")
        val bri: Int,
        @SerializedName("d")
        val d: Long,
        @SerializedName("ht")
        val ht: Ht,
        @SerializedName("i")
        val i: Int,
        @SerializedName("img")
        val img: İmg,
        @SerializedName("pe")
        val pe: Pe,
        @SerializedName("sc")
        val sc: Sc,
        @SerializedName("sgi")
        val sgi: Int,
        @SerializedName("st")
        val st: String,
        @SerializedName("str")
        val str: Boolean,
        @SerializedName("to")
        val to: To,
        @SerializedName("v")
        val v: String
    ) {
        data class At(
            @SerializedName("i")
            val i: Int,
            @SerializedName("n")
            val n: String,
            @SerializedName("p")
            val p: Int,
            @SerializedName("rc")
            val rc: Int,
            @SerializedName("sn")
            val sn: String
        )

        data class Br(
            @SerializedName("id")
            val id: Int
        )

        data class Ht(
            @SerializedName("i")
            val i: Int,
            @SerializedName("n")
            val n: String,
            @SerializedName("p")
            val p: Int,
            @SerializedName("rc")
            val rc: Int,
            @SerializedName("sn")
            val sn: String
        )

        data class İmg(
            @SerializedName("id")
            val id: Int
        )

        data class Pe(
            @SerializedName("fi")
            val fi: String,
            @SerializedName("si")
            val si: String
        )

        data class Sc(
            @SerializedName("abbr")
            val abbr: String,
            @SerializedName("at")
            val at: At,
            @SerializedName("ht")
            val ht: Ht,
            @SerializedName("min")
            val min: Int,
            @SerializedName("st")
            val st: Int
        ) {
            data class At(
                @SerializedName("c")
                val c: Int,
                @SerializedName("ht")
                val ht: Int,
                @SerializedName("r")
                val r: Int
            )

            data class Ht(
                @SerializedName("c")
                val c: Int,
                @SerializedName("ht")
                val ht: Int,
                @SerializedName("r")
                val r: Int
            )
        }

        data class To(
            @SerializedName("flag")
            val flag: String,
            @SerializedName("i")
            val i: Int,
            @SerializedName("n")
            val n: String,
            @SerializedName("p")
            val p: Int,
            @SerializedName("sn")
            val sn: String
        )
    }
}