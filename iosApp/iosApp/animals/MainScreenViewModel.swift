import Foundation
import SwiftUI
import shared

@MainActor
class MainScreenViewModel : ObservableObject {
    let getAnimalsUseCase: GetAnimalsUseCase = KoinKt.getForIOS(objCClass: GetAnimalsUseCase.self) as! GetAnimalsUseCase
    
    @Published public var animalsList: [GetAnimalsQuery.DataAnimal] = []
    
    func fetchAnimals() async {
        do {
            let animalsResult = try await getAnimalsUseCase.invoke(
                animalType: AnimalType.dog,
                limit: LimitInput(value: 50),
                page: 1
            )
            animalsResult.tap(f: { response in
                self.animalsList = response!.animals
            })
        } catch {
            print("Error fetching animals \(error)")
        }
    }
}
