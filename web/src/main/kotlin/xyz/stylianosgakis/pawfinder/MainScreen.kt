package xyz.stylianosgakis.pawfinder

import csstype.Color
import csstype.Length
import csstype.ListStyleType
import csstype.px
import react.FC
import react.Props
import react.css.css
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul

external interface MainScreenProps : Props {
    var greeting: String
}

val MainScreen = FC<MainScreenProps> { props ->
    div {
        css {
            backgroundColor = Color("#f0f0f0")
            width = 600.px
            margin = Length.auto
        }
        ul {
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
