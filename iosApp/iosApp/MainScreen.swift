import SwiftUI
import shared

struct MainScreen: View {
    let greet = Greeting().greeting()
    
    var body: some View {
        ScrollView(showsIndicators: true) {
            VStack {
                ForEach(0...50, id: \.self) { number in
                    Text("\(greet) \(number)")
                }
            }
            .frame(maxWidth: .infinity, alignment: .leading)
        }
    }
}

struct MainScreen_Previews: PreviewProvider {
    static var previews: some View {
        MainScreen()
    }
}
