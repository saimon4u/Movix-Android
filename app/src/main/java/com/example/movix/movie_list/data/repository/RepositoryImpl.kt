package com.example.movix.movie_list.data.repository

import com.example.movix.movie_list.data.mappers.toMovie
import com.example.movix.movie_list.data.mappers.toShow
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
    private val api: Api
): Repository{
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        type: String,
        page: Int
    ): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))

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

            emit(Resource.Success(movieListFromApi.results.map { movieDto ->
                movieDto.toMovie(type)
            }))

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

            emit(Resource.Success(showListFromApi.results.map { showDto ->
                showDto.toShow(type)
            }))

            emit(Resource.Loading(false))
        }
    }

}

//class RepositoryImpl @Inject constructor(
//    private val api: Api,
//): Repository {
//    override suspend fun getMovieList(
//        forceFetchFromRemote: Boolean,
//        type: String,
//        category: String,
//        page: Int
//    ): Flow<Resource<List<Movie>>> {
//        return flow {
//            emit(Resource.Loading(true))
//
//            val movieListFromApi = try{
//                movieApi.getMovieList(type, category, page)
//            }catch (e: IOException){
//                e.printStackTrace()
//                emit(Resource.Error("Something went wrong..."))
//                return@flow
//            }catch (e: HttpException){
//                e.printStackTrace()
//                emit(Resource.Error("Something went wrong..."))
//                return@flow
//            }catch (e: Exception){
//                e.printStackTrace()
//                emit(Resource.Error("Something went wrong..."))
//                return@flow
//            }
//
//            emit(Resource.Success(movieListFromApi.results.map { movieDto ->
//                movieDto.toMovie(category)
//            }))
//
//            emit(Resource.Loading(false))
//        }
//    }
//}