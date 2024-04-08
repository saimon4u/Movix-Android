package com.example.movix.details.data.repository

import com.example.movix.details.data.remote.DetailsApi
import com.example.movix.details.data.mappers.toCast
import com.example.movix.details.data.mappers.toCrew
import com.example.movix.details.data.mappers.toMovieDetails
import com.example.movix.details.data.mappers.toShowDetails
import com.example.movix.details.data.mappers.toSimilarMovie
import com.example.movix.details.data.mappers.toSimilarShow
import com.example.movix.details.data.mappers.toVideo
import com.example.movix.details.domain.model.Cast
import com.example.movix.details.domain.model.Crew
import com.example.movix.details.domain.model.MovieDetails
import com.example.movix.details.domain.model.ShowDetails
import com.example.movix.details.domain.model.SimilarMovie
import com.example.movix.details.domain.model.SimilarShow
import com.example.movix.details.domain.model.Video
import com.example.movix.details.domain.repository.Repository
import com.example.movix.movie_list.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: DetailsApi
): Repository {
    override suspend fun getCrews(
        category: String,
        id: Int
    ): Flow<Resource<List<Crew>>> {
        return flow {
            emit(Resource.Loading(true))

            val crewListFromApi = try{
                api.getCredits(
                    category = category,
                    id = id
                )
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }

            emit(Resource.Success(
                crewListFromApi.crew.map { it.toCrew() }
            ))

            emit(Resource.Loading(false))
        }
    }

    override suspend fun getCasts(
        category: String,
        id: Int
    ): Flow<Resource<List<Cast>>> {
        return flow {
            emit(Resource.Loading(true))

            val castListFromApi = try{
                api.getCredits(
                    category = category,
                    id = id
                )
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }

            emit(Resource.Success(
                castListFromApi.cast.map { it.toCast() }
            ))

            emit(Resource.Loading(false))
        }
    }

    override suspend fun getMovieDetails(
        id: Int
    ): Flow<Resource<MovieDetails>> {
        return flow {
            emit(Resource.Loading(true))

            val movieDetailsFromApi = try{
                api.getMovieDetails(
                    id = id
                )
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }

            emit(Resource.Success(
                movieDetailsFromApi.toMovieDetails()
            ))

            emit(Resource.Loading(false))
        }
    }

    override suspend fun getShowDetails(
        id: Int
    ): Flow<Resource<ShowDetails>> {
        return flow {
            emit(Resource.Loading(true))

            val showDetailsFromApi = try{
                api.getShowDetails(
                    id = id
                )
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }

            emit(Resource.Success(
                showDetailsFromApi.toShowDetails()
            ))

            emit(Resource.Loading(false))
        }
    }

    override suspend fun getVideos(
        category: String,
        id: Int
    ): Flow<Resource<List<Video>>> {
        return flow {
            emit(Resource.Loading(true))

            val videoListFromApi = try{
                api.getVideoes(
                    category = category,
                    id = id
                )
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }

            emit(Resource.Success(
                videoListFromApi.results.map { result ->
                    result.toVideo()
                }
            ))

            emit(Resource.Loading(false))
        }
    }

    override suspend fun getSimilarMovies(id: Int): Flow<Resource<List<SimilarMovie>>> {
        return flow {
            emit(Resource.Loading(true))

            val similarMovieListFromApi = try{
                api.getSimilarMovie(
                    id = id
                )
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }

            emit(Resource.Success(
                similarMovieListFromApi.results.map { result->
                    result.toSimilarMovie()
                }
            ))

            emit(Resource.Loading(false))
        }
    }

    override suspend fun getSimilarShows(id: Int): Flow<Resource<List<SimilarShow>>> {
        return flow {
            emit(Resource.Loading(true))

            val similarShowListFromApi = try{
                api.getSimilarShow(
                    id = id
                )
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Resource.Error("Something went wrong..."))
                return@flow
            }

            emit(Resource.Success(
                similarShowListFromApi.results.map { result ->
                    result.toSimilarShow()
                }
            ))

            emit(Resource.Loading(false))
        }
    }
}