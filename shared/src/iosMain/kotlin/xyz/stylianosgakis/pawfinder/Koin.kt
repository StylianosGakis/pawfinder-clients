import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.mp.KoinPlatformTools
import xyz.stylianosgakis.pawfinder.getDependency

private val koin: Koin by lazy {
    KoinPlatformTools.defaultContext().get()
}

@Suppress("unused") // Used from Swift
fun <T> getForIOS(objCClass: ObjCClass): T? {
    return getOriginalKotlinClass(objCClass)?.let {
        koin.getDependency(it)
    }
}
