@file:Suppress("RemoveExplicitTypeArguments")

package xyz.stylianosgakis.pawfinder

import com.apollographql.apollo3.ApolloClient
import kotlin.reflect.KClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import xyz.stylianosgakis.pawfinder.backend.GetAnimalsUseCase

fun initKoin(
    extraConfiguration: KoinApplication.() -> Unit = {},
) {
    startKoin {
        extraConfiguration()
        modules(sharedModule)
    }
}

@Suppress("unused") // Used from Swift
fun initKoin() {
    initKoin {}
}

internal fun <T> Koin.getDependency(clazz: KClass<*>): T {
    return get(clazz, parameters = { parametersOf(clazz.simpleName) }) as T
}

private val sharedModule: Module = module {
    single<ApolloClient> {
        ApolloClient.Builder()
            .serverUrl(BuildKonfig.backendGraphQlEndpoint)
            .build()
    }
    single<GetAnimalsUseCase> { GetAnimalsUseCase(get()) }
}
