package xyz.stylianosgakis.pawfinder

import org.koin.core.Koin
import react.FC
import react.PropsWithChildren
import react.createContext

val ApplicationContext = createContext<Koin>()

external interface AppModuleProps : PropsWithChildren {
    var koin: Koin
}

val ApplicationModule = FC<AppModuleProps> { props ->
    val koin = props.koin

    ApplicationContext.Provider(koin) {
        props.children()
    }
}
