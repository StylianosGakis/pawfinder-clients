import kotlin.reflect.KClass
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import xyz.stylianosgakis.pawfinder.getDependency

@Suppress("unused") // Used from Swift
fun <T> Koin.getForNative(objCClass: ObjCClass): T? {
    return getOriginalKotlinClass(objCClass)?.let { kClass: KClass<*> ->
        getDependency(kClass)
    }
}
