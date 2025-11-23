package fr.mathis.apptv.data.repository

import fr.mathis.apptv.data.api.EpisodateApiService
import fr.mathis.apptv.data.model.TvShow
import fr.mathis.apptv.data.model.TvShowDetail
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRepository @Inject constructor(
    private val apiService: EpisodateApiService
) {

    suspend fun getMostPopularShows(page: Int = 1): Result<List<TvShow>> {
        return try {
            val response = apiService.getMostPopular(page)
            Result.success(response.tvShows)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getShowDetails(showId: Int): Result<TvShowDetail> {
        return try {
            val response = apiService.getShowDetails(showId)
            Result.success(response.tvShow)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun searchShows(query: String, page: Int = 1): Result<List<TvShow>> {
        return try {
            val response = apiService.searchShows(query, page)
            Result.success(response.tvShows)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

