import Foundation
import shared


private var _koin: Koin_coreKoin?

var koin: Koin_coreKoin {
    return _koin!
}

func initializeKoin() {
    _koin = shared.KoinKt.doInitKoin().koin
}

extension Koin_coreKoin {
    func get() -> GetAnimalsUseCase {
        koin.getForNative(objCClass: GetAnimalsUseCase.self) as! GetAnimalsUseCase
    }
}
