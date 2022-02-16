import SwiftUI
import shared

struct MainScreen: View {
    @StateObject private var viewModel: MainScreenViewModel = MainScreenViewModel()
    
    var body: some View {
        List {
            Text(Greeting().greeting())
                .frame(maxWidth: .infinity, alignment: .center)
            ForEach(Array(viewModel.animalsList.enumerated()), id: \.element.id) { index, animal in
                AnimalView(animal: animal, index: index)
            }
        }
        .refreshable {
            await viewModel.fetchAnimals()
        }
        .task {
            await viewModel.fetchAnimals()
        }
    }
}

struct MainScreen_Previews: PreviewProvider {
    static var previews: some View {
        MainScreen()
    }
}
