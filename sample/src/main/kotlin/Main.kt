import com.github.kotlinizer.materialktx.components.mwcButton
import com.github.kotlinizer.materialktx.components.mwcList
import com.github.kotlinizer.materialktx.components.mwcListItem
import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlinx.html.p
import kotlinx.html.style
import org.w3c.dom.Element
import org.w3c.dom.get
import kotlin.browser.document

fun main() {
    document.addEventListener("DOMContentLoaded", {

        document.getElementsByTagName("body")[0]?.appendChild(
//        addButtons()
            addList()
        )
        afterShow()
    })
}

fun addList() = document.create.div {
    p {
        mwcList {
            repeat(4) {
                mwcListItem { text("Item $it") }
            }
        }
    }
    p {
        mwcList {
            activatable = true
            repeat(4) {
                mwcListItem { text("Item $it") }
            }
        }
    }
    p {
        mwcList {
            activatable = true
            multi = true
            repeat(4) {
                mwcListItem { text("Item $it") }
            }
        }
    }
}


fun addButtons(): Element {
    val margin = "margin: 8px"
    return document.create.div {
        p {
            mwcButton("Standard") {
                style = margin
            }
            mwcButton("Standard") {
                style = margin
                icon = "code"
            }
        }
        p {
            mwcButton("Outlined") {
                style = margin
                outlined = true
            }
            mwcButton("Outlined") {
                style = margin
                outlined = true
                icon = "code"
            }
        }
        p {
            mwcButton("RAISED") {
                style = margin
                raised = true
            }
            mwcButton("RAISED") {
                style = margin
                raised = true
                icon = "code"

            }
        }
        p {
            mwcButton("UNELEVATED") {
                style = margin
                unelevated = true
            }
            mwcButton("UNELEVATED") {
                style = margin
                unelevated = true
                icon = "code"
            }
        }
        p {
            mwcButton("DENSE") {
                style = margin
                dense = true
            }

            mwcButton("DENSE") {
                style = margin
                dense = true
                icon = "code"
            }

        }
        p {
            mwcButton("Trailing Icon") {
                style = margin
                trailingicon = true
                icon = "code"
            }
        }
        p {
            mwcButton("Disabled") {
                style = margin
                disabled = true
            }
            mwcButton("Disabled") {
                style = margin
                disabled = true
                icon = "code"
            }
        }
    }

}

fun afterShow() {


}