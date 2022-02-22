import Foundation
import SwiftUI
import shared
import KMPNativeCoroutinesAsync

@MainActor
class MainScreenViewModel : ObservableObject {
    let getAnimalsUseCase: GetAnimalsUseCase = koin.get()
    
    @Published public var animalsList: [GetAnimalsQuery.DataAnimal] = []
    
    func fetchAnimals() async {
        Task {
            
        }
        do {
            // todo clean this up, using asyncResult and ..Native functions
            let animalsResult = await asyncResult(for: getAnimalsUseCase.invokeNative(limit: LimitInput(value: 50), page: 1))
            if case let .success(animalsResult) = animalsResult {
                animalsResult.fold(ifLeft: <#T##(ApolloError?) -> Any?#>, ifRight: <#T##(GetAnimalsResponse?) -> Any?#>)
            }
            animalsResult.tap(f: { response in
                self.animalsList = response!.animals
            })
        } catch {
            print("Error fetching animals \(error)")
        }
    }
}
