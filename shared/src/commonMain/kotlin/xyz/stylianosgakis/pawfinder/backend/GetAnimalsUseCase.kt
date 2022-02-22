package xyz.stylianosgakis.pawfinder.backend

import arrow.core.Either
import com.apollographql.apollo3.ApolloClient
import xyz.stylianosgakis.pawfinder.GetAnimalsQuery
import xyz.stylianosgakis.pawfinder.apollo.ApolloError
import xyz.stylianosgakis.pawfinder.apollo.toEither
import xyz.stylianosgakis.pawfinder.type.AnimalType
import xyz.stylianosgakis.pawfinder.type.LimitInput

class GetAnimalsUseCase(
    private val apolloClient: ApolloClient,
) {
    suspend operator fun invoke(
        limit: LimitInput,
        page: Int,
    ): Either<ApolloError, GetAnimalsResponse> {
        return invoke(limit, page, AnimalType.CAT)
    }

    suspend operator fun invoke(
        limit: LimitInput,
        page: Int,
        animalType: AnimalType = AnimalType.CAT,
    ): Either<ApolloError, GetAnimalsResponse> {
        return apolloClient
            .query(GetAnimalsQuery(animalType, limit, page))
            .execute()
            .toEither()
            .map { dto -> GetAnimalsResponse.fromDto(dto, limit, page) }
    }
}

data class GetAnimalsResponse(
    val animals: List<GetAnimalsQuery.Data.Animal>,
    val limit: LimitInput,
    val page: Int,
) {
    companion object {
        fun fromDto(dto: GetAnimalsQuery.Data, limit: LimitInput, page: Int): GetAnimalsResponse {
            return GetAnimalsResponse(
                dto.animals,
                limit,
                page
            )
        }
    }
}
