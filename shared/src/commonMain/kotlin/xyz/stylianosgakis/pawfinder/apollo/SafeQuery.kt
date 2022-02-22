package xyz.stylianosgakis.pawfinder.apollo

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Error
import com.apollographql.apollo3.api.Operation

sealed interface ApolloError {
    data class Errors(val errors: List<Error>?) : ApolloError
    object NoData : ApolloError
}

fun <T : Operation.Data> ApolloResponse<T>.toEither(): Either<ApolloError, T> {
    if (hasErrors()) return ApolloError.Errors(errors).left()
    val data = data ?: return ApolloError.NoData.left()
    return data.right()
}
