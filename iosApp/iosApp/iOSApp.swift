import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
        initializeKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			MainScreen()
		}
	}
}
