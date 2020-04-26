import com.github.kotlinizer.materialktx.components.*
import com.github.kotlinizer.materialktx.components.MwcListItemTag.Companion.GRAPHIC_AVATAR
import com.github.kotlinizer.materialktx.components.MwcListItemTag.Companion.GRAPHIC_ICON
import com.github.kotlinizer.materialktx.components.MwcListItemTag.Companion.GRAPHIC_LARGE
import com.github.kotlinizer.materialktx.components.MwcListItemTag.Companion.GRAPHIC_MEDIUM
import kotlinx.html.dom.create
import kotlinx.html.id
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
    style {
        +"""
            #custom  mwc-icon{
                background-color: black;
                color: white;
            }
        """.trimIndent()
    }
    mwcList {
        repeat(4) {
            mwcListItem("Item $it")
        }
    }
    mwcList {
        activatable = true
        repeat(4) {
            mwcListItem("Item $it") {
                if (it == 1) {
                    selected = true
                    activated = true
                }
            }
        }
    }
    mwcList {
        activatable = true
        multi = true
        repeat(4) {
            mwcListItem("Item $it") {
                if (it == 1 || it == 3) {
                    selected = true
                    activated = true
                }
            }
        }
    }
    mwcList {
        id = "custom"
        mwcListItemGraphic(GRAPHIC_AVATAR, "Avatar graphic", "folder")
        mwcListItemGraphic(GRAPHIC_ICON, "Icon graphic", "folder")
        mwcListItemGraphic(GRAPHIC_MEDIUM, "Medium graphic", "folder")
        mwcListItemGraphic(GRAPHIC_LARGE, "Large graphic", "folder")

    }
    mwcList {
        mwcListItemMeta("Location A", "info")
        mwcListItemMeta("Location B", "info")
        mwcListItemMeta("Location C", "info")
        mwcListItemMeta("Location D", "info")
    }
    mwcList {
        mwcListItemTwoLine("Item 0", "secondary line")
        mwcListItemTwoLine("Item 1", "secondary line")
        mwcListItemTwoLine("Item 2", "secondary line")
        mwcListItemTwoLine("Item 3", "secondary line")
    }
    mwcList {
        mwcListItem("Item 0")
        mwcDivider()
        mwcListItem("Item 1")
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