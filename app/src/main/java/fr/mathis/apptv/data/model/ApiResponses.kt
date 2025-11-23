package fr.mathis.apptv.data.model

import com.google.gson.annotations.SerializedName

data class MostPopularResponse(
    @SerializedName("total")
    val total: String?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("tv_shows")
    val tvShows: List<TvShow>
)

data class TvShowDetailResponse(
    @SerializedName("tvShow")
    val tvShow: TvShowDetail
)

data class SearchResponse(
    @SerializedName("total")
    val total: String?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("tv_shows")
    val tvShows: List<TvShow>
)

