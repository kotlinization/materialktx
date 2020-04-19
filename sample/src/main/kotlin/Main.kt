import com.github.kotlinizer.materialktx.components.MwcButtonTag
import com.github.kotlinizer.materialktx.components.mwcButton
import kotlinx.html.dom.create
import kotlinx.html.id
import kotlinx.html.js.div
import kotlinx.html.label
import kotlinx.html.p
import kotlinx.html.style
import org.w3c.dom.get
import kotlin.browser.document

fun main() {
    document.addEventListener("DOMContentLoaded", {
        addButtons()
        afterShow()
    })
}


fun addButtons() {
    val margin = "margin: 8px"
    document.getElementsByTagName("body")[0]?.appendChild(
        document.create.div {
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
                    icon="code"
                }

            }
            p{
                mwcButton("Trailing Icon") {
                    style = margin
                    trailingicon=true
                    icon="code"
                }
            }
            p {
                mwcButton("Disabled"){
                    style=margin
                    disabled=true
                }
                mwcButton("Disabled"){
                    style=margin
                    disabled=true
                    icon="code"
                }
            }
        }
    )

}

fun afterShow() {


}