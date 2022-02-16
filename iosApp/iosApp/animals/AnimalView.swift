import SwiftUI
import shared

struct AnimalView: View {
    let animal: GetAnimalsQuery.DataAnimal
    let index: Int
    
    var body: some View {
        VStack {
            Text(animal.name)
            if let description = animal.description_ {
                Text(description)
            }
        }
        .rotation3DEffect(
            .degrees((index % 2 == 0 ? 0 : 180)),
            axis: (x: 0, y: 1, z: 0)
        )
    }
}

struct AnimalView_Previews: PreviewProvider {
    static var previews: some View {
        AnimalView(animal: GetAnimalsQuery.companion.previewData(), index: 1)
    }
}
