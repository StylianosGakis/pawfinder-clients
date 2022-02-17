package xyz.stylianosgakis.pawfinder

import arrow.core.NonEmptyList
import csstype.Color
import csstype.Length
import csstype.ListStyleType
import csstype.Margin
import csstype.Padding
import csstype.px
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import react.FC
import react.Props
import react.css.PropertiesBuilder
import react.css.css
import react.dom.html.ReactHTML.body
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h5
import react.dom.html.ReactHTML.hr
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul
import react.useContext
import react.useEffect
import react.useRef
import react.useState
import xyz.stylianosgakis.pawfinder.backend.GetAnimalsUseCase
import xyz.stylianosgakis.pawfinder.type.AnimalType
import xyz.stylianosgakis.pawfinder.type.LimitInput

external interface MainScreenProps : Props {
    var greeting: String
}

val MainScreen = FC<MainScreenProps> { props ->
    val getAnimalsUseCase: GetAnimalsUseCase = useContext(ApplicationContext).get()
    var animals: List<GetAnimalsQuery.Data.Animal> by useState(emptyList())
    useEffect(getAnimalsUseCase) {
        val coroutineScope = CoroutineScope(Dispatchers.Default)
        val job = coroutineScope.launch {
            try {
                getAnimalsUseCase
                    .invoke(AnimalType.CAT, LimitInput(50), 1)
                    .tap {
                        delay(10_000)
                        animals = it.animals
                    }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        cleanup {
            job.cancel()
        }
    }

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
            li {
                css {
                    padding = Padding(vertical = Length("30px"), horizontal = Length("20px"))
                }
                +props.greeting
            }
            val listItemCss: PropertiesBuilder.() -> Unit = { margin = Margin("20px") }
            NonEmptyList.fromList(animals)
                .fold(
                    ifEmpty = {
                        li {
                            css {
                                listItemCss()
                            }
                            LoadingText()
                        }
                    },
                    ifSome = { animals ->
                        animals.all.forEachIndexed { index, animal ->
                            li {
                                css {
                                    listItemCss()
                                }
                                h5 {
                                    +animal.name
                                }
                                animal.description?.let { description ->
                                    body {
                                        +description
                                    }
                                }
                            }
                            if (index != animals.lastIndex) {
                                hr()
                            }
                        }
                    }
                )
        }
    }
}

val LoadingText = FC<Props> {
    val (text, setText) = useState("Loading")
    val updatedText = useRef(text)
    val updatedSetText = useRef(setText)
    useEffect(Unit) {
        val coroutineScope = CoroutineScope(Dispatchers.Default)
        val job = coroutineScope.launch {
            var oldText = updatedText.current!!
            while (isActive) {
                val newText = if (oldText.takeLast(3) == "...") {
                    oldText.dropLast(3)
                } else {
                    "$oldText."
                }
                updatedSetText.current!!(newText)
                oldText = newText
                delay(400)
            }
        }
        cleanup {
            job.cancel()
        }
    }
    +text
}
