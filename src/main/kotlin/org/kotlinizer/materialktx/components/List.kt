package org.kotlinizer.materialktx.components

import kotlinx.html.*
import org.kotlinizer.materialktx.AttributesBoolean
import org.w3c.dom.CustomEvent
import org.w3c.dom.Element

class MwcListTag(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "mwc-list",
    consumer = consumer,
    initialAttributes = initialAttributes,
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag, ImportList {

    var activatable: Boolean by AttributesBoolean()
}

@HtmlTagMarker
inline fun FlowContent.mwcList(
    crossinline block: MwcListTag.() -> Unit = {}
) = MwcListTag(emptyMap, consumer).visit(block)


abstract external class MwcList : Element, ImportList {

    fun select(index: Int)
}

fun MwcList.addSelectedItemListener(listener: (SelectedDetail) -> Unit) {
    addEventListener("selected", {
        val selectedDetail = (it as? CustomEvent)?.detail.unsafeCast<SelectedDetail>()
        listener(selectedDetail)
    })
}

external interface SelectedDetail : ImportList {
    val index: Int
}

@JsNonModule
@JsModule("@material/mwc-list")
external interface ImportList
