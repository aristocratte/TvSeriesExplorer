package fr.mathis.apptv.data.api

import fr.mathis.apptv.data.model.MostPopularResponse
import fr.mathis.apptv.data.model.SearchResponse
import fr.mathis.apptv.data.model.TvShowDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodateApiService {

    @GET("most-popular")
    suspend fun getMostPopular(
        @Query("page") page: Int = 1
    ): MostPopularResponse

    @GET("show-details")
    suspend fun getShowDetails(
        @Query("q") showId: Int
    ): TvShowDetailResponse

    @GET("search")
    suspend fun searchShows(
        @Query("q") query: String,
        @Query("page") page: Int = 1
    ): SearchResponse
}

