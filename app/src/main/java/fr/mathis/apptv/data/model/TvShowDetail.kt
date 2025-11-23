package fr.mathis.apptv.data.model

import com.google.gson.annotations.SerializedName

data class TvShowDetail(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("url")
    val url: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("description_source")
    val descriptionSource: String?,
    @SerializedName("start_date")
    val startDate: String?,
    @SerializedName("end_date")
    val endDate: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("network")
    val network: String?,
    @SerializedName("youtube_link")
    val youtubeLink: String?,
    @SerializedName("image_path")
    val imagePath: String?,
    @SerializedName("image_thumbnail_path")
    val imageThumbnailPath: String?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("rating_count")
    val ratingCount: String?,
    @SerializedName("countdown")
    val countdown: Countdown?,
    @SerializedName("genres")
    val genres: List<String>?,
    @SerializedName("pictures")
    val pictures: List<String>?,
    @SerializedName("episodes")
    val episodes: List<Episode>?
)

data class Countdown(
    @SerializedName("season")
    val season: Int?,
    @SerializedName("episode")
    val episode: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("air_date")
    val airDate: String?
)

data class Episode(
    @SerializedName("season")
    val season: Int,
    @SerializedName("episode")
    val episode: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("air_date")
    val airDate: String?
)

