@file:Suppress("RemoveExplicitTypeArguments")

package xyz.stylianosgakis.pawfinder

import com.apollographql.apollo3.ApolloClient
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import xyz.stylianosgakis.pawfinder.backend.GetAnimalsUseCase

fun initKoin(
    initCode: KoinApplication.() -> Unit = {},
) {
    startKoin {
        initCode()
        modules(sharedModule)
    }
}

val sharedModule: Module = module {
    single<ApolloClient> {
        ApolloClient.Builder()
            .serverUrl(BuildKonfig.backendGraphQlEndpoint)
            .build()
    }
    single<GetAnimalsUseCase> { GetAnimalsUseCase(get()) }
}
