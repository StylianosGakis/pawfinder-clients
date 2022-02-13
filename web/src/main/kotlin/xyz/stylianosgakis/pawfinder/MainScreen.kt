package xyz.stylianosgakis.pawfinder

import kotlinx.css.Color
import kotlinx.css.ListStyleType
import kotlinx.css.backgroundColor
import kotlinx.css.listStyleType
import kotlinx.css.margin
import kotlinx.css.px
import kotlinx.css.width
import react.Props
import react.dom.li
import react.fc
import styled.StyleSheet
import styled.css
import styled.styledDiv
import styled.styledUl

external interface MainScreenProps : Props {
    var greeting: String
}

val MainScreen = fc<MainScreenProps> { props ->
    styledDiv {
        css {
            +ComponentStyles.mainContent
        }
        styledUl {
            css {
                listStyleType = ListStyleType.none
            }
            repeat(400) { index ->
                li {
                    +"${props.greeting} $index"
                }
            }
        }
    }
}

object ComponentStyles : StyleSheet(name = "ComponentStyles", isStatic = true) {
    val mainContent by css {
        backgroundColor = Color("#f0f0f0")
        width = 600.px
        margin = "auto"
    }
}
