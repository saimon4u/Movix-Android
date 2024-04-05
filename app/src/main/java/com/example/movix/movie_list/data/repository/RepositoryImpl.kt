package com.example.movix.movie_list.data.repository

import android.util.Log
import com.example.movix.movie_list.data.local.Database
import com.example.movix.movie_list.data.mappers.toMovie
import com.example.movix.movie_list.data.mappers.toMovieEntity
import com.example.movix.movie_list.data.mappers.toShow
import com.example.movix.movie_list.data.mappers.toShowEntity
import com.example.movix.movie_list.data.remote.Api
import com.example.movix.movie_list.domain.model.Movie
import com.example.movix.movie_list.domain.model.Show
import com.example.movix.movie_list.domain.repository.Repository
import com.example.movix.movie_list.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject



class RepositoryImpl @Inject constructor(
    private val api: Api,
    private val database: Database
): Repository{
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        type: String,
        page: Int
    ): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))

            val localMovieList = database.dao.getMovieListByType(type)
            val shouldLoadLocalMovies = localMovieList.isNotEmpty() && !forceFetchFromRemote

            if(shouldLoadLocalMovies){
                emit(Resource.Success(
                    data = localMovieList.map {
                        it.toMovie(type)
                    }
                ))
                emit(Resource.Loading(false))
                return@flow
            }

            val movieListFromApi = try{
                api.getMovieList(type, page)
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

            val movieEntities = movieListFromApi.results.let{
                it.map {movieDto->
                    movieDto.toMovieEntity(type)
                }
            }

//            Log.e("TAG", movieEntities.size.toString() )

            database.dao.upsertMovieList(movieEntities)

            emit(Resource.Success(
                movieEntities.map { it.toMovie(type) }
            ))

            emit(Resource.Loading(false))
        }
    }

    override suspend fun getShowList(
        forceFetchFromRemote: Boolean,
        type: String,
        page: Int
    ): Flow<Resource<List<Show>>> {
        return flow {
            emit(Resource.Loading(true))

            val localShowList = database.dao.getShowListByType(type)
            val shouldLoadLocalShows = localShowList.isNotEmpty() && !forceFetchFromRemote

            if(shouldLoadLocalShows){
                emit(Resource.Success(
                    data = localShowList.map {
                        it.toShow(type)
                    }
                ))
                emit(Resource.Loading(false))
                return@flow
            }

            val showListFromApi = try{
                api.getShowList(type, page)
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

            val showEntities = showListFromApi.results.let{
                it.map {showDto->
                    showDto.toShowEntity(type)
                }
            }

            database.dao.upsertShowList(showEntities)

            emit(Resource.Success(
                showEntities.map { it.toShow(type) }
            ))

            emit(Resource.Loading(false))
        }
    }

    override suspend fun getDiscoverMovies(
        forceFetchFromRemote: Boolean,
        page: Int,
        sortBy: String,
        genre: Int,
        type: String
    ): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))


            val localMovieList = database.dao.getMovieListByType(type)
            val shouldLoadLocalMovies = localMovieList.isNotEmpty() && !forceFetchFromRemote

            if(shouldLoadLocalMovies){
                emit(Resource.Success(
                    data = localMovieList.map {
                        it.toMovie(type)
                    }
                ))
                emit(Resource.Loading(false))
                return@flow
            }

            val movieListFromApi = try{
                api.getDiscoverMovieList(
                    page = page,
                    sortBy = sortBy,
                    genre = genre
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

            val movieEntities = movieListFromApi.results.let{
                it.map {movieDto->
                    movieDto.toMovieEntity(type)
                }
            }

            database.dao.upsertMovieList(movieEntities)

            emit(Resource.Success(
                movieEntities.map { it.toMovie(type) }
            ))

            emit(Resource.Loading(false))
        }
    }

}
