package com.example.matches.data.model.remote


import com.google.gson.annotations.SerializedName

data class MatchesResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("at")
        val at: AwayTeam,
        @SerializedName("br")
        val br: Br,
        @SerializedName("bri")
        val bri: Int,
        @SerializedName("d")
        val d: Long,
        @SerializedName("ht")
        val ht: HomeTeam,
        @SerializedName("i")
        val matchId: Int,
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
        val leagueInformation: LeagueInformation,
        @SerializedName("v")
        val v: String
    ) {
        data class AwayTeam(
            @SerializedName("i")
            val i: Int,
            @SerializedName("n")
            val name: String,
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

        data class HomeTeam(
            @SerializedName("i")
            val i: Int,
            @SerializedName("n")
            val name: String,
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
            val matchStatus: String,
            @SerializedName("at")
            val awayTeam: AwayTeam,
            @SerializedName("ht")
            val homeTeam: HomeTeam,
            @SerializedName("min")
            val min: Int,
            @SerializedName("st")
            val st: Int
        ) {
            data class AwayTeam(
                @SerializedName("c")
                val score: Int,
                @SerializedName("ht")
                val halfScore: Int,
                @SerializedName("r")
                val r: Int
            )

            data class HomeTeam(
                @SerializedName("c")
                val score: Int,
                @SerializedName("ht")
                val halfScore: Int,
                @SerializedName("r")
                val r: Int
            )
        }

        data class LeagueInformation(
            @SerializedName("flag")
            val flag: String,
            @SerializedName("i")
            val id: Int,
            @SerializedName("n")
            val name: String,
            @SerializedName("p")
            val point: Int,
            @SerializedName("sn")
            val shortName: String
        )
    }
}