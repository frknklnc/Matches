package com.example.matches.data.remote.model


import com.google.gson.annotations.SerializedName

data class MatchesDto(
    @SerializedName("data")
    val data: List<MatchDto>,
    @SerializedName("success")
    val success: Boolean
) {
    data class MatchDto(
        @SerializedName("at")
        val awayTeamDto: AwayTeamDto,
        @SerializedName("br")
        val br: Br,
        @SerializedName("bri")
        val bri: Int,
        @SerializedName("d")
        val matchDate: Long,
        @SerializedName("ht")
        val homeTeamDto: HomeTeamDto,
        @SerializedName("i")
        val matchId: Int,
        @SerializedName("img")
        val img: Img,
        @SerializedName("pe")
        val pe: Pe,
        @SerializedName("sc")
        val scoreInformationDto: ScoreInformationDto,
        @SerializedName("sgi")
        val sgi: Int,
        @SerializedName("st")
        val st: String,
        @SerializedName("str")
        val str: Boolean,
        @SerializedName("to")
        val leagueInformationDto: LeagueInformationDto,
        @SerializedName("v")
        val v: String
    ) {
        data class AwayTeamDto(
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

        data class HomeTeamDto(
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

        data class Img(
            @SerializedName("id")
            val id: Int
        )

        data class Pe(
            @SerializedName("fi")
            val fi: String,
            @SerializedName("si")
            val si: String
        )

        data class ScoreInformationDto(
            @SerializedName("abbr")
            val matchStatus: String,
            @SerializedName("at")
            val awayTeamScoreDto: AwayTeamScoreDto?,
            @SerializedName("ht")
            val homeTeamScoreDto: HomeTeamScoreDto?,
            @SerializedName("min")
            val min: Int,
            @SerializedName("st")
            val st: Int
        ) {
            data class AwayTeamScoreDto(
                @SerializedName("c")
                val score: Int,
                @SerializedName("ht")
                val halfScore: Int?,
                @SerializedName("r")
                val r: Int
            )

            data class HomeTeamScoreDto(
                @SerializedName("c")
                val score: Int,
                @SerializedName("ht")
                val halfScore: Int?,
                @SerializedName("r")
                val r: Int
            )
        }

        data class LeagueInformationDto(
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